#include <bits/stdc++.h>

using namespace std;

int N, cnt;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    
    cin >> N;

    long i;

    for (i = 666; i < ~0U<<2; i++)
    {
        string S = to_string(i);
        if(S.find("666")!=string::npos) cnt++;
        if(cnt == N) break;
    }
    cout << i;
    
    
    return 0;
}