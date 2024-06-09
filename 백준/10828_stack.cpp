#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    int N, num;
    string cmd;
    cin >> N;
    vector<int> myStack;

    for(int i=0; i<N; i++){

        cin >> cmd;

        if (cmd == "push"){
            cin >> num;
            myStack.push_back(num);
        }

        else if (cmd == "pop"){
            // c++ STL's pop_back() doesn't return.
            if (myStack.empty()) {
                cout << "-1\n";
                continue;
            }
            cout << myStack.back() << '\n';
            myStack.pop_back();
        }

        else if (cmd == "size"){
            cout << myStack.size() << '\n';
        }

        else if (cmd == "empty"){
            if (myStack.empty()) cout << "1\n";
            else cout << "0\n";
        }

        else if (cmd == "top"){
            if (myStack.empty()) {
                cout << "-1\n";
                continue;
            }
            cout << myStack.back() << '\n';
        }

    }


    return 0;
}