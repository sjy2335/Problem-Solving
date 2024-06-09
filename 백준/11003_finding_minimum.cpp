#include <bits/stdc++.h>

using namespace std;
using P = pair<int, int>;

int N, L;

struct compare {
    bool operator()(P a, P b){
    return a.first > b.first;
    }
};

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> L;

    priority_queue<P, vector<P>, compare> PQ;

    for (int i = 1; i <= N; i++) {

        int n; cin >> n;
        PQ.push(make_pair(n, i));

        while(PQ.top().second < i-L+1){
            PQ.pop();
        }

        cout << PQ.top().first << ' ';
    }
    
    return 0;
}