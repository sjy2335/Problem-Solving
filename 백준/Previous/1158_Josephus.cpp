#include <bits/stdc++.h>

using namespace std;

int N, K;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    
    cin >> N >> K;

	list<int> l;

	for (size_t i = 1; i < N+1; i++) {l.push_back(i);}
	
	auto iter = l.begin();
    cout << '<';

    while (l.size() > 1) {
        for (int i = 0; i < K-1; i++) { // K-1번 이동
            iter++;
            if (iter == l.end()) iter = l.begin();
        }
        cout << *iter << ", ";
        iter = l.erase(iter); // iter가 가리키는 원소를 삭제하고, 다음 원소를 가리키게 함
        if (iter == l.end()) iter = l.begin(); // 삭제 후 끝에 도달했다면, 시작으로 이동
    }
	cout << *iter << '>';
	
    
    return 0;
}