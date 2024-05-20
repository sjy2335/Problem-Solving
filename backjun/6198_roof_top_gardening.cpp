#include <bits/stdc++.h>

using namespace std;

int N;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    
    cin >> N;
    stack<long> S;
    long long res = 0;

    for (int i = 0; i < N; i++)
    {
        int n; cin >> n;
        while(!S.empty() && S.top() <= n){
            S.pop();
        }
        res += S.size();
        S.push(n);
    }
    
    cout << res << '\n';
    return 0;
}