#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <queue>

using namespace std;

int main(void) {
	int N = 0, K = 0;
	scanf_s("%d %d", &N, &K);
	queue<int> q;

	// 1. Enqueue all
	for (int i = 1; i <= N; i++) q.push(i);

	// 2. Rotate K-1 * People, Dequeue K-th person
	printf("<");
	while (q.size() > 1) {
		for (int i = 1; i < K; i++) {
			q.push(q.front());
			q.pop();
		}
		printf("%d, ", q.front());
		q.pop();
	}
	printf("%d>", q.front());
}