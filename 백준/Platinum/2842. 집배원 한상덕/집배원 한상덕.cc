#include <iostream>
#include <deque>
#include <set>
#include <map>

using namespace std;

const int MAX_N = 50;
int N, K;
pair<int, int> P;
char village[MAX_N][MAX_N];
int heights[MAX_N][MAX_N];
set<int> height_set;
const int dr[] = {-1, -1, -1, 0, 0, 1, 1, 1};
const int dc[] = {-1, 0, 1, -1, 1, -1, 0, 1,};


int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            cin >> village[i][j];
            if (village[i][j] == 'K') K++;
            else if (village[i][j] == 'P') P = {i, j};

        }
    }


    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            cin >> heights[i][j];
            height_set.insert(heights[i][j]);
        }
    }

    auto min_h = height_set.begin();
    auto max_h = height_set.begin();
    int answer = 1'000'000;

    while (max_h != height_set.end() && min_h != height_set.end()) {
        int tmp_k = 0;
        deque<pair<int, int>> dq;
        bool visited[MAX_N][MAX_N] = {false};

        if (heights[P.first][P.second] >= *min_h && heights[P.first][P.second] <= *max_h) {
            dq.push_back(P);
            visited[P.first][P.second] = true;
        }
        
        while (!dq.empty()) {
            pair<int, int> curr = dq.front();
            dq.pop_front();

            for (int i = 0; i < 8; i++) {
                int nr = curr.first + dr[i];
                int nc = curr.second + dc[i];

                if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
                if (visited[nr][nc]) continue;
                if (heights[nr][nc] < *min_h || heights[nr][nc] > *max_h) continue;
                if (village[nr][nc] == 'K') tmp_k++;
                visited[nr][nc] = true;
                dq.emplace_back(nr, nc);
            }
        }

        if (K == tmp_k) {
            answer = min(answer, *max_h - *min_h);
            min_h++;
            if (*max_h < *min_h) max_h = min_h;
        }
        else {
            max_h++;
        }
    }

    cout << answer << endl;

    return 0;
}