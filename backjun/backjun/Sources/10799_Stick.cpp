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
		//1. "(" �ԷµǸ� �ϴ� push.
		if (cmd[i] == '(') {
			stack.push('(');
		}
		//2. "()" �������� ������ ������. pop �ϰ� ���� ���� �����ŭ ans�� ����.
		else if (cmd[i - 1] == '(' && cmd[i] == ')') {
			stack.pop();
			ans += stack.size();
		}
		//3. "))" �����̸� ���밡 �������� ans�� �ϳ� ����.
		else if (cmd[i - 1] == ')' && cmd[i] == ')') {
			ans++;
			stack.pop();
		}
	}
	cout << ans;
	return 0;
}