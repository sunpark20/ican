//Big integer fast rather than I thought.
//need change ambicious variable. It is very confuse.

/**
 * Created by sun on 2016-04-29.
 */
public class e30 {
    public static void main(String args[]) {
        int len;
        String num;
        final int MAX=999999;
        int finalSum=0;
        for(int i=0;i<MAX;i++){
            num=String.valueOf(i);
            len=num.length();
            int localSum=0;
            for(int j=0;j<len;j++){
                int Int_converted=Integer.valueOf(num.charAt(j)-48);
                localSum+=pow_fifth(Int_converted);
            }
            if(localSum==i) {
                System.out.println("**" + i + " " + localSum);
                finalSum+=localSum;
            }

        }
        System.out.println(finalSum);
    }
    static int pow_fifth(int i){
        return i*i*i*i*i;
    }
}
