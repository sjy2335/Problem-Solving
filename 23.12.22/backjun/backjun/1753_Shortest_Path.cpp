#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>

#define INF 1e9

using namespace std;

// bool visited[20001] = { false, };

vector<pair<int, int>> graph[20001];
int table[20001]; // �ִ� �Ÿ� ���̺�
int V, E, K; // Vertices, Edges, Starting

// �ð��ʰ�...
// int get_shortest() {
//	int min = INF;
//	int idx;
//	for (int i = 1; i <= V; i++) {
//		if (table[i] <= min && !visited[i]) {
//			min = table[i];
//			idx = i;
//		}
//	}
//	return idx;
//}
//
//void dijkstra() {
//	// ���� ��� �ڽ� �Ÿ� 0
//	table[K] = 0;
//
//	for (int i = 0; i < E; i++) {
//		int crnt = get_shortest();
//		visited[crnt] = true;
//		for (int j = 0; j < graph[crnt].size(); j++) {
//			int cost = table[crnt] + graph[crnt][j].second;
//			if (cost < table[graph[crnt][j].first]) {
//				table[graph[crnt][j].first] = cost;
//			}
//		}
//	}
//}

void dijkstra() {
	
	// priority_queue ����ؼ� �ִ� �Ÿ� ���̺��� ��� ���� �ð� �ּ�ȭ
	priority_queue< pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>> > pq; // �ڵ����� ù��° ���ҷ� ��
	pq.push({ 0, K }); // ���� ��� �Ÿ� 0
	table[K] = 0;

	while (!pq.empty()) {
		int dist = pq.top().first;
		int crnt = pq.top().second;
		pq.pop();
		if (table[crnt] < dist) continue;
		for (int i = 0; i < graph[crnt].size(); i++) {
			int cost = dist + graph[crnt][i].second;
			if (cost < table[graph[crnt][i].first]) {
				table[graph[crnt][i].first] = cost;
				pq.push({ cost, graph[crnt][i].first });
			}
		}
	}
}

int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int u, v, w; // u ---( w: weight )---> v

	cin >> V >> E;
	cin >> K;

	for (int i = 0; i < E; i++) {
		cin >> u >> v >> w;
		graph[u].push_back({ v, w });
	}

	fill_n(table, V + 1, INF); // �ִ� �Ÿ� ���̺� �ʱ�ȭ
	dijkstra();

	for (int i = 1; i <= V; i++) {
		if (table[i] == INF) cout << "INF";
		else cout << table[i];
		cout << '\n';
	}

	return 0;
}