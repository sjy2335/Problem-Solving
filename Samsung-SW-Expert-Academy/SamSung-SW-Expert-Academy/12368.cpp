#include <iostream>

using namespace std;

int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int T;
	cin >> T;
	for (int i = 0; i < T; i++) {
		int A, B;
		cin >> A >> B;
		cout << '#' << T + 1;
		if (A + B >= 24) cout << A + B - 24 << '\n';
		else cout << A + B << '\n';
	}

	return 0;

}