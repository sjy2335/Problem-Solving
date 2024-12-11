#include <iostream>
#include <vector>
#include <string>

using namespace std;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    int T;
    cin >> T;
    cin.ignore(); // getline을 위해 버퍼를 비워줘야 함.

    for (size_t i = 0; i < T; i++)
    {
        // getline 공백을 포함하는 문장 단위로 입력 받기
        // <string>의 getline()은 문자열의 크기를 지정하지 않아도 됨.
        string sentence;
        vector<char> stack;
        getline(cin, sentence);

        for (size_t j = 0; j <= sentence.size(); j++)
        {
            if (j == sentence.size() || sentence[j]==' ') {
                while(!stack.empty()) {
                    cout << stack.back();
                    stack.pop_back();
                }
                cout << ' ';
                continue;
            }
            stack.push_back(sentence[j]);
        }
        cout << '\n';
    }
    
    return 0;
}