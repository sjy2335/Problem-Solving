#include <iostream>
#include <vector>
#include <string.h>

using namespace std;

int n, m;
bool areFriends[10][10];

int countPairings(bool taken[10]) {
	int firstFree = -1;
	int ret = 0;
	for (int i = 0; i < n; i++) {
		if (!taken[i]) {
			firstFree = i;
			break;
		}
	}
	if (firstFree == -1) return 1; // base-case: 짝을 찾지 못한 학생이 없음
	for (int pairWith = firstFree + 1; pairWith < n; pairWith++) {
		if (!taken[pairWith] && areFriends[firstFree][pairWith]) {
			// 자주 쓰이는 한가지 형태. 재귀함수 호출 앞뒤. 잘 기억하기.
			taken[firstFree] = taken[pairWith] = true;
			ret += countPairings(taken);
			taken[firstFree] = taken[pairWith] = false;
		}
	}
	return ret;
}

int main(void) {

	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	unsigned int C;
	cin >> C;

	for (unsigned int i = 0; i < C; i++) {
	
		memset(areFriends, 0, sizeof(areFriends));
		cin >> n >> m;
		
		for (unsigned int j = 0; j < m; j++) {
			int a, b;
			cin >> a >> b;
			areFriends[a][b] = 1;
			areFriends[b][a] = 1;
		}
		
		bool taken[10] = { 0 };
		cout << countPairings(taken) << '\n';
	}

	return 0;
}