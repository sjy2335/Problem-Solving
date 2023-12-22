#include <iostream>
#include <string>
#include <algorithm>

#define MAX 1000001

using namespace std;

int d[MAX];

int dp(int n){

	if (n == 1) return 0;

	if (d[n] != 0 && d[n] != MAX) return d[n];


	if (n % 2 == 0 && n % 3 == 0) {
		int res1 = min(dp(n / 3), dp(n / 2));
		return d[n] = min(res1, dp(n - 1)) + 1;
	}

	else if (n % 2 == 0) {
		return d[n] = min(dp(n / 2), dp(n - 1)) + 1;
	}

	else if (n % 3 == 0) {
		
		return d[n] = min(dp(n / 3), dp(n - 1)) + 1;
	}

	return d[n] = dp(n - 1) + 1;

}

int main(void) {

	int N;

	cin >> N;

	for (int i = 2; i <= N; i++) {
		d[i] = MAX;
	}

	cout << dp(N) << endl;

	return 0;
}