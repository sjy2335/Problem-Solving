#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int N, maxCount = 0;
char map[51][51];

void countRow() {
    for (int i = 0; i < N; i++) {
        int count = 1;
        for (int j = 0; j < N; j++) {
            if (map[i][j] == map[i][j + 1]) ++count;
            else {
                if (count > maxCount) maxCount = count;
                count = 1;
            }
        }
    }
}

void countColumn() {

    for (int i = 0; i < N; i++) {
        int count = 1;
        for (int j = 0; j < N; j++) {
            if (map[j][i] == map[j+1][i]) ++count;
            else {
                if (count > maxCount) maxCount = count;
                count = 1;
            }
        }
    }
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    cin >> N;

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            cin >> map[i][j];
        }
    }

    // 주어진 모든 칸에서 하나 선택 (N * N 번 동안)    
    // 인접한 칸 색깔이 다를 경우 색깔을 바꾸고
    // 전체 행 or 열 방향에서 연속된 칸의 최대 개수 찾기

    /*
    xxxxx int dx = { 1, 0, 0, -1 };
    xxxxx int dy = { 0, -1, 1, 0 }; // 상, 좌, 우, 화
    => 어차피 전체 탐색 할꺼니 상하좌우 필요없고,
    오른쪽 인접 부분, 아래쪽 인접 부분만 각각
    처리해보면서 구현하기
    */

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N-1; j++) { // 마지막 열은 그 앞 열과 함께 저절로 확인됨
            swap(map[i][j], map[i][j + 1]);
            countRow();
            countColumn();
            swap(map[i][j], map[i][j + 1]); // 원래대로 되돌려 놓기

            swap(map[j][i], map[j+1][i]);
            countRow();
            countColumn();
            swap(map[j][i], map[j+1][i]); // 원래대로
        }
    }

    cout << maxCount << '\n';

    return 0;
}