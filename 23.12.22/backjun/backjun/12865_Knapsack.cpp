#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <vector>
#include <algorithm>

using namespace std;

int main(void)
{
    int N = 0, K = 0;
    vector<vector<int>> dp(101, vector<int>(100001, 0));

    scanf("%d %d", &N, &K);

    /*int* W = new int(N+1);
    int* V = new int(N+1);*/
    int W[101] = { 0 };
    int V[101] = { 0 };

    //그놈의 동적할당.. 항상 왜 안되는거야


    for (int i = 1; i <= N; i++) {
        scanf("%d %d", &W[i], &V[i]);
    }

    for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= K; j++) {
            if (W[i] <= j)
                dp[i][j] = max(dp[i - 1][j], V[i] + dp[i - 1][j - W[i]]);
            else
                dp[i][j] = dp[i - 1][j];
        }
    }
    printf("%d", dp[N][K]);
    return 0;
}