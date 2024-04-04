#include <iostream>
#include <string>
#include <algorithm>
#include <vector>

using namespace std;

int main() {
    // 생각할 필요 없는 문제는 여기에 풀고 지우기.
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    
    string A, B;
    cin >> A >> B;
    int cnt1[26]={0};
    int cnt2[26]={0};
    bool possible = true;
    int result=0;
    for (size_t i = 0; i < A.size(); i++)
    {
        cnt1[A[i]-'a']++;
    }
    for (size_t i = 0; i < B.size(); i++)
    {
        cnt2[B[i]-'a']++;
    }
    for (size_t i = 0; i < 26; i++)
    {
        if(cnt1[i] > cnt2[i]) result += cnt1[i]-cnt2[i];
        if(cnt1[i] < cnt2[i]) result += cnt2[i]-cnt1[i];
    }
    
    cout << result;
}