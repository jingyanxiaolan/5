//5-21�Ӽ�������
#include<cstdio>
#include<iostream>
#include<algorithm>
using namespace std;
int n,c; //�����˱���n��c,n����װ����,c���ִ���������
int a[1000]; //����������a 
int sum=0,ans=0; //�����˱���sum��ans,sum����ǰ����װ�ϴ��ļ�װ��������ans�������װ����
void pr(){
    if(sum>ans)
    ans=sum;
}
void dfs(int x){
    if(x==0)    return;
    for(int i=x;i>=1;i--){
        sum+=a[i];//����ӵ�һ������ʼ����һλ�����ĺ�
        if(sum>c){//���Ǻʹ���Ŀ��ֵ
            sum-=a[i];//����ȥ��������һλ
            }
            if(i==1){
                pr();
                sum=0;
            }
        }
        dfs(x-1);
    }
int main(){
    
    scanf("%d%d",&n,&c); //����n��c��ֵ��5 10
    for(int i=1;i<=n;i++){
        scanf("%d",&a[i]); //����a[i]��ֵ��7 2 6 5 4
    }
    sort(a+1,a+n+1);//������������Ҫ2 4 5 6 7
    dfs(n);
    printf("%d",ans); //������װ��������10
    return 0;
}

