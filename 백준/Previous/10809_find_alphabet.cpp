#include <iostream>

using namespace std;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    int A, B, C;
    cin >> A >> B >> C;
    cout <<  (A+B)%C << '\n' << ((A%C) + (B%C))%C <<'\n' << (A*B)%C << '\n'<<((A%C) * (B%C))%C;
    
    return 0;
}