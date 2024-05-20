#include <bits/stdc++.h>

using namespace std;

int N, M;
string board[50];

string board1[8] = {
        "WBWBWBWB",
        "BWBWBWBW",
        "WBWBWBWB",
        "BWBWBWBW",
        "WBWBWBWB",
        "BWBWBWBW",
        "WBWBWBWB",
        "BWBWBWBW"
};
string board2[8] = {
        "BWBWBWBW",
        "WBWBWBWB",
        "BWBWBWBW",
        "WBWBWBWB",
        "BWBWBWBW",
        "WBWBWBWB",
        "BWBWBWBW",
        "WBWBWBWB"
};

int cnt1(int x, int y)
{
    int cnt = 0;
    for(int i = 0; i < 8; i++)
    {
        for(int j = 0; j < 8; j++)
        {
            if(board[x+i][y+j] != board1[i][j])
                cnt++;
        }

    }
    return cnt;
}
int cnt2(int x, int y)
{
    int cnt = 0;
    for(int i = 0; i < 8; i++)
    {
        for(int j = 0; j < 8; j++)
        {
            if(board[x+i][y+j] != board2[i][j])
                cnt++;
        }

    }
    return cnt;
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    
    cin >> N >> M;

    for (size_t i = 0; i < N; i++)
    {
        cin >> board[i];
    }

    int min_cnt = ~0U >> 2;
    for (size_t i = 0; i < N-7; i++) {
        for (size_t j = 0; j < M-7; j++) {
            int tmp = min(cnt1(i, j), cnt2(i, j));
            if(tmp < min_cnt) min_cnt = tmp;
        }
    }

    cout << min_cnt;
    
    return 0;
}