#include <iostream>
#include <algorithm>
#include <string>
#include <vector>

using namespace std;

int main(void) {
	//stdio.h�� ����ȭ ���� �ӵ� ������ �ϴ� 3��
	//��, scanf printf ��� �Ұ�, �̱� �����忡���� ��� ����
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int d, b, cnt = 0;
	vector<string> dbj; //�躸��
	vector<int> overlap; //��ġ�� �ε��� ������ ����
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
	//���ٽ� �̿� ���
}