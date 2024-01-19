#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;
const int MAX_N = 101;
const int MAX_K = 10001;
const int INF = (~0U >> 2); // 32��Ʈ 0011...1111 -> �� 10��
int N, K, value[MAX_N], dp[MAX_N][MAX_K];

// ����Լ�
int f(int n, int k) {
    // base-case
    if (n == N) return (k == 0 ? 0 : INF);
    
    // already calculated
    if (dp[n][k] != -1) return dp[n][k];

    int result = f(n + 1, k); // �� ��� : n���� �� �־��� �� ���
    // ���� ���� n�� ����ġ���� ũ��
    // n���� �־��� ��(���̶� ���� ó�� �ϰ�)�� ���� �� �־��� ���� ���ؼ�
    // ���� �� ���� �ʿ��� ���� result�� ���� 
    if (k >= value[n]) result = min(result, f(n, k - value[n]) + 1);
    
    dp[n][k] = result; // �ش� dp �迭 �� �ʱ�ȭ
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

    // dp �迭 ��ü -1�� �ʱ�ȭ
    for (int i = 0; i <= N; i++)
        for (int j = 0; j <= K; j++)
            dp[i][j] = -1;
    
    int result = f(0, K);

    if (result == INF) cout << "-1\n";
    else cout << result << '\n';

    return 0;
}