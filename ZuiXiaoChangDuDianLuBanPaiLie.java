

//5-2��С���ȵ�·����������
import java.util.Scanner;


public class ZuiXiaoChangDuDianLuBanPaiLie {

 
   private static int n,m;
  //�����˱���n��m,n������n����·�壬m������m�����ӿ�
   private static int[] bestx;
 //������һά����bestx,bestx����ǰ���Ž�
    private static int[][] B;

 //�����˶�ά����B���������ӿ�����
    private static int[] x,low,high;
 //������һά����x,low,high��x����ǰ��
    private static int bestd;//�������bestd������ǰ�����ܶ�
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);


        while (true){
  
          n = input.nextInt(); //�������n��ֵ
            m = input.nextInt();

  //�������m��ֵ
           bestx = new int[n+1];
 //���ٴ�СΪn+1��int*��һά���飬bestx���������׵�ַ
            B = new int[n+1][m+1];

 //��������Ϊn+1����Ϊm+1��int*�Ͷ�ά���飬B ���������׵�ַ
         for(int i=1; i<=n; i++)
 //i=1;i<=8;i++
                for(int j=1; j<=m; j++)
  //j=1;j<=5;j++
                   B[i][j] = input.nextInt();

 //�����ά���������i,j
           int minLen = arrangeBoards();

 
           System.out.println(minLen);


           for(int i=1; i<=n; i++)
  //i=1;i<=8;i++
               System.out.print(bestx[i]+" ");
        }
    }


    private static int arrangeBoards(){
 
       x = new int[n+1];
 //���ٴ�СΪn+1��int*��һά���飬x���������׵�ַ
       low = new int[m+1];  //���ٴ�СΪm+1��int*��һά���飬low���������׵�ַ
        high = new int[m+1];

  //���ٴ�СΪm+1��int*��һά���飬high���������׵�ַ
       bestd = n+1;

  //8+1=9
       for(int i=1; i<=n; i++)
  //i=1;i<=8;i++
           x[i] = i;


        backtrack(1);

 //ѭ������
       return bestd;
    }

 
   private static void backtrack(int i){
 
       if(i == n){
  //i==8
           int tmp = len(i);
  
          if(tmp < bestd){
   
             bestd = tmp;
 
               for(int j=1; j<=n; j++)
 
                   bestx[j] = x[j];
 
           }
        }else{
   
         for(int j=i; j<=n; j++){
 
               swap(x,i,j);
 //��������Ԫ�� x[i] �� x[j]���ֵ
                int ld = len(i);
  
              if(ld < bestd)
  
                  backtrack(i+1);
 
               swap(x,i,j);
 //��������Ԫ�� x[i] �� x[j]���ֵ
           }
        }
    }

    
private static int len(int ii){
  
      for(int i=1; i<=m; i++){
 
           high[i] = 0;
 
           low[i] = n+1;
        }
 
       for(int i=1; i<=ii; i++)

            for(int k=1; k<=m; k++)

                if(B[x[i]][k] > 0){
  
                  if(i < low[k]) low[k] = i;
  
                  if(i > high[k]) high[k] = i;
                }

        int tmp = 0;
  
      for(int k=1; k<=m; k++)
  
          if(low[k]<=n && high[k]>0 && tmp<high[k]-low[k])
 
               tmp = high[k] - low[k];


        return tmp;
    }

 
   private static void swap(int[] x, int i, int j){
 
       int tmp;
  
      tmp = x[i];
 
       x[i] = x[j];
   
     x[j] = tmp;
    }
}
