#include <bits/stdc++.h>

using namespace std;

int dx[4] = {0, -1, 1, 0};
int dy[4] = {-1, 0, 0, 1};

int paper[100][100];
bool visited[100][100];

int m, n, k, cnt;


int bfs(int x, int y){
    int area = 0;
    
    queue<pair<int, int>> q;
    q.push({x, y});
    visited[x][y] = true;

    while (!q.empty())
    {
        auto [x1, y1] = q.front();
        q.pop();
        area++;

        for (int i = 0; i < 4; i++)
        {
            int x2 = x1 + dx[i];
            int y2 = y1 + dy[i];
            if(x2 >= 0 && y2 >= 0 && x2 < m && y2 < n && !visited[x2][y2] 
            && paper[x2][y2]) {
                q.push({x2, y2});
                visited[x2][y2] = true;
            }
        }
    }

    return area;
}


int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin >> m >> n >> k;

    fill(&paper[0][0], &paper[0][0]+100*100, 1);

    // input & pre-process
    for (int i = 0; i < k; i++)
    {
        int x1, y1, x2, y2;
        cin >> x1 >> y1;
        cin >> x2 >> y2;

        for (int j = x1; j < x2; j++) {
            for (int l  = y1; l < y2; l++){
                paper[l][j] = 0;
            }  
        }
    }
    

    vector<int> v;

    for (int i = 0; i < m; i++)
    {
        for (int j = 0; j < n; j++)
        {
            if(!visited[i][j] && paper[i][j]){
                cnt++;
                v.push_back(bfs(i, j));                
            }
        }
    }

    sort(v.begin(), v.end());

    cout << cnt << '\n';
    for(int a : v) cout << a << ' ';

    return 0;
}