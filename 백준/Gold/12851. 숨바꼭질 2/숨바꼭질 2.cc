#include <iostream>
#include <queue>
#include <vector>

using namespace std;

const int MAX = 100000;

void bfs(int N, int K) {
    if (N == K) {
        cout << 0 << "\n" << 1 << "\n";
        return;
    }

    vector<int> dist(MAX + 1, -1);
    vector<int> ways(MAX + 1, 0);

    queue<int> q;
    q.push(N);
    dist[N] = 0;
    ways[N] = 1;

    while (!q.empty()) {
        int curr = q.front();
        q.pop();

        for (int next : {curr - 1, curr + 1, 2 * curr}) {
            if (next < 0 || next > MAX) continue; // 도달 불가능한 경우

            if (dist[next] == -1) { // 처음 방문하는 경우 (== 가장 빠르게 도달)
                dist[next] = dist[curr] + 1;
                ways[next] = ways[curr];
                q.push(next);
            } 
            
            else if (dist[next] == dist[curr] + 1) { // 다른 방법으로 가장 빠르게 도달하는 경우
                ways[next] += ways[curr];
            }
        }
    }

    cout << dist[K] << "\n" << ways[K] << "\n";
    return;
}

int main() {
    int N, K;
    cin >> N >> K;
    bfs(N, K);
    return 0;
}