#include <bits/stdc++.h>

using namespace std;

int arr[100001];
int N, K;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

	cin >> N >> K;
	queue<int> q;
	int crnt;

	q.push(N);
	while (!q.empty()) {
		crnt = q.front();
		q.pop();
		
		if (crnt < 0 || crnt>100000) continue;
		if (crnt == K) { 
			cout << arr[crnt];
			break;
		}

		if (crnt-1 >= 0 && arr[crnt - 1] == 0) {
			arr[crnt-1] = arr[crnt]+1;
			q.push(crnt - 1);
		}
		if (crnt+1<=100000 && arr[crnt + 1] == 0) {
			arr[crnt+1] = arr[crnt] + 1;
			q.push(crnt + 1);
		}
		if (2 * crnt <=100000&& arr[2*crnt] == 0) {
			arr[2*crnt] = arr[crnt] + 1;
			q.push(2 * crnt);
		}

	
	}
    

    return 0;
}