#include <iostream>
#include <queue>
#include <vector>
#include <cmath>

using namespace std;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    struct Compare {
        bool operator()(int a, int b) {
            if (abs(a) == abs(b))
                return a > b;
            return abs(a) > abs(b);
        }
    };

    priority_queue<int, vector<int>, Compare> pq;

    int N;
    cin >> N;

    while (N-- > 0) {
        int x;
        cin >> x;

        if (x == 0) {
            if (x == 0) {
                if (pq.empty()) {
                    cout << 0 << "\n";
                } else {
                    cout << pq.top() << "\n";
                    pq.pop();
                }
            }
        } else {
            pq.push(x);
        }
    }

    return 0;
}