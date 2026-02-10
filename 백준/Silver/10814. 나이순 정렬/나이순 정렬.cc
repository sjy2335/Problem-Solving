#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

struct Member {
    int age;
    string name;
    int joined;
};

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    
    int N;
    cin >> N;
    vector<Member> v;
    
    for (int i = 0; i < N; i++) {
        int age;
        string name;
        
        cin >> age >> name;
        Member member{age, name, i};
        v.push_back(member);
    }
    
    sort(v.begin(), v.end(), 
         [](const Member& a, const Member& b) {
             if (a.age != b.age) return a.age < b.age;
             return a.joined < b.joined;
         });
    
    for (auto member: v) {
        cout << member.age << " " << member.name << endl;
    }   
    
    return 0;
}