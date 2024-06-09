#include<iostream>
#include<cmath>
#include<algorithm>

using namespace std;

const int MAX = 10001;

// �־��� ���� ��ġ�� ã�� �Լ�
pair<int, int> findPosition(int x) {
    int layer = (int)(ceil((-1.0 + sqrt(1.0 + 8.0 * x)) / 2.0)); // ���� �� ���
    int pos = x - layer * (layer - 1) / 2; // �ش� �������� ��ġ ���
    return { layer, pos };
}

// �� ���� ������ �ּ� �̵� �Ÿ��� ����ϴ� �Լ�
// �� ���� ������ �ּ� �̵� �Ÿ��� ����ϴ� �Լ�
int minDistance(int start, int end) {
    pair<int, int> startPos = findPosition(start);
    pair<int, int> endPos = findPosition(end);

    int layerStart = startPos.first;
    int posStart = startPos.second;
    int layerEnd = endPos.first;
    int posEnd = endPos.second;

    // ���� ���� ��ġ�� ���
    if (layerStart == layerEnd) {
        return abs(posStart - posEnd);
    }

    // ���� �̵� �Ÿ�
    int vertical = abs(layerStart - layerEnd);

    // ���� �̵� �Ÿ� ���
    int horizontal;
    if (layerStart < layerEnd) {
        // �Ʒ��� �̵��ϴ� ���
        horizontal = max(posEnd - posStart, layerEnd - layerStart - posStart + 1);
    }
    else {
        // ���� �̵��ϴ� ���
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
