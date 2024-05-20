#include <bits/stdc++.h>

using namespace std;

int N;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    
    cin >> N;
    for (size_t i = 0; i < N; i++)
    {
        string cmd;
        list<char> l;
        auto iter = l.begin();

        cin >> cmd;


        for(char c : cmd){
            switch (c){
            case '<':
                if(iter != l.begin()){
                    iter--;
                }
                break;
            case '>':
                if (iter != l.end()){
                    iter++;
                }
                break;
            case '-':
                if (iter != l.begin()){
                iter = l.erase(--iter);
                }
                break;
            default:
                l.insert(iter, c);
                break;
            }
        }

        for (char c: l)
        {
            cout << c;
        }

        cout << '\n';
    }
    
    


    return 0;
}