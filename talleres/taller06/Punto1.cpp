#include <bits/stdc++.h>

using namespace std;

class Alist {
public:
    int size = 10;
    int actual = 0;
    int* arr = new int[size];
    int get(int index)
    {
        if (index >= size || index < 0)
            return -1;
        return arr[index];
    }
    int add(int value)
    {
        if (actual == size) {
            size = size*2;
            int *temp = new int[size];
            for (int i = 0; i < size / 2; i++) {
                temp[i] = arr[i];
            }
            delete[] arr;
            arr = temp;
        }
        arr[actual] = value;
        ++actual;
    }
    int insert(int value, int index)
    {
        if (index > actual || index < 0) {
            cout << "Err!! index not valid.\n";
            return -1;
        }
        if (index == actual) {
            if (actual == size) {
                size *= 2;
                int temp[size];
                for (int i = 0; i < size / 2; i++) {
                    temp[i] = arr[i];
                }
                delete[] arr;
                arr = temp;
            }
            arr[actual] = value;
            ++actual;
        }
        int *temp = new int[size];
        for (int i = 0; i < index; i++) {
            temp[i] = arr[i];
        }
        for (int i = index+1; i < size; i++) {
            temp[i] = arr[i];
        }
        temp[index]=value;
        delete[] arr;
        arr = temp;
    }
};

int
main()
{
}
