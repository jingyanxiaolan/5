//5-8整数变换问题
import java.util.*;
public class ZhengShuBianHuanWenTi{
static int m;
static int tempcount,bestcount; //定义了变量tempcount和bestcount，tempcount代表当前变换次数，bestcount代表最少次数
static int[] temp1=new int[100]; //定义了一维数组temp1
static int[] temp2=new int[100]; //定义了一维数组temp2
public static void main(String args[]){
Scanner input=new Scanner(System.in);
int n=input.nextInt(); //输入整数n:15
m=input.nextInt(); //输入整数m:4
tempcount=0; //将tempcount的初值定为0
bestcount=100; //将bestcount的初值定为100
Transform(n);
System.out.println(bestcount);
for(int i=bestcount;i>=1;i--){
if(temp2[i]==2)System.out.print("f");
if(temp2[i]==1)System.out.print("g");
}
}

public static void Transform(int t){
if(t==m){//找到转换方法
if(tempcount<bestcount){
bestcount=tempcount;//将最小转换次数赋值给bestcount
for(int i=1;i<=bestcount;i++){
temp2[i]=temp1[i];//temp2存最小次数转换方法
}
}
return ;
}

int temp=t/2;
tempcount++;
if(tempcount<bestcount&& t>0){
temp1[tempcount]=1;//使用方法g赋值为1
Transform(temp);
}
tempcount--;//回溯
    
temp=3*t;
tempcount++;
if(tempcount<bestcount){
temp1[tempcount]=2; //使用方法f赋值为2
Transform(temp);
}
tempcount--;//回溯
}
}