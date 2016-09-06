package common;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by soy on 2016-08-31.
 */
public class test {
    public static void main(String[] args){
        String weekDay;
        SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy.MM.dd EEE HH:mm");
        Calendar calendar = Calendar.getInstance();
        weekDay = dayFormat.format(calendar.getTime());
        System.out.println(weekDay);
    }
}
