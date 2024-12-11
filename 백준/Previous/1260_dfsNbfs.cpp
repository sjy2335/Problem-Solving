#include <bits/stdc++.h>

using namespace std;

int N, M, V;
bool visited[1001];

vector<vector<int>> v;

void dfs(int crnt){
    visited[crnt] = true;
    cout << crnt <<' ';
    for(int next : v[crnt]){
        if(!visited[next]) dfs(next);
    }
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> M >> V;

    v.resize(N+1);
    
    for (size_t i = 0; i < M; i++)
    {
        int v1, v2;
        cin >> v1 >> v2;
        v[v1].push_back(v2);
        v[v2].push_back(v1);
    }

    // dfs
    for (int i = 0; i < N+1; i++) {
        sort(v[i].begin(), v[i].end());
    }

    dfs(V);
    

    // bfs
    cout << '\n';

    fill_n(visited, 1001, false);

    for (int i = 0; i < N+1; i++) {
        sort(v[i].begin(), v[i].end());
    }

    queue<int> q;
    q.push(V);
    visited[V] = true;
    
    while(!q.empty()){

        int crnt = q.front();
        cout << crnt << ' ';
        q.pop();

        for (int i = 0; i < v[crnt].size(); i++)
        {
            int tmp = v[crnt][i];
            if(!visited[tmp]) q.push(tmp);
            visited[tmp] = true;
        }
        
    }
    

    return 0;
}