#include <iostream>
#include <queue>
#include <vector>

using namespace std;
// 이진 탐색..? 아니다 DP인가..? XXXXXXXX
// BFS를 이용해야 함을 인식하기!

bool visited[200001] = { false };

int main(void) {

	ios_base::sync_with_stdio(NULL);  // 속도 향상
	cin.tie(NULL);
	cout.tie(NULL);

	int N, K, time=0, n, m; // 수빈, 동생
	queue<pair<int, int>> q; // <값, 시간>을 정점으로 하는 큐
	pair<int, int> tmp;
	cin >> N >> K;
	tmp.first = N;
	tmp.second = 0;

	q.push(tmp);
	visited[tmp.first] = true;
	
	while (tmp.first != K) {
		tmp = q.front();
		n = tmp.first;
		m = tmp.second;
		q.pop();
			
		if (!visited[n - 1] && n - 1 >= 0) {
			visited[n - 1] = true;
			q.push(make_pair(n - 1, m + 1));
		}
		if (!visited[n + 1] && n + 1 < 100001) {
			visited[n + 1] = true;
			q.push(make_pair(n + 1, m + 1));
		}
		if (!visited[n * 2] && n * 2 < 100001) {
			visited[n * 2] = true;
			q.push(make_pair(n * 2, m + 1));
		}
	}
	cout << tmp.second;

	return 0;
}