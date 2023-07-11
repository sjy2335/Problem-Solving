#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int K, N, tmp;
	cin >> K >> N;
	vector<int> v;

	for (int i = 0; i < K; i++) {
		cin >> tmp;
		v.push_back(tmp);
	}

	sort(v.begin(), v.end());

	long long left = 1;
	long long right = v[K - 1];

	while (left <= right) {
		long long mid = (left + right) / 2;
		long long count = 0;

		for (unsigned int i = 0; i < K; i++) {
			count += v[i] / mid;
		}

		if (count < N) right = mid - 1;
		else {
			left = mid + 1;
		}
	}
	
	cout << right << endl;
	
	return 0;
}