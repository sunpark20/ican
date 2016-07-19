import java.io.BufferedReader;
import java.io.FileReader;

public class e42 {
    public static void main(String args[]) throws Exception{ //not reliable throws

        //step1. words파일 읽어서 숫자로 변환하기
        FileReader fr=new FileReader("p042_words.txt");
        BufferedReader br=new BufferedReader(fr);
        String input;

        //읽을 파일의 문자들이 한줄이 끝이라 한 번만 읽음.
        input=br.readLine();
        input=input.replaceAll("\"","");
        String[] words=input.split(",");

        int[] convertedWords=new int[words.length];
        for(int i=0;i<convertedWords.length;i++)
            convertedWords[i]=0;

        int count=0;
        for(String word: words){
            for(int i=0;i<word.length();i++){
                char a=word.charAt(i);
                convertedWords[count]+=a-64;
            }
            System.out.println(word+" "+convertedWords[count]);
            count++;
        }
        System.out.println("number of words: "+count);

        //step2.find triangle number under 300
        boolean[] triNumber=new boolean[301];
        double n=1.0;

        while (true){
            double d=(1.0/2.0)*n*(n+1.0);
            int tn=(int)d;
            System.out.println(d);
            if(300<tn)
                break;
            triNumber[tn]=true;
            n++;
        }

        int finalResult=0;
        for(int cNum:convertedWords){
            if(triNumber[cNum])
                finalResult++;
        }
        System.out.println(finalResult);
    }
}

