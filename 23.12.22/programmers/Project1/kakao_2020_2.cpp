#include <iostream>
#include <string>
#include <stack>

using namespace std;

int is_correct(string p) {
    stack<char> s1;
    for (int i = 0; i < p.size(); i++) {
        switch (p[i]) {
        case '(':
            s1.push('(');
            break;
        case ')':
            if (s1.empty()) return 0;
            if (s1.top() == '(') s1.pop();
        }
    }
    if (s1.empty()) return 1;
}

string solution(string p) {

    string u = "", v = "", answer = "";
    int n = 0, m = 0, i;
    stack<char> s1;

    if (!p.size()) return answer;

    //1. 두개의 균형잡힌 문자열로 분리
    s1.push(p[0]); // 첫번째 놈 s1과, u에 넣기
    u += p[0];
    for (i = 1; i < p.size(); i++) {
        char data = p[i];
        if (s1.top() != data) {
            s1.pop();
        }
        else {
            s1.push(data);
        }
        u += data;
        if (s1.empty()) break;
    }
    for (int j = ++i; j < p.size(); j++) {
        v += p[j];
    }
    cout << u << "\n";
    cout << v << "\n";
    

    cout << is_correct(u)<<"\n";
    if (is_correct(u)) {
        answer = u + solution(v);
    }
    else {
        string tmp = "(";
        tmp += solution(v);
        tmp += ')';
        u.erase(u.begin());
        u.erase(u.begin() + u.size() - 1);
        for (int i = 0; i < u.size();i++) {
            switch (u[i]) {
            case '(':
                u[i] = ')';
                break;
            case ')':
                u[i] = '(';
                break;
            default:
                break;
            }
        }
        cout << "tmp: " + tmp + "\n";
        cout << "reversed u: " + u + "\n";
        answer = tmp + u;
    }
    cout << "a: "+ answer << "\n";
    return answer;
}

int main(void) {
    string s;
    cin >> s;
    cout << "solution: "+ solution(s);
}