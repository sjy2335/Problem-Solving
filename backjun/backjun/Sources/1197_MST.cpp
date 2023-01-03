#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#define P pair<int,int>

using namespace std;
// ��Ÿ�� ������ �� �ص� �ذ��� �� �ǳ�... ���߿� �ٽ�..
// prim �˰��� ������ ���� ��ó: https://huiung.tistory.com/76

int visited[10001] = { 0 };
vector<P> edge[100001];
// ����ġ ����. edge[0][0].first = ����ġ, edge[0][0].second = ���� ����

int prim()
{
    int now = 0, dist = 0, result = 0, vertex_from_now = 0;
    priority_queue<P> pq; // first = ����ġ, second = ����
    pq.push(P(0, 1));

    while (!pq.empty()) {
        // 1. ���� ������ top�� ���� �������� ����
        now = pq.top().second;
        dist = pq.top().first;

        pq.pop();
        if (visited[now])
            continue;

        visited[now] = 1; // ���� �湮 ǥ��
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
    //�׷��� edge �Է�
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