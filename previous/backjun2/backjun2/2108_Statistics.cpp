#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>


using namespace std;

int N, arr[500001], cnt[8002];

int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> N;

	for (int i = 0; i < N; i++) {
		int tmp;
		cin >> tmp;
		arr[i] = tmp;
		cnt[tmp + 4000]++;
	}

	int sum = 0;

	// mean
	for (int i = 0; i < N; i++) {
		sum += arr[i];
	}
	int res = floor(float(sum) / float(N) + 0.5); // 0.5 더하고 내림하면 반올림과 가틈
	cout << res << '\n';

	// median
	sort(arr, arr + N); // 입력 받은 배열 오름차순 정렬
	cout << arr[N / 2] << '\n';

	// mode
	int most = -1;
	int most_val;
	bool second = false;

	for (int i = 0; i < 8002; i++) {
		if (cnt[i] == 0) continue;
		if (cnt[i] == most) {
			if (second) {
				most_val = i - 4000;
				second = false;
			}
		}
		if (cnt[i] > most) {
			most = cnt[i];
			most_val = i - 4000;
			second = true;
		}
	}

	cout << most_val << '\n';

	// distance
	cout << arr[N - 1] - arr[0] << '\n';

	return 0;

}