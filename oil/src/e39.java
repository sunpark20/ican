//trouble to translate english
public class e39 {
    public static void main(String[] args) {
        int result=0;
        int p=0;
        int count=0;
        int sides=120;
        int until=sides+1;
//        int k=1001;

        for(int k=120;k<1000;k++){
            //a를 반까지만 보면 된다(그 이상은 중복 ex)max=10일때 a=1,b=4,c=5 // a=1,b=5,c=4)
            if(isEven(k))
                until=k/2;
            else
                until=k/2+1;
            //a를 1~max까지 변화시킨다.
            for(int i=1;i<until;i++){
                double a=i;
                for(int j=i;j<until;j++){ //a보다 작은 b는 이미 전에 다 계산함.
                    double b=j;
                    double c=k-a-b; ///c는 자동으로 결정 된다.
                    if(isTri(a,b,c)) {
                        count++;
                    }
                }
            }
            if(result<count) {
                result = count;
                p=k;
            }
            System.out.println(count+", "+k);
            count=0;
        } //end for k

        System.out.println(result+" "+p);
    }
    static boolean isTri(double a, double b,double c){

//        System.out.println(a+" "+b+" "+c);

        a=Math.pow(a, 2);
        b=Math.pow(b, 2);
        c=Math.pow(c, 2);

        if(c==(a+b)) {
//            System.out.println(" "+a+" "+b+" "+c);
            return true;
        }
        else
            return false;
    }
    static boolean isEven(int num){
        if(num%2==0)
            return true;
        else
            return false;
    }
}

