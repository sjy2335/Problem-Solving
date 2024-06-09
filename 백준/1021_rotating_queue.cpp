#include <bits/stdc++.h>

using namespace std;

int N, M, cnt;
int arr[51];

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    
    cin >> N >> M;
    for (int i = 0; i < M; i++)
    {
        cin >> arr[i];
    }
    
    deque<int> dq;
    for (int i = 0; i < N; i++)
    {
        dq.push_back(i+1);
    }
    
    for (int i = 0; i < M; i++)
    {
        int idx;
        for(int j = 0; j < dq.size(); j++) {
            if(dq[j] == arr[i]) {
            idx = j;
            break;
            }
        }

        while(dq.front() != arr[i]){
            if (idx > dq.size()/2){
                dq.push_front(dq.back());
                dq.pop_back();
            }
            else {
                dq.push_back(dq.front());
                dq.pop_front();
            }
            cnt++;
        }
        dq.pop_front();
    }
    
    cout << cnt;

    return 0;
}