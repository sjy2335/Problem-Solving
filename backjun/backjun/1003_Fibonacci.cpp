#include <iostream>
#include <vector>

using namespace std;

// ²ôÀû²ôÀû -> DP.
int main(void) {

	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	vector<pair<int,int>> DP;
	pair<int, int> tmp;

	int T=0, N=0;

	cin >> T;

	for (int i = 0; i < T; i++) {
		cin >> N;

		// DP[0]°ú DP[1] ÃÊ±âÈ­
		tmp.first = 1;
		tmp.second = 0;
		DP.push_back(tmp);

		tmp.first = 0;
		tmp.second = 1;
		DP.push_back(tmp);
		
		for (int j = 2; j <= N; j++) {
			tmp.first = DP[j - 2].first + DP[j - 1].first;
			tmp.second = DP[j - 2].second + DP[j - 1].second;
			DP.push_back(tmp);
		}

		cout << DP[N].first << ' ' << DP[N].second;
		cout << '\n';

		vector<pair<int, int>>().swap(DP);
	}
	return 0;
}