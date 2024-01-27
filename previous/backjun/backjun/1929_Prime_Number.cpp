#include <iostream>

using namespace std;

int main(void) {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int M = 0, N = 0;
	cin >> M >> N;

	// Brute Force => �ð� �ʰ�
	// Eratosthenes�� ü �̿�

	// N���� ���� ���� �Ҽ����� �Ǻ��ϴ� �迭, �ϴ� ���� true�� �ʱ�ȭ
	bool* primeArray = new bool[N + 1];
	primeArray[0] = false;
	primeArray[1] = false;
	for (int i = 2; i <= N; i++) primeArray[i] = true;

	//�Ҽ��̸�, �� ������� ���� false�� ����
	for (int i = 2; i * i <= N; i++) {
		if (primeArray[i])
			// i * (i-1)������ �̹� �� �� �ܰ迡�� ó�� ��!
			for (int j = i * i; j <= N; j += i)
				primeArray[j] = false;
	}

	for (int i = M; i <= N; i++) {
		if (primeArray[i]) cout << i << '\n';
	}

	return 0;
}