#include <bits/stdc++.h>

using namespace std;

int N;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    
    cin >> N;

    stack<int> S;

    for (int i = 0; i < N; i++)
    {
        int c;
        cin >> c;
        switch (c){
            case 1:
                int X;
                cin >> X;
                S.push(X);
                break;
            case 2:
                if(S.empty()) cout << "-1\n";
                else {
                    cout << S.top() << "\n";
                    S.pop();
                }
                break;
            case 3:
                cout << S.size() << "\n";
                break;
            case 4:
                if(S.empty()) cout << "1\n";
                else cout << "0\n";
                break;
            case 5:
                if(S.empty()) cout << "-1\n";
                else cout << S.top() << "\n"; 
                break;
            default:
                break;

        }
    }
    

    return 0;
}