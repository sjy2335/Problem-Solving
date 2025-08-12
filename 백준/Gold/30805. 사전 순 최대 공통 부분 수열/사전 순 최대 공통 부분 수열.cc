#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int N, M;

    cin >> N;
    vector<int> A(N);
    for (int i = 0; i < N; i++) {
        cin >> A[i];
    }

    cin >> M;
    vector<int> B(M);
    for (int i = 0; i < M; i++) {
        cin >> B[i];
    }

    vector<int> result;
    int a_idx = 0;
    int b_idx = 0;

    // 두 수열 중 하나의 끝에 도달할 때까지
    while (a_idx < N && b_idx < M) {
        int best_val = 0;
        int next_a_idx = -1;
        int next_b_idx = -1;

        // 현재 위치에서 선택할 수 있는 가장 큰 값을 찾음
        for (int val = 100; val >= 1; --val) {
            int current_a_pos = -1;
            
            for (int i = a_idx; i < N; ++i) {
                if (A[i] == val) {
                    current_a_pos = i;
                    break;
                }
            }

            if (current_a_pos == -1) {
                continue;
            }

            int current_b_pos = -1;
            for (int j = b_idx; j < M; ++j) {
                if (B[j] == val) {
                    current_b_pos = j;
                    break;
                }
            }
            
            // 가장 큰 값을 찾았으면 더 작은 값은 볼 필요 없음
            if (current_b_pos != -1) {
                best_val = val;
                next_a_idx = current_a_pos;
                next_b_idx = current_b_pos;
                break;
            }
        }

        // 공통 원소를 찾았다면 
        if (best_val > 0) {
            // 다음 탐색 위치를 현재 찾은 위치 다음으로 갱신
            result.push_back(best_val);
            a_idx = next_a_idx + 1;
            b_idx = next_b_idx + 1;
        } else {
            // 100부터 1까지 찾아도 공통 원소가 없으면 종료
            break;
        }
    }

    cout << result.size() << endl;
    if (!result.empty()) {
        for (int i = 0; i < result.size(); ++i) {
            cout << result[i] << (i == result.size() - 1 ? "" : " ");
        }
        cout << endl;
    }

    return 0;
}