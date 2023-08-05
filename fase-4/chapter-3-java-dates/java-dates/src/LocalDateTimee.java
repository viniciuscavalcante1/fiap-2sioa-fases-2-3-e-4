import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimee {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        System.out.println(now.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
        System.out.println(now.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss.SSS")));
    }
}
