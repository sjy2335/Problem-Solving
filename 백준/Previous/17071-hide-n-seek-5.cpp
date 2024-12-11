#include <bits/stdc++.h>

using namespace std;

int N, K;
bool visited[2][500001];

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

	cin >> N >> K;
	queue<pair<int, pair<int, int>>> q; // 초, 동생, 수빈


	q.push({0, {K, N}});

	while (q.size()) {
        int time = q.front().first;
		int bro = q.front().second.first;
        int crnt = q.front().second.second;
        
		q.pop();
		
		if (crnt < 0 || crnt>500000 || bro > 500000) continue;
		if (visited[time%2][bro] || crnt == bro) { 
			cout << time;
            return 0;
		}

        time++;

		if (crnt - 1 >= 0 && visited[time%2][crnt - 1] == 0) {
            visited[time%2][crnt-1] = true;
            q.push({time, {bro+time, crnt-1}});
		}
		if (crnt + 1 <= 500000 && visited[time%2][crnt + 1] == 0) {
            visited[time%2][crnt+1] = true;
			q.push({time, {bro+time, crnt+1}});
		}
		if (crnt * 2 <= 500000 && visited[time%2][crnt * 2] == 0) {
            visited[time%2][crnt*2] = true;
			q.push({time, {bro+time, crnt*2}});
		}
	
	}

    cout << "-1";    

    return 0;
}