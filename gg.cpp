//5-3��С���������������
#include<iostream>
#include<stdio.h>
using namespace std;
int w[100][100];//w[i][j]Ϊ��i������ڵ�j����Ӧ�̵�����
int c[100][100];//c[i][j]Ϊ��i������ڵ�j����Ӧ�̵ļ۸�
int bestx[100];//bestx[i]��ʾһ���������׺�����Ž⣬������ŵ�i������Ĺ�Ӧ�̣�
int x[100];//x[i]��ʱ��ŵ�i������Ĺ�Ӧ��
int cw=0,cc=0,bestw=10000;
int cost;//�޶��۸�
int n;//������
int m;//��Ӧ����
void Backtrack(int t)
{
    int j;
    if(t>n)//������Ҷ�ӽ�㣬һ��������������������Ѿ�����
    {
        bestw=cw;//��ǰ��С����
        for(j=1;j<=n;j++)
            bestx[j]=x[j];
    }
    else
    {
        for(j=1;j<=m;j++)
        {
            if(cc+c[t][j]<=cost && cw+w[t][j]<bestw)
            {
                x[t]=j;
                cc+=c[t][j];
                cw+=w[t][j];
                Backtrack(t+1);
                cc-=c[t][j];
                cw-=w[t][j];
            }
        }
    }
}
 
int main()
{
    int i,j;
    cin>>n; //���벿����n��ֵ:3 
    cin>>m; //���빩Ӧ����m��ֵ:4
    cin>>cost; //�����޶��۸�cost��ֵ:4
    for(i=1; i<=n; i++)
        for(j=1; j<=m; j++)
            cin>>w[i][j]; //������������ڲ�ͬ��Ӧ�̵�����:1 2 3;3 2 1;2 2 2
    for(i=1; i<=n; i++)
        for(j=1; j<=m; j++)
            cin>>c[i][j]; //������������ڲ�ͬ��Ӧ�̵ļ۸�:1 2 3;3 2 1;2 2 2
    Backtrack(1);
    cout<<bestw<<' '; //��������С����
    cout<<endl; //����
    for(i=1;i<=n;i++)
        cout<<bestx[i]<<' '; //������ÿ�������Ĺ�Ӧ��
	cout<<endl;
    return 0;
}
