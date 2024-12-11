#include <iostream>
#include <algorithm>

using namespace std;

int L, C; // L은 암호의 자릿수, C는 입력 알파벳 개수
char A[15], P[15]; // A에 입력 알파벳 담고, P에 정답
bool isVowel[26];

void backtrack(int crnt, int prev, int consonant, int vowel){
    if (crnt == L){
        if (consonant >= 2 && vowel >= 1) {
            for (char value: P){
                cout << value; 
            }
            cout << endl;
        }
        return;
    } 
    for (int i = prev+1; i<C; i++){
        P[crnt] = A[i];
        backtrack(crnt+1, i ,consonant+!isVowel[A[i]-'a'], vowel+isVowel[A[i]-'a']);
    }
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    
    cin >> L >> C; 
    for(int i=0; i<C; i++){
        cin >> A[i];
    }

    sort(A, A+C); // 먼저 입력 알파벳 정렬
    
    // 모음 bool 배열 초기화
    isVowel[0] = isVowel[4] = isVowel[8] = isVowel[14] = isVowel[20] = true;
    
    // 가능성 있는 암호(조건을 만족하는 알파벳 조합)를 모두 출력해야 함 -> 백트래킹!
    backtrack(0, -1, 0, 0); // crnt, prev, consonant, vowel

    return 0;
}

