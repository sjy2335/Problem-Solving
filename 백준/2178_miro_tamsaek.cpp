#include <bits/stdc++.h>

using namespace std;

int N, M;

int miro[101][101];
bool visited[101][101];

int dx[4] = {0, -1, 1, 0};
int dy[4] = {-1, 0, 0, 1};

void bfs(int x, int y){

    queue<pair<int, int>> q;

    q.push({x, y});
    visited[x][y] = true;

    while (!q.empty())
    {
        auto [x1, y1] = q.front();
        q.pop();

        for (int i = 0; i < 4; i++)
        {
            int x2 = x1 + dx[i];
            int y2 = y1 + dy[i];
            if (x2 >= 0 && y2 >= 0 && x2 < M && y2 < N && miro[x2][y2] && !visited[x2][y2]){
                miro[x2][y2] = miro[x1][y1] + 1;
                visited[x2][y2] = true;
                q.push({x2, y2});
            }
        }
    }
}


int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin >> M >> N;

    for (int i = 0; i < M; i++)
    {
        string s;
        cin >> s;
        for (int j = 0; j < N; j++)
        {
            
            miro[i][j] = s[j] - '0';
        }
        
    }

    bfs(0,0);


    cout << miro[--M][--N];
    return 0;
}