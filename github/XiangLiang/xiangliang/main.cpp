#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
int main()
{
    int n, m;
    cin >>n>>m;
    const int tol = m;
    vector<string> course[tol + 1];

    while(n --)
    {
        string stu;
        int sum;
        cin >>stu>>sum;
        while(sum --)
        {
            int t;
            cin >>t;
            course[t].push_back(stu);
        }
    }
    for(int i = 1; i <= tol; i ++)
    {
        cout <<i<<' '<<course[i].size()<<endl;
        sort(course[i].begin(),course[i].end());
        for(int j = 0; j < course[i].size(); j ++)
            cout <<course[i][j]<<endl;
    }
    return 0;
}
