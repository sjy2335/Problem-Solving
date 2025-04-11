#include <iostream>
#include <cmath>

using namespace std;

bool is_prime[10001];

void fill_is_prime() {
    fill(is_prime + 2, is_prime + 10001, true);
    for (int i = 2; i < sqrt(10001); i++) {
        if (!is_prime[i]) continue;
        for (int j = i * 2; j < 10001; j += i) {
            is_prime[j] = false;
        }
    }
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    fill_is_prime();

    int T;
    cin >> T;

    while(T-- > 0) {
        int n;
        cin >> n;

        for (int i = n / 2; i >= 2; i--) {
            if (is_prime[i] && is_prime[n - i]) {
                cout << i << " " << n - i << "\n";
                break;
            }
        }

    }

    return 0;
}