#include <bits/stdc++.h>

using namespace std;

int dx[4] = {0, -1, 1, 0};
int dy[4] = {-1, 0, 0, 1};

int N, M, cnt;

int light[101][101];
int visited[101][101];
vector<pair<int, int>> v[101][101];


int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> M;

    for (int i = 0; i < M; i++)
    {
        int x, y, a, b;
        cin >> x >> y >> a >> b;
        v[x][y].push_back({a, b});
    }

    queue<pair<int, int>> q;

    q.push({1, 1});
    light[1][1] = 1; 
    cnt+=1;
    visited[1][1] = 1;

    while (q.size()) {
        auto [x1, y1] = q.front();
        q.pop();

        for (auto [xt, yt] : v[x1][y1]) {
            if (!light[xt][yt]) {
                light[xt][yt] = 1; 
                cnt+=1;

                for (int i = 0; i < 4; i++) {
                    int x2 = xt + dx[i];
                    int y2 = yt + dy[i];
                    if (x2 >= 1 && y2 >= 1 && x2 <= N && y2 <= N && visited[x2][y2] && !visited[xt][yt]) {
                        q.push({xt, yt});
                        visited[xt][yt] = 1;
                        break;
                    }
                }
            }
        }

        for (int i = 0; i < 4; i++) {
            int x2 = x1 + dx[i];
            int y2 = y1 + dy[i];
            if(x2 < 1 || y2 < 1 || x2 > N || y2 > N) continue;
            if(!visited[x2][y2] && light[x2][y2]){
                q.push({x2, y2});
                visited[x2][y2] = 1;
            }
        }
    }


    cout << cnt;

    return 0;
}