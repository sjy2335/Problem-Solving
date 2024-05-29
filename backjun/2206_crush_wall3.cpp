#include <bits/stdc++.h>

using namespace std;

int N, M, K;
int origin[1001][1001];
int matrix[1001][1001][11][2];

int dx[4] = {0, -1, 1, 0};
int dy[4] = {-1, 0, 0, 1};

typedef struct point {
    int x;
    int y;
    int broken;
    bool is_day;
}point;

vector<int> v;

void bfs(){
    queue<point> q;
    q.push({0, 0, 0, 1});
    matrix[0][0][0][1] = 1;

    while (q.size()) {
        int x1 = q.front().x;
        int y1 = q.front().y;
        int broken = q.front().broken;
        bool is_day = q.front().is_day;
        q.pop();

        if (x1 == N-1 && y1 == M-1) {
            cout << matrix[x1][y1][broken][is_day] << '\n';
            return;
        }

        for (int i = 0; i < 4; i++) {
            int x2 = x1 + dx[i];
            int y2 = y1 + dy[i];

            if(x2<0 || y2<0 || x2 >= N || y2 >= M) continue;
            
            if (origin[x2][y2] && broken < K ) {
                // 벽이 있고 아직 K번 부수지 않은 경우
                // 당연히 여기서도 중복 push 발생할 수 있음 십자 방향으로 추가되면서
                if (!is_day) { // 밤이면 그냥 한번 더 넣어줌
                    if(matrix[x1][y1][broken][!is_day]) continue; // 전에 와봤으면
                    q.push({x1, y1, broken, !is_day});
                    matrix[x1][y1][broken][!is_day] = matrix[x1][y1][broken][is_day] + 1;
                } else { // 낮이면
                    if(matrix[x2][y2][broken+1][!is_day]) continue; // 전에 와봤으면
                    q.push({x2, y2, broken+1, !is_day});
                    matrix[x2][y2][broken+1][!is_day] = matrix[x1][y1][broken][is_day] + 1;
                }
                
            } else if (!origin[x2][y2] && !matrix[x2][y2][broken][!is_day]){ 
                // 벽이 없고 아직 방문 안한 경우
                matrix[x2][y2][broken][!is_day] = matrix[x1][y1][broken][is_day] + 1;
                q.push({x2, y2, broken, !is_day});
            }

        }

    }
    

    cout << -1 << '\n';

    return;

}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> M >> K;

    for (int i = 0; i < N; i++) {
        string s;
        cin >> s;
        for (int j = 0; j < M; j++) {
            origin[i][j]= s[j]-'0';
        }        
    }

    bfs();

    return 0;
}