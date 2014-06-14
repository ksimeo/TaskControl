package helpers;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Avega on 14.06.14.
 */
public class CommonHelper
{
    public static String correctDateFormat(Date date)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(date);
    }
}
