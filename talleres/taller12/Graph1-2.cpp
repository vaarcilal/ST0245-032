/*
    Author: Vincent A. Arcila L.
*/

#include <iostream>
#include <list>
#include <queue>
#include <vector>

using namespace std;

// Class for undirected graph
class Graph {
public:
    list<int>* al;
    int size = 0;

    Graph(int size)
    {
        this->size = size;
        al = new list<int>[size];
    }
    // add edge from a to b and viceversa
    void addEdge(int a, int b)
    {
        al[a].push_back(b);
        al[b].push_back(a);
    }

    // get sons from a
    vector<int> getSons(int a)
    {
        vector<int> sons;
        for (int b : al[a]) {
            sons.push_back(b);
        }
        return sons;
    }

    bool isThereWayDFS(int a, int b)
    {
        bool* visited = new bool[size];
        for (int i = 0; i < size; i++) {
            visited[i] = false;
        }
        return isThereWayDFS(a, b, visited);
    }

    bool isThereWayDFS(int a, int b, bool* visited)
    {
        if (a == b)
            return true;
        //            vector<int> sons = getSons(a);
        visited[a] = true;
        list<int>::iterator i;
        for (i = al[a].begin(); i != al[a].end(); ++i) {
            if (!visited[*i]) {
                bool way = isThereWayDFS(*i, b, visited);
                if (way == true)
                    return true;
            }
        }
        return false;
    }

    // determine wether is a way from a to b using BFS
    bool isThereWayBFS(int a, int b)
    {
        queue<int> q;
        bool visited[size];
        for (int i = 0; i < size; i++) {
            visited[i] = false;
        }

        q.push(a);
        visited[a] = true;

        while (!q.empty()) {
            q.pop();
            if (!visited[q.front()]) {
                for (int i : al[q.front()]) {
                    if (i == b)
                        return true;
                    if (!visited[i]) {
                        visited[i] = true;
                        q.push(i);
                    }
                }
            }
        }
        return false;
    }
};

int main()
{
    Graph g(4);
    g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(1, 2);
    g.addEdge(2, 0);
    //    g.addEdge(2, 3);
    g.addEdge(3, 3);
    if (g.isThereWayBFS(2, 1))
        cout << "YES BFS\n";
    else
        cout << "NO BFS\n";
    if (g.isThereWayDFS(2, 1))
        cout << "YES DFS\n";
    else
        cout << "NO DFS\n";
}
