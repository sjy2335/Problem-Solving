#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

// C++ => ���͸� Ȱ���� ���� ����Ʈ�� �׷��� ����, ���� ����
vector<int> graph[1001];
bool visited[1001] = {false};
bool pushed[1001] = { false };
void DFS(int V);
void BFS(int V);

int main(void) {

	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	int N=0, M=0, V=0, v1=0, v2=0; // ���� ����, ���� ����, ���� ����
	cin >> N >> M >> V;

	// ���� ����Ʈ ä���
	for (int i = 0; i < M; i++) {
		cin >> v1 >> v2;
		graph[v1].push_back(v2);
		graph[v2].push_back(v1);
	}

	// �������� ���� �ؾ� ������ ���� ��µ�..
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
	// ��������� ����

	// ���� ���� �湮
	visited[V] = true;
	cout << V << ' ';

	// ���� ������ ���� �������� �湮
	for (int i = 0; i < graph[V].size(); i++) {
		int tmp = graph[V][i];
		if (!visited[tmp]) {
			DFS(tmp);
		}
	}
	return;
}

void BFS(int V) {
	// Queue�� ����
	
	// ���� ���� push & �湮
	queue<int> queue;
	queue.push(V);
	pushed[V] = true;

	// Queue�� �� ������
	while (!queue.empty()) {

		// front �湮
		V = queue.front();
		visited[V] = true;
		cout << V << ' ';

		// front�� ������ ������ push �� front�� pop
		for (int i = 0; i < graph[V].size(); i++) {
			int tmp = graph[V][i];
			if (!visited[tmp] && !pushed[tmp]) {
				queue.push(tmp);
				pushed[tmp] = true;
			}
		}
		// ���� ������ ó�� ���� front�� pop��.
		queue.pop();
	}
}