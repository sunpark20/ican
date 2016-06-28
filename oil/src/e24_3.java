import java.util.ArrayList;
import java.util.List;

// 지역변수를 잘 생각하면 한방인데.. 개헷갈리네 -> 31번으로 가서 더 연습하자(coinSum)

public class e24_3 {
    static final int NUM = 10;

    static int count=0;
    public static void main(String args[]) {
        List<String> fStr = new ArrayList<String>();
        for (int i = 0; i < NUM; i++) {
            fStr.add(String.valueOf(i));
        }
        r("",fStr,0);

    }
    static void r(String each, List<String> str, int c){
        if(count==1000000)
            return;
        if(c==10) {
            count++;
            System.out.println(each+" "+count);
            return;
        }
        for(String s:str) {
            ArrayList<String> newStr=new ArrayList<String>(str);
            newStr.remove(s);
            r(each+s, newStr, c+1);
        }
    }
}

