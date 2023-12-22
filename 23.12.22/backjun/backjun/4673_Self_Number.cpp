#include <iostream>
#include <string>

using namespace std;

bool exist[10001] = {false, };

int d(int n) {

	string str = to_string(n);
	int len = str.size();
	int res = n;

	for (int i = 0; i < len; i++) {
		res += str[i] - '0';
	}

	return res;
}

int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	for (int i = 1; i < 10000; i++) {
		int idx = d(i);
		if (idx <= 10000) exist[idx] = true;
	}

	for (int i = 1; i <= 10000; i++) {
		if (!exist[i]) cout << i << '\n';
	}


	return 0;
}