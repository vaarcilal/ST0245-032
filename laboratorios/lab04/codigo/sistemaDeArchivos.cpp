#include <fstream>
#include <iostream>
#include <queue>
#include <sstream>
#include <stack>
#include <string>

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
    struct Nodo* nodo = searchBrothers(head, name);
    if (nodo != NULL)
        return nodo;
    if (head->son == NULL && head->brother == NULL)
        return NULL;
    if (head->son == NULL)
        return search(head->brother, name);
    if (head->brother == NULL)
        return search(head->son, name);

    nodo = search(head->son, name);
    if (nodo != NULL)
        return nodo;
    nodo = search(head->brother, name);
    if (nodo != NULL)
        return nodo;
}

string trimed(string str)
{
    bool state = true;
    string r = "";
    for (int i = 0; i < str.size(); i++) {
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
        istringstream iss(line);
        do {
            iss >> ch;
            counter++;
        } while (ch != '[');

        iss >> owner
            >> sizetmp
            >> sizestr
            >> name;
        size = mix(sizetmp, sizestr);
        nodo = nuevoNodo(name, owner, size);

        if (counter > lastcounter) {
            fathers.top()->son = nodo;
            fathers.push(nodo);
        } else if (counter == lastcounter) {
            fathers.top()->brother = nodo;
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
            fathers.push(nodo);
        }

        lastcounter = counter;
        counter = 0;
    }
}

void addSubtreeToQueue(struct Nodo* head, vector<struct Nodo*>& q)
{
    q.push_back(head);
    if (head->son == NULL) {
        if (head->brother == NULL)
            return;
        else
            addSubtreeToQueue(head->brother, q);
    } else {
        if (head->brother == NULL)
            addSubtreeToQueue(head->son, q);
        else {
            addSubtreeToQueue(head->brother, q);
            addSubtreeToQueue(head->son, q);
        }
    }
}

void searchAllUnder(struct Nodo* root, string name, vector<struct Nodo*>& q)
{
    struct Nodo* head = search(root, name)->son;
    addSubtreeToQueue(root,q);
}

int main()
{
    struct Nodo* root = new struct Nodo;
    string inpFile = "prueba.txt";
    createTree(root, inpFile);
    string file;
    while (cin >> file) {
        struct Nodo* nodo = search(root, file);
        if (nodo == NULL)
            cout << "NO SE ENCUENTRA\n";
        else {
            cout << nodo->name << " " << nodo->size << " " << nodo->owner << " ";
            if (nodo->brother != NULL)
                cout << nodo->brother->name << " ";
            if (nodo->son != NULL)
                cout << nodo->son->name;
            cout << endl;
        }
    }
}
