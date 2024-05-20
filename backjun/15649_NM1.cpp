#include <bits/stdc++.h>

using namespace std;

int N, M;
vector<int> V;

void f(int n){
    if (n == N+1) return;

    if(V.size()==M){
        for (int v: V){
            cout << v << ' ';
        }
        cout << '\n';
    }

    f(n+1);

    V.push_back(n);
    f(n+1);
    V.pop_back();   
    
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);    

    cin >> N >> M;
    f(1);

    return 0;
}