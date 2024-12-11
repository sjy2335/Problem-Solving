#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    vector<int> heights;
    int sum = 0;

    for ( int i = 0; i < 9; i++) {
         int tmp;
        cin >> tmp;
        sum += tmp;
        heights.push_back(tmp);
    }

    // 9�� �� 7���� ��¥, ��¥�� 2��
    // ��¥ 2���� �̴� 2�� for ������ �����

     int i, j;

    for (i = 0; i < 8; i++) {
        for (j = i+1; j < 9; j++) {
            if (sum - heights[i] - heights[j] == 100) {
                heights.erase(heights.begin() + j);
                heights.erase(heights.begin() + i);
                break;
            }    
        }
        if (j < 9) break;
    }

    sort(heights.begin(), heights.end());
    for ( int k = 0; k < heights.size(); k++) {
        cout << heights[k] << '\n';
    }

    return 0;
}