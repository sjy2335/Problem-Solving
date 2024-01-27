#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

// C++ => 벡터를 활용해 인접 리스트로 그래프 구현, 전역 변수
vector<int> graph[1001];
bool visited[1001] = {false};
bool pushed[1001] = { false };
void DFS(int V);
void BFS(int V);

int main(void) {

	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	int N=0, M=0, V=0, v1=0, v2=0; // 정점 개수, 간선 개수, 시작 정점
	cin >> N >> M >> V;

	// 인접 리스트 채우기
	for (int i = 0; i < M; i++) {
		cin >> v1 >> v2;
		graph[v1].push_back(v2);
		graph[v2].push_back(v1);
	}

	// 오름차순 정렬 해야 예제랑 같이 출력됨..
	for (int i = 0; i <= N; i++) {
		sort(graph[i].begin(), graph[i].end());
	}

	DFS(V);
	for (int i = 0; i <= N; i++) visited[i] = false;
	cout << '\n';
	BFS(V);

	return 0;
}

void DFS(int V) {
	// 재귀적으로 구현

	// 현재 정점 방문
	visited[V] = true;
	cout << V << ' ';

	// 현재 정점의 인접 정점들을 방문
	for (int i = 0; i < graph[V].size(); i++) {
		int tmp = graph[V][i];
		if (!visited[tmp]) {
			DFS(tmp);
		}
	}
	return;
}

void BFS(int V) {
	// Queue로 구현
	
	// 시작 정점 push & 방문
	queue<int> queue;
	queue.push(V);
	pushed[V] = true;

	// Queue가 빌 때까지
	while (!queue.empty()) {

		// front 방문
		V = queue.front();
		visited[V] = true;
		cout << V << ' ';

		// front의 인접한 정점들 push 후 front를 pop
		for (int i = 0; i < graph[V].size(); i++) {
			int tmp = graph[V][i];
			if (!visited[tmp] && !pushed[tmp]) {
				queue.push(tmp);
				pushed[tmp] = true;
			}
		}
		// 인접 정점들 처리 이후 front를 pop함.
		queue.pop();
	}
}