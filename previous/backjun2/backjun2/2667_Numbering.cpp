#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int map[26][26];

int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N;
	cin >> N;

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cin >> map[i][j];
		}
	}

	// 그래프 이론
	// DFS? BFS? -> BFS
	// 상좌우하(최적화 나으려나)
	int dx[4] = { 0, -1, 1, 0 };
	int dy[4] = { -1, 0, 0, 1 };



	return 0;

}