#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

int main() {
    
    unordered_map<int, int> m;
    
    int N;
    cin >> N;
    
    for (int i = 0; i < N; i++) {
        int num;
        cin >> num;
        m[num]++;
    }
    
    int M;
    cin >> M;
    
    vector<int> keys;
    
    for (int i = 0; i < M; i++) {
        int k;
        cin >> k;
        keys.push_back(k);
    }
    
    for (int i = 0; i < M; i++) {
        cout << m[keys[i]] << " "; // Default Value 0
    }
    
    return 0;
}