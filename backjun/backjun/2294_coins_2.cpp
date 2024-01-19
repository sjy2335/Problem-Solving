#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;
const int MAX_N = 101;
const int MAX_K = 10001;
const int INF = (~0U >> 2); // 32비트 0011...1111 -> 약 10억
int N, K, value[MAX_N], dp[MAX_N][MAX_K];

// 재귀함수
int f(int n, int k) {
    // base-case
    if (n == N) return (k == 0 ? 0 : INF);
    
    // already calculated
    if (dp[n][k] != -1) return dp[n][k];

    int result = f(n + 1, k); // 비교 대상 : n번을 안 넣었을 때 결과
    // 남은 돈이 n번 값어치보다 크면
    // n번을 넣었을 때(값이랑 개수 처리 하고)와 위의 안 넣었을 때를 비교해서
    // 동전 더 적게 필요한 값을 result애 넣음 
    if (k >= value[n]) result = min(result, f(n, k - value[n]) + 1);
    
    dp[n][k] = result; // 해당 dp 배열 값 초기화
    return result;
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    cin >> N >> K;
    
    for (int i = 0; i < N; i++) {
        cin >> value[i];
    }

    // dp 배열 전체 -1로 초기화
    for (int i = 0; i <= N; i++)
        for (int j = 0; j <= K; j++)
            dp[i][j] = -1;
    
    int result = f(0, K);

    if (result == INF) cout << "-1\n";
    else cout << result << '\n';

    return 0;
}