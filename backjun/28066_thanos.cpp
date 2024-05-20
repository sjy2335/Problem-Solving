#include <bits/stdc++.h>

using namespace std;

int N, K;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> K;
    deque<int> dq;

    for (int i = 1; i <= N; i++) {
        dq.push_back(i);
    }

    while(dq.size()>1){
        if(dq.size()<K) {cout << dq.front(); return 0;}
        dq.push_back(dq.front());
        for (int i = 0; i < K; i++)
        {
            dq.pop_front();
        }
    }
    
    cout << dq.front();
    return 0;
}