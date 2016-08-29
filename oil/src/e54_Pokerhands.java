//there is hell.. I NEED PRETTY FUNTION.. CLASS..

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class e54_Pokerhands {
    static int count=0;
    static int ftN3=0;
    static int ftN2_1=0;
    static int ftN2_2=0;
    static int ftN1=0;

    public static void main(String[] args) throws Exception{ //not correct throw
        FileReader fr=new FileReader("p054_poker.txt");
        BufferedReader br=new BufferedReader(fr);
        String s=null;
//        int cc=500;
        while ((s = br.readLine()) != null){
//        while (--cc!=0){
//            s = br.readLine();

            // < init each readLine
            Card p1=new Card();
            Card p2=new Card();
            ftN3=0;
            ftN2_1=0;
            ftN2_2=0;
            // >

            System.out.println(s);

            String tc;
            for(int i=0;i<5;i++){
                tc=s.split(" ")[i];
                p1.num.add(StoI(tc));
                p1.suit.add((int)tc.charAt(1));
            }
            for(int i=5;i<10;i++){
                tc=s.split(" ")[i];
                p2.num.add(StoI(s.split(" ")[i]));
                p2.suit.add((int)tc.charAt(1));
            }

            Collections.sort(p1.num);
            Collections.sort(p2.num);

            System.out.println(p1.num);
            System.out.println(p1.suit);
            System.out.println(p2.num);
            System.out.println(p2.suit);


            Capsul(p1, p2);
            System.out.println("");
//            System.exit(1);
        }
        System.out.println(count);
    }
    static int StoI(String s){
        Character c=s.charAt(0);
        if(c=='T')
            return 10;
        else if(c=='J')
            return 11;
        else if(c=='Q')
            return 12;
        else if(c=='K')
            return 13;
        else if(c=='A')
            return 14;
        return c-48;
    }
    static boolean Capsul(Card p1, Card p2){
        //로티풀
        if(RoyalFlush(p1)) {
            System.out.println("p1 로티풀");
            count++;
            return true;
        }else if(RoyalFlush(p2)){
            System.out.println("p2 로티풀");
            return false;
        }else if(StraightFlush(p1) && StraightFlush(p2)){ //스티풀
            if(sameClass(p1, p2, "스티풀")){
                count++;
                return true;
            }else{
                return false;
            }
        }else if(StraightFlush(p1)){
            System.out.println("p1 스티풀");
            count++;
            return true;
        }else if(StraightFlush(p2)) {
            System.out.println("p2 스티풀");
            return false;
        }else if(FourCard(p1) && FourCard(p2)){ //포카
            if(sameClass(p1,p2,"포카")){
                count++;
                return true;
            }else{
                return false;
            }
        }else if(FourCard(p1)){
            System.out.println("p1 포카");
            count++;
            return true;
        }else if(FourCard(p2)) {
            System.out.println("p2 포카");
            return false;
        }else if(oneThreeFull(p1)==4 && oneThreeFull(p2)==4){ //풀하우스

            initAV();
            oneThreeFull(p1);
            int tNum1=ftN3;
            int tNum1_1=ftN2_1;

            initAV();
            oneThreeFull(p2);
            int tNum2=ftN3;
            int tNum2_1=ftN2_1;

            if(tNum1 == tNum2){
                if(tNum2_1 < tNum1_1){
                    System.out.println("쌍 풀하우스, P1 승");
                    count++;
                    return true;
                }else{
                    System.out.println("쌍 풀하우스, P2 승");
                    return false;
                }

            }else if(tNum2 < tNum1) {
                System.out.println("쌍 풀하우스, P1 승");
                count++;
                return true;
            }else if(tNum1 < tNum2){
                System.out.println("쌍 풀하우스, P2 승");
                return false;
            }
        }else if(oneThreeFull(p1)==4){
            System.out.println("p1 풀하우스");
            count++;
            return true;
        }else if(oneThreeFull(p2)==4) {
            System.out.println("p2 풀하우스");
            return false;
        }else if(isFlush(p1) && isFlush(p2)){ //플러쉬
            if(sameClass(p1,p2,"플러시")){
                count++;
                return true;
            }else{
                return false;
            }
        }else if(isFlush(p1)){
            System.out.println("p1 플러쉬");
            count++;
            return true;
        }else if(isFlush(p2)) {
            System.out.println("p2 플러쉬");
            return false;
        }else if(isStraight(p1) && isStraight(p2)){ //스트레이트
            if(sameClass(p1,p2,"스트페이트")){
                count++;
                return true;
            }else{
                return false;
            }
        }else if(isStraight(p1)){
            System.out.println("p1 스트레이트");
            count++;
            return true;
        }else if(isStraight(p2)) {
            System.out.println("p2 스트레이트");
            return false;
        }else if(oneThreeFull(p1)==3 && oneThreeFull(p2)==3){ //Three
            initAV();
            oneThreeFull(p1);
            int tNum1=ftN3;

            initAV();
            oneThreeFull(p2);
            int tNum2=ftN3;


            Card ca1=new Card();
            Card ca2=new Card();
            if(tNum1 == tNum2){
                for(int i=0;i<5;i++){
                    if(tNum1!= p1.num.get(i)){
                        ca1.num.add(p1.num.get(i));
                    }
                    if(tNum2!= p2.num.get(i)){
                        ca2.num.add(p2.num.get(i));
                    }
                }
                if(HighCard(ca1, ca2)){
                    System.out.println("쌍트리플, P1 승");
                    count++;
                    return true;
                }else{
                    System.out.println("쌍트리플, P2 승");
                    return false;
                }
            }else if(tNum2 < tNum1) {
                System.out.println("트리플, P1 승");
                count++;
                return true;
            }else if(tNum1 < tNum2){
                System.out.println("트리플, P2 승");
                return false;
            }
        }else if(oneThreeFull(p1)==3){
            System.out.println("p1 트리플");
            count++;
            return true;
        }else if(oneThreeFull(p2)==3) {
            System.out.println("p2 트리플");
            return false;
        }else if(oneThreeFull(p1)==2 && oneThreeFull(p2)==2){ //투페어
            initAV();
            oneThreeFull(p1);
            int tNum1_1=ftN2_1;
            int tNum1_2=ftN2_2;
            int tNum1_3=ftN1;


            initAV();
            oneThreeFull(p2);
            int tNum2_1=ftN2_1;
            int tNum2_2=ftN2_2;
            int tNum2_3=ftN1;


            Card ca1=new Card();
            Card ca2=new Card();

            ca1.num.add(tNum1_1);
            ca1.num.add(tNum1_2);
            ca1.num.add(tNum1_3);

            ca2.num.add(tNum2_1);
            ca2.num.add(tNum2_2);
            ca2.num.add(tNum2_3);

            if(tNum1_2 == tNum2_2){
                if(tNum1_1 == tNum2_1){
                    if(tNum1_3 > tNum2_3){
                        System.out.println("쌍투, p1 투페어");
                        count++;
                        return true;
                    }else{
                        System.out.println("쌍투, p2 투페어");
                        return false;
                    }
                }else if(tNum1_1 > tNum2_1){
                    System.out.println("쌍투, p1 투페어");
                    count++;
                    return true;
                }else{
                    System.out.println("쌍투, p2 투페어");
                    return false;
                }
            }else if(tNum1_2 > tNum2_2){
                System.out.println("쌍투, p1 투페어");
                count++;
                return true;
            }else if(tNum2_2 > tNum1_2){
                System.out.println("쌍투, p2 투페어");
                return false;
            }


        }else if(oneThreeFull(p1)==2){
            System.out.println("p1 투페어");
            count++;
            return true;
        }else if(oneThreeFull(p2)==2) {
            System.out.println("p2 투페어");
            return false;
        }else if(oneThreeFull(p1)==1 && oneThreeFull(p2)==1){ //원페어

            initAV();
            oneThreeFull(p1);
            int tNum1_1=ftN2_1;
            int tNum1_2=ftN2_2;
            int tNum1_3=ftN1;


            initAV();
            oneThreeFull(p2);
            int tNum2_1=ftN2_1;
            int tNum2_2=ftN2_2;
            int tNum2_3=ftN1;

//            System.out.printf(" %d %d %d %d %d %d\n", tNum1_1,tNum1_2,tNum1_3,tNum2_1,tNum2_2,tNum2_3);

            Card ca1=new Card();
            Card ca2=new Card();

            for(int i=0;i<5;i++){
                if(tNum1_1!=p1.num.get(i))
                    ca1.num.add(p1.num.get(i));
                if(tNum2_1!=p2.num.get(i))
                    ca2.num.add(p2.num.get(i));
            }
            System.out.println(ca1.num+" "+ca2.num);
            if(tNum1_1 == tNum2_1){
                if(HighCard(ca1, ca2)){
                    System.out.println("쌍워누ㅡ p1 원페어");
                    count++;
                    return true;
                }else{
                    System.out.println("쌍워누ㅡ p2 원페어");
                    return false;
                }
            }else if(tNum1_1 > tNum2_1){
                System.out.println("쌍워누ㅡ p1 원페어");
                count++;
                return true;
            }else{
                System.out.println("쌍워누ㅡ p2 원페어");
                return false;
            }


        }else if(oneThreeFull(p1)==1){
            System.out.println("p1 원페어");
            count++;
            return true;
        }else if(oneThreeFull(p2)==1) {
            System.out.println("p2 원페어");
            return false;
        }else if(HighCard(p1,p2)){
            System.out.println("p1 탑");
            count++;
            return true;
        }else{
            System.out.println("p2 탑");
        }


        return false;
    }

    //풀하우스도 함.
    static Integer oneThreeFull(Card p){
        int[] c=new int[5];
        int threeNum=0;
        int TwoNum=0;
        for(int i=0;i<5;i++){
            c[i]=0;
        }
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                if(p.num.get(i)==p.num.get(j)){
                    c[i]++;
                }
            }
        }
        //추가 정보 전달
        for(int i=0;i<5;i++){
            if(c[i]==3)
                ftN3=p.num.get(i);
            if(c[i]==2) {
                if(ftN2_1==0){
                    ftN2_1 = p.num.get(i);
                }else{
                    if(ftN2_1!=p.num.get(i)){
                        if(ftN2_2==0){
                            ftN2_2=p.num.get(i);
                        }
                    }
                }
            }
            if(c[i]==1)
                ftN1=p.num.get(i);
        }
