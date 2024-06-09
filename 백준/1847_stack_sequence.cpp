#include <iostream>
#include <vector>
#include <stack>

using namespace std;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    int n;
    cin >> n;

    vector<int> target;
    stack<int> stack;
    vector<char> result;

    for (int i = 0; i < n; i++)
    {
        int data;
        cin >> data;
        target.push_back(data);
    }

    int crnt = 0;

    for (int num = 1; num <= n; num++)
    {
        //cout << "num: " << num << '\n';
        stack.push(num);
        result.push_back('+');

        while (!stack.empty() && target[crnt] == stack.top()){
            //cout << "crnt: " << crnt << '\n';
            stack.pop();
            result.push_back('-');
            crnt++;
        }

    }

    if (!stack.empty()) cout << "NO\n";
    
    else {
        for(auto iter = result.begin(); iter != result.end(); ++iter){
            cout << *iter << '\n';
        }
    }
    

    return 0;
}