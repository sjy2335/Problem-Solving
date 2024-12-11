#include <bits/stdc++.h>

using namespace std;

int dx[4] = {0, -1, 1, 0};
int dy[4] = {-1, 0, 0, 1};

int N;
string grid[101];
bool visited[101][101];

void bfs(int x, int y, char c){
    queue<pair<int, int>> q;
    q.push({x, y});
    visited[x][y] = true;

    while (q.size()) {
        auto [cx, cy] = q.front();
        q.pop();
        for (int i = 0; i < 4; i++) {
            int nx = cx + dx[i];
            int ny = cy + dy[i];
            if(nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny] && grid[nx][ny] == c){
                visited[nx][ny] = true;
                q.push({nx, ny});
            }
        }
    }
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    for (int i = 0; i < N; i++) {
        cin >> grid[i];
    }
    
    // 안 적록색약
    int cnt = 0;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            if(!visited[i][j]){
               bfs(i, j, grid[i][j]);
               cnt++;
            }
        }
    }
    
    cout << cnt << ' ';

    // 적록색약
    fill(&visited[0][0], &visited[0][0] + 100 * 100, 0);
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < N; j++)
        {
            if(grid[i][j] == 'R') grid[i][j] = 'G';
        }
    }
    

    cnt = 0;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            if(!visited[i][j]){
               bfs(i, j, grid[i][j]);
               cnt++;
            }
        }
    }
    
    cout << cnt;

    return 0;
}