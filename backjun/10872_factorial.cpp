#include <iostream>

using namespace std;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    int N, result=1;
    cin >> N;

    for (size_t i = 1; i <= N; i++)
    {
        result *= i;
    }
    cout << result;
    

    return 0;
}