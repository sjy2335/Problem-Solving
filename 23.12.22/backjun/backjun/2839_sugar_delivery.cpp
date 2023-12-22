#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int d[5001] = { 0, };

int dp(int N) {

	if (N == 0) return 0;
	if (N < 0) return -1;
	if (d[N] != 0) return d[N];

	int result = -1;

	int res1 = dp(N - 3);
	int res2 = dp(N - 5);

	if (res1 != -1 && res2 != -1) result = min(res1, res2) + 1;
	else if (res1 != -1) result = res1 + 1;
	else if (res2 != -1) result = res2 + 1;

	return d[N] = result;
}



int main(void) {

	ios_base::sync_with_stdio(0);
	cin.tie(NULL);
	cout.tie(NULL);

	int n, res;
	cin >> n;

	cout << dp(n) << endl;
	return 0;

}