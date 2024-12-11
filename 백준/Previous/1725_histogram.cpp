#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int N;
vector<int> V;

// ... 벡터 말고 그냥 최대 범위 리스트는 괜찮던데 왜 오류나는거지

// recursive function - divide & conquer algorithm
// it calculates the max width among the histogram's [l, e) range.
// in each recursion, it not only checks the left area and the right area
// it also calculates the area overlapped in the middle.
int histogram(int s, int e) {
    
    // base-case
    if (s == e) return 0;
    if (s + 1 == e) return V[s];

    int mid = (s + e) / 2;
    int result = max(histogram(s, mid), histogram(mid, e));

    int width = 1, minHeight = V[mid], l = mid, r = mid; // 구역 안에서 가장 낮은 높이를 차용
    while (r - l+1 <  e - s) {
        int p = l > s ? min(minHeight, V[l - 1]) : -1; // 왼쪽으로 확장했을 경우의 높이
        int q = r < e - 1 ? min(minHeight, V[r + 1]) : -1; // 오른쪽으로 확장했을 경우의 높이
        if (p >= q) {
            minHeight = p;
            l--;
        }
        else {
            minHeight = q;
            r++;
        }
        result = max(result, ++width * minHeight);
    }
    return result;
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    cin >> N;
    for (int i = 0; i < N; ++i) {
        int tmp;
        cin >> tmp;
        V.push_back(tmp);
    }
    cout << histogram(0, N-1) << '\n';
    return 0;
}