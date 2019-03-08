#include <bits/stdc++.h>

using namespace std;

struct Node {
    int dato;
    struct Node* next;
};

struct Node* head = NULL;

struct llist {

public:
    void Print()
    {
        struct Node* ptr;
        ptr = head;
        while (ptr != NULL) {
            cout << ptr->dato << " " << endl;
            ptr = ptr->next;
        }
    }
    void InsertOn(int index, int dato_nuevo)
    {
        int cont = -1;
        struct Node* ptr;
        ptr = head;
        while (ptr != NULL) {
            cont++;
            if (cont == index - 1) {
                struct Node* onext = ptr->next;
                struct Node* nodo_nuevo = (struct Node*)malloc(sizeof(struct Node));
                nodo_nuevo->dato = dato_nuevo;
                ptr->next = nodo_nuevo;
                nodo_nuevo->next = onext;
                break;
            }
            ptr = ptr->next;
        }

        if (index == 0) {
            struct Node* first = (struct Node*)malloc(sizeof(struct Node));
            first->dato = dato_nuevo;
            first->next = NULL;
            head = first;
        }
    }
    void EraseOn(int index)
    {
        int cont = -1;
        struct Node* ptr;
        ptr = head;
        while (ptr != NULL) {
            cont++;
            if (cont == index - 1) {
                struct Node* onext = ptr->next;
                ptr->next = onext->next;
                delete onext;
                break;
            }
            ptr = ptr->next;
        }
    }

    void Find(int n)
    {
        int cont = -1;
        struct Node* ptr;
        ptr = head;
        while (ptr != NULL) {
            cont++;
            if (ptr->dato == n) {
                cout << "Está en : " << cont << endl;
                break;
            }
            ptr = ptr->next;
            cout << "No está\n";
        }
    }
};

int main()
{
    struct llist uno;
    uno.InsertOn(0, 2901);
    uno.InsertOn(1, 2);
    uno.InsertOn(2, 9);
    uno.InsertOn(3, 5);
    uno.Print();
    cout << endl
         << endl;
    uno.Print();
    uno.Find(9);
}
