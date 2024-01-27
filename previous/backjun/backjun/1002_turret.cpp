#include <iostream>

using namespace std;


int main(void) {

	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	int N, x1, y1, r1, x2, y2, r2, res, dist;
	cin >> N;

	for (int i = 0; i < N; i++) {

		cin >> x1 >> y1 >> r1 >> x2 >> y2 >> r2;

		dist = (x1 - x2) * (x1 - x2) + (y1-y2)* (y1 - y2); // �� �� �߽� �Ÿ� (����)
		int r_sum = (r1 + r2) * (r1 + r2); // ������ ���� ����
		int r_sub = (r1 - r2) * (r1 - r2); // ������ ���� ����

		// dist�� r_sub, r_sum�� ���踦 �̿�
		// +) ���� ������ �� �Ӱ���(�����ϴ� ����)���� �Ÿ�, ������ ���� ���� ���Ǳ�
		// ��� ���� ��������...

		// �Ÿ��� ������ ������ ũ��, ������ �պ��� ������ ���� 2��
		if (dist > r_sub && dist < r_sum) res = 2;

		// ���� || ����
		else if (r_sum == dist || r_sub == dist) res = 1;

		// else�� ���� ���� ��� ó��
		else res = 0;

		// if - else �帧 ���� ���ͼ� ��ġ�� ��� ó��
		if (dist == 0 && r1 == r2) res = -1;

		cout << res << '\n';
	}
	return 0;
}