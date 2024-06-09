#include <bits/stdc++.h>

using namespace std;

int arr[100][100];


int dx[4] = {0, -1, 1, 0};
int dy[4] = {-1, 0, 0, 1};

int N, max_cnt;

int bfs(int rain){
    int cnt = 0;
    bool visited[100][100]={false};

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            if(!visited[i][j] && arr[i][j] > rain){
                cnt++;

                queue<pair<int, int>> q;
                q.push({i,j});
                visited[i][j] = true;

                while (!q.empty()) {

                    auto [x1, y1] = q.front();
                    q.pop();

                    for (int k = 0; k < 4; k++)
                    {
                        int x2 = x1 + dx[k];
                        int y2 = y1 + dy[k];
                        if(x2 >= 0 && y2 >= 0 && x2 < N && y2 < N && !visited[x2][y2] 
                        && arr[x2][y2] > rain){
                            q.push({x2, y2});
                            visited[x2][y2] = true;
                        }
                    }
                }
            }
        }
    }
    
    return cnt;
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            cin >> arr[i][j];
        }
    }

    for (int i = 0; i < 100; i++)
    {
        max_cnt = max(max_cnt, bfs(i));
    }
    
    cout << max_cnt;
    

    return 0;
}