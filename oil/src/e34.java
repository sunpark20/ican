/**
 * Created by soy on 2016-02-22.
 */
public class e34 {
    public static void main(String args[]){
        final int MAX=99999999;
        int result=0;
        int iNum=3;

        while(iNum<MAX) {
            String str = String.valueOf(iNum);
            int sum = 0;
            for (int i = 0; i < str.length(); i++) {
                char each = str.charAt(i);
                sum += f(each);
            }
            if (iNum == sum) {
                System.out.println("빙고"+ iNum);
                result += iNum;
            }
            iNum++;
        }
        System.out.println(result);
    }

    static int f(char c){
        int num=c-48;
        int sum=1;
        while(num > 1){
            sum*=num;
            num--;
        }
        return sum;
    }
}
