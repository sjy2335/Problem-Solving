#include <iostream>
#include <string>

using namespace std;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    string S;
    int L[26]={0,};
    cin >> S;

    for (size_t i = 0; i < S.size(); i++)
    {
        L[S[i] - 97]++;
    }
    
    for(int num: L){
        cout << num << ' ';
    }


    return 0;
}