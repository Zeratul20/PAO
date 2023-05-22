import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Audit {
    private static final String CSV_SEPARATOR = ",";
    private static final DateTimeFormatter TIMESTAMP_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private String filePath;

    public Audit(String filePath) {
        this.filePath = filePath;
    }

    public void writeActionToCsv(String actionName) {
        LocalDateTime now = LocalDateTime.now();
        String timestamp = now.format(TIMESTAMP_FORMAT);
        String record = actionName + CSV_SEPARATOR + timestamp;
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath, true))) {
            writer.println(record);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}