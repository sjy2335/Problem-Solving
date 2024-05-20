#include <iostream>
#include <string>
#include <list>

using namespace std;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    string str; // 공백 없으므로 getline(필요 없음)
    cin >> str;

    list<char> myList;
    for (int i = 0; i < str.size(); i++) myList.push_back(str[i]);
    
    list<char>::iterator iter;
    iter = myList.end();

    int M;
    cin >> M;

    for (int i = 0; i < M; i++)
    {
        char cmd;
        cin >> cmd;
        if (cmd == 'P') {
            char ch;
            cin >> ch;
            myList.insert(iter, ch);
        }
        else if (cmd == 'L') {
            if (iter!=myList.begin())iter --;
        }
        else if (cmd == 'D') {
            if (iter!=myList.end()) iter ++;
        }
        else if (cmd == 'B'){
            if (iter != myList.begin()) {
                // iter를 하나 줄이며 erase를 불러 커서 앞의 글자를 삭제
                iter = myList.erase(--iter); 
                // erase가 반환하는 iter로 갱신시켜줘야 한다. 메모리 관련 오류.
            }
        }
    }
    
    for (iter = myList.begin(); iter != myList.end(); iter++){
        cout << *iter;
    }

    cout << '\n';

    return 0;
}