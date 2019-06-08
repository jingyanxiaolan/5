//5-24一般解空间搜索问题


import java.util.Scanner;


public class YiBanJieKongJianSouSuo {


    private static int n,k,m;
 //定义了变量n、k、m,n代表顶点数，k代表边数，m代表颜色数
    private static int[] x;
 //定义了整形一维数组x
   private static int sum;
 //定义了整型变量sum
    private static boolean[][] edge;

 //定义了二维数组edge
    public static void main(String[] args){
 
       Scanner input = new Scanner(System.in);

 //从控制台输入字符
        while (true){
 
           sum = 0;

 
           n = input.nextInt();
 //输入x的值
           k = input.nextInt();
 //输入k的值
           m = input.nextInt();//输入m的值
 
           edge = new boolean[n+1][n+1];
  //开辟了行为n+1，列为n+1的i布尔型二维数组，edge等于数组首地
          x = new int[n+1];

 //开辟大小为n+1的int*型一维数组，x等于数组首地址
           for(int i=1; i<=k; i++){
 
               int x = input.nextInt();
 //输入x的值
               int y = input.nextInt();
  //输入y的值
              edge[x][y] = true;
 
               edge[y][x] = true;
            }

 
           backtrack(1);

 
           output();
        }
    }

 
   private static void backtrack(int t){
 
       if(t > n) record();
 
       else
            
for(int i=f(n,t); i<=g(n,t); i++){
 
               x[t] = h(i);
  
              change(t);
 
               if(constraint(t) && bound(t)) backtrack(t+1);
   
             restore(t);
            }
    }

 
   private static void record(){
 
       sum++;
    }

   
 private static boolean constraint(int t){
   
     for(int j=1; j<=n; j++)
  
          if(edge[t][j] && x[j]==x[t]) return false;

  
      return true;
    }

 
   private static boolean bound(int t){
 
       return true;
    }

  
  private static void change(int t){
    }


    private static void restore(int t){
 
       x[t] = 0;
    }


    private static int f(int n, int t){

        return 1;
    }

  
  private static int g(int n, int t){
 
       return m;
    }

  
  private static int h(int i){
  
      return i;
    }

   
 private static void output(){
  
      System.out.println(sum);
    }
}
