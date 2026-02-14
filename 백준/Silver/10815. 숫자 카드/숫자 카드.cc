#include <iostream>
#include <unordered_set>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    
    int N, M;
    unordered_set<int> set;
    
    cin >> N;
    for (int i = 0; i < N; i++) {
        int num;
        cin >> num;
        set.insert(num);
    }
    
    cin >> M;
    for (int i = 0; i < M; i++) {
        int num;
        cin >> num;
        cout << (set.find(num) != set.end() ? "1" : "0") << (i == M - 1 ? "\n" : " ");
    }
    
    return 0;
}