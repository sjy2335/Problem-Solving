#include <iostream>

using namespace std;

int a[20];
int N, S, cnt=0;


void func(int curr, int sum){

	// ���� �����ϸ� cnt ����
	// ���� �Ҹ����� backtrack
	if (curr == N) {
		if (sum == S) cnt++;
		return;
	}

	func(curr + 1, sum); // ���� �� �� ����
	func(curr + 1, sum + a[curr]); // ���� �� ����
}


int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);


	cin >> N >> S; // ���� ���� N, ���� S

	for (int i = 0; i < N; i++) {
		cin >> a[i];
	}

	func(0, 0);
	if (S==0) cnt--; // ������ ��==0�� �� ������ ����
	cout << cnt << endl;

	return 0;
}