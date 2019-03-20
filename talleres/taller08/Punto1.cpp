#include <bits/stdc++.h>
#include <boost/algorithm/string.hpp>

using namespace std;

bool isOp(string ch)
{
    string ops = "+-*/";
    int algo = ops.find(ch);
    return algo!=-1;
}

int evaluar(string st)
{
    stack<int> numeros;
    vector<string> vd;
    boost::split(vd, st, boost::is_any_of(" "));
    for (string ch : vd) {
        cout<<ch<<endl;
        if (isOp(ch)) {
            int a = numeros.top();
            numeros.pop();
            int b = numeros.top();
            numeros.pop();
            if (ch == "+")
                numeros.push(a + b);
            if (ch == "-")
                numeros.push(b - a);
            if (ch == "*")
                numeros.push(a * b);
            if (ch == "/")
                numeros.push(b / a);
        } else if (ch != " ") {
            numeros.push(stoi(ch));
        }
    }
    return numeros.top();
}


int main()
{
    string st = "12 5 - 4 +";
    cout<<evaluar(st);
}
