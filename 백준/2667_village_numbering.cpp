#include <bits/stdc++.h>

using namespace std;

int dx[4] = {0, -1, 1, 0};
int dy[4] = {-1, 0, 0, 1};

int N, cnt;

int arr[25][25];
bool visited[25][25];

int bfs(int x, int y){
    int area = 0;

    queue<pair<int, int>> q;
    q.push({x, y});
    visited[x][y] = true;

    while (!q.empty()) {
        auto [x1, y1] = q.front();
        q.pop();
        area++;

        for (int i = 0; i < 4; i++)
        {
            int x2 = x1 + dx[i];
            int y2 = y1 + dy[i];
            if (x2 >= 0 && y2 >= 0 && x2 < N && y2 < N && arr[x2][y2] && !visited[x2][y2]) {
                q.push({x2, y2});
                visited[x2][y2] = true;
            }
        }
    }
    return area;
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    for (int i = 0; i < N; i++) {
        string s;
        cin >> s;
        for (int j = 0; j < N; j++){
            arr[i][j] = s[j] - '0';
        }
    }
    
    vector<int> v;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            if(arr[i][j]&&!visited[i][j]){
                cnt++;
                v.push_back(bfs(i, j));
            }
        }
    }
    sort(v.begin(), v.end());
    
    cout << cnt << '\n';

    for (auto i : v) {
        cout << i << '\n';
    }
    
    

    return 0;
}