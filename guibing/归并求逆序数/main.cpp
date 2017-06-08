#include <iostream>
#include <cstdio>
using namespace std;
int a[100010],b[100010];
int cnt;
void mergesort(int low,int mid,int high)
{
    int i=low,j=mid+1,k=0;
    while(j<=high&&i<=mid)
    {
        if(a[i]<=a[j])
            b[k++]=a[i++];
        else
        {
            b[k++]=a[j++];
            cnt+=(mid-i)+1;
        }
    }
    while(i<=mid)
        b[k++]=a[i++];
    while(j<=high)
        b[k++]=a[j++];
    for(i=0; i<k; i++)
        a[i+low]=b[i];
}
void msort(int low,int high)
{
    if(low<high)
    {
        int mid=(low+high)/2;
        msort(low,mid);
        msort(mid+1,high);
        mergesort(low,mid,high);
    }
}
int main()
{
    int n;
    scanf("%d",&n);
    for(int i=0; i<n; i++)
        scanf("%d",&a[i]);
    cnt=0;
    msort(0,n-1);
    printf("%d\n",cnt);

    return 0;
}
