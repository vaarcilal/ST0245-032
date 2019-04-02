#include <stdio.h>
#include <stdlib.h>

struct Nodo {
    int valor;
    struct Nodo* izquierda;
    struct Nodo* derecha;
};

struct Nodo* nuevoNodo (int valor){
    struct Nodo * nodo = (struct Nodo*)malloc(sizeof(struct Nodo));
    nodo->valor = valor;
    nodo->derecha = NULL;
    nodo->izquierda = NULL;
};

void addNodo(int valor,struct Nodo *head){
    if(valor > head->valor){
        if(head->derecha == NULL){
            struct Nodo * nodo = nuevoNodo(valor);
            head->derecha = nodo;
        }else{
            addNodo(valor,head->derecha);
        }
    }else{
        if(head->izquierda == NULL){
            struct Nodo * nodo = nuevoNodo(valor);
            head->izquierda = nodo;
        }else{
            addNodo(valor,head->izquierda);
        }
    }
}

bool buscar(int valor,struct Nodo *head){
    if(head->valor == valor){
        return true;
    }else if(head->derecha == NULL && head->izquierda==NULL){
        return false;
    }else{
        if(head->derecha != NULL && head->izquierda != NULL){
            return buscar(valor,head->derecha) || buscar(valor,head->izquierda);
        }else if(head->derecha != NULL){
            return buscar(valor,head->derecha);
        }else{
            return buscar(valor,head->izquierda);
        }
    }
}

int main(){
    struct Nodo *cabeza = nuevoNodo(3);
    addNodo(5,cabeza);
    addNodo(1,cabeza);
    addNodo(9,cabeza);
    printf("%d",buscar(9,cabeza));

}
