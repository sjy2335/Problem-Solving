#include <bits/stdc++.h>

using namespace std;

long long n;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    
    cin >> n;
    cout << n * (n-1) * (n-2) / 6 << '\n' << '3';
    return 0;
}