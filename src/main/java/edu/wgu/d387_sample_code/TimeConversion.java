package edu.wgu.d387_sample_code;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


@Component
public class TimeConversion{


    public List<String> getTimeConversion() {

        ArrayList<String> timeZones = new ArrayList<>();

        ZoneId easternTime=ZoneId.of("America/New_York");
        ZoneId mountainTime=ZoneId.of("America/Denver");
        ZoneId zoneUtc=ZoneId.of("UTC");
        ZoneId zoneId=ZoneId.systemDefault();

        LocalDateTime localDateTime=LocalDateTime.now();
//        System.out.println("local time "+localDateTime.toString());
        ZonedDateTime zonedDateTime=localDateTime.atZone(zoneId);
        ZonedDateTime zonedDateTimeEastern=zonedDateTime.withZoneSameInstant(easternTime);
        LocalDateTime localDateTimeEastern=zonedDateTimeEastern.toLocalDateTime();
//        System.out.println("Eastern time "+localDateTimeEastern.toString());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
        String text = localDateTimeEastern.format(formatter);
        timeZones.add(text);
        ZonedDateTime zonedDateTimeMountain=zonedDateTime.withZoneSameInstant(mountainTime);
        LocalDateTime localDateTimeMountain=zonedDateTimeMountain.toLocalDateTime();

        text = localDateTimeMountain.format(formatter);
        timeZones.add(text);
//        System.out.println("Mountain time "+localDateTimeMountain.toString());
        ZonedDateTime zonedDateTimeUtc=zonedDateTime.withZoneSameInstant(zoneUtc);
        LocalDateTime localDateTimeUtc=zonedDateTimeUtc.toLocalDateTime();
//        System.out.println("Utc time "+localDateTimeUtc.toString());
        text = localDateTimeUtc.format(formatter);
        timeZones.add(text);
        return timeZones;

    }

    public void run(){
        List<String> timeConversion = getTimeConversion();
        System.out.println(timeConversion);
    }

}
