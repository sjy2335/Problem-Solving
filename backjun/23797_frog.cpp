#include <bits/stdc++.h>

using namespace std;

string S;
int K;
int P;
int res;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin >> S;

    for(char c: S) {
        if(c == 'K'){
            K++;
            if(P) P--;
        }
        if (c == 'P'){
            P++;
            if(K) K--;
        }
        res = max(res, max(P, K));
    }
    
    cout << res;

    
    return 0;
}