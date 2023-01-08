#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

int solution(string s) {
    
    int size = s.size();
    int answer = size, tmp;
    for (int unit = 2; unit < size/2; unit++) {
        tmp = 0;
        for (int i = 0; i < size; i++) {
            string stmp = s.substr(i, unit);

        }
    }

    return answer;
}

int main(void) {
    string s;
    cin >> s;
    solution(s);
}