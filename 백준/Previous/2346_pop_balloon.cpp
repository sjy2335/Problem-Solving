#include <bits/stdc++.h>

using namespace std;

int N;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    
    cin >> N;
    deque<pair<int, int>> dq;
    
    for (size_t i = 1; i <= N; i++)
    {
        int n;
        cin >> n;
        dq.push_back(make_pair(i, n));
    }

    cout << dq.front().first << ' ';
    int tmp = dq.front().second;
    dq.pop_front();

    while (!dq.empty())
    {
        if(tmp > 0){
            for (int i = 0; i < tmp-1; i++)
            {
                dq.push_back(dq.front());
                dq.pop_front();
            }
            cout << dq.front().first << ' ';
            tmp = dq.front().second;
            dq.pop_front();
        } else {
            for (int i = 0; i > tmp+1; i--)
            {
                dq.push_front(dq.back());
                dq.pop_back();
            }
            cout << dq.back().first << ' ';
            tmp = dq.back().second;
            dq.pop_back();
        }    
    }
    
    return 0;
}