#include <iostream>
#include <string>
#include <algorithm>
#include <vector>

using namespace std;

int N;

bool f[101]={};

int func2(int arr[], int size){
    for (int i = 0; i<size; i++)
    {
        if(100-*(arr+i)>0 && f[100-*(arr+i)]) {

            return 1;
        }
    }

    return 0;
}

int main() {
    // 생각할 필요 없는 문제는 여기에 풀고 지우기.
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    int arr[1001]={0};
    
    cin >> N;
    for (size_t i = 0; i < N; i++)
    {
        cin>>arr[i];
        f[arr[i]]=true;
    }
    cout << func2(arr, N);
}