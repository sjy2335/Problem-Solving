#include <iostream>

using namespace std;

int a[20];
int N, S, cnt=0;


void func(int curr, int sum){

	// 조건 만족하면 cnt 증가
	// 조건 불만족시 backtrack
	if (curr == N) {
		if (sum == S) cnt++;
		return;
	}

	func(curr + 1, sum); // 현재 값 안 더함
	func(curr + 1, sum + a[curr]); // 현재 값 더함
}


int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);


	cin >> N >> S; // 정수 개수 N, 합은 S

	for (int i = 0; i < N; i++) {
		cin >> a[i];
	}

	func(0, 0);
	if (S==0) cnt--; // 조건이 합==0일 때 공집합 빼기
	cout << cnt << endl;

	return 0;
}