public class e38 {
    static boolean[] nineDigitCheck=new boolean[9];

    public static void main(String[] args){

        final int MAX=9328; //max=9328
        String result="";
        for(int k=1;k<MAX;k++){
            int target=k;
            initNineDigitCheck();
            result="";
            int n=1;
            boolean stop=false;
            while (true){
                int num=target*n;
                String strNum=String.valueOf(num);
                for(int i=0;i<strNum.length();i++){
                    int eachNum=(int) strNum.charAt(i)-48;
                    if(stop(eachNum)) {
                        stop=true;
                        break;
                    }
                    else {
                        nineDigitCheck[eachNum-1] = true;
                        result+=String.valueOf(eachNum);
                    }
                }
                if(stop)
                    break;
                if(discover()) {
                    System.out.println(target);
                    System.out.println(" "+result);

                    break;
                }
                n++;
            }
        } //end of for(k)
    }
    static boolean discover(){
        int count=0;

        for(int i=0;i<nineDigitCheck.length;i++) {
            if(nineDigitCheck[i])
                count++;
        }
        if(count==9)
            return true;
        else
            return false;
    }
    static boolean stop(int eachNum){
        if(eachNum==0)
            return true;
        eachNum-=1;
        if(nineDigitCheck[eachNum])
            return true;
        else
            return false;
    }
    static void initNineDigitCheck(){
        for(int i=0;i<nineDigitCheck.length;i++)
            nineDigitCheck[i]=false;
    }
}

