package common;

/**
 * Created by soy on 2016-08-31.
 */
public class CalTime{
    private static long start;
    private static long end;

    public static void mStart(){
        CalTime.start=System.currentTimeMillis();
        System.out.println("---시간측정시작---");
    }
    public static void mTime(){
        CalTime.end=System.currentTimeMillis();
        long time= CalTime.end- CalTime.start;
        System.out.println("---총 소요시간: "+time+"ms");
    }
}
