#include <bits/stdc++.h>

using namespace std;

long A, B, V; 
int cnt;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    
    cin >> A >> B >> V;
    int R = A - B;
    if (V<A) cnt = 1;
    else if((V-A)%R) {cnt = (V-A) / R + 2;} // V-A가 R로 나누어 떨어지지 않는 경우
    else {cnt = (V-A) / R + 1;} // V-A가 R로 나누어 떨어지는 경우

    /* ??? 이게 무슨 풀이지
    int A, B, V;
    cin >> A >> B >> V;
    cout << (V - B - 1) / (A - B)  + 1 ;
    return 0;
    */

    cout << cnt;

    return 0;
}