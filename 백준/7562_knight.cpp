#include <bits/stdc++.h>

using namespace std;

int dx[8] = {-1, 1, -2, 2, -2, 2, -1, 1};
int dy[8] = {-2, -2, -1, -1, 1, 1, 2, 2};

int board[300][300];
int T;



int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin >> T;
    for (int i = 0; i < T; i++) {

        fill(&board[0][0], &board[0][0]+300*300, 0);

        int l;
        cin >> l;
        int cx, cy, tx, ty;
        cin >> cx >> cy;
        cin >> tx >> ty;

        int cnt = 0;

        queue<pair<int, int>> q;

        q.push({cx, cy});
        board[cx][cy] = 1;

        while (!board[tx][ty]) {
            auto [x1, y1] = q.front();
            q.pop();
            for (int i = 0; i < 8; i++)
            {
                int x2 = x1 + dx[i];
                int y2 = y1 + dy[i];
                if(x2>=0 && y2>=0 && x2 <l && y2 <l && !board[x2][y2]){
                    q.push({x2, y2});
                    board[x2][y2] = board[x1][y1] + 1;
                }
            }            
        }

        cout << board[tx][ty] - 1 << '\n';

    }
    

    return 0;
}