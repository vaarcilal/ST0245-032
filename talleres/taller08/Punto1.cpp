#include <bits/stdc++.h>

using namespace std;

bool isOp(char ch)
{
    bool state = false;
    string ops = "+-*/";
    for (char op : ops) {
        if (ch == op)
            state = true;
    }
    return state;
}

int evaluar(string st)
{
    stack<int> numeros;
    for (char ch : st) {
        if (isOp(ch)) {
            int a = numeros.top();cout<<a<<" ";
            numeros.pop();
            int b = numeros.top();cout<<b<<endl;
            numeros.pop();
            if (ch == '+')
                numeros.push(a + b);
            if (ch == '-')
                numeros.push(b - a);
            if (ch == '*')
                numeros.push(a * b);
            if (ch == '/')
                numeros.push(b / a);
        } else if (ch != ' ') {
            numeros.push((int)ch-48);
        }
        cout<<endl;
    }
    return numeros.top();
}

int main()
{
    string st = "6 5 -4 +";
    cout<<evaluar(st);
}
