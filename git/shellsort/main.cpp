#include <iostream>
using namespace std;
void shellsort(int *a, int n)
{
    for(int gap = n/2; gap > 0; gap/=2)
    {
        for(int i = gap; i < n; i ++)
            for(int j = i - gap; j >= 0 && a[j] > a[j + gap]; j -= gap)
            swap(a[j], a[j + gap]);
        if(gap == n/2 || gap == 1)
            for(int i = 0; i < n; i ++)
            cout <<a[i], i == n - 1?cout <<endl:cout <<' ';
    }
}
int main()
{
    int n;
    while(cin >>n)
    {
        int *a = new int [n];
        for(int i = 0; i < n; i ++)
            cin >>a[i];
        shellsort(a, n);
    }
    return 0;
}
