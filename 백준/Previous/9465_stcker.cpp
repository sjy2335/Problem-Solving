#include <iostream>
#include <algorithm>
#include <vector>
#include <string.h>

using namespace std;
// max ��� ����
const int MAX = 100001;

// N, �Է� �迭, dp �迭 ����
int N, value[2][MAX], dp[MAX][3];

// ��ƼĿ �Լ� ����
int sticker(int c, int status) {
    // base-case
    if (c == N) return 0;

    // already calculated
    if (dp[c][status] != -1) return dp[c][status];

    // result calculation
    int result = sticker(c + 1, 0); // status 0 �ѱ�.

    // status != 1
    if (status != 1) result = max(result, sticker(c+1, 1) + value[0][c]);
    // status != 2
    if (status != 2) result = max(result, sticker(c+1, 2) + value[1][c]);
    // dp �迭 ����
    dp[c][status] = result;

    return result;
}


int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    int T;
    cin >> T;

    for (int i = 0; i < T; i++) {
        cin >> N;
        for (int j = 0; j < 2; j++) {
            for (int n = 0; n < N; n++) {
                cin >> value[j][n];
            }
        }
        for (int i = 0; i < MAX; i++) memset(dp[i], -1, sizeof(int) * 3);
        cout << sticker(0, 0) << '\n';
    }

    return 0;
}