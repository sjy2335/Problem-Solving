#include <iostream>
#include <unordered_map>
#include <string>
#include <cctype>
#include <algorithm>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    int N, M;
    cin >> N >> M;
    unordered_map<int, string> index_name_map;
    unordered_map<string, int> name_index_map;
    
    for (int i = 1; i <= N; i++) {
        string name;
        cin >> name;
        index_name_map[i] = name;
        name_index_map[name] = i;
    }
    
    for (int i = 0; i < M; i++) {
        string noi; // name_or_index
        cin >> noi;
        if (!noi.empty() && all_of(noi.begin(), noi.end(), [](char c) {
            return isdigit(c);
        })) {
            cout << index_name_map[stoi(noi)] << "\n";
        } else {
            cout << name_index_map[noi] << "\n";
        }
    }
    
    return 0;
}