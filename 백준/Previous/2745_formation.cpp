#include <cmath>
#include <iostream>

using namespace std;

string N;
int B, result;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    
    cin >> N >> B;
    for (size_t i = 0; i < N.size(); i++)
    {
        char c; int n;
        c = N[N.size()-i-1];
        if(c >= 'A') n = c - 'A' + 10;
        else n = c - '0';

        result += n * pow(B, i);
    }
    cout << int(result);

    return 0;
}