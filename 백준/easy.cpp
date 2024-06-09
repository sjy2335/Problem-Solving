#include <bits/stdc++.h>

using namespace std;

int a, b, c, d, e, f;

int main(void) {
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	cin >> a >> b >> c >> d >> e >> f;

	for (int i = -999; i < 1000; i++)
	{
		for (int j = -999; j < 1000; j++)
		{
			if((a * i + b * j == c) && (d * i + e * j == f)) {cout << i << ' ' << j; return 0;}
		}
	}
	

	return 0;
}