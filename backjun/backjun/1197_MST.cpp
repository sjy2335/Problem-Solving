#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#define P pair<int,int>

using namespace std;
// 런타임 에러가 뭘 해도 해결이 안 되네... 나중에 다시..
// prim 알고리즘 전반적 구현 출처: https://huiung.tistory.com/76

int visited[10001] = { 0 };
vector<P> edge[100001];
// 가중치 저장. edge[0][0].first = 가중치, edge[0][0].second = 도착 정점

int prim()
{
    int now = 0, dist = 0, result = 0, vertex_from_now = 0;
    priority_queue<P> pq; // first = 가중치, second = 정점
    pq.push(P(0, 1));

    while (!pq.empty()) {
        // 1. 현재 정점을 top의 도착 정점으로 지정
        now = pq.top().second;
        dist = pq.top().first;

        pq.pop();
        if (visited[now])
            continue;

        visited[now] = 1; // 정점 방문 표시
        result += dist;

        for (int i = 0; i < edge[now].size(); i++) {
            vertex_from_now = edge[now][i].second;
            if (!visited[vertex_from_now]) {
                pq.push(P(edge[now][i].first * -1, vertex_from_now));
            }
        }
    }
    return result * -1;
}

int main()
{
    int V = 0, E = 0, A = 0, B = 0, C = 0;
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> V >> E;
    //그래프 edge 입력
    for (int i = 0; i < E; i++) {
        cin >> A >> C >> B;
        edge[A].push_back(P(C, B));
        edge[B].push_back(P(C, A));
    }

    int result = prim();
    // The answer must be 31
    cout << result << '\n';

    return 0;
}