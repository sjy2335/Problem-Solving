#include <string>
#include <vector>
#include <algorithm>

using namespace std;

const int INF = 20'000'000;

int solution(int n, int s, int a, int b, vector<vector<int>> fares) {
    s--; a--; b--;
    
    int costs[200][200];
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            costs[i][j] = i == j ? 0 : INF;
        }
    }
    
    for (vector<int> fare: fares) {
        int c = fare[0] - 1;
        int d = fare[1] - 1;
        int f = fare[2];
        costs[c][d] = f;
        costs[d][c] = f;
    }
    
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < n; k++) {
                costs[j][k] = min(costs[j][k], costs[j][i] + costs[i][k]);
            }
        }
    }
   
    int answer = INF;
    for (int i = 0; i < n; i++) {
        answer = min(answer, costs[s][i] + costs[i][a] + costs[i][b]);
    }
    
    
    return answer;
}