#include <iostream>
#include <vector>

using namespace std;

int N, M;

void backtracking(int k, vector<int> v) {

	if (v.size() == M) {
		for (int i = 0; i < v.size(); i++) cout << v[i] << " ";
		cout << endl;
		return;
	}

	for (int i = k; i <= N; i++) {
		v.push_back(i);
		backtracking(i + 1, v);
		v.pop_back();
	}
}

int main(void) {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	vector<int> v;

	cin >> N >> M;

	backtracking(1, v);

	return 0;
}
