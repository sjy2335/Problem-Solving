#include <bits/stdc++.h>

using namespace std;

int N;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    
    cin >> N;

    for (size_t i = 0; i < N; i++)
    {
        string S;
        cin >> S;

        bool flag = true;
        stack<int> stack;

        for (int i = 0; i < S.size(); i++)
        {
            if(S[i]=='('){
                stack.push(1);
            }
            if(S[i]==')'){
                if(stack.empty()) flag = false;
                else stack.pop();
            }
        }
        if(!stack.empty()) flag = false;

        if(flag) cout << "YES\n";
        else cout << "NO\n";
    }
    
    
    return 0;
}