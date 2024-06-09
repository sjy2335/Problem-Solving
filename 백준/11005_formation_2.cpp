#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

int N, B;
vector<char> result;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    
    cin >> N >> B;
    do{
        int r = N % B;
        char c = r >= 10 ? char('A' + r - 10) : '0' + r;
        result.push_back(c);
        N = (N-r) / B;
    } while (N > 0);
    
    int l = result.size();
    for (size_t i = 0; i < l; i++)
    {
        cout << result.back();
        result.pop_back();
    }
}