#include <bits/stdc++.h>

using namespace std;

int T, M, N, K;
bool arr[50][50];
int dx[4] = {0, -1, 1, 0};
int dy[4] = {-1, 0, 0, 1};

void dfs(int x1, int y1){
    arr[x1][y1] = false; // 탐색 완료 처리 
    for (int i = 0; i < 4; i++) {
        int x2 = x1 + dx[i];
        int y2 = y1 + dy[i];
        if (x2 < 0 || y2 < 0 || x2 >= M || y2 >= N) continue;
        if (arr[x2][y2]) dfs(x2, y2);
    }
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin >> T;

    for (int i = 0; i < T; i++)
    {
        int res = 0;

        for (int j = 0; j < M; j++) {
            for (int k = 0; k < N; k++) {
                arr[j][k] = false;
            }
        }

        cin >> M >> N >> K;
        for (int j = 0; j < K; j++)
        {
            int X, Y;
            cin >> X >> Y;
            arr[X][Y] = true;
        }

        for (int k = 0; k < M; k++){
            for (int l = 0; l < N; l++){
                if(arr[k][l]){
                    dfs(k, l);
                    res++;
                }
            } 
        }

        cout << res << '\n';
    }
    return 0;
}