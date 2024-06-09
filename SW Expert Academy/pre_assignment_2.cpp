#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

const int MAX = 1e9;

// 전역 변수로 최소 소멸 능력치, 요원들의 능력치 저장
int minDestruction;
vector<vector<int>> agents;

// 모든 조합을 탐색하는 재귀 함수
void findMinDestruction(int n, int idx, int abilities, int destruction) {
    // 모든 능력치가 사용되었고, 모든 요원이 고려되었을 경우 최소값 업데이트
    if (abilities == 0b111 && idx == n) {
        minDestruction = min(minDestruction, destruction);
        return;
    }

    // 모든 요원이 고려되었지만, 모든 능력치가 사용되지 않은 경우 반환
    if (idx == n) return;

    // 요원들이 3개 각각의 능력치를 공유하는 경우에 대해 재귀적으로 탐색
    for (int i = 0; i < 3; ++i) {
        findMinDestruction(n, idx + 1, abilities | (1 << i), destruction + agents[idx][(i + 1) % 3] + agents[idx][(i + 2) % 3]);
    }
}

int main() {
    ios_base::sync_with_stdio(0); // 입출력 속도 향상을 위한 설정
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
