package edu.wgu.d387_sample_code.TimeZones;

import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@CrossOrigin(origins = "http://localhost:4200")
public class TimeConvert {

    public static String getTime() {

        ZonedDateTime time = ZonedDateTime.now();

        //Strict IDs
        ZonedDateTime ET = time.withZoneSameInstant(ZoneId.of("America/New_York"));
        ZonedDateTime MT = time.withZoneSameInstant(ZoneId.of("America/Denver"));
        ZonedDateTime UTC = time.withZoneSameInstant(ZoneId.of("UTC"));

        String timePattern = "yyyy-MM-dd hh:mm a";
        DateTimeFormatter timePatternFormatter = DateTimeFormatter.ofPattern(timePattern);

        String displayTimes = ET.format(timePatternFormatter) + " ET / " + MT.format(timePatternFormatter) + " MT / " + UTC.format(timePatternFormatter) + " UTC";

        return displayTimes;
    }
}
