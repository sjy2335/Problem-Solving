#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int N, M; // 나무의 수 N, 필요한 나무 길이 M
long long res = 0;
vector<int> v;

void F(int target, int l, int r) {
	if (l <= r) {
		int mid = (l + r) / 2;
		long long sum = 0;
		// calculating tree length
		for (int i = 0; i < N; i++) {
			if (v[i] > mid) {
				sum += v[i] - mid;
			}
		}

		if (sum >= target)
		{
			if (res < mid) res = mid;
			F(target, mid + 1, r);
		}
		else F(target, l, mid - 1);
	}
	else {
		cout << res << '\n';
		return;
	}
}

int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> N >> M;

	for (int i = 0; i < N; i++) {
		int tmp;
		cin >> tmp;
		v.push_back(tmp);
	}

	sort(v.begin(), v.end());

	F(M, 0, v[N - 1]);

	return 0;
}