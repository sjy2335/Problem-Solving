#include <iostream>
#include <string>
#include <queue>

using namespace std;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    queue<int> myQueue;
    int N;
    cin >> N;

    for (size_t i = 0; i < N; i++)
    {
        string cmd;
        cin >> cmd;
        if (cmd=="push") {
            int data;
            cin >> data;
            myQueue.push(data);
        }
        else if(cmd == "pop"){
            if (myQueue.empty()) cout << "-1\n";
            else{
                cout << myQueue.front() << '\n';
                myQueue.pop();
            }
        }
        else if(cmd == "size"){
            cout << myQueue.size() << '\n';
        }
        else if(cmd == "empty"){
            if (myQueue.empty()) cout << "1\n";
            else cout << "0\n";
        }
        else if(cmd == "front"){
            if (myQueue.empty()) cout << "-1\n";
            else{
                cout << myQueue.front() << '\n';
            }
        }
        else if(cmd == "back"){
            if (myQueue.empty()) cout << "-1\n";
            else{
                cout << myQueue.back() << '\n';
            }
        }


    }
    


    return 0;
}