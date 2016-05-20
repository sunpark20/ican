/**
 * Created by soy on 2016-02-22.
 */
public class e6 {
    public static void main(String args[]){
        final int  MAX=100;
        int naturalNum=1;
        int squares=0,one=0;

        while(naturalNum<=MAX){
            squares+=naturalNum;
            System.out.println(naturalNum);
            naturalNum++;
        }
        squares*=squares;
        System.out.println(squares);

        //이번엔 하나씩 제곱한거 계싼합니다.
        naturalNum=1;
        while(naturalNum<=MAX){
            one+=naturalNum*naturalNum;
            naturalNum++;
        }
        System.out.println(squares-one);

    }
}
