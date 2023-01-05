#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;


int main(void) {

    ios_base::sync_with_stdio(0);
    cin.tie(NULL);
    cout.tie(NULL);

    int N = 0;
    cin >> N;

    // 계산 횟수를 담은 Dynamic Programming 배열
    vector<int> dp(N+1);

    for (int i = 2; i <= N; i++) {
        dp[i] = dp[i - 1] + 1;
        if (i % 2 == 0) dp[i] = min(dp[i], dp[i / 2] + 1);
        if (i % 3 == 0) dp[i] = min(dp[i], dp[i / 3] + 1);
    }


    cout << dp[N];

    return 0;
}