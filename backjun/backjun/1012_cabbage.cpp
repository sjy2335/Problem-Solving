#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>

using namespace std;

bool visited[51][51] = {false, };
int map[51][51] = { 0, };

int x_d[] = { -1, 0, 0, 1 };
int y_d[] = { 0, -1, 1, 0 };


queue<pair<int, int>> q;

void bfs(int x1, int y1) {
	q.push({ x1, y1 });
	visited[x1][y1] = true;

	while(!q.empty()) {
		// 상하좌우 순회
		pair<int, int> tmp = q.front();
		q.pop();

		for (int i = 0; i < 4; i++) {

			int x2 = tmp.first + x_d[i];
			int y2 = tmp.second + y_d[i];

			if (x2 >= 0 && y2 >= 0 && !visited[x2][y2] && map[x2][y2]) {
				visited[x2][y2] = true;
				q.push({ x2, y2 });
			}
		}
	}

}

int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int T, M, N, K, X, Y;

	cin >> T;	// test case 개수

	for (int t = 0; t < T; t++) {
		int cnt = 0;

		cin >> M >> N >> K;	// 가로, 세로, 배추 수

		for (int i = 0; i < K; i++) {
			cin >> X >> Y;
			map[Y][X] = 1; // 배열 index는 x, y 좌표와 순서 반대!
		}

		// 방문 안한 양배추 무리에 bfs 적용 -> 적용 횟수 count
		for (int i = 0; i < N; i++) 
		{
			for (int j = 0; j < M; j++)
			{
				if (!visited[i][j] && map[i][j]) {
					bfs(i, j);
					cnt++;
				}
			}
		}

		cout << cnt << endl;

		// map, visited 초기화
		fill_n(&map[0][0], 51*51, 0);
		fill_n(&visited[0][0], 51*51, false);
	}
	
	return 0;
}