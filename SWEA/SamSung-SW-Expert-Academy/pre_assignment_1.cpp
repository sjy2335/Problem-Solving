#include<iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

const int MAX = 10001; 
vector<int> adj[MAX]; // 인접 리스트를 저장하는 배열

int bfs(int start, int end) {
    if (start == end) return 0; // 시작점과 끝점이 같은 경우

    vector<int> dist(MAX, -1);
    queue<int> q;
    q.push(start);
    dist[start] = 0;

    while (!q.empty()) {
        int curr = q.front();
        q.pop();
        for (int next : adj[curr]) {
            if (dist[next] == -1) {
                dist[next] = dist[curr] + 1;
                q.push(next);
                if (next == end) return dist[next]; // 목표 지점에 도달한 경우 조기 종료
            }
        }
    }

    return dist[end];
}

// 피라미드 그래프 형식 만드는 함수
void buildPyramid() {
    for (int i = 1; i <= 141; ++i) {
        int start = i * (i - 1) / 2 + 1;
        int end = i * (i + 1) / 2;
        for (int j = start; j <= end; ++j) {
            if (j + i < MAX) {
                adj[j].push_back(j + i); // 왼쪽 아래
                adj[j + i].push_back(j); // 역방향
            }
            if (j + i + 1 < MAX) {
                adj[j].push_back(j + i + 1); // 오른쪽 아래
                adj[j + i + 1].push_back(j); // 역방향
            }
            if (j + 1 <= end) {
                adj[j].push_back(j + 1); // 오른쪽
                adj[j + 1].push_back(j); // 역방향
            }
        }
    }
}


int main(int argc, char** argv)
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    buildPyramid();

    int test_case;
    int T;
    cin >> T;

    for (test_case = 1; test_case <= T; ++test_case) {
        int s, e;
        cin >> s >> e;

        cout << '#' << test_case << ' ' << bfs(s, e) << '\n';
    }
    
    return 0;
}
