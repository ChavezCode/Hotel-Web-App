
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;


@Component
public class TimeZone{


    public void getTimeZone() {
        ZoneId easternTime=ZoneId.of("America/New_York");
        ZoneId mountainTime=ZoneId.of("America/Denver");
        ZoneId zoneUtc=ZoneId.of("UTC");
        ZoneId zoneId=ZoneId.systemDefault();

        LocalDateTime localDateTime=LocalDateTime.now();
        System.out.println("local time "+localDateTime.toString());
        ZonedDateTime zonedDateTime=localDateTime.atZone(zoneId);
        ZonedDateTime zonedDateTimeEastern=zonedDateTime.withZoneSameInstant(easternTime);
        LocalDateTime localDateTimeEastern=zonedDateTimeEastern.toLocalDateTime();
        System.out.println("Eastern time "+localDateTimeEastern.toString());
        ZonedDateTime zonedDateTimeMountain=zonedDateTime.withZoneSameInstant(mountainTime);
        LocalDateTime localDateTimeMountain=zonedDateTimeMountain.toLocalDateTime();
        System.out.println("Pacific time "+localDateTimeMountain.toString());
        ZonedDateTime zonedDateTimeUtc=zonedDateTime.withZoneSameInstant(zoneUtc);
        LocalDateTime localDateTimeUtc=zonedDateTimeUtc.toLocalDateTime();
        System.out.println("Utc time "+localDateTimeUtc.toString());

    }


    public void run() {
       getTimeZone();
    }
}
