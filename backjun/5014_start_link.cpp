#include <bits/stdc++.h>

using namespace std;

int F, S, G, U, D;
int arr[1000001];

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin >> F >> S >> G >> U >> D;
    
    queue<int> q;
    q.push(S);
    arr[S] = 1;

    while(!q.empty()){
        int crnt = q.front();
        q.pop();

        if (crnt == G) {
            cout << arr[crnt] - 1 << '\n'; 
            return 0;
        }
        if (crnt + U <= F && U != 0 && !arr[crnt+U]) {
            arr[crnt+U] = arr[crnt] + 1;
            q.push(crnt + U);
        }
        if (crnt - D > 0 && D != 0 && !arr[crnt-D]) {
            arr[crnt-D] = arr[crnt] + 1;
            q.push(crnt - D);
        }
    }

    cout << "use the stairs\n";
    return 0;
}