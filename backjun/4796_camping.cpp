#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    int L, P, V, i=0;

    while (true) {
        
        cin >> L >> P >> V;

        if (!(L || P || V)) return 0;

        int ans = (V / P) * L + min(V % P, L);
        
        cout << "Case " << ++i << ": " << ans << '\n';

    }
}