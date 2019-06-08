

//5-2最小长度电路板排列问题
import java.util.Scanner;


public class ZuiXiaoChangDuDianLuBanPaiLie {

 
   private static int n,m;
  //定义了变量n和m,n代表有n个电路板，m代表有m个连接块
   private static int[] bestx;
 //定义了一维数组bestx,bestx代表当前最优解
    private static int[][] B;

 //定义了二维数组B，代表连接块数组
    private static int[] x,low,high;
 //定义了一维数组x,low,high，x代表当前解
    private static int bestd;//定义变量bestd，代表当前最优密度
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);


        while (true){
  
          n = input.nextInt(); //输入变量n的值
            m = input.nextInt();

  //输入变量m的值
           bestx = new int[n+1];
 //开辟大小为n+1的int*型一维数组，bestx等于数组首地址
            B = new int[n+1][m+1];

 //开辟了行为n+1，列为m+1的int*型二维数组，B 等于数组首地址
         for(int i=1; i<=n; i++)
 //i=1;i<=8;i++
                for(int j=1; j<=m; j++)
  //j=1;j<=5;j++
                   B[i][j] = input.nextInt();

 //输入二维数组的数据i,j
           int minLen = arrangeBoards();

 
           System.out.println(minLen);


           for(int i=1; i<=n; i++)
  //i=1;i<=8;i++
               System.out.print(bestx[i]+" ");
        }
    }


    private static int arrangeBoards(){
 
       x = new int[n+1];
 //开辟大小为n+1的int*型一维数组，x等于数组首地址
       low = new int[m+1];  //开辟大小为m+1的int*型一维数组，low等于数组首地址
        high = new int[m+1];

  //开辟大小为m+1的int*型一维数组，high等于数组首地址
       bestd = n+1;

  //8+1=9
       for(int i=1; i<=n; i++)
  //i=1;i<=8;i++
           x[i] = i;


        backtrack(1);

 //循环调用
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
 //交换数组元素 x[i] 和 x[j]里的值
                int ld = len(i);
  
              if(ld < bestd)
  
                  backtrack(i+1);
 
               swap(x,i,j);
 //交换数组元素 x[i] 和 x[j]里的值
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
