//모든 사각형을 채울 필요 없다.
//diagonal 방향은 간단한 규칙대로 증가한다.
//일단은 primeArray를 반토막 배열로 만드는 것부터 시작하자.

import java.math.BigDecimal;
import java.util.ArrayList;

public class e67_2 {
    public static void main(String[] args){
        int sideLen;
        int interval;
        int index;
        int MAX=3;
        ArrayList<Integer> diagonalNum=new ArrayList<>();
        e67_2 method=new e67_2();

//        for(int z=0;z<100000;z++){
            //init 변수.
            diagonalNum.clear();
            sideLen=1;
            interval=2;
            index=1;
            diagonalNum.add(index); //먼저 1을 추가.

            for(int i=0;i<MAX;i++){
                for(int ix=0;ix<4;ix++) {
                    index+=interval;
                    diagonalNum.add(index);
                }
                interval+=2;
                sideLen+=2;
            }
            System.out.println("side길이:" + sideLen);
//            method.showNum(diagonalNum);

            //<prime 체커 생성하기
            //크기를 x*x+1 하는 이유는 프라임 체크는 정수로 하는데,
            // 프라임체크의 시작은 0, 사각형의 시작은 1이기 때문에 맞춰준다.
            boolean[] primeArray=method.makePrimeArray(sideLen);
            System.out.println("프라임 array 생성완료");
            //>prime 체커 생성하기
            System.out.println("프라임 array 크기:"+primeArray.length+ "  diagonal크기: "+diagonalNum.size());
            method.showPrimeArray(primeArray);

            //2.ArrayList를 훑어서 소수가 전체의 몇퍼센트인지 보자.
            int primeCount=0;
            for(int i=0;i<diagonalNum.size();i++){
                if(diagonalNum.get(i)%2!=0){
                    if(primeArray[diagonalNum.get(i)/2])
                        primeCount++;
                }
            }
            System.out.println(primeCount +" "+ diagonalNum.size());
            int percent=method.percent(primeCount, diagonalNum.size());
            System.out.println(percent+"%");
//            if(percent < 10)
//                break;
            MAX+=1;
//        } //>for z

    }

    private void showNum(ArrayList<Integer> dn){
        for(int i=0;i<dn.size();i++)
            System.out.print(dn.get(i) + " ");
        System.out.println("");
    }
    private int percent(int primeCount, int totalCount){
        BigDecimal pc=new BigDecimal(String.valueOf(primeCount));
        BigDecimal tc=new BigDecimal(String.valueOf(totalCount));
        pc=pc.divide(tc, 2, BigDecimal.ROUND_HALF_UP);
        pc=pc.multiply(new BigDecimal("100"));
        pc=pc.setScale(0);
        return Integer.valueOf(pc.toString());
    }

    private void showPrimeArray(boolean[] primeArray){
        for(int i=0;i<primeArray.length;i++) {
            if(primeArray[i])
                System.out.println(i*2+1);
        }
    }

    //숫자 2는 따로 체크해야한다.
    private boolean[] makePrimeArray(int sideLen){
        int size=sideLen*sideLen;
        int arraySize=sideLen*sideLen/2+1;

        // <<< init primeArray
        boolean[] primeArray=new boolean[arraySize];
        for(int i=1;i<primeArray.length;i++){
            primeArray[i]=true;
        }
        // >>> end init primeArray
        // sqrt까지만 해보면 된다.
        double dp=size;
        int sqrtPrimeMax=(int)Math.sqrt(dp);

        for(int i=0;i<sqrtPrimeMax+1;i++){
            if(primeArray[i]){
                primeArray = checkPrime(i, size, primeArray);
            }
        }
        return primeArray;
    }
    private boolean[] checkPrime(int prime, int size, boolean[] primeArray){
        primeArray[prime]=true;
        int muledPrime=prime+prime;
        while (true){
            if(muledPrime < size)
                break;
            if(muledPrime%2 != 0){
                System.out.println("거지");
                primeArray[muledPrime/2]=false;
            }
            muledPrime+=prime;
        }
        return primeArray;
    }
}
