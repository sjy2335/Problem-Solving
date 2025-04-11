#include <iostream>
#include <queue>

using namespace std;

int dr[] = {-1, -1, -1,  0, 0,  1, 1, 1};
int dc[] = {-1,  0,  1, -1, 1, -1, 0, 1};

int w, h;
int map[50][50];
bool visited[50][50];

void bfs(int r, int c) {
    visited[r][c] = true;
    queue<pair<int, int> > q;
    q.push(make_pair(r, c));

    while (!q.empty()) {
        pair<int, int> curr = q.front();
        q.pop();
        for (int i = 0; i < 8; i++) {
            int nr = curr.first  + dr[i];
            int nc = curr.second + dc[i];

            if (nr < 0 || nc < 0 || nr >= h || nc >= w) continue;
            if (map[nr][nc] == 0) continue;
            if (visited[nr][nc]) continue;

            visited[nr][nc] = true;
            q.push(make_pair(nr, nc));
        }
    }
}

int getIslandsCount() {
    fill(&visited[0][0], &visited[0][0] + 50 * 50, false);

    int count = 0;
    for (int i = 0; i < h; i++) {
        for (int j = 0; j < w; j++) {
            if (visited[i][j]) continue;
            if (map[i][j] == 0) continue;
            count++;
            bfs(i, j);
        }
    }

    return count;
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    while (true) {
        cin >> w >> h;
        if (w == 0 && h == 0) break;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                cin >> map[i][j];
            }
        }

        cout << getIslandsCount() << "\n";

    }
    return 0;
}