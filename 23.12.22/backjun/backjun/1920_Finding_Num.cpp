#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int N, M, tmp;
vector<int> A, V;

void binary_search(int left, int right, int target) {
	if (left <= right) {
		int mid = (left + right) / 2;
		if (A[mid] == target) {
			cout << 1 << '\n';
			return;
		}
		else if (A[mid] > target) {
			binary_search(left, mid - 1, target);
		}
		else if (A[mid] < target) {
			binary_search(mid + 1, right, target);
		}
	}
	else {
		cout << 0 << '\n';
		return;
	}
}


int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);


	cin >> N;
	for (int i = 0; i < N; i++) {
		cin >> tmp;
		A.push_back(tmp);
	}

	sort(A.begin(), A.end());

	cin >> M;
	for (int i = 0; i < M; i++) {
		cin >> tmp;
		V.push_back(tmp);
	}


	for (int i = 0; i < M; i++) {
		binary_search(0, N-1, V[i]);
	}

	return 0;
}