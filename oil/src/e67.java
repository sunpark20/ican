//실패 out of heap memory
//메모리나 한번 정리해서 써보고 내일 다시 도전한다.
//대각선으로 뻗는 규칙을 찾으면 될 것 같다.
//배열이 1000 * 1000개인 100만개정도 되니까 자바가 뻗는다는 사실도 기억합시다.

import java.math.BigDecimal;
public class e67 {
    public static void main(String[] args){
        //square 초기화
        int sideLen=7;
        final int interval=1000;

//        for(int z=0;z<5;z++){
            sideLen+=interval;
            System.out.println("side"+sideLen);
            int[][] square=new int[sideLen][sideLen];
            int startNum=(int)(sideLen/2);
            int index=1;
            square[startNum][startNum]=index++;

            //<prime 체커 생성하기
            e67 method=new e67();
            //크기를 x*x+1 하는 이유는 프라임 체크는 정수로 하는데,
            // 프라임체크의 시작은 0, 사각형의 시작은 1이기 때문에 맞춰준다.
            boolean[] primeArray=method.makePrimeArray(sideLen);
            //>prime 체커 생성하기

            //settring the Wall, xy
            e67_wall Wall=new e67_wall(startNum);
            e67_xy XY=new e67_xy(startNum, startNum);

            while (true){
                if( sideLen*sideLen < index)
                    break;
                Wall.expand();
                //right
                while (XY.getY() < Wall.getRightW()){
                    XY.r();
                    square[XY.getX()][XY.getY()]=index++;
                }
                //up
                while (Wall.getTopW() < XY.getX()){
                    XY.u();
                    square[XY.getX()][XY.getY()]=index++;
                }
                //left
                while (Wall.getLeftW() < XY.getY()){
                    XY.l();
                    square[XY.getX()][XY.getY()]=index++;
                }
                //down
                while (XY.getX() < Wall.getBottomW()){
                    XY.d();
                    square[XY.getX()][XY.getY()]=index++;
                }
                //right
                while (XY.getY() < Wall.getRightW()){
                    XY.r();
                    square[XY.getX()][XY.getY()]=index++;
                }
            } // > whlie

//        method.showSquareArray(square);

            int totalCount=sideLen+sideLen-1;
            int primeCount=0;
            //search
            //l to r, also up to down diagonal
            for(int i=0;i<square.length;i++) {
                if(primeArray[square[i][i]]){
                    primeCount++;
                }
            }
            //reverse as upper condition
            int tempJ=0;
            for(int i=square.length-1;0 <= i;i--) {
                if(primeArray[square[i][tempJ++]])
                    primeCount++;
            }
            System.out.println(primeCount + " / "+ totalCount);
            System.out.println(method.percent(primeCount, totalCount));
        }
//    }

    private int percent(int primeCount, int totalCount){
        BigDecimal pc=new BigDecimal(String.valueOf(primeCount));
        BigDecimal tc=new BigDecimal(String.valueOf(totalCount));
        pc=pc.divide(tc, 2, BigDecimal.ROUND_HALF_UP);
        pc=pc.multiply(new BigDecimal("100"));
        pc=pc.setScale(0);
        return Integer.valueOf(pc.toString());
    }

    private void showSquareArray(int[][] square){
        for(int i=0;i<square.length;i++) {
            for(int j=0;j<square[0].length;j++){
                System.out.printf("%3d", square[i][j]);
            }
            System.out.println("");
        }
    }

    private void showPrimeArray(boolean[] primeArray){
        for(int i=2;i<primeArray.length;i++) {
            if(primeArray[i])
                System.out.println(i);
        }
    }

    private boolean[] makePrimeArray(int sideLen){
        int size=sideLen*sideLen+1;
        // <<< init primeArray
        boolean[] primeArray=new boolean[size];
        for(int i=2;i<primeArray.length;i++){
            primeArray[i]=true;
        }
        // >>> end init primeArray
        // sqrt까지만 해보면 된다.
        double dp=size;
        int sqrtPrimeMax=(int)Math.sqrt(dp);

        for(int i=2;i<sqrtPrimeMax+1;i++){
            if(primeArray[i]){
                primeArray = checkPrime(i, size, primeArray);
            }
        }
        return primeArray;
    }
    private boolean[] checkPrime(int prime, int size, boolean[] primeArray){
        primeArray[prime]=true;

        int muledPrime=prime+prime;

        while (muledPrime<size){
            primeArray[muledPrime]=false;
            muledPrime+=prime;
        }
        return primeArray;
    }
}
