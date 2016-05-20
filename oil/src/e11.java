import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by soy on 2016-03-01.
 */
public class e11 {

    public static void main(String[] args) {
        final int SIZE=20;
        int[][] num=new int[SIZE][SIZE];
       //ready-read file
        try {

            String fileName = "grid.txt";
            String line = "";
            BufferedReader br = new BufferedReader(new FileReader(fileName));

            int j=0;
            while((line = br.readLine()) != null) {
                for(int i=0;i<SIZE;i++){
                    num[j][i]=Integer.parseInt(line.split(" ")[i]);
                    //System.out.print(line.split(" ")[i]);
                }
                j++;
            }

            br.close();
        } catch (IOException e){
            e.printStackTrace();
        }

        //print num
        for(int i=0;i<SIZE;i++) {
            for (int j = 0; j < SIZE; j++)
                System.out.print(num[i][j] + " ");
            System.out.println("");
        }
        int sum=0;
        final int REST=3;

        // <<< 가로 거꾸로 갑니다.
        for(int i=SIZE-1;i>0;i--){
            for(int j=SIZE-1;j>REST;j--){
                int value=num[i][j]*num[i][j-1]*num[i][j-2]*num[i][j-3];
//                System.out.println(num[i][j]+" "+num[i][j+1]+" "+num[i][j+2]+" "+num[i][j+3]);
                if(value>sum)
                    sum=value;
            }
        }


        // <<< 세로 거꾸로 갑니다.
        for(int j=SIZE-1;j>0;j--){
            for(int i=SIZE-1;i>REST;i--){
                int value=num[i][j]*num[i-1][j]*num[i-2][j]*num[i-3][j];
//                System.out.println(num[i][j]+" "+num[i][j+1]+" "+num[i][j+2]+" "+num[i][j+3]);
                if(value>sum)
                    sum=value;
            }
        }



        // <<< 대각선 거꾸로 갑니다.
        for(int i=SIZE-1;i>REST;i--){
            for(int j=SIZE-REST-1;j>=0;j--){
                System.out.println(i +" "+ j);
                int value=num[i][j]*num[i-1][j+1]*num[i-2][j+2]*num[i-3][j+3];

                if(value>sum)
                    sum=value;
            }
        }

        System.out.println(sum);

    }

}
