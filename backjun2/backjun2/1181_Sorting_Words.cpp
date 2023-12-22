#include <iostream>
#include <vector>
#include <algorithm>
#include <string>

using namespace std;
string str[20001];

struct rule {
	bool operator()(string const& a, string const& b) const {
		if (a.size() == b.size()) return a < b;
		return a.size() < b.size();
	}
};

int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N;
	cin >> N;

	for (int i = 0; i < N; i++) {
		cin >> str[i];
	}

	sort(str, str+N, rule());
	string pre = "";

	for (int i = 0; i < N; i++) {
		if (pre == str[i]) continue;
		pre = str[i];
		cout << pre << '\n';
	}

	return 0;

}