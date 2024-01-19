#include <iostream>

using namespace std;

int main(void) {

	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	int test_case;
	int T;
	cin >> T;


	for (test_case = 1; test_case <= T; ++test_case)
	{
		unsigned int L, U, X;
		cin >> L >> U >> X;
		cout << '#' << test_case << ' ';

		if (X <= L) cout << L - X << '\n';
		else if (X <= U) cout << "0\n";
		else cout << "-1\n";

	}
	return 0;//정상종료시 반드시 0을 리턴해야합니다.

}