#include <bits/stdc++.h>

using namespace std;

int dx[4] = {0, -1, 1, 0};
int dy[4] = {-1, 0, 0, 1};

int T, w, h;
char building[1001][1001];

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin >> T;
    for (int t = 0; t < T; t++) {
        
        int visited[1001][1001] = {0,};
        bool found = false;

        pair<int, int> start;
        queue<pair<bool, pair<int, int>>> q;
    
        cin >> w >> h;
    
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                cin >> building[i][j];
                if(building[i][j]=='*') q.push({0, {i, j}});
                if(building[i][j]=='@') {start = {i, j};}
            }
        }

        q.push({1, start});
        visited[start.first][start.second] = 1;

        while (q.size()) {
            bool sangkeun = q.front().first;
            auto [x1, y1] = q.front().second;

            if((x1==0 || y1==0 || x1 == h-1 || y1 == w-1) && visited[x1][y1]){
                found = true;
                cout << visited[x1][y1] << '\n';
                break;
            }

            q.pop();
            
            for (int i = 0; i < 4; i++)
            {
                int x2 = x1 + dx[i];
                int y2 = y1 + dy[i];

                if(x2 < 0 || y2 < 0 || x2 >= h || y2 >= w) continue;

                if(sangkeun){ // 상근 처리 중이면 
                    if(building[x2][y2] == '.' && !visited[x2][y2]){
                        visited[x2][y2] = visited[x1][y1] + 1;
                        q.push({1, {x2, y2}});
                    }
                }
                if(!sangkeun) { // 불 처리 중이면
                    if(building[x2][y2] == '.' || building[x2][y2]=='@') {
                        building[x2][y2] = '*';
                        q.push({0, {x2, y2}});
                    }
                }
            }
        }

        if(!found) cout << "IMPOSSIBLE\n";

    }
    return 0;
}