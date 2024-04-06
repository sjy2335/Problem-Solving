#include <iostream>

using namespace std;

int T, C;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    
    cin >> T;
    for (size_t i = 0; i < T; i++)
    {
        int arr[4] = {};
        cin >> C;

        while(C > 0){
            if(C / 25 > 0) { arr[0] += C / 25; C -= 25 * (C / 25); }
            else if (C / 10 > 0) { arr[1] += C / 10; C -= 10 * (C / 10); }
            else if (C / 5 > 0) { arr[2] += C / 5; C -= 5 * (C / 5); }
            else { arr[3] += C; C = 0; }
        }
        
        for(int a : arr){
            cout << a << ' ';
        }
        cout << '\n';
    }
    

    return 0;
}