#include <bits/stdc++.h>

using namespace std;

int N;
int dp[5001];

int f(int n){
    if (n == 0) return 0;
    if (n < 0) return -1;
    if (dp[n]!=0) return dp[n];

    int res1 = f(n-3);
    int res2 = f(n-5);

    int result;

    if(res1 == -1 && res2 == -1) result = -1;
    else if (res1 == -1) result = res2 + 1;
    else if (res2 == -1) result = res1 + 1;
    else result = min(res1, res2) + 1;

    dp[n] = result;
    return result;
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    
    cin >> N;

    cout << f(N);

    return 0;
}