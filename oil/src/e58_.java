//분모+분자는 다음 분모가 되고, 다음 분모 + 전 분자는 다음 분자가 된다.

import common.CalTime;

import java.math.BigInteger;
import java.util.ArrayList;

public class e58_ {

    public static void main(String[] args){
        CalTime.mStart();
        final int MAX=1000;
        BigInteger n=new BigInteger("3");
        BigInteger dn=new BigInteger("2");
        int count=0;
        int bCount=1; // 3/2부터 시작해서 초기값은 1로 한다.
        ArrayList<Integer> al=new ArrayList<>();
        for(int i=0;i<MAX;i++) {
            bCount++;
            BigInteger tempN=dn;
            dn = n.add(dn);
            n = dn.add(tempN);

            // 모든 expansion 표시
//            System.out.println(n.toString()+" / "+ dn.toString());

            if (n.toString().length() > dn.toString().length()) {
//                System.out.println(i+2+"번째 빙고"+ bCount);
                count++;
                al.add(bCount);
                bCount=0;
            }
//            BigDecimal bn=new BigDecimal(n.toString());
//            BigDecimal bdn=new BigDecimal(dn.toString());
//            BigDecimal bd=bn.divide(bdn, 100, BigDecimal.ROUND_HALF_UP);
//            System.out.println(i + 2 + " " + n.toString() + " / " + dn.toString() + " " + bd.toString());
        }

        System.out.println("카운트는"+count);

//        getThreeIndex(al);

        //<3, 5, 8 이 몇갠지 본다
        int three=0;
        int five=0;
        int eight=0;
        for(int i=0;i<al.size();i++) {
//            System.out.println(i + 1 + " " + al.get(i));
            if(al.get(i)==3) {
                three++;
                int index=three*3+five*5+eight*8;
                System.out.println(index+":"+three+" "+five+" "+ eight);
            }
            else if(al.get(i)==5)
                five++;
            else if(al.get(i)==8)
                eight++;
        }
        // > 3, 5, 8 이 몇갠지 본다
        CalTime.mTime();
    }
    private static void getThreeIndex(ArrayList<Integer> al){
        int index=0;
        for(int i=0;i<al.size();i++){
            index+=al.get(i);
            if(al.get(i)==3){
                System.out.println("인덱스 "+ index);
            }
        }
    }
}

