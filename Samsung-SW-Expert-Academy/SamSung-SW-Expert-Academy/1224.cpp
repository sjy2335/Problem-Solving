#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
#include <stack>

using namespace std;

int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int length;
	cin >> length;

	char* input = new char[length]; // memory allocation
	cin >> input; // ex. ¡°3+(4+5)*6+7¡±

	stack<char> number_stack;
	stack<char> operation_stack;

	// if number, just print
	// 
	// In terms of operator, 
		// 1. if stack empty, just push
		// 2. if the operator priority higher than the 'top', push
		// else, pop until 1 or 2
	//
	// after all, pop until empty
	// 
	// if '(' just push with next operator
	// if ')' pop and print until '('
	// 
	// calculation done at the same time during transformation

	for (int i = 0; i < length; i++) {

	}


	return 0;

}