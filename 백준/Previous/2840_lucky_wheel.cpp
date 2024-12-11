#include <bits/stdc++.h>

using namespace std;

int N, K;
bool exist[26];

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    
    cin >> N >> K;
    
    list<char> l;
    l.assign(N, '?');
    
    auto iter = l.end();

    for (size_t i = 0; i < K; i++)
    {
        int n; char c;
        cin >> n >> c;

        for (size_t j = 0; j < n; j++)
        {
            iter++;
            if(iter == l.end()) iter = l.begin();
        }
        
        if((*iter != c && (*iter != '?' || exist[c-'A']))){
            cout << '!';
            return 0;
        }

        *iter = c;
        exist[c-'A'] = true;

    }

    for (size_t i = 0; i < N; i++)
    {
        cout << *iter;
        if(iter == l.begin()) iter = l.end();
        iter--;
    }
    

    return 0;
}