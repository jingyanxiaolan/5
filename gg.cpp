//5-3最小重量机器设计问题
#include<iostream>
#include<stdio.h>
using namespace std;
int w[100][100];//w[i][j]为第i个零件在第j个供应商的重量
int c[100][100];//c[i][j]为第i个零件在第j个供应商的价格
int bestx[100];//bestx[i]表示一次搜索到底后的最优解，用来存放第i个零件的供应商，
int x[100];//x[i]临时存放第i个零件的供应商
int cw=0,cc=0,bestw=10000;
int cost;//限定价格
int n;//部件数
int m;//供应商数
void Backtrack(int t)
{
    int j;
    if(t>n)//搜索到叶子结点，一个搜索结束，所有零件已经找完
    {
        bestw=cw;//当前最小重量
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
    cin>>n; //输入部件数n的值:3 
    cin>>m; //输入供应商数m的值:4
    cin>>cost; //输入限定价格cost的值:4
    for(i=1; i<=n; i++)
        for(j=1; j<=m; j++)
            cin>>w[i][j]; //输入各部件的在不同供应商的重量:1 2 3;3 2 1;2 2 2
    for(i=1; i<=n; i++)
        for(j=1; j<=m; j++)
            cin>>c[i][j]; //输入各部件的在不同供应商的价格:1 2 3;3 2 1;2 2 2
    Backtrack(1);
    cout<<bestw<<' '; //输出结果最小重量
    cout<<endl; //换行
    for(i=1;i<=n;i++)
        cout<<bestx[i]<<' '; //输出结果每个部件的供应商
	cout<<endl;
    return 0;
}
