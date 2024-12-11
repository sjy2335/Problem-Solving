#include <iostream>
#include <algorithm>

using namespace std;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    
    int N, result;
    cin >> N;

    for (int i = 1; i < N; i++) {
        int tmp = i;
        int sum = i;
        while (tmp != 0) {
            sum += tmp % 10;
            tmp /= 10;
        }
        if (sum == N) {
            cout << i << '\n';
            return 0;
        }
    }
    cout << "0\n";
    return 0;
}