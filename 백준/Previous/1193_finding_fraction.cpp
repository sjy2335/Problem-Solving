#include <bits/stdc++.h>

using namespace std;

int main(void){
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    long x, sum=1, step=1;
    cin >> x;

    while(sum + step <= x) {sum+= step; step++;}
    

    int a, b;
    if(step%2) {
        a = step; 
        b = 1;
        for (; sum < x ;sum++) { a--; b++; }      
    } else {
        a = 1;
        b = step;
        for (; sum < x ;sum++) { a++; b--; }
    }

    cout << a << '/' << b;
    return 0;
}