#include <iostream>
#include <string>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    
    int N;
    cin >> N;
    
    int q1 = N / 5;
    int q2 = N / 25;
    int q3 = N / 125;
    
    cout << q1 + q2 + q3 << endl;
    
    return 0;
}