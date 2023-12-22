#include <iostream>
#include <vector>
#include <stack>

using namespace std;

bool visited[101]; // starts with vertex 1, need 101 indices
vector<int> a[101]; // a for adjacent list
stack<pair<int, int>> stk;

int dfs(int start, int end) {
    stk.push({ start, 0 }); // pair of {node, count}
    visited[start] = true;

    while (!stk.empty()) {
        int person = stk.top().first;
        int count = stk.top().second;
        stk.pop();

        if (person == end) {
            return count;
        }

        for (int i = 0; i < a[person].size(); i++) {
            int neighbor = a[person][i];
            if (!visited[neighbor]) {
                stk.push({ neighbor, count + 1 });
                visited[neighbor] = true;
            }
        }
    }

    return -1;
}

int main(void) {

	ios_base::sync_with_stdio(NULL);  // 3 lines for c++ execution time speed up
	cin.tie(NULL);
	cout.tie(NULL);

	int V, t1, t2, E;
	cin >> V;
	cin >> t1 >> t2;
	cin >> E;

	int n1, n2;

	// adding edges in adjacent list
	for (int i = 0; i < E; i++) {
		cin >> n1 >> n2;
		a[n1].push_back(n2);
		a[n2].push_back(n1);
	}

	int result = dfs(t1, t2);

	cout << result << '\n';

	return 0;
}