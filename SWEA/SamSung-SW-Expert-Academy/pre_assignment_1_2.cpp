#include<iostream>
#include<cmath>
#include<algorithm>

using namespace std;

const int MAX = 10001;

// 주어진 지점 위치를 찾는 함수
pair<int, int> findPosition(int x) {
    int layer = (int)(ceil((-1.0 + sqrt(1.0 + 8.0 * x)) / 2.0)); // 속한 층 계산
    int pos = x - layer * (layer - 1) / 2; // 해당 층에서의 위치 계산
    return { layer, pos };
}

// 두 지점 사이의 최소 이동 거리를 계산하는 함수
// 두 지점 사이의 최소 이동 거리를 계산하는 함수
int minDistance(int start, int end) {
    pair<int, int> startPos = findPosition(start);
    pair<int, int> endPos = findPosition(end);

    int layerStart = startPos.first;
    int posStart = startPos.second;
    int layerEnd = endPos.first;
    int posEnd = endPos.second;

    // 같은 층에 위치한 경우
    if (layerStart == layerEnd) {
        return abs(posStart - posEnd);
    }

    // 수직 이동 거리
    int vertical = abs(layerStart - layerEnd);

    // 수평 이동 거리 계산
    int horizontal;
    if (layerStart < layerEnd) {
        // 아래로 이동하는 경우
        horizontal = max(posEnd - posStart, layerEnd - layerStart - posStart + 1);
    }
    else {
        // 위로 이동하는 경우
        horizontal = max(posStart - posEnd, layerStart - layerEnd - posEnd + 1);
    }

    return vertical + horizontal;
}

int main(int argc, char** argv)
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    int test_case;
    int T;
    cin >> T;

    for (test_case = 1; test_case <= T; ++test_case)
    {
        int s, e;
        cin >> s >> e;

        cout << '#' << test_case << ' ' << minDistance(s, e) << '\n';
    }
    return 0;
}
