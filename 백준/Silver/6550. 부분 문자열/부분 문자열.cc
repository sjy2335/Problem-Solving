#include <iostream>
#include <bits/stdc++.h>

using namespace std;

const string CORRECT = "Yes\n";
const string INCORRECT = "No\n";

string s, t;

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	while(cin >> s >> t) {
	  int s_index = 0;
	  for (int i = 0; i < t.length(); i++) {
		if (s[s_index] == t[i]) s_index++;
	  }
	  if (s_index == s.length()) cout << CORRECT;
	  else cout << INCORRECT;
	}

	return 0;
}