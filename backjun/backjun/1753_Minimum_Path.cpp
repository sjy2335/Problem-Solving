#include <iostream>
#include <vector>
#include <queue>

using namespace std;

// Just a general Dijkstra using Problem

int main(void) {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	int V=0, E=0, K=0; // num of Vertices, Edges, Starting Vertex
	cin >> V >> E;
	cin >> K;
	vector<vector<pair<int, int>>> graph(V+1);
	vector<int> table(V + 1);

	int u = 0, v = 0, w = 0; // u --(w)--> v
	for (int i = 0; i < E; i++) {
		cin >> u >> v >> w;
		graph[u].push_back({ v, w }); // Directed Graph
	}
	
	priority_queue<pair<int, int>> pq; // previous V, minimum path
	for (int i = 1; i <= V; i++) {
		
	}


	return 0;
}