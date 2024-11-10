package students;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    private static final SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    static String formatDate(Date date) {
        return formatter.format(date);
    }
}
