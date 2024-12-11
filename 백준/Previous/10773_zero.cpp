#include <bits/stdc++.h>

using namespace std;

int N, sum;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    
    cin >> N;
    stack<int> S;

    for (int i = 0; i < N; i++)
    {
        int n;
        cin >> n;
        if(!n) {
            if(!S.empty()) S.pop();
        }
        else (S.push(n));
    }

    while(!S.empty()){
        sum += S.top();
        S.pop();
    }

    cout << sum;
    
    return 0;
}