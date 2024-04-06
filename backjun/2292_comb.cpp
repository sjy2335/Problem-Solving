#include <bits/stdc++.h>

using namespace std;

long N;
long result=1;
int cnt=1;

int main() {
    // 초기값이랑 경계값 확인하기.
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    
    cin >> N;

    for(int i = 1; result < N; i++){
        result += 6 * i;
        cnt++;
    }
    cout << cnt;

    return 0;
}