#include <iostream>
#include <queue>
#include <vector>

using namespace std;
// 이진 탐색..? 아니다 DP인가..? XXXXXXXX
// BFS를 이용해야 함을 인식하기!

bool visited[200001] = { false }; // 100001 넘어가는 값은 쓰지 않는 것이 분명한데, 200001 정도로 선언하지 않으면 계속 OutOfBounds가...
// 나중에 꼭 다시 풀어봐야 할 문제..

int main(void) {

	ios_base::sync_with_stdio(NULL);  // 속도 향상
	cin.tie(NULL);
	cout.tie(NULL);

	int N, K, time=0, n, m; // 수빈, 동생
	queue<pair<int, int>> q; // pair <값, 걸리는 시간>을 정점으로 하는 큐
	pair<int, int> tmp; // 현재 Node 가리키는 pair
	cin >> N >> K;
	tmp.first = N;
	tmp.second = 0;

	// 첫 번째 노드 삽입
	q.push(tmp);
	visited[tmp.first] = true;
	
	// 이후, 큐를 활용해 BFS 구현
	// 단, push되는 값이 Max(100000)를(을) 넘어가지 않도록! 
	// 원래 그냥 K*2 정도로 하려고 했는데, 자꾸 에러가..
	// 또, 아래처럼 push 말고 pop 할 때 visit 처리하면 에러 발생했음. 근데 사실 그게 더 비효율적이기도 한 듯.
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