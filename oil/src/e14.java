import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;

/**
 * Created by soy on 2016-03-16.
 */
public class e14 {
    public static void main(String[] args) {
        final int SIZE = 100;
        BigInteger sum=new BigInteger("0");
        String[] number = new String[SIZE];
        //ready-read file
        try {
            String fileName = "number.txt";
            String line = "";
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            int i=0;

            while ((line = br.readLine()) != null) {
                BigInteger row=new BigInteger(line);
                sum=sum.add(row);
                number[i]=line;
                System.out.println(i+" "+line);
                i++;
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(sum);
        String strSum=sum.toString();
        System.out.println("?????? ?? 10????????");

        System.out.println(strSum.substring(0, 10));
    }
}
