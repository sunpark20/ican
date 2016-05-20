import java.util.ArrayList;

/**
 * Created by soy on 2016-03-16.
 */
public class e17 {
    public static void main(String[] args) {
        ArrayList<String> num=new ArrayList<>();
        num.add("one");
        num.add("two");
        num.add("three");
        num.add("four");
        num.add("five");
        num.add("six");
        num.add("seven");
        num.add("eight");
        num.add("nine");
        num.add("ten");

        num.add("eleven");
        num.add("twelve");
        num.add("thirteen");
        num.add("fourteen");
        num.add("fifteen");
        num.add("sixteen");
        num.add("seventeen");
        num.add("eighteen");
        num.add("nineteen");

        ArrayList<String> tenNum=new ArrayList<>();
        tenNum.add("twenty");
        tenNum.add("thirty");
        tenNum.add("forty");
        tenNum.add("fifty");
        tenNum.add("sixty");
        tenNum.add("seventy");
        tenNum.add("eighty");
        tenNum.add("ninety");
        for(int i=0;i<tenNum.size();i++){
            num.add(tenNum.get(i));
            for(int j=0;j<9;j++){
                num.add(tenNum.get(i)+num.get(j));
            }
        }
        ArrayList<String> hundredNum=new ArrayList<>();
        for(int i=0;i<9;i++){
            hundredNum.add(num.get(i)+"hundred");
        }
        for(int i=0;i<9;i++){
            num.add(hundredNum.get(i));
            for(int j=0;j<99;j++){
                num.add(hundredNum.get(i)+"and"+num.get(j));
            }
        }
        num.add("onethousand");
        int size=0;
        for(int i=0;i<num.size();i++) {
            size+=num.get(i).length();
            System.out.println(size);
        }

    }
}
