/**
 * Created by soy on 2016-02-22.
 */
public class e7 {
    public static void main(String args[]){
        int MAX_NUM=10001;
        MAX_NUM+=1;

        long num;
        int count=0;

        num=2;

        while (true){

            //각 수의 루트까지 반복해봐서 소수인지 판단한다.
            double d = Math.sqrt(num);
            int maxI=(int)d;

            //초반의 경우에 루트가너무 작은경우에 예외
            if(maxI<=num)
                maxI=(int)num;

            //나누어떨어진 수가 2개면 소수라고 판단한다.
            int check=0;

            for(int i=2;i<maxI;i++){
                if(num%i==0)
                    check++;
            }
            if(check==0) {
                count++;
                System.out.println("이건 소스라요" + count + "번째 " + num);
            }
            if(count==MAX_NUM){
                System.out.println("\n이건 소스라요"+ count +"번째 "+num);
                break;
            }

            num++;
        }

    }
}
