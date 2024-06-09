#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

const int MAX = 1e9;

// ���� ������ �ּ� �Ҹ� �ɷ�ġ, ������� �ɷ�ġ ����
int minDestruction;
vector<vector<int>> agents;

// ��� ������ Ž���ϴ� ��� �Լ�
void findMinDestruction(int n, int idx, int abilities, int destruction) {
    // ��� �ɷ�ġ�� ���Ǿ���, ��� ����� ����Ǿ��� ��� �ּҰ� ������Ʈ
    if (abilities == 0b111 && idx == n) {
        minDestruction = min(minDestruction, destruction);
        return;
    }

    // ��� ����� ����Ǿ�����, ��� �ɷ�ġ�� ������ ���� ��� ��ȯ
    if (idx == n) return;

    // ������� 3�� ������ �ɷ�ġ�� �����ϴ� ��쿡 ���� ��������� Ž��
    for (int i = 0; i < 3; ++i) {
        findMinDestruction(n, idx + 1, abilities | (1 << i), destruction + agents[idx][(i + 1) % 3] + agents[idx][(i + 2) % 3]);
    }
}

int main() {
    ios_base::sync_with_stdio(0); // ����� �ӵ� ����� ���� ����
    cin.tie(0);
    cout.tie(0);

    int T, n;
    cin >> T;
    
    for (int test_case = 1; test_case <= T; ++test_case) { 
        cin >> n;
        agents = vector<vector<int>>(n, vector<int>(3));
        
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < 3; ++j) {
                cin >> agents[i][j];
            }
        }
        
        minDestruction = MAX;
        findMinDestruction(n, 0, 0, 0);
       
        cout << '#' << test_case << ' ' << (minDestruction == MAX ? -1 : minDestruction) << '\n';
    }
    return 0;
}
