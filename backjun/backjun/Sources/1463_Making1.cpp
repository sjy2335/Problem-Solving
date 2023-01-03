#include <iostream>

using namespace std;

int main(void){

    ios_base::sync_with_stdio(0);
    cin.tie(NULL);
    cout.tie(NULL);

    int N=0, min=0;
    cin >> N;

    while (N != 1){
        min++;
        if (!N%3) N /= 3;
        else if (!N%2) N/=2;
        else N--;
    }
    
    cout<<min;
    return 0;
}