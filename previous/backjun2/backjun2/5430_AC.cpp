#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <deque>

using namespace std;


int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int T, count;
	string cmd, data;

	cin >> T;

	for (int i = 0; i < T; i++) {
		bool error_flag = false;
		bool reverse_flag = false;

		cin >> cmd >> count >> data;

		deque<int> dq;
		string s = "";

		// 1. data parsing - using "isdigit" and concatenation
		for (int i = 0; i < data.length(); i++) {

			if (isdigit(data[i])) { // 정수 아니면 건너뜀
				s += data[i]; // concat
			}
			else {
				if (!s.empty()) { // 공백이나 대괄호 발견, 숫자 있으면 push_back
					dq.push_back(stoi(s));
					s = "";
				}
			}
		}

		// 2. command execute
		for (int i = 0; i < cmd.size(); i++) {

			switch (cmd[i]) {
			case 'R':
				reverse_flag = !reverse_flag;
				break;

			case 'D':
				if (dq.empty()) error_flag = true;
				else {
					if (reverse_flag) dq.pop_back();
					else dq.pop_front();
				}
				break;

			default:
				break;
			}
		}

		if (!error_flag) {
			cout << '[';
			if (!dq.empty()) {

				if (reverse_flag) {
					for (int i = dq.size() - 1; i >= 1; i--) {
						cout << dq[i] << ',';
					}
					cout << dq[0];
				}
				else {
					for (int i = 0; i < dq.size() - 1; i++) {
						cout << dq[i] << ',';
					}
					cout << dq.back();
				}
			}
			cout << "]\n";
		}
		else cout << "error\n";
	}
	return 0;
}