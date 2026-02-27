#include <string>
#include <vector>

#include <iostream>

using namespace std;

vector<int> solution(vector<int> sequence, int k) {
    vector<int> answer;
    
    int accumulated = sequence[0];
    int left = 0, right = 0;
    
    while (left < sequence.size() and right < sequence.size()) {
        if (
            accumulated == k and 
            (answer.size() == 0 or answer[1] - answer[0] > right - left)
        ) {
            answer = {left, right};
        }
        
        if (accumulated <= k) {
            right++;
            accumulated += sequence[right];
        } else { // if accumulated > k
            accumulated -= sequence[left];
            left++;
        }
    }
    
    return answer;
}