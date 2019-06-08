//5-21子集树问题
#include<cstdio>
#include<iostream>
#include<algorithm>
using namespace std;
int n,c; //定义了变量n，c,n代表集装箱数,c是轮船的载重量
int a[1000]; //定义了数组a 
int sum=0,ans=0; //定义了变量sum和ans,sum代表当前的已装上船的集装箱重量，ans代表最大装载量
void pr(){
    if(sum>ans)
    ans=sum;
}
void dfs(int x){
    if(x==0)    return;
    for(int i=x;i>=1;i--){
        sum+=a[i];//计算从第一个数开始和下一位的数的和
        if(sum>c){//若是和大于目标值
            sum-=a[i];//则舍去并进行下一位
            }
            if(i==1){
                pr();
                sum=0;
            }
        }
        dfs(x-1);
    }
int main(){
    
    scanf("%d%d",&n,&c); //输入n和c的值：5 10
    for(int i=1;i<=n;i++){
        scanf("%d",&a[i]); //输入a[i]的值：7 2 6 5 4
    }
    sort(a+1,a+n+1);//这里的排序很重要2 4 5 6 7
    dfs(n);
    printf("%d",ans); //输出最大装载重量：10
    return 0;
}

