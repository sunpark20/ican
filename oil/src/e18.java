import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Created by soy on 2016-03-16.
 */
public class e18 {
    static int NMM=300;
    static int[][] num=new int[NMM][NMM];
    static boolean[][] check=new boolean[NMM][NMM];
    static int MAX=14;
    static int d=0;
    static int c=0;
    static int finish=0;
    static int sum=0;
    static int maxSum=0;

    static int count=0;
    public static void main(String[] args) {
        try{
            FileReader fr=new FileReader("e18_2.txt");
            BufferedReader br=new BufferedReader(fr);
            String s=null;

            int i=0;
            int dt=0;
            while ((s = br.readLine()) != null){
                System.out.println(s);
                Scanner sc=new Scanner(s);
                int j=0;
                while(sc.hasNextInt() == true){
                    // 파일에 int형 숫자가 존재하는지 확인
                    dt = sc.nextInt(); // 존재하면 읽어오기
                    num[i][j++]=dt;
                }
                i++;
            }
            MAX=i-1;
        }catch(Exception e){
            e.printStackTrace();
        }


       /*int k=0,j=0;
        while(true){
            if(num[k][j]==0)
                break;
            j=0;
            while (true){
                if(num[k][j]==0)
                    break;
                System.out.print(num[k][j]+" ");
                j++;
            }
            k++;
            System.out.println("");
        }*/
        System.out.println(num[0][0]);
        check[0][0]=true;
        sum+=num[0][0];
        long cccc=0;
        while(true){
            System.out.println(cccc++);
            //종료조건
            if(c==0 && d==0)
                finish++;
            if(finish==3) {
                System.out.println("finish");
                break;
            }

            downS();
        }
        System.out.println(maxSum);
    }
    static private void downS(){
        if(d==MAX)
            up();
        if(!check[d+1][c]) {
            d++;
//            System.out.println("<<<<"+num[d][c]);
            sum+=num[d][c];
            check[d][c] = true;
        }
        else if(!check[d+1][c+1]) {
            d++; c++;
//            System.out.println(">>>>"+num[d][c]);
            sum+=num[d][c];
            check[d][c] = true;
        }else{
            up();
        }


    }

    static private void up(){
        if(d==MAX){ //last
            if(maxSum<sum)
                maxSum=sum;
//            System.out.println("last need compare maxSum"+num[d][c] +" "+ sum);
        }
        sum-=num[d][c];

        boolean ifCon=false;
        if(d-1>=0){
            if(check[d-1][c+1]) {
                if(c+1<=d-1){
                    d--;
                    c++;
                    ifCon=true;
                }
            }
            if(!ifCon){
                if(check[d-1][c]){
                    d--;
                    ifCon=true;
                }
            }
            if(!ifCon) {
                if(check[d-1][c-1]){
                    if(c+1>=0) {
                        d--;
                        c--;
                    }
                }
            }
        }
        for(int i=0;i<MAX;i++){
            check[d+2][i]=false;
        }
//        System.out.println("up   " + num[d][c]);

    }
}
