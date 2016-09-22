// 0~10은 몇개일까요?  11개   10~99 까지는 몇개일까요? 99-10 +1 개 = 86개  이런게 헷갈리네.. 이런 실수로 시간 ++30분

package e1669;

import java.io.File;
import java.util.*;

/**
 * Created by soy on 2016-09-20.
 */
public class Main {
    static ArrayList<Sossi> soList=new ArrayList<Sossi>();
    static int time=0;

    public static void main(String[] args){

        /*//<hardcode input
        int max=5;
        soList.add(new Sossi(4,9));
        soList.add(new Sossi(5, 2));
        soList.add(new Sossi(2, 1));
        soList.add(new Sossi(3, 5));
        soList.add(new Sossi(1, 4));
        //>hardcode input*/

//        input();

        try{
            inputFile();
        }catch (Exception e){
            e.printStackTrace();
        }

        Collections.sort(soList, new Acomp());


        while(true){
            if(soList.size()==1) {
                time++;
                System.out.println(time);
                break;
            }
            ArrayList<Sossi> mark=new ArrayList<>();
            mark.clear();
            int a=0;
            mark.add(soList.get(0));

            for(int i=1;i<soList.size();i++){
                if(makeSossigi(a,i)) {
                    System.out.println("make!!   " + i);
                    mark.add(soList.get(i));
                    a=i;
                }
            }

            remove(mark);
            time++;
            System.out.println("size: " + soList.size() + " time: " + time);
        }//>while

    }

    static private void remove(ArrayList<Sossi> copyedAl){
        for (Sossi deleteCandidate : copyedAl) {
            soList.remove(deleteCandidate);
        }
    }

    static private boolean makeSossigi(int a,int b){
        Sossi so=soList.get(a);
        int a1=so.getA();
        int b1=so.getB();
        Sossi so2=soList.get(b);
        int a2=so2.getA();
        int b2=so2.getB();
        if( a2 < a1 || b2 < b1)
            return false;
        else
            return true;
    }

    static private void printAl(ArrayList<Sossi> soList){
        for(int i=0;i<soList.size();i++){
            System.out.println(soList.get(i).a+" "+soList.get(i).b);
        }
    }

    private static void input(){
        //정올에서 실행
        Scanner sc = new Scanner(System.in);
        int max = sc.nextInt();
        int a, b, c;
        for (int i = 0; i < max; i++) {
            a = sc.nextInt();
            b = sc.nextInt();
            soList.add(new Sossi(a, b));
        }
        //정올에서 끝
    }

    private static void inputFile() throws Exception{
        //정올에서 실행
        Scanner sc = new Scanner(new File("1669.txt"));
        int max = sc.nextInt();
        int a, b, c;
        for (int i = 0; i < max; i++) {
            a = sc.nextInt();
            b = sc.nextInt();
            soList.add(new Sossi(a, b));
        }
        //정올에서 끝
    }
}
class Acomp implements Comparator<Sossi> {
    @Override
    public int compare(Sossi arg0, Sossi arg1) {
        // TODO Auto-generated method stub
        return arg0.a-arg1.a;
    }
}
class Sossi {
    int a;
    int b;

    public Sossi(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
}
