#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int N;
vector<int> V;

// ... ���� ���� �׳� �ִ� ���� ����Ʈ�� �������� �� �������°���

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

    int width = 1, minHeight = V[mid], l = mid, r = mid; // ���� �ȿ��� ���� ���� ���̸� ����
    while (r - l+1 <  e - s) {
        int p = l > s ? min(minHeight, V[l - 1]) : -1; // �������� Ȯ������ ����� ����
        int q = r < e - 1 ? min(minHeight, V[r + 1]) : -1; // ���������� Ȯ������ ����� ����
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