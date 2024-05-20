#include <bits/stdc++.h>

using namespace std;

int C, N;


int main(void) {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    

    cin >> C;
    for (size_t i = 0; i < C; i++){

        cin >> N;
        vector<int> v; // 벡터, 합 초기화
        int sum=0;
        float res;

        for (size_t j = 0; j < N; j++){
            int score;
            cin >> score;
            v.push_back(score);
            sum += score;
        }

        int avg = sum / N;
        int cnt=0;

        for (auto p : v) {if(p > avg) cnt++;}
        
        res = cnt / float(N) * 100;

        cout << fixed;
        cout.precision(3);
        cout << res << "%\n";
    }
        
    return 0;
}