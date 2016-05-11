/**
 * Created by soy on 2016-02-22.
 */
public class e4 {
    public static void main(String args[]){
        int a=999,b=999;
        int maxnum=0;
        while (a>100){
            for(int i=100;i<b;i++){
                int c=a*i;
                String s=String.valueOf(c);
                if(s.length()%2==0){
//                    System.out.println(a+" "+i+":"+c );
                    String temp,s1,s2;
                    temp=String.valueOf(c);
                    s1=temp.substring(0, 3);
                    s2=temp.substring(3, 6);
                    StringBuffer sb=new StringBuffer(s2);
                    s2=sb.reverse().toString();
//                    System.out.println(s1+" "+s2 );
                    if(s1.compareTo(s2)==0){
                        temp=s1+s2;
                        int valueInt=Integer.parseInt(temp);
                        if(valueInt > maxnum)
                            maxnum=valueInt;
                    }

                }
            }
            a--;
        }
        System.out.println(maxnum);
    }
}
