import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

public class DateTimeExample {
  public static void main(String[] args)  {
	
    //----------------------------
    //Current Date time
    //----------------------------
    
    // These classes are used when timezone are not required to be explicitly specified
    LocalDate ld = LocalDate.now(); //a date in ISO format (yyyy-MM-dd)
    System.out.println(ld); //2019-10-10

    LocalTime lt = LocalTime.now(); // time without date part
    System.out.println(lt); //08:57:12.212 (Actuall current local  time was 2:28 PM)

    LocalDateTime ldt = LocalDateTime.now(); //date + time
    System.out.println(ldt); //2019-10-10T08:57:12.212

    //----------------------------
    //Convert to Date
    //----------------------------
    
    LocalDate dt21 = LocalDate.of(2019,12,25);
    System.out.println(dt21); // 2019-12-25

    LocalDate dt22 = LocalDate.of(2017,Month.MAY,6);
    System.out.println(dt22); // 2017-05-06

    LocalDate dt3 = LocalDate.parse("2019-09-25"); // Note : 09 instead of 9 
	System.out.println(dt3); // 2019-09-25

    LocalDate maxDate = LocalDate.MAX;
    LocalDate minDate = LocalDate.MIN;
    System.out.println(minDate + " / " + maxDate); // -999999999-01-01 / +999999999-12-31
    
    //----------------------------
	//Convert to Time
    //----------------------------
    
    LocalTime t11 = LocalTime.of(23,11,22,111);
    System.out.println(t11); // 23:11:22.000000111

    LocalTime t13 = LocalTime.of(3,8,9,222);
    System.out.println(t13); // 03:08:09.000000222

    LocalTime tweleveThirty = LocalTime.of(12, 30);
    System.out.println(tweleveThirty); // 12:30
    
    LocalTime t12 = LocalTime.parse("22:23:24.555");
    System.out.println(t12); // 22:23:24.555

    LocalTime sixThirty = LocalTime.parse("06:30");
    System.out.println(sixThirty); // 06:30
    
    LocalTime maxTime = LocalTime.MAX;
    LocalTime minTime = LocalTime.MIN;
    System.out.println(minTime + " / " + maxTime); // 00:00 / 23:59:59.999999999
    
    //----------------------------
    // DATETIME
    //----------------------------
    
    LocalDateTime ldt21 = LocalDateTime.of(2019, Month.OCTOBER, 10, 15, 42);
    System.out.println(ldt21); // 2019-10-10T15:42
    
    LocalDateTime ldt22 = LocalDateTime.parse("2019-11-30T16:44:00");
    System.out.println(ldt22); // 2019-11-30T16:44
    
    LocalDateTime ldt23 = LocalDateTime.of(LocalDate.now(), LocalTime.now());
    System.out.println("ldt23 :" + ldt23); // 2019-10-10T10:41:03.888
    
    //----------------------------
    // ZonedDateTime API
    //----------------------------
    
    //Get all ZoneIds
    Set<String> allZoneIds = ZoneId.getAvailableZoneIds();
    //commented as it was filling the console
    //System.out.println(allZoneIds.stream().collect(Collectors.joining(", ", "[","]")));
    
    
    ZoneId zoneId = ZoneId.of("Asia/Kolkata");
    ZonedDateTime zonedDateTime = ZonedDateTime.now(zoneId);
    System.out.println("\n Current time in IST : " + zonedDateTime); //Current time in IST : 2019-10-10T16:01:04.486+05:30[Asia/Kolkata]
    
    
    ZonedDateTime zdt2= ZonedDateTime.parse("2015-05-03T10:15:30+05:30[Asia/Kolkata]");
    System.out.println("\n ZonedDateTime " + zdt2); // 2015-05-03T10:15:30+05:30[Asia/Kolkata]
    
    //----------------------------
    //Comparison
    //----------------------------
    
    //isBefore, isAfter, isEqual
    
    
    //----------------------------
    // Date to String
    //----------------------------
    LocalDateTime ldt_now = LocalDateTime.now();
    
    String dt = ldt_now.format(DateTimeFormatter.ISO_DATE);
    System.out.println("\n ISO_DATE : " + dt); // 2019-10-10
    
    String dt2 = ldt_now.format(DateTimeFormatter.ISO_DATE_TIME);
    System.out.println("\n ISO_DATE_TIME : " + dt2); // 2019-10-10T11:09:19.652
    
    String dt5 = ldt_now.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    System.out.println("\n ISO_LOCAL_DATE_TIME : " + dt5); // 2019-10-10T11:09:19.652
    
    String dt6 = ldt_now.format(DateTimeFormatter.BASIC_ISO_DATE);
    System.out.println("\n BASIC_ISO_DATE : " + dt6); // 20191010
    
    String customFormat =  ldt_now.format(DateTimeFormatter.ofPattern("d-MM-y hh:mm:ss"));
    System.out.println("\n customFormat : " + customFormat); // 10-10-2019 11:10:07
    
    //----------------------------
    // java.util.Date to java.time
    //----------------------------
    Date dt7 = new Date();
    System.out.println("\n dt7 : " + dt7); // Thu Oct 10 11:10:22 UTC 2019
    LocalDate current = dt7.toInstant()
                       .atZone(ZoneId.systemDefault())
                       .toLocalDate();
    System.out.println("\n current : " + current); // 2019-10-10
    
    //TODO : Convert to Java SQL Date
    
    //TODO : Convert to Java Util Date
  }
}
