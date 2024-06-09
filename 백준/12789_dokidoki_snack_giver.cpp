#include <bits/stdc++.h>

using namespace std;

int N;
stack<int> S;


int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    
    cin >> N;

    int tmp = 1;

    for (int i = 0; i < N; i++)
    {
        int n;
        cin >> n;
        S.push(n);   
        while(!S.empty() && S.top() == tmp){
            S.pop();
            tmp++;
        }
    }
    if (S.empty()) cout << "Nice\n";
    else cout << "Sad\n";

    return 0;
}