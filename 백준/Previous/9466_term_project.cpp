#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

// 전역 변수로 학생 수, 원하는 학생 담는 배열, 정답 변수 선언
int n, s[100000], cnt;
// 방문 했는지, bfs 완료했는지 모두 확인하는 변수
bool visited[100000], finished[100000];

// dfs 함수 정의
// 현재 정점 방문 -> 인접 정점(원하는 학생) 처리
// 만약 다음 정점이 이전에 방문했던 정점이지만, 아직 끝마치지 않았다면 싸이클 발생한 것
// -> 싸이클 다시한번 순회하면서 결과(개수) 더해주기
// 그렇지 않다면, 그 인접 정점으로 dfs 재귀 호출

void dfs(int crnt){
    visited[crnt] = true;
    int next = s[crnt];
    if (visited[next]){
        if (!finished[next]){
            for (int tmp = next; tmp != crnt; tmp = s[tmp]) cnt++;
            cnt ++; // 자기 자신
        }
    }
    else dfs(next);
    finished[crnt] = true;
}


int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    int T;
    cin >> T;

    for (int i=0; i<T; i++){
        cin >> n;
        for (int j=0; j<n; j++){
            cin >> s[j];
            s[j]--;
        } 
        // 각 컴포넌트에 대한 DFS 시작
        fill(visited, visited+n, false);
        fill(finished, finished+n, false);
        cnt=0;
        for(int i=0; i<n; i++)
            if (!visited[i]) dfs(i);
        cout << n - cnt << '\n';
    }

    return 0;
}