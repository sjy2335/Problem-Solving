#include <iostream>
#include <algorithm>
#include <string>
#include <vector>

using namespace std;

int main(void) {
	//stdio.h와 동기화 꺼서 속도 빠르게 하는 3줄
	//단, scanf printf 사용 불가, 싱글 쓰레드에서만 사용 가능
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int d, b, cnt = 0;
	vector<string> dbj; //듣보잡
	vector<int> overlap; //겹치는 인덱스 저장할 벡터
	cin >> d >> b;
	//dbj.resize(d + b);
	//for (int i = 0; i < d + b; i++)
	//	cin >> dbj[i];
	//sort(dbj.begin(), dbj.end());
	//for (int i = 0; i < (d + b - 1);i++) {
	//	if (dbj[i] == dbj[i + 1]) {
	//		cnt++;
	//		overlap.push_back(i);
	//	}
	//}
	//cout << cnt << '\n';
	//for (int i = 0; i < overlap.size(); i++) {
	//	cout << dbj.at(overlap[i]) << '\n';
	//}  //sol1

	vector<string> ans;
	dbj.resize(d);
	for (int i = 0; i < d; i++) cin >> dbj[i];
	sort(dbj.begin(), dbj.end());
	for (int i = 0; i < b; i++) {
		string tmp;
		cin >> tmp;
		if (binary_search(dbj.begin(), dbj.end(), tmp)) ans.push_back(tmp);
	}
	cout << ans.size() << '\n';
	sort(ans.begin(), ans.end());
	for_each(ans.begin(), ans.end(), [](string str) { cout << str << '\n'; });
	//람다식 이용 출력
}