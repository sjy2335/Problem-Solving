#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;
int arr[128][128];
int white, blue; // 자동 0 초기화

void func(int r, int c, int size) { // 현재 row, column, size

	int curr = arr[r][c]; // 현재 색깔 (0 or 1)
	
	bool correct = true;

	for (int i = r; i < r + size; i++) {
		for (int j = c; j < c + size; j++) {
			if (curr != arr[i][j]) correct = false;
			if (!correct) {
				// 1, 2, 3, 4 사분면 확인
				func(r, c, size / 2);
				func(r, c + size / 2, size / 2);
				func(r + size / 2, c, size / 2);
				func(r + size / 2, c + size / 2, size / 2);
				return;
			}
		}
	}

	if (correct) {
		if (curr == 0) white++;
		else blue++;
	}
}


int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N;
	cin >> N;

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cin >> arr[i][j];
		}
	}

	func(0, 0, N);

	cout << white << '\n';
	cout << blue << '\n';

	return 0;
}