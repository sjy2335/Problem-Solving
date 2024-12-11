#include <bits/stdc++.h>

using namespace std;

int T;


int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    
    cin >> T;

    for (int i = 0; i < T; i++)
    {
        int N, M, idx; 
        cin >> N >> M;
        deque<pair<int, int>> dq;
        
        int max_imp = 1;
        for (int j = 0; j < N; j++)
        {
            int n; cin>> n;
            dq.push_back(make_pair(n, j));
            if(n > max_imp) max_imp = n;
        }

        int cnt = 1;
        while(!dq.empty()){
            if(dq.front().first < max_imp) {
                dq.push_back(dq.front());
                dq.pop_front();
            }
            else {
                if(dq.front().second == M) break;
                else{dq.pop_front(); cnt++;}
            }
        }
        cout << cnt << '\n';
    }
    

    return 0;
}