#include <bits/stdc++.h>

using namespace std;

int dx[4] = {0, -1, 1, 0};
int dy[4] = {-1, 0, 0, 1};

char lake[1501][1501];

int R, C;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin >> R >> C;

    for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++) {
            cin >> lake[i][j];
        }
    }

    
    


    return 0;
}