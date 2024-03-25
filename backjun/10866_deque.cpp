#include <iostream>
#include <deque>
#include <string>

using namespace std;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    int N;
    cin >> N;
    deque<int> dq;

    for (size_t i = 0; i < N; i++)
    {
        string cmd;
        cin >> cmd;
        if (cmd == "push_back"){
            int data;
            cin >> data;
            dq.push_back(data);
        }
        else if (cmd == "push_front"){
            int data;
            cin >> data;
            dq.push_front(data);
        }

        else if (cmd == "pop_front"){
            if(dq.empty()){
                cout << "-1";
            }
            else{
                cout << dq.front();
                dq.pop_front();
            }
            cout << "\n";
        }
        else if (cmd == "pop_back"){
            if(dq.empty()){
                cout << "-1";
            }
            else{
                cout << dq.back();
                dq.pop_back();
            }
            cout << "\n";
        }
        else if (cmd == "size"){
            cout << dq.size();
            cout << "\n";
        }
        else if (cmd == "empty"){
            if(dq.empty()) cout << "1";
            else cout << "0";
            cout << "\n";
        }
        else if (cmd == "front"){
            if(dq.empty()){
                cout << "-1";
            }
            else{
                cout << dq.front();
            }
            cout << "\n";
        }
        else if (cmd == "back"){
            if(dq.empty()){
                cout << "-1";
            }
            else{
                cout << dq.back();
            }
            cout << "\n";
        }
    }
    return 0;
}