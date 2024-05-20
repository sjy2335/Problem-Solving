#include <bits/stdc++.h>

using namespace std;


int N;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    
    cin >> N;

    stack<pair<int, int>> S;


    for(int i = 1; i <= N; i++){
        int n; cin >> n;  

        while(!S.empty()){
            // 현재 값보다 top의 값이 크다면 top의 인덱스 출력
            if(S.top().first > n){
                cout << S.top().second << ' ';
                break;
            }
            // 현재 값보다 top의 값이 작다면 pop (필요 없어짐)
            S.pop();
        }

        if(S.empty()) cout << "0 ";

        S.push(make_pair(n, i));

    }

    return 0;
}