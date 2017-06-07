#include <iostream>
#include <stdlib.h>
#include <string.h>
#include <stdio.h>
using namespace std;

struct node
{
    int data;
    struct node * next;
};

int main()
{
    ios::sync_with_stdio(false);

    int m, n;
    struct node * head[500001], *p, *temp;

    while(cin >> n >> m)
    {
        for(int i = 0; i < n; i++)
            head[i] = NULL;//初始化链表头，对应每个点都有一个链表

        for(int i = 0; i < m; i++)//输入两点，确定连线
        {
            int u, v;
            cin >> u >> v;
            //当输入的点还没有建立链表的时候，开辟内存，存入数据
            if(head[u] == NULL)
            {
                head[u] = (struct node *)malloc(sizeof(struct node));
                head[u]->data = v;
                head[u]->next = NULL;
            }
            //当输入的点已经开辟了内存建立了链表，通过逆序建立链表的方法，存入数据
            else
            {
                temp = head[u]->next;
                p = (struct node *)malloc(sizeof(struct node));
                p->data = v;
                p->next = temp;
                head[u]->next = p;
            }
        }
        int q;
        cin >> q;
        for(int i = 0; i < q; i++)
        {
            int x, y;
            int flag = 0;
            cin >> x >> y;
            //当输入数据没有建立链表则不能连通
            if(head[x] == NULL)
                cout << "No" << endl;
            else
            {
                //从当前点开始遍历整个链表，当遇到输入的数据的时候，flag赋值跳出
                temp = head[x];
                while(temp != NULL)
                {
                    if(temp->data == y)
                    {
                        flag = 1;
                        break;
                    }
                    temp = temp->next;
                }
                if(flag == 1)
                    cout << "Yes" << endl;
                else
                    cout << "No" << endl;
            }
        }
    }
    return 0;
}

