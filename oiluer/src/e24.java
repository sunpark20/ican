import java.util.Arrays;
/**
 * 아무것도 안보고 품: O
 * 속도: 하
 * 만족도: 하
 * 설명:
 * 다이나믹 배열로 채워가면서 풀긴 풀었는데.. @.@ 소스도 속도도 개판이다.
 * 구글링 20분쯤 해본 결과, 각 언어의 순열 함수를 이용해서 푸는듯하다.
 * 나중에 혹시 궁금하면 해보도록
 */
public class e24 {
    static int templl;
    public static void main(String args[]){
        String[] num=new String[10000000];
        int NumIndex=3, LetterNum=3, preNum=2;
        int start=1, end=2;

        //init num
        num[0]="0";
        num[1]="01";
        num[2]="10";
        e24 e24=new e24();

        int whileC=8;

        while(whileC-- > 0){
            System.out.printf("문자열 갯수는 %d개  이전 기록 = num[%d~%d], each= %d\n", LetterNum, start, end, preNum);
            for(int i=0;i<LetterNum;i++){
                int CopyCount=start;
                for(int j=0;j<preNum;j++){
                    String result=String.valueOf(i);
                    if(i==0){
                        result+=e24.plusOne(num[CopyCount++]);
                        //1씩 더하기
                    }else if(0<i && i<LetterNum-1){
                        templl=LetterNum;
                        //앞만 +1 해서 넣어줌.
                        result+=e24.plusMid(i, num[CopyCount++]);
                    }else{  //letterNum-1
                        result+=num[CopyCount++];
                    }
                    num[NumIndex++]=result;
                } // j END
            } //i END
            // 0.start, end 바꿔주기.
            LetterNum++;
            start=end+1;
            end=NumIndex-1;
            preNum=end-start+1;

        } // while END

        int i = 0;
        while(num[i] != null) {
            i++;
        }
        Arrays.sort(num, start, end-start);

        int count=1;
        while(true){
            if(count==1000000) {
                System.out.println(num[start]);
            }
            start++;
            count++;
        }
//        e24.print(num);
    }

    private void print(String[] num) {
        for(int i=0;i<num.length;i++){
            if(num[i]==null)
                break;
            System.out.printf("%3d 번째 %s\n", i, num[i]);
        }

    }

    private String plusOne(String num){
        String newNum="";
        for(int i=0;i<num.length();i++){
            int tempInt=Integer.valueOf(num.charAt(i))-47;
            newNum+=String.valueOf(tempInt);
        }
        return newNum;
    }

    private String plusMid(int i, String num){
        String newNum="";
        String target=String.valueOf(i);
        String nn=String.valueOf(templl-1);
        newNum=num.replaceAll(target, nn);
        return newNum;
    }
}
