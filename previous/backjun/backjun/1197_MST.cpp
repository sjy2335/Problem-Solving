#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int parent[10001];

int get_parent(int x) {
	if (parent[x] == x) return x;
	return parent[x] = get_parent(parent[x]);
}

void union_parent(int a, int b) {
	a = get_parent(a);
	b = get_parent(b);
	if (a < b) parent[b] = a;
	else parent[a] = b;
}

bool find_parent(int a, int b) {
	a = get_parent(a);
	b = get_parent(b);
	if (a == b) return true;
	return false;
}

// ��ü ���� �߿��� ª�� ������� �׷����� ���Խ��Ѿ� ��.
// ���� ����Ʈ���ٴ� ���� ��ü ���� ��ü�� �ϳ��� ���Ϳ� �ֱ�.
class Edge {
public:
	int node[2];
	int dist;
	Edge(int a, int b, int dist) {
		this->node[0] = a;
		this->node[1] = b;
		this->dist = dist;
	}
	// ���� sort �Լ� ������ ���� ������ �������̵�
	bool operator <(Edge& edge) {
		return this->dist < edge.dist;
	}
};


int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int V, E, A, B, C;
	vector<Edge> edges;

	cin >> V >> E;

	for (int i = 0; i < E; i++) {
		cin >> A >> B >> C;
		edges.push_back(Edge(A, B, C));
	}

	sort(edges.begin(), edges.end());

	int res = 0;

	for (int i = 1; i <= V; i++) {
		parent[i] = i;
	}

	for (int i = 0; i < edges.size(); i++) {
		if (!find_parent(edges[i].node[0], edges[i].node[1])) {
			res += edges[i].dist;
			union_parent(edges[i].node[0], edges[i].node[1]);
		}
	}

	cout << res << '\n';

	return 0;
}