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

    // �־��� ��� ĭ���� �ϳ� ���� (N * N �� ����)    
    // ������ ĭ ������ �ٸ� ��� ������ �ٲٰ�
    // ��ü �� or �� ���⿡�� ���ӵ� ĭ�� �ִ� ���� ã��

    /*
    xxxxx int dx = { 1, 0, 0, -1 };
    xxxxx int dy = { 0, -1, 1, 0 }; // ��, ��, ��, ȭ
    => ������ ��ü Ž�� �Ҳ��� �����¿� �ʿ����,
    ������ ���� �κ�, �Ʒ��� ���� �κи� ����
    ó���غ��鼭 �����ϱ�
    */

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N-1; j++) { // ������ ���� �� �� ���� �Բ� ������ Ȯ�ε�
            swap(map[i][j], map[i][j + 1]);
            countRow();
            countColumn();
            swap(map[i][j], map[i][j + 1]); // ������� �ǵ��� ����

            swap(map[j][i], map[j+1][i]);
            countRow();
            countColumn();
            swap(map[j][i], map[j+1][i]); // �������
        }
    }

    cout << maxCount << '\n';

    return 0;
}