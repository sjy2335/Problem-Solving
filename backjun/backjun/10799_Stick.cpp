#include <iostream>
#include <string>
#include <stack>

using namespace std;

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	string cmd;
	cin >> cmd;
	stack<char> stack;
	int ans = 0;

	for (int i = 0; i < cmd.length(); i++) {
		//1. "(" 입력되면 일단 push.
		if (cmd[i] == '(') {
			stack.push('(');
		}
		//2. "()" 연속으로 나오면 레이저. pop 하고 현재 스택 사이즈만큼 ans에 더함.
		else if (cmd[i - 1] == '(' && cmd[i] == ')') {
			stack.pop();
			ans += stack.size();
		}
		//3. "))" 형태이면 막대가 끝났으니 ans에 하나 더함.
		else if (cmd[i - 1] == ')' && cmd[i] == ')') {
			ans++;
			stack.pop();
		}
	}
	cout << ans;
	return 0;
}