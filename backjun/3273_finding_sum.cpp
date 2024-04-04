  #include <iostream>
#include <algorithm>
#include <vector>

using namespace std;
int main() {
    // 시간 초과가 띄우는 것부터 문제.
    // 정렬과 투포인터 알고리즘 생각하기.
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    
    int n;
    cin>>n;
    vector<int>v;

    for (size_t i = 0; i < n; i++)
    {
        int m; cin >> m;
        v.push_back(m);
    }
    sort(v.begin(), v.end());
    
    int x; cin >> x;
    int cnt=0;

    // for (auto i = v.begin(); i < v.end()-1; i++)
    // {
    //     for (auto j=i+1; j<v.end();j++){
    //         if (*i + *j == x) cnt++;
    //         if (*i + *j > x) break;
    //     }
    // }

    auto s = v.begin();
    auto e = v.end()-1;

    while(*s < *e){
        if(*s + *e == x) {
            cnt++;
            s++;
            e--;
        }
        else if(*s + *e < x) {s++;}
        else e--;
    }
    
    cout << cnt;
}