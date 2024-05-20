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

    for (int i = 0; i < N; i++)
    {
        int cmd;
        cin >> cmd;
        if (cmd == 1){
            int data;
            cin >> data;
            dq.push_front(data);
        }
        else if (cmd == 2){
            int data;
            cin >> data;
            dq.push_back(data);
        }

        else if (cmd == 3){
            if(dq.empty()){
                cout << "-1";
            }
            else{
                cout << dq.front();
                dq.pop_front();
            }
            cout << "\n";
        }
        else if (cmd == 4){
            if(dq.empty()){
                cout << "-1";
            }
            else{
                cout << dq.back();
                dq.pop_back();
            }
            cout << "\n";
        }
        else if (cmd == 5){
            cout << dq.size();
            cout << "\n";
        }
        else if (cmd == 6){
            if(dq.empty()) cout << "1";
            else cout << "0";
            cout << "\n";
        }
        else if (cmd == 7){
            if(dq.empty()){
                cout << "-1";
            }
            else{
                cout << dq.front();
            }
            cout << "\n";
        }
        else if (cmd == 8){
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