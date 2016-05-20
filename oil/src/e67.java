import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Created by soy on 2016-03-16.
 */
public class e67 {
    static int NMM=300;
    static int[][] num=new int[NMM][NMM];
    static int DEPTH;

    public static void main(String[] args) {
        try{
            FileReader fr=new FileReader("e64.txt");
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
            DEPTH=i-1;
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(DEPTH);
        while(true){

            for(int i=0;i<DEPTH;i++) {
                int tempMax = num[DEPTH][i];
                if(num[DEPTH][i]<num[DEPTH][i+1])
                    tempMax=num[DEPTH][i+1];
                num[DEPTH-1][i]+=tempMax;
            }
            DEPTH--;
            if(DEPTH==0)
                break;
        }
        print();
        System.out.println("정답은: "+num[0][0]);

    }
    static private void print(){
        int k=0,j=0;
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
        }
    }

}
