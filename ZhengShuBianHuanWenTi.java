//5-8�����任����
import java.util.*;
public class ZhengShuBianHuanWenTi{
static int m;
static int tempcount,bestcount; //�����˱���tempcount��bestcount��tempcount����ǰ�任������bestcount�������ٴ���
static int[] temp1=new int[100]; //������һά����temp1
static int[] temp2=new int[100]; //������һά����temp2
public static void main(String args[]){
Scanner input=new Scanner(System.in);
int n=input.nextInt(); //��������n:15
m=input.nextInt(); //��������m:4
tempcount=0; //��tempcount�ĳ�ֵ��Ϊ0
bestcount=100; //��bestcount�ĳ�ֵ��Ϊ100
Transform(n);
System.out.println(bestcount);
for(int i=bestcount;i>=1;i--){
if(temp2[i]==2)System.out.print("f");
if(temp2[i]==1)System.out.print("g");
}
}

public static void Transform(int t){
if(t==m){//�ҵ�ת������
if(tempcount<bestcount){
bestcount=tempcount;//����Сת��������ֵ��bestcount
for(int i=1;i<=bestcount;i++){
temp2[i]=temp1[i];//temp2����С����ת������
}
}
return ;
}

int temp=t/2;
tempcount++;
if(tempcount<bestcount&& t>0){
temp1[tempcount]=1;//ʹ�÷���g��ֵΪ1
Transform(temp);
}
tempcount--;//����
    
temp=3*t;
tempcount++;
if(tempcount<bestcount){
temp1[tempcount]=2; //ʹ�÷���f��ֵΪ2
Transform(temp);
}
tempcount--;//����
}
}