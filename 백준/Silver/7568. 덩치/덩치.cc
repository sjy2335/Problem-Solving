#include <bits/stdc++.h>
using namespace std;

struct Person {
    int w, h;
    int idx;
};

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    
    int N;
    cin >> N;
    
    vector<Person> v(N);
    for (int i = 0; i < N; i++) {
        cin >> v[i].w >> v[i].h;
        v[i].idx = i;
    }
    
    vector<int> rankAns(N, 1);
    
    // N <= 50 => N^2 Bruteforce
    for (int i = 0; i < N; i++) {
        int bigger = 0;
        for (int j = 0; j < N; j++) {
            if (v[j].w > v[i].w && v[j].h > v[i].h) bigger++;
        }
        rankAns[v[i].idx] = bigger + 1;
    }
    
    for (int i = 0; i < N; i++) {
        cout << rankAns[i] << ' ';
    }
    
    return 0;
}