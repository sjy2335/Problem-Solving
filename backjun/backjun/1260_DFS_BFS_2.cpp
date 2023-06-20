#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>

using namespace std;

bool visited[1001] = { false, };
vector<int> a[1001]; // 인접 리스트

void dfs(int v) {
	if (visited[v]) return;

	cout << v << ' ';
	visited[v] = true;

	for (unsigned int i = 0; i < a[v].size(); i++) {
		int w = a[v][i];
		dfs(w);
	}
}

void bfs(int v) {
	queue<int> q;
	q.push(v);
	visited[v] = true;
	cout << v << ' ';

	while (!q.empty()) {
		int tmp = q.front();
		q.pop();
		for (unsigned int i = 0; i < a[tmp].size(); i++) {
			int tmp2 = a[tmp][i];
			if (!visited[tmp2]) {
				visited[tmp2] = true;
				cout << tmp2 << ' ';
				q.push(tmp2);
			}
		}
	}
}


int main(void) {

	int N, M, V;
	int n1, n2;

	cin >> N >> M >> V;

	for (int i = 1; i <= M; i++) {
		cin >> n1 >> n2;
		a[n1].push_back(n2);
		a[n2].push_back(n1);
	}

	// 오름차순 정렬해야 예제와 같이 출력됨
	for (int i = 1; i <= N; i++) {
		sort(a[i].begin(), a[i].end());
	}

	dfs(V);
	cout << endl;

	fill_n(visited, 1001, false); // 방문 배열 초기화

	bfs(V);
	cout << endl;
	
	return 0;
}