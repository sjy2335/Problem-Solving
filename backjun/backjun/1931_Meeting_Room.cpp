#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

// Greedy Algorithm !!

// �ð� �ʰ�.. �׳� ���� �ð��� �������� �����ϰ� �� �ð���
// ��ġ���� Ȯ���ϸ� ���� ���� ȸ�Ǹ� ���� �� ����.

int main(void) {
	ios_base::sync_with_stdio(0);
	cin.tie(NULL);
	cout.tie(NULL);

	int N, start, end, res=0, prevEnd=0;
	vector<pair<int, int>> meetings;
	cin >> N;

	// ȸ�� ��� ���Ϳ� end, start ���� pair�� �Է�
	for (int i = 0; i < N; i++) {
		cin >> start >> end;
		meetings.push_back(make_pair(end, start));
	}
	// -> ������ �ð� ���� �������� ����
	sort(meetings.begin(), meetings.end());

	for (int i = 0; i < N; i++) {
		if (meetings[i].second >= prevEnd) {
			res++;
			prevEnd = meetings[i].first;
		}
	}

	cout << res;
	return 0;
}