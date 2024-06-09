#include <bits/stdc++.h>

using namespace std;

int a1, a0, c, n0;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cin >> a1 >> a0 >> c >> n0;

    int res = a1 * n0 + a0 <= c * n0  && a1 <= c ? 1 : 0;
    // 1. 0일때, 일치할 때 경계값
    // 2. 음수일 때, 값 역전될 때.
    cout << res;
    
    return 0;
}