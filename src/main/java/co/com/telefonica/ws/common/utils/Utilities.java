package co.com.telefonica.ws.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Slf4j
@Component
public class Utilities {

    public static String timestampStr() {
        var zoneIdCo = ZoneId.of("America/Bogota");
        var now = ZonedDateTime.now(zoneIdCo);
        var dtf = DateTimeFormatter.ISO_OFFSET_DATE_TIME;
        return Shield.blindStr(now.truncatedTo(ChronoUnit.MILLIS).format(dtf));
    }

    public static String timestamp() {
        return Shield.blindStr(String.valueOf(System.currentTimeMillis()));
    }

    public static String dateToStr(Date date) {
        String specificFormat = "yyyy-MM-dd";
        SimpleDateFormat sdfSalida = new SimpleDateFormat(specificFormat);
        return sdfSalida.format(date);
    }

    private Utilities() { }

}
