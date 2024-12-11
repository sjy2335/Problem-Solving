#include <bits/stdc++.h>

using namespace std;

int dx2[8] = {-1, 1, -2, 2, -2, 2, -1, 1};
int dy2[8] = {-2, -2, -1, -1, 1, 1, 2, 2};

int dx1[4] = {0, -1, 1, 0};
int dy1[4] = {-1, 0, 0, 1};

int K, W, H;

bool board[201][201];
int visited[201][201][31];

typedef struct point{
    int x;
    int y;
    int mm; // monkey move
}point;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin >> K >> W >> H;

    for (int i = 0; i < H; i++) {
        for (int j = 0; j < W; j++) {
            cin >> board[i][j];
        }
    }

    queue<point> q;
    q.push({0, 0, 0});
    visited[0][0][0] = 1;

    while (q.size()) {
        auto [x1, y1, mm1] = q.front();

        q.pop();

        if( x1 == W-1 && y1 == H-1 ) {
            cout << visited[y1][x1][mm1]-1; 
            return 0;
        }


        if (mm1 < K) {
            for (int i = 0; i < 8; i++)
            {
                int x2 = x1 + dx2[i];
                int y2 = y1 + dy2[i];

                if(x2 >= 0 && y2 >= 0 && x2 < W && y2 < H && !visited[y2][x2][mm1+1] && !board[y2][x2]){
                    q.push({x2, y2, mm1+1});
                    visited[y2][x2][mm1+1] = visited[y1][x1][mm1]+1;
                }
            }
            
        }
        for (int i = 0; i < 4; i++)
        {
            int x2 = x1 + dx1[i];
            int y2 = y1 + dy1[i];

            if(x2 >= 0 && y2 >= 0 && x2 < W && y2 < H && !visited[y2][x2][mm1] && !board[y2][x2]){
                q.push({x2, y2, mm1});
                visited[y2][x2][mm1] = visited[y1][x1][mm1]+1;
            }
        }
    }

    cout << "-1";

    return 0;
}