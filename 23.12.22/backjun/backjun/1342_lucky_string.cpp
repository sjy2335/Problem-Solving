#include <iostream>
#include <string>
#include <algorithm>

using namespace std;


int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	string S;
	int cnt = 0;

	cin >> S;
	sort(S.begin(), S.end());

	do {
		bool correct = true;
		for (int i = 0; i < S.size() - 1; i++) {
			if (S[i] == S[i + 1]) {
				correct = false; break;
			}
		}
		if (correct) cnt++;
	} while (next_permutation(S.begin(), S.end()));
	// ��� ���� �����ִ� c++ stl <algorithm> �� next_permutation �Լ�
	// ������������ ���ĵ� ���� �־��ָ� ���� ���� ���ϰ� ���� ������ true ��ȯ


	cout << cnt << endl;

	return 0;
}