#include <bits/stdc++.h>

using namespace std;

int T;


int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cin >> T;

    for (int i = 0; i < T; i++) {
        
        deque<int> dq;

        bool error_flag = false;
        bool reverse_flag = false;

        string p; int n; string s_arr;
        cin >> p >> n >> s_arr;

        // 1. push back with parsing - isdigit, concatenation with "+", stoi 
        string tmp = "";
        for (char c : s_arr) {
            if (isdigit(c)) { tmp += c; }
            else {
                if(!tmp.empty()){
                    dq.push_back(stoi(tmp)); 
                    tmp = "";
                }
            }
        }

        // 2. operation
        for (char c : p) {
            if (c == 'R') reverse_flag = !reverse_flag;
            if (c == 'D') {
                if(dq.empty()) {error_flag = true;}
                else if(reverse_flag){
                    dq.pop_back();
                }
                else{
                    dq.pop_front();
                }
            }
        }

        // 3. printing        
        if (error_flag) {
            cout << "error\n";
            continue;
        }
        
        
        cout << '[';
        if (!dq.empty()) {
            if (reverse_flag) {
                while(dq.size()>1){
                    cout << dq.back() << ',';
                    dq.pop_back();
                }
                cout << dq.back();
                dq.pop_back();
            }
            else {
                while (dq.size()>1) {
                    cout << dq.front() << ',';
                    dq.pop_front();
                }
                cout << dq.front();
                dq.pop_front();
            }
        }
        
        cout << "]\n";
    }

    

    return 0;
}