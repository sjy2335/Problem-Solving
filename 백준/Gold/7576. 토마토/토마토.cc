#include <bits/stdc++.h>
// 7569 => 7576
using namespace std;

int dy[6] = {-1, 0, 0, 1};
int dx[6] = {0, -1, 1, 0};

int M, N;

int box[1001][1001];

typedef struct point {
    int y;
    int x;
}point;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    queue<point> q;

    cin >> M >> N;


    for (int j = 0; j < N; j++) {
        for (int k = 0; k < M; k++) {
            cin >> box[j][k];
            if(box[j][k] == 1) q.push({ j, k}); // z, y, x 순으로 들어감
        }
    }


    while (q.size()) {
        auto [y1, x1] = q.front();
        q.pop();

        for (int i = 0; i < 6; i++) {
            int x2 = x1 + dx[i];
            int y2 = y1 + dy[i];

            if(x2<0 || y2<0 || x2 >= M || y2 >= N) continue;
            if(box[y2][x2] == -1) continue;
            if(box[y2][x2] == 0){
                box[y2][x2] = box[y1][x1] + 1;
                q.push({y2, x2});
            }
        }
    }

    int day = 1;

    for (int j = 0; j < N; j++) {
        for (int k = 0; k < M; k++) {
            if(box[j][k]==0) {cout << -1; return 0;}
            day = day < box[j][k] ? box[j][k] : day; 
        }
    }
   
 
    cout << day-1;

    return 0;
}