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
	// 모든 순열 구해주는 c++ stl <algorithm> 의 next_permutation 함수
	// 오름차순으로 정렬된 순열 넣어주면 다음 순열 구하고 없을 때까지 true 반환


	cout << cnt << endl;

	return 0;
}