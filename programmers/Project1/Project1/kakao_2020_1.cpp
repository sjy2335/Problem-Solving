#include <string>
#include <vector>
#include <iostream>

using namespace std;

int solution(string s) {
    
    int size = s.size();
    int answer = size; // 1개 단위가 최소
    
    for (int i = 0; i < s.size(); i++) {
        answer = 0;

    }

    return answer;
}

int main(void) {
    string s;
    cin >> s;
    solution(s);
}