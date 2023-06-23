#include <iostream>
#include <algorithm>
#include <string>

using namespace std;
int arr[128][128];
int white, blue; // 자동 0 초기화

void func(int r, int c, int size) { // 현재 row, column, size


	int curr = arr[r][c]; // 현재 값 (0 or 1)

	bool correct = true;

	// 현재 사각형 확인
	for (int i = r; i < r + size; i++) {
		for (int j = c; j < c + size; j++) {
			if (curr != arr[i][j]) correct = false;
			if (!correct) {
				cout << '('; // 여는 괄호는 직관적으로 이해 되는데
				// 하위 1, 2, 3, 4 사분면 확인
				func(r, c, size / 2);
				func(r, c + size / 2, size / 2);
				func(r + size / 2, c, size / 2);
				func(r + size / 2, c + size / 2, size / 2);
				cout << ')'; // 닫는 괄호 바로 떠올리려면 재귀 확실히..
				// + 전부 0이거나 전부 1인 경우 괄호 출력 안 해도 맞네..?
				return;
			}
		}
	}

	if (correct) {
		cout << curr;
	}

}


int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N;
	cin >> N;

	string S;

	for (int i = 0; i < N; i++) {
		cin >> S;
		for (int j = 0; j < N; j++) {
			arr[i][j] = S[j] - 48;
		}
	}

	func(0, 0, N);

	return 0;
}