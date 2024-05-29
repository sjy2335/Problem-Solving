#include <bits/stdc++.h>

using namespace std;

int dx[6] = {0, 0, -1, 1, 0, 0};
int dy[6] = {0, -1, 0, 0, 1, 0};
int dz[6] = {-1, 0, 0, 0, 0, 1};

int M, N, H;

int box[101][101][101];

typedef struct point {
    int z;
    int y;
    int x;
}point;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    queue<point> q;

    cin >> M >> N >> H;

    for (int i = 0; i < H; i++) {
        for (int j = 0; j < N; j++) {
            for (int k = 0; k < M; k++) {
                cin >> box[i][j][k];
                if(box[i][j][k] == 1) q.push({i, j, k}); // z, y, x 순으로 들어감
            }
        }
    }

    while (q.size()) {
        auto [z1, y1, x1] = q.front();
        q.pop();

        for (int i = 0; i < 6; i++) {
            int x2 = x1 + dx[i];
            int y2 = y1 + dy[i];
            int z2 = z1 + dz[i];

            if(x2<0 || y2<0 || z2 <0 || x2 >= M || y2 >= N || z2 >= H) continue;
            if(box[z2][y2][x2] == -1) continue;
            if(box[z2][y2][x2] == 0){
                box[z2][y2][x2] = box[z1][y1][x1] + 1;
                q.push({z2, y2, x2});
            }
        }
    }

    int day = 1;

    for (int i = 0; i < H; i++) {
        for (int j = 0; j < N; j++) {
            for (int k = 0; k < M; k++) {
                if(box[i][j][k]==0) {cout << -1; return 0;}
                day = day < box[i][j][k] ? box[i][j][k] : day; 
            }
        }
    }
 
    cout << day-1;

    return 0;
}