#include <iostream>

using namespace std;

int main(void) {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int M = 0, N = 0;
	cin >> M >> N;

	// Brute Force => 시간 초과
	// Eratosthenes의 체 이용

	// N까지 수에 대해 소수인지 판별하는 배열, 일단 전부 true로 초기화
	bool* primeArray = new bool[N + 1];
	primeArray[0] = false;
	primeArray[1] = false;
	for (int i = 2; i <= N; i++) primeArray[i] = true;

	//소수이면, 그 배수들을 전부 false로 만듦
	for (int i = 2; i * i <= N; i++) {
		if (primeArray[i])
			// i * (i-1)까지는 이미 그 전 단계에서 처리 됨!
			for (int j = i * i; j <= N; j += i)
				primeArray[j] = false;
	}

	for (int i = M; i <= N; i++) {
		if (primeArray[i]) cout << i << '\n';
	}

	return 0;
}