import java.util.ArrayList;
import java.util.List;

//for문 9번 겹친것 답은 나오네.
//결국 배열이 count 만큼 생긴것입니다.
//얘를 재귀로 바꿔보시오.

public class e24_2 {
    static int count=0;
    static final int NUM=10;
    static List<String>[] str=new ArrayList[NUM];
    public static void main(String args[]) {
        InitStr();
        int N=0;

        for(String s0: str[0]){
            str[1]=new ArrayList<>(str[0]);
            str[1].remove(s0);

            for(String s1: str[1]){
                str[2]=new ArrayList<>(str[1]);
                str[2].remove(s1);

                for(String s2: str[2]){
                    str[3]=new ArrayList<>(str[2]);
                    str[3].remove(s2);

                    for(String s3: str[3]){
                        str[4]=new ArrayList<>(str[3]);
                        str[4].remove(s3);

                        for(String s4: str[4]){
                            str[5]=new ArrayList<>(str[4]);
                            str[5].remove(s4);

                            for(String s5: str[5]){
                                str[6]=new ArrayList<>(str[5]);
                                str[6].remove(s5);

                                for(String s6: str[6]){
                                    str[7]=new ArrayList<>(str[6]);
                                    str[7].remove(s6);

                                    for(String s7: str[7]){
                                        str[8]=new ArrayList<>(str[7]);
                                        str[8].remove(s7);

                                        for(String s8: str[8]){
                                            str[9]=new ArrayList<>(str[8]);
                                            str[9].remove(s8);

                                            for(String s9: str[9]){
                                                    count++;
                                                if(count==1000000)
                                                        System.out.println(s0 + " " + s1+ " " + s2+" "+s3+" "+s4+" "+s5 + " " + s6+ " " + s7+" "+s8+" "+s9);

                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

            }
        }
        System.out.println(count);
    }




    static private void InitStr(){
        for(int i=0;i<NUM;i++){
            str[i]=new ArrayList<String>();
            for(int j=0;j<NUM;j++){
                str[i].add(String.valueOf(j));
            }
        }
    }
    static private void printStr(List<String> str){
       for(String s: str)
                System.out.print(s+" ");
        System.out.println("");
    }
}
