//5-23排列数问题



import java.util.PriorityQueue;

import java.util.Queue;

import java.util.Scanner;


public class YuanPaiLie {


    private static class Circle implements Comparable{

        float len;//当前圆排列的长度

        float[] x;//当前圆排列圆心横坐标
 
       float[] r;//当前圆排列

        int s;    //待排列圆的个数


        public int compareTo(Object o){

            Circle circle = (Circle) o;

            int result = Float.compare(len, circle.len);


            return result;
        }

        //计算当前所选圆的圆心横坐标

        private float center(int t){
 
           float temp = 0;
 
           for(int j=1; j<t; j++){

                float valuex = x[j]+(float)(2.0*Math.sqrt(r[t]*r[j]));
 
               if(valuex > temp) temp=valuex;
            }

 
           return temp;
        }

        //计算当前圆排列的长度

        private void compute(int ii){
  
          float low=0,high=0;
  
          for(int i=1; i<=ii; i++){
 
               if(x[i]-r[i] < low) low=x[i]-r[i];
                if(x[i]+r[i] > high) high=x[i]+r[i];
            }

 
           len = high-low;
        }
    }

 
   private static int MAX = 100000;
 
   private static int n;

    private static float[] p,B;

 
   public static void main(String[] args){
 
       Scanner input = new Scanner(System.in);


       while (true){
 
           n = input.nextInt();

 
           p = new float[n+1];
 
           B = new float[n+1];

  
          for(int i=1; i<=n; i++)
 
               B[i] = input.nextFloat();

  
          System.out.println(String.format("%.5f",circlePerm(B, n)));
 }
    }

 
   private static float circlePerm(float[] a, int n){
 
       Queue<Circle> H = new PriorityQueue<>();
  
      Circle E = new Circle();
  
      E.x = new float[n+1];
   
     E.r = new float[n+1];
   
     E.r=a; E.s=0; E.len=MAX;
 
       float minLen = MAX;
 
       do{
 
           if(E.s == n-1){

                E.x[n] = E.center(n);
  
              E.compute(n);
  
              if(E.len < minLen){
 
                   p=E.r; minLen=E.len;
 
               }
            }else {

                for(int i=E.s+1; i<=n; i++){
  
                  Circle N = new Circle();
 
                   N.x = new float[n+1];

                    N.r = new float[n+1];
 
                   N.s=E.s+1; N.len=E.len;

                    for(int j=1; j<=n; j++){N.x[j]=E.x[j]; N.r[j]=E.r[j];}
 
                   N.r[N.s]=E.r[i]; N.r[i]=E.r[N.s];

                    N.x[N.s]=N.center(N.s);
 
                   N.compute(N.s);
 
                   if(N.len < minLen) H.add(N);
                }
            }

            if(H.isEmpty()) return minLen;
 
           else E = H.poll();
 
       }while (E.len < minLen);


        return minLen;
    }

}
