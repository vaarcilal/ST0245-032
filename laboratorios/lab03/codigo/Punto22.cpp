#include <boost/algorithm/string.hpp>
#include <iostream>
#include <stack>
#include <string>
#include <vector>
using namespace std;
int main()
{
    string n;
    getline(cin, n);
    int cantidad = stoi(n);
    stack<int> posiciones[cantidad];
    int lugaresBloques[cantidad];

    for (int i = 0; i < cantidad; i++) {
        posiciones[i].push(i);
        lugaresBloques[i] = i;
    }

    string st;
    string delimiter = " ";
    vector<string> strings;
    while (getline(cin, st) && st != "quit") {
        boost::split(strings, st, boost::is_any_of(" "));
        int bloque1 = stoi(strings[1]);
        int bloque2 = stoi(strings[3]);
        if (bloque1 == bloque2 || lugaresBloques[bloque1] == lugaresBloques[bloque2])
            continue;
        stack<int> temp;
        int in1 = lugaresBloques[bloque1];
        int in2 = lugaresBloques[bloque2];

        if (strings[2] == "onto") {
            while (posiciones[in2].top() != bloque2) {
                posiciones[posiciones[in2].top()].push(posiciones[in2].top());
                posiciones[in2].pop();
            }
        }
        if (strings[0] == "move") {
            //cout<<bloque1<<" "<<in1<<endl;
            while (posiciones[in1].top() != bloque1) {
                //cout<<" HOLAA";
                posiciones[posiciones[in1].top()].push(posiciones[in1].top());
                posiciones[in1].pop();
            }
            int temp3 = lugaresBloques[bloque1];
            lugaresBloques[bloque1] = lugaresBloques[lugaresBloques[bloque2]];
            lugaresBloques[bloque2] = temp3;
        }
        if (strings[0] == "pile") {
            while (posiciones[in1].top() != bloque1) {
                temp.push(posiciones[in1].top());
                posiciones[in1].pop();
            }
            temp.push(bloque1);
            posiciones[in1].pop();
            while (!temp.empty()) {
                posiciones[in2].push(temp.top());
                temp.pop();
            }
            int temp3 = lugaresBloques[bloque1];
            lugaresBloques[bloque1] = lugaresBloques[lugaresBloques[bloque2]];
            lugaresBloques[bloque2] = temp3;
            continue;
        }
        posiciones[in2].push(bloque1);
        posiciones[in1].pop();
        int temp2 = lugaresBloques[bloque1];
        lugaresBloques[bloque1] = lugaresBloques[lugaresBloques[bloque2]];
        lugaresBloques[bloque2] = temp2;
    }
    stack<int> otras[cantidad];
    for(int g =0;g<cantidad;g++){
        while(!posiciones[g].empty()){
            otras[g].push(posiciones[g].top());
            posiciones[g].pop();
        }
    }
    for (int p = 0; p < cantidad; p++) {
        cout << p << ":";
        while (!otras[p].empty()) {
            cout << " " << otras[p].top();
            otras[p].pop();
        }
        cout << endl;
    }
}
