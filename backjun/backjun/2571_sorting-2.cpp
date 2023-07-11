#include <iostream>

using namespace std;

int N;
int a1[1000001];
int* a2;

void merge(int left, int right)
{
	int mid = (left + right) / 2;

	int i = left;
	int j = mid + 1;
	int k = left;
	while (i <= mid && j <= right)
	{
		if (a1[i] <= a1[j]) 
			a2[k++] = a1[i++]; 
		else
			a2[k++] = a1[j++];
	}

	int tmp = i > mid ? j : i;
	
	while(k<=right) a2[k++] = a1[tmp++];

	for (int i=left;i<=right;i++) a1[i] = a2[i];
}

void divide(int left, int right) {
	int mid;
	if (left != right)
	{
		mid = (left + right) / 2;
		divide(left, mid);
		divide(mid + 1, right);
		merge(left, right);
	}
}

int main(void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N;
	cin >> N;

	a2 = new int[N];

	for (int i = 0; i < N; i++) {
		cin >> a1[i];
	}

	divide(0, N-1);

	for (int i = 0; i < N; i++) {
		cout << a1[i] << "\n";
	}

	return 0;
}