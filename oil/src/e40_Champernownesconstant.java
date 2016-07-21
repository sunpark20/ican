//just solve brute-force way
//gogo find other soultion.

public class e40_Champernownesconstant {
    static String str="";
    static  int sum=1;
    public static void main(String[] args) {
        int num=1;

        final int MAXSTR=1000000;
        while(true){
            str+=num;
            num++;
            if(str.length()>MAXSTR)
                break;
        }
        System.out.println(str);
        mul(1);
        mul(10);
        mul(100);
        mul(1000);
        mul(10000);
        mul(100000);
        mul(1000000);

        System.out.println(sum);
    }
    static void mul(int i){
        i-=1;
        sum*=(str.charAt(i)-48);
        System.out.println(" "+(str.charAt(i)-48));

    }
}

