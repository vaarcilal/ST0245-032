/*
Author: Vincent A. Arcila L.
Date: 2019-04-16

*/

#include <boost/algorithm/string.hpp>
#include <chrono>
#include <fstream>
#include <iostream>
#include <queue>
#include <sstream>
#include <stack>
#include <string>
#include <thread>

using namespace std;

struct Nodo {
    int size;
    string owner;
    string name;
    struct Nodo* son;
    struct Nodo* brother;
};

struct Nodo* nuevoNodo(string name, string owner, int size)
{
    struct Nodo* nodo = new struct Nodo;
    nodo->name = name;
    nodo->owner = owner;
    nodo->size = size;
    nodo->son = NULL;
    nodo->brother = NULL;
    return nodo;
};

struct Nodo* searchBrothers(struct Nodo* head, string name)
{
    if (head->name == name)
        return head;
    if (head->brother == NULL)
        return NULL;
    return searchBrothers(head->brother, name);
}

struct Nodo* search(struct Nodo* head, string name)
{
    if (head->name == name)
        return head;
    if (head->brother == NULL) {
        if (head->son == NULL)
            return NULL;
        return search(head->son, name);
    }
    struct Nodo* nodo = searchBrothers(head->brother, name);
    if (nodo != NULL)
        return nodo;

    if (head->son == NULL) {
        return search(head->brother, name);
    }
    nodo = search(head->son, name);
    if (nodo != NULL)
        return nodo;
    nodo = search(head->brother, name);
    return nodo;
}

string trimed(string str)
{
    bool state = true;
    string r = "";
    for (unsigned int i = 0; i < str.size(); i++) {
        if (state) {
            if (str[i] == '/')
                continue;
        }
        state = false;
        r += str[i];
    }
    state = true;
    string s = "";
    for (int i = r.size() - 1; i >= 0; i--) {
        if (state == true) {
            if (r[i] == '/')
                continue;
        }
        state = false;
        s = r[i] + s;
    }
    return s;
}

int mix(int s, string st)
{
    if (st[0] == 'M')
        return stoi(to_string(s) + "000000");
    if (st[0] == 'K')
        return stoi(to_string(s) + "000");
    return s;
}

void createTree(struct Nodo* root, string inpFile)
{
    stack<struct Nodo*> fathers;
    ifstream inp(inpFile);
    string line;
    getline(inp, line);
    line = trimed(line);
    root->brother = NULL;
    root->son = NULL;
    root->owner = "VINCENT";
    root->name = line;
    root->size = 4000;
    fathers.push(root);

    struct Nodo* nodo;
    string name, owner, lastSep, sep, sizestr;
    int counter = 0, lastcounter = 0, size;
    float sizetmp;
    char ch;
    while (getline(inp, line)) {
        if (line == "")
            break;
        istringstream iss(line);
        do {
            iss >> ch;
            counter++;
        } while (ch != '[');
        counter--;

        iss >> owner
            >> sizetmp
            >> sizestr
            >> name;
        size = mix(sizetmp, sizestr);
        nodo = nuevoNodo(name, owner, size);
        if (counter > lastcounter) {
            fathers.top()->son = nodo;
            nodo->name = fathers.top()->name + "/" + nodo->name;
            fathers.push(nodo);
        } else if (counter == lastcounter) {
            fathers.top()->brother = nodo;

            vector<string> result;
            boost::split(result, fathers.top()->name, boost::is_any_of("/"));
            string lname = result[0];
            for (unsigned int i = 1; i < result.size() - 1; i++) {
                lname = lname + "/" + result[i];
            }
            nodo->name = lname + "/" + nodo->name;

            fathers.pop();
            fathers.push(nodo);
        } else {
            int pops = ((lastcounter - counter) / 4) + 1;
            while (pops != 0) {
                fathers.pop();
                pops--;
            }
            struct Nodo* lastson = fathers.top()->son;
            while (lastson->brother != NULL) {
                lastson = lastson->brother;
            }
            lastson->brother = nodo;

            vector<string> result;
            boost::split(result, fathers.top()->name, boost::is_any_of("/"));
            string lname = result[0];
            result.erase(result.begin());
            for (string l : result) {
                lname += "/" + l;
            }
            nodo->name = lname + "/" + nodo->name;

            fathers.push(nodo);
        }

        lastcounter = counter;
        counter = 0;
    }
}

void searchAllUnder(struct Nodo* head, vector<struct Nodo*>& q)
{
    q.push_back(head);
    if (head->son == NULL) {
        if (head->brother == NULL)
            return;
        else
            searchAllUnder(head->brother, q);
    } else {
        if (head->brother == NULL)
            searchAllUnder(head->son, q);
        else {
            searchAllUnder(head->brother, q);
            searchAllUnder(head->son, q);
        }
    }
}
vector<struct Nodo*> greaterThan(vector<struct Nodo*> v, int size)
{
    vector<struct Nodo*> r;
    for (struct Nodo* nodo : v) {
        if (nodo->size >= size)
            r.push_back(nodo);
    }
    return r;
}

vector<struct Nodo*> lowerThan(vector<struct Nodo*> v, int size)
{
    vector<struct Nodo*> r;
    for (struct Nodo* nodo : v) {
        if (nodo->size <= size)
            r.push_back(nodo);
    }
    return r;
}

vector<struct Nodo*> restrictOwner(vector<struct Nodo*> v, string owner)
{
    if (owner == "")
        return v;
    vector<struct Nodo*> r;
    for (struct Nodo* nodo : v) {
        if (nodo->owner == owner)
            r.push_back(nodo);
    }
    return r;
}

string inpFileNewName(string s)
{
    s.erase(s.end() - 4, s.end());
    return s + "Processed.txt";
}

int main()
{
    struct Nodo* root = new struct Nodo;
    string inpFile = "prog.txt";
    string command = "preprocess.py " + inpFile;
    system(command.c_str());
    inpFile = inpFileNewName(inpFile);
    this_thread::sleep_for(chrono::milliseconds(400));
    createTree(root, inpFile);
    string line;
    cout << "Enter your queries in the following format: Father_directory [>,<] [size] [owner]\n";
    while (getline(cin, line)) {
        vector<string> vecstr;
        istringstream iss(line);
        string tmp;
        iss >> tmp;
        struct Nodo* nodo = search(root, tmp);
        if (nodo == NULL)

            cout <<endl<< "No such file or directory: " << tmp << endl;
        else {
            vector<struct Nodo*> v;
            searchAllUnder(nodo->son, v);
            vector<string> tmp;
            while(iss.rdbuf()->in_avail() != 0){
                string t;
                iss>>t;
                tmp.push_back(t);
            }
            vector<string> vcs;
            if (tmp.size() == 1) {
                v = restrictOwner(v,tmp[0]);
            }else if(tmp.size() == 2 || tmp.size() == 3){
                if(tmp[0] ==">"){
                    v = greaterThan(v,stoi(tmp[1]));
                    if(tmp.size() == 3){
                        v = restrictOwner(v,tmp[2]);
                    }
                }else{
                    v = lowerThan(v,stoi(tmp[1]));
                    if(tmp.size() == 3){
                        v = restrictOwner(v,tmp[2]);
                    }
                }
            }
            cout<<endl;
            for(struct Nodo* n:v){
                cout<<n->name<<" "<<n->size<<" "<<n->owner<<endl;
            }
            if(v.size() ==0) cout<<endl<<"No such files or directories"<<endl;
        }
    }
}
