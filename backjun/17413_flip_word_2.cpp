#include <iostream>
#include <string>
#include <stack>

using namespace std;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    stack<char> stack;
    string S;
    getline(cin, S);

    for (size_t i = 0; i <= S.size(); i++)
    {
        if(S[i]=='<'){
            while(!stack.empty()){
                cout << stack.top();
                stack.pop();
            }
            while (S[i] != '>'){
                cout << S[i++];
            }
            cout << S[i]; // to print '>';
            continue;
        }
        if(i==S.size()){
            while(!stack.empty()){
                cout << stack.top();
                stack.pop();
            }
            continue;
        }
        if(S[i]==' '){
            while(!stack.empty()){
                cout << stack.top();
                stack.pop();
            }
            cout << ' ';
            continue;
        }
        stack.push(S[i]);
    }

    return 0;
}