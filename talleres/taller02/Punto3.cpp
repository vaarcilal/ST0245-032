#include <bits/stdc++.h>

using namespace std;

vector<int> subset;
vector<int> myset{1,2,3,4};
int n =3;
int k=0;

void search(int, vector<int>);

int main() {
	search(k, myset);

	return 0;
}

void search(int k, vector<int> myset){
	if(k==myset.size()) {
		cout<<"Conjunto: ";
		for(const int e: subset ){
			cout<<e;
		}
		cout<<endl<<endl;
		
	}else{
		subset.push_back(myset[k]);
		search(k+1,myset);
		subset.pop_back();
		search(k+1,myset);
	}

}
