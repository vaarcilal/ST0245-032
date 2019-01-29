#include <bits/stdc++.h>

using namespace std;

bool search(int);
bool isThere(int, vector<int>, int);

int main() {
    vector<int> pesos{1,2};
	if(isThere(0, pesos,5)) cout<<"sí\n";
    else cout<<"no";
	return 0;
}

bool isThere(int start, vector<int> nums, int target){
    if(target==0) return true;
    if(start==nums.size()) return false;
    bool un1 = isThere(start+1,nums,target-nums[start]);
    bool un2 = isThere(start+1,nums,target);
    return un1||un2;
}

