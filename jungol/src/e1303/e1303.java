package e1303;// 정답봄..실패... 이제 안봐야지..분하다
// 백정에 하나더 있으니까, 이거 까먹을 떄쯤 그거 풀어봐. 그건 input많음.

import java.util.*;

public class e1303 {
    static int result=0;
    static  ArrayList<Integer> resultAl=new ArrayList<Integer>();
//    static int eCount=0;
    static boolean time=true;
    static int eCount=0;

    public static void main(String[] args) {
//        if(time)
//            CalTime.mStart();
        ArrayList<room> al = new ArrayList<>();

        //정올에서 실행
        Scanner cin = new Scanner(System.in);
        int max2 = cin.nextInt();
        int a, b, c;
        for (int i = 0; i < max2; i++) {
            a = cin.nextInt();
            b = cin.nextInt();
            c = cin.nextInt();
            al.add(new room(a, b, c));
        }
        //정올에서 끝

        /*//순차입력세트1
        int num = 1;
        int aa=1;
        for(int i=0;i<5;i++) {
            al.add(new room(num++, aa++, aa++));
        }
        //순차입력세트1 끝*/


/*
       //입력받기
        int num=1;
//        for(int i=0;i<10;i++){
            al.add(new room(num++, 79, 82));
            al.add(new room(num++, 80, 84));
            al.add(new room(num++, 46, 50));
            al.add(new room(num++, 15, 91));
            al.add(new room(num++, 32, 35));

            al.add(new room(num++, 27, 65));
            al.add(new room(num++, 51, 100));
            al.add(new room(num++, 72, 81));
            al.add(new room(num++, 4, 53));
            al.add(new room(num++, 44, 46));

        al.add(new room(num++, 57, 73));
        al.add(new room(num++, 30, 62));
        al.add(new room(num++, 6, 49));
        al.add(new room(num++, 41, 43));
        al.add(new room(num++, 97, 100));

        al.add(new room(num++, 87, 98));
        al.add(new room(num++, 2, 46));
        al.add(new room(num++, 30, 92));
        al.add(new room(num++, 34, 63));
        al.add(new room(num++, 23, 40));
//        }
        //입력받기 끝*/

        Collections.sort(al, new StimeComp());

//        show(al);
        int max=0;
        ArrayList<Integer> rl=new ArrayList<>();
        for(int i=0;i<al.size();i++){
            ArrayList<Integer> trace=new ArrayList<>();
            trace.add(al.get(i).num);
            int f=al.get(i).f;
            for(int j=0;j<al.size();j++){
                if(i==j)
                    continue;
//                System.out.println(f+" "+al.get(j).s);
                if(f <= al.get(j).s ){
                    trace.add(al.get(j).num);
                    f=al.get(j).f;
                }
            }
            if(max<trace.size()) {
                max=trace.size();
                rl=(ArrayList<Integer>)trace;
            }
        }
        System.out.println(max);
        for(int i=0;i<max;i++){
            System.out.print(rl.get(i)+" ");
        }


        /*Main main=new Main();
        main.re(al, new ArrayList<Integer>());

        System.out.println(result);
        for(int i=0;i<resultAl.size();i++){
            System.out.print(resultAl.get(i) + " ");
        }*/


//        System.out.println("eCount는?"+eCount);
//        if(time)
//            CalTime.mTime();

    }

    private void re(ArrayList<room> al, ArrayList<Integer> trace){
        eCount++;
        //종료조건.
        if(al.isEmpty()){
            if(result < trace.size()) {
                result = trace.size();
                resultAl=(ArrayList<Integer>)trace.clone();
            }
            return;
        }

        for(int i=0;i<al.size();i++){
            room thisRoom=al.get(i);
            int f=thisRoom.f;
            ArrayList<room> copyedAl=(ArrayList<room>)al.clone();
            remove(copyedAl, f);
            if(copyedAl.size()+trace.size()<=result)
                continue;
            //점프 안해도 되는 것이라면 진행한다.
            ArrayList<Integer> copyedTrace=(ArrayList<Integer>) trace.clone();
            copyedTrace.add(thisRoom.num);
            copyedAl.remove(thisRoom);
            re(copyedAl, copyedTrace);
        }
    }

    private void remove(ArrayList<room> copyedAl, int f){
        List<room> deleteCandidates = new ArrayList<>();
        // Pass 1 - collect delete candidates
        for (room room : copyedAl) {
            if (room.s < f) {
                deleteCandidates.add(room);
            }
        }
        // Pass 2 - delete
        for (room deleteCandidate : deleteCandidates) {
            copyedAl.remove(deleteCandidate);
        }
    }

    private static void show(ArrayList<room> al){
        System.out.println("프린트");
        for(int i=0;i<al.size();i++)
            System.out.printf("%d 방 시작:%d, 끝:%d\n",al.get(i).num, al.get(i).s, al.get(i).f);
        System.out.println("");
    }


}

class StimeComp implements Comparator<room> {
    @Override
    public int compare(room arg0, room arg1) {
        // TODO Auto-generated method stub
        return arg0.f-arg1.f;
    }

}

class room {
    public int num;
    public int s;
    public int f;
    public room(int num, int s, int f) {
        this.num=num;
        this.s = s;
        this.f = f;
    }
}
