import java.time.*;
import java.util.List;
import java.time.format.DateTimeFormatter;

public class ZoneIds {
    public static long getDifferenceInHoursToSaoPaulo(Instant end) {
        LocalDateTime nowSP = LocalDateTime.now(ZoneId.of("America/Sao_Paulo"));
        Instant start = nowSP.toInstant(ZoneOffset.ofTotalSeconds(0));
        Duration duration = Duration.between(start, end);
        return duration.toHours();
    }

    public static void main(String[] args) {
        List<String> zoneIds = ZoneId.getAvailableZoneIds().stream().sorted().toList();

        for (String zone: zoneIds) {
            System.out.println(zone);
        }

        LocalDateTime now = LocalDateTime.now(ZoneId.of("America/Sao_Paulo"));
        LocalDateTime nowInTokyo = LocalDateTime.now(ZoneId.of("Asia/Tokyo"));
        System.out.println("São Paulo: " + now.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
        System.out.println("Tokyo: " + nowInTokyo.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
        System.out.println("Difference in hours: " + getDifferenceInHoursToSaoPaulo(nowInTokyo.toInstant(ZoneOffset.ofTotalSeconds(0))));

    }
}
