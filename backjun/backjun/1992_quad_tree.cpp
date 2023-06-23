#include <iostream>
#include <algorithm>
#include <string>

using namespace std;
int arr[128][128];
int white, blue; // �ڵ� 0 �ʱ�ȭ

void func(int r, int c, int size) { // ���� row, column, size


	int curr = arr[r][c]; // ���� �� (0 or 1)

	bool correct = true;

	// ���� �簢�� Ȯ��
	for (int i = r; i < r + size; i++) {
		for (int j = c; j < c + size; j++) {
			if (curr != arr[i][j]) correct = false;
			if (!correct) {
				cout << '('; // ���� ��ȣ�� ���������� ���� �Ǵµ�
				// ���� 1, 2, 3, 4 ��и� Ȯ��
				func(r, c, size / 2);
				func(r, c + size / 2, size / 2);
				func(r + size / 2, c, size / 2);
				func(r + size / 2, c + size / 2, size / 2);
				cout << ')'; // �ݴ� ��ȣ �ٷ� ���ø����� ��� Ȯ����..
				// + ���� 0�̰ų� ���� 1�� ��� ��ȣ ��� �� �ص� �³�..?
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