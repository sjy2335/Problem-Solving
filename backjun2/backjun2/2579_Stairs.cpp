#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int N, stairs[301], dp[301];

int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> N;

	for (int i = 0; i < N; i++) {
		cin >> stairs[i];
	}

	// 재귀함수 없이, 반복문과 DP 테이블로 구현
	dp[0] = stairs[0];
	dp[1] = dp[0] + stairs[1];
	dp[2] = max(stairs[0] + stairs[2], stairs[1] + stairs[2]);

	for (int i = 3; i < N; i++) {
		dp[i] = max(dp[i - 2] + stairs[i], dp[i - 3] + stairs[i - 1] + stairs[i]);
	}

	cout << dp[N - 1] << '\n';

	return 0;

}