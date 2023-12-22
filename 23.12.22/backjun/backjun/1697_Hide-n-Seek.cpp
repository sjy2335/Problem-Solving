#include <iostream>
#include <queue>
#include <vector>

using namespace std;
// ���� Ž��..? �ƴϴ� DP�ΰ�..? XXXXXXXX
// BFS�� �̿��ؾ� ���� �ν��ϱ�!

bool visited[200001] = { false }; // 100001 �Ѿ�� ���� ���� �ʴ� ���� �и��ѵ�, 200001 ������ �������� ������ ��� OutOfBounds��...
// ���߿� �� �ٽ� Ǯ����� �� ����..

int main(void) {

	ios_base::sync_with_stdio(NULL);  // �ӵ� ���
	cin.tie(NULL);
	cout.tie(NULL);

	int N, K, time=0, n, m; // ����, ����
	queue<pair<int, int>> q; // pair <��, �ɸ��� �ð�>�� �������� �ϴ� ť
	pair<int, int> tmp; // ���� Node ����Ű�� pair
	cin >> N >> K;
	tmp.first = N;
	tmp.second = 0;

	// ù ��° ��� ����
	q.push(tmp);
	visited[tmp.first] = true;
	
	// ����, ť�� Ȱ���� BFS ����
	// ��, push�Ǵ� ���� Max(100000)��(��) �Ѿ�� �ʵ���! 
	// ���� �׳� K*2 ������ �Ϸ��� �ߴµ�, �ڲ� ������..
	// ��, �Ʒ�ó�� push ���� pop �� �� visit ó���ϸ� ���� �߻�����. �ٵ� ��� �װ� �� ��ȿ�����̱⵵ �� ��.
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