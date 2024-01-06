/*
	Samsung SW Expert Academy 23-24 Winter
	No. 2 [pre-assignment] Last war against AI

	Greedy Algorithm
*/

#include<iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(int argc, char** argv)
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	unsigned int test_case, T;
	cin >> T;

	for (test_case = 1; test_case <= T; ++test_case)
	{
		unsigned int n;
		cin >> n;
		vector<vector<int>> agents(n, vector<int>(3));
		for (int i = 0; i < n; i++) {
			cin >> agents[i][0] >> agents[i][1] >> agents[i][2];
		}
		sort(agents.begin(), agents.end(), [](const vector<int>& a, const vector<int>& b) {
			return a[0] + a[1] + a[2] > b[0] + b[1] + b[2];
		});
		vector<int> shared(3, 0);
		int loss = 0;
		for (auto& agent : agents) {
			if(find(shared.))
		}
		cout << '#' << test_case << ' ' << result << '\n';
	}
	return 0;
}