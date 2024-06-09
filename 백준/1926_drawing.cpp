#include <bits/stdc++.h>

using namespace std;

int n, m, cnt, max_area;

int drawing[500][500];
int visited[500][500];

int dx[4] = {0, -1, 1, 0};
int dy[4] = {-1, 0, 0, 1};

int bfs(int x, int y){

    queue<pair<int,int>> q;

    q.push({x, y});
    visited[x][y] = true;

    int area = 0;
    
    while (!q.empty()) {
        auto [x1, y1] = q.front();
        q.pop();
        area++;

        for (int i = 0; i < 4; i++) {
            int x2 = x1 + dx[i];
            int y2 = y1 + dy[i];

            if(x2 >= 0 && y2 >= 0 && x2 < n && y2 < m && !visited[x2][y2] 
            && drawing[x2][y2]) {
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

    cin >> n >> m;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cin >> drawing[i][j]; 
        }
    }
    
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if(drawing[i][j] && !visited[i][j]){
                cnt++;
                max_area = max(max_area, bfs(i, j));
            }
        }
    }

    cout << cnt << '\n' << max_area << '\n';


    return 0;
}