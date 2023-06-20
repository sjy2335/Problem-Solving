#include <iostream>
#include <vector>

using namespace std;

bool visited[101]; // starts with vertex 1, need 101 indices
vector<int> a[101]; // a for adjacent list
int count;

void dfs(int n) {
	if (visited[n]) return;
	visited[n] = true;
	if (n != 1) ::count++;
	for (unsigned int i = 0; i < a[n].size(); i++) {
		int m = a[n][i];
		dfs(m);
	}
}

int main(void) {

	ios_base::sync_with_stdio(NULL);  // 3 lines for c++ execution time speed up
	cin.tie(NULL);
	cout.tie(NULL);

	int V, E;
	cin >> V;
	cin >> E;

	int n1, n2;
	::count = 0;

	// adding edges in adjacent list
	for (int i = 0; i < E; i++) {
		cin >> n1 >> n2;
		a[n1].push_back(n2);
		a[n2].push_back(n1);
	}

	dfs(1);

	cout << ::count << '\n';

	return 0;
}