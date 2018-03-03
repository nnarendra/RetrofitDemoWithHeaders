package com.naren.connectingwithserverviaretrofit.utils;

import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by narendra on 2/11/18.
 */

public class DateTimeUtility {
    static final String DATEFORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";

    public static int getCurrentDayOfWeek() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        return calendar.get(Calendar.DAY_OF_WEEK) - 1;
    }


    public static String getUTCString(Date date) {
        final SimpleDateFormat sdf = new SimpleDateFormat(DATEFORMAT);
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        final String utcTime = sdf.format(date);
        return utcTime;
    }
    public static String getUTCString(Date date,String formate) {
        final SimpleDateFormat sdf = new SimpleDateFormat(formate);
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        final String utcTime = sdf.format(date);
        return utcTime;
    }

    public static Date StringDateToDate(String StrDate) {
        if (StrDate == null) {
            return null;
        }
        Date dateToReturn = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATEFORMAT);
        try {
            dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            dateToReturn = (Date) dateFormat.parse(StrDate);
        } catch (ParseException e) {
            return nonUTCStringToDate(StrDate);
        }
        return dateToReturn;
    }

    public static Date nonUTCStringToDate(String StrDate) {
        if (StrDate == null) {
            return null;
        }
        Date dateToReturn = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss+SS:SS");
        try {
            dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            dateToReturn = (Date) dateFormat.parse(StrDate);
            Log.d("time", "time:" + dateToReturn.toString());
        } catch (ParseException e) {
            SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS+SS:SS");
            try {
                dateFormat2.setTimeZone(TimeZone.getTimeZone("UTC"));
                dateToReturn = (Date) dateFormat2.parse(StrDate);
                Log.d("time", "time:" + dateToReturn.toString());
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
            //e.printStackTrace();
        }
        return dateToReturn;
    }

    public static Date stringToDateSafe(String strDate) {
        if (strDate == null) {
            return null;
        }
        String[] formats = {
                "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'",
                "yyyy-MM-dd'T'HH:mm:ss+SS:SS",
                "yyyy-MM-dd'T'HH:mm:ss.SSS+SS:SS",
                "yyyy-MM-dd'T'HH:mm:ss'Z'",
                "yyyy-MM-dd HH:mm:ss",
                "yyyy-MM-dd HH:mm:ss.SSS",
                "yyyy-MM-dd'T'HH:mm:ss+XXX",
                "yyyy-MM-dd'T'HH:mm:ss+XXXXX",
                "yyyy-MM-dd"
        };
        Date dateToReturn = null;
        for (String format : formats) {
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat(format);
                dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                dateToReturn = dateFormat.parse(strDate);
                Log.i("DT", "Succeeded :: " + strDate);
                break;
            } catch (Exception e) {
                //Silent Failure
                Log.i("DT", "Failed :: " + strDate);
            }
        }
        return dateToReturn;
    }

    public static Date stringToLocalDateSafe(String strDate) {
        if (strDate == null) {
            return null;
        }
        String[] formats = {
                "yyyy-MM-dd",
                "MM-dd-yyyy",
                "dd-MM-yyyy",
                "MM/dd/yyyy",
                "dd/MM/yyyy"
        };
        Date dateToReturn = null;
        for (String format : formats) {
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat(format);
                dateToReturn = dateFormat.parse(strDate);
                Log.i("DT", "Succeeded :: " + strDate);
                break;
            } catch (Exception e) {
                //Silent Failure
                Log.i("DT", "Failed :: " + strDate);
            }
        }
        return dateToReturn;
    }

    public static Date addDays(Date date, int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days); //minus number would decrement the days
        return cal.getTime();
    }

    public static Date addHours(Date date, int hours) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR, hours); //minus number would decrement the days
        return cal.getTime();
    }

    public static Date addMilliSecond(Date date, int ms) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MILLISECOND, ms); //minus number would decrement the days
        return cal.getTime();
    }

    public static String getFormattedDate(Date date, String format) {
        return new SimpleDateFormat(format).format(date);
    }

    public static int getDayOfWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_WEEK) - 1;
    }


    public static long getDiffDays(String previousDate, String today) {
        try {
            if (previousDate != null && today != null) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd", Locale.getDefault());

                Date date1 = null, date2 = null;
                long dayCount = -1;

                date1 = dateFormat.parse(today);
                date2 = dateFormat.parse(previousDate);

                long diff = date1.getTime() - date2.getTime();
                dayCount = diff / (24 * 60 * 60 * 1000);
                return dayCount;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static long getDiffDays(Date from, Date to) {
        long diff = to.getTime() - from.getTime();
        return (diff / (24 * 60 * 60 * 1000));
    }

    public static String getDayName(Date date) {
        return new SimpleDateFormat("EEE").format(date);
    }

    public static String getTimeFromDate(Date date) {
        SimpleDateFormat localDateFormat = new SimpleDateFormat("HH:mm");
        return localDateFormat.format(date);
    }

}
