#include <iostream>
#include <cmath>

using namespace std;

int N;
int stats[20][20];
bool selected[20];

int getMinimumDifference(int idx, int count);
int getDifference();

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
             cin >> stats[i][j];
        }
    }

    cout << getMinimumDifference(0, 0) << "\n";

    return 0;
}

int getMinimumDifference(int idx, int count) {
    if (count == N / 2) {
        return getDifference();
    }

    int minDiff = 1e8;
    for (int i = idx; i < N; i++) {
        if (selected[i]) continue;
        selected[i] = true;
        minDiff = min(minDiff, getMinimumDifference(i + 1, count + 1));
        selected[i] = false;
    }

    return minDiff;
}

int getDifference() {
    int start = 0;
    int link = 0;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            if (selected[i] && selected[j]) start += stats[i][j];
            if (!selected[i] && !selected[j]) link += stats[i][j];
        }
    }
    return abs(start - link);
}
