import java.util.*;
class CalendarDemo
{
public static void main(String args[])
{
Calendar cal=Calendar.getInstance();
System.out.println("year is:"+cal.get(Calendar.YEAR)+"\tmonth is:"+(1+cal.get(Calendar.MONTH))+"\tday is:"+cal.get(Calendar.DAY_OF_MONTH)+"\tno.of days is:"+cal.get(Calendar.DAY_OF_YEAR));
}
}