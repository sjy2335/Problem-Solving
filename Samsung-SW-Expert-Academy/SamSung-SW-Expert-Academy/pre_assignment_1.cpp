/*
	Samsung SW Expert Academy 23-24 Winter
	No. 1 [pre-assignment] Triangle-Gimbap World

	Shortest Path - Graph BFS
*/

#include<iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

const int MAX = 10001;

int dist[MAX];
vector<int> adj[MAX];

inline void bfs(int start) {
	queue<int> q;
	dist[start] = 0;
	q.push(start);
	while (!q.empty()) {
		int curr = q.front();
		q.pop();
		for (int next : adj[curr]) {
			if (dist[next] == -1) {
				dist[next] = dist[curr] + 1;
				q.push(next);
			}
		}
	}
}

int main(int argc, char** argv)
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	int test_case;
	int T;
	cin >> T;

	register int i, j; // 유의미한가?
	for (i = 1; i <= 141; i++) {
		for (j = i * (i - 1) >> 1 + 1; j <= i * (i + 1) >> 1; j++) {
			// 아래 층과 연결
			if (j - i >= (i - 1) * (i - 2) >> 1 + 1) {
				adj[j].push_back(j - i);
				adj[j - i].push_back(j); // 반대 방향도 연결
			}
			if (j - i + 1 >= (i - 1) * (i - 2) >> 1 + 1 && j - i + 1 <= i * (i - 1) >> 1) {
				adj[j].push_back(j - i + 1);
				adj[j - i + 1].push_back(j);
			}

			// 오른쪽 노드와 연결
			if (j + 1 <= i * (i + 1) >> 1) {
				adj[j].push_back(j + 1);
				adj[j + 1].push_back(j);
			}
		}
	}


	for (test_case = 1; test_case <= T; ++test_case)
	{
		int s, e;
		cin >> s >> e;

		fill(dist, dist + 10001, -1);
		
		bfs(s);
		cout << '#' << test_case << ' ' << dist[e] << '\n';
	}
	return 0;
}