//5-24һ���ռ���������


import java.util.Scanner;


public class YiBanJieKongJianSouSuo {


    private static int n,k,m;
 //�����˱���n��k��m,n����������k���������m������ɫ��
    private static int[] x;
 //����������һά����x
   private static int sum;
 //���������ͱ���sum
    private static boolean[][] edge;

 //�����˶�ά����edge
    public static void main(String[] args){
 
       Scanner input = new Scanner(System.in);

 //�ӿ���̨�����ַ�
        while (true){
 
           sum = 0;

 
           n = input.nextInt();
 //����x��ֵ
           k = input.nextInt();
 //����k��ֵ
           m = input.nextInt();//����m��ֵ
 
           edge = new boolean[n+1][n+1];
  //��������Ϊn+1����Ϊn+1��i�����Ͷ�ά���飬edge���������׵�
          x = new int[n+1];

 //���ٴ�СΪn+1��int*��һά���飬x���������׵�ַ
           for(int i=1; i<=k; i++){
 
               int x = input.nextInt();
 //����x��ֵ
               int y = input.nextInt();
  //����y��ֵ
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
