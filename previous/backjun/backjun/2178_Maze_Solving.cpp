#include <iostream>
#include <queue>

using namespace std;

int maze[102][102];
int dist[102][102];
bool visited[102][102]; // 전역 변수는 0으로 자동 초기화

int r_d[4] = { -1, 0, 0, 1 };
int c_d[4] = { 0, -1, 1, 0 }; // 상 좌 우 하 가 빠를까 해서
int N, M;

queue<pair<int, int>> q;

void bfs(int r1, int c1) {
	
	visited[r1][c1] = true;
	q.push({ r1, c1 });
	dist[r1][c1]++;

	while (!q.empty()) {
		
		int r_crnt = q.front().first;
		int c_crnt = q.front().second;

		q.pop();

		for (int i = 0; i < 4; i++) {
			int r2 = r_crnt + r_d[i];
			int c2 = c_crnt + c_d[i];

			if (r2 >= 1 && c2 >= 1 && !visited[r2][c2] && maze[r2][c2]) {
				visited[r2][c2] = true;
				q.push({ r2, c2 });
				dist[r2][c2] = dist[r_crnt][c_crnt] + 1;
			}
		}
	}
}

int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> N >> M;

	char tmp;

	// index [1][1] 부터 [N][M]까지 입력 받음
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= M; j++) {
			cin >> tmp;
			maze[i][j] = tmp - '0';
		}
	}

	bfs(1, 1);
	cout << dist[N][M] << '\n';

	return 0;
}