//        System.out.println(ftN3+" "+ftN2_1+" "+ftN2_2);
//        for(int i=0;i<5;i++){
//            System.out.println(c[i]);
//        }
        //투페어가 있다면 2가 4개 있을 것이다.
        int twoCount=0;
        for(int i=0;i<5;i++){
            if(c[i]==2)
                twoCount++;
        }



        HashSet<Integer> hs=new HashSet();
        for(int i=0;i<5;i++){
            hs.add(c[i]);
        }
        if(hs.contains(3) && hs.contains(2))
            return 4; //풀
        else if(hs.contains(3))
            return 3; //트리플
        else if(twoCount==4)
            return 2; //투페어
        else if(hs.contains(2))
            return 1; //페어


        return 0;
    }

    static boolean sameClass(Card p1, Card p2, String s){
        if(HighCard(p1, p2)){
            System.out.println("쌍"+s+", p1 높은 수");
            count++;
            return true;
        }else{
            System.out.println("쌍"+s+", p2 높은 수");
            return false;
        }
    }

    static boolean FourCard(Card p){
        int n1=p.num.get(0);
        int n2=p.num.get(4);
        int c1=0;
        int c2=0;
        for(int i=1;i<5;i++){
            if(n1==p.num.get(i))
                c1++;
        }
        for(int i=0;i<4;i++){
            if(n2==p.num.get(i))
                c2++;
        }
        if(c1==3 || c2==3)
            return true;
        else
            return false;
    }

    static boolean isFlush(Card p){
        int suit = p.suit.get(0);
        for (int i = 1; i < 5; i++) {
            if (suit != p.suit.get(i)) {
                return false;
            }
        }
        return true;
    }

    static boolean isStraight(Card p){
        for (int i = 0; i < 4; i++) {
            int f=p.num.get(i);
            int b=p.num.get(i+1);
            if(b-f!=1)
                return false;
        }
        return true;
    }

    static boolean RoyalFlush(Card p) {
        if(!isFlush(p))
            return false;
        if( !(p.num.contains(10) && p.num.contains(11)
                && p.num.contains(12) && p.num.contains(13)
                    && p.num.contains(14)) ) {
            return false;
        }
        return true;
    }

    static boolean StraightFlush(Card p) {
        if(!isFlush(p))
            return false;
        if(!isStraight(p))
            return false;
        return true;
    }

    static boolean HighCard(Card p1, Card p2){
        int index=p1.num.size()-1;
        while (index!=-1){
            if(p1.num.get(index) > p2.num.get(index)) {
                return true;
            }else if(p2.num.get(index) > p1.num.get(index))
                return false;
            index--;
        }
        return false;
    }

    static private void initAV(){
        ftN1=0;
        ftN2_1=0;
        ftN2_2=0;
        ftN3=0;

    }
}
class Card{
    ArrayList<Integer> num=new ArrayList<>();
    ArrayList<Integer> suit=new ArrayList<>();
}