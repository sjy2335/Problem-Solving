#include <iostream>

using namespace std;


int main(void) {

	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	int N, x1, y1, r1, x2, y2, r2, res, dist;
	cin >> N;

	for (int i = 0; i < N; i++) {

		cin >> x1 >> y1 >> r1 >> x2 >> y2 >> r2;

		dist = (x1 - x2) * (x1 - x2) + (y1-y2)* (y1 - y2); // 두 원 중심 거리 (제곱)
		int r_sum = (r1 + r2) * (r1 + r2); // 반지름 합의 제곱
		int r_sub = (r1 - r2) * (r1 - r2); // 반지름 차의 제곱

		// dist와 r_sub, r_sum의 관계를 이용
		// +) 조건 설정할 때 임계점(내접하는 지점)에서 거리, 반지름 차의 관계 살피기
		// 고등 수학 생각나네...

		// 거리가 반지름 차보단 크고, 반지름 합보단 작으면 교점 2개
		if (dist > r_sub && dist < r_sum) res = 2;

		// 외접 || 내점
		else if (r_sum == dist || r_sub == dist) res = 1;

		// else로 교점 없는 경우 처리
		else res = 0;

		// if - else 흐름 빠져 나와서 겹치는 경우 처리
		if (dist == 0 && r1 == r2) res = -1;

		cout << res << '\n';
	}
	return 0;
}