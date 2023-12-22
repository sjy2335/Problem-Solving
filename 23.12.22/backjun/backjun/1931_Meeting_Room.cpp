#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

// Greedy Algorithm !!

// 시간 초과.. 그냥 종료 시간을 기준으로 정렬하고 앞 시간과
// 겹치는지 확인하면 가장 많은 회의를 담을 수 있음.

int main(void) {
	ios_base::sync_with_stdio(0);
	cin.tie(NULL);
	cout.tie(NULL);

	int N, start, end, res=0, prevEnd=0;
	vector<pair<int, int>> meetings;
	cin >> N;

	// 회의 목록 벡터에 end, start 순서 pair로 입력
	for (int i = 0; i < N; i++) {
		cin >> start >> end;
		meetings.push_back(make_pair(end, start));
	}
	// -> 끝나는 시간 기준 오름차순 정렬
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