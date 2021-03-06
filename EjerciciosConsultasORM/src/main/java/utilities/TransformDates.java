package utilities;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TransformDates {

    /*Date to String*/
    public String dateToString(Date date){
        try {
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
            return dateFormat.format(date);

        }catch (NullPointerException npe){
            System.out.println("Date cannot be null");
            npe.printStackTrace();
        }
        return null;
    }

    /*String to Date java.util*/
    public Date StringToDate(String date) {
        try{
            SimpleDateFormat stringFormat = new SimpleDateFormat("dd/MM/yy");
            return stringFormat.parse(date);
        }catch (ParseException pe){
            System.out.println("Error introducing date");
            pe.printStackTrace();
        }
        return null;
    }

    /*Java Date to SQLDate*/
    public java.sql.Date javaDateToSQLDate(Date date){
        return new java.sql.Date(date.getTime());
    }

    /*increment years*/
    public Date incrementYears(Date date, int years){
        Calendar calendar =  Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, years);
        return calendar.getTime();
    }

}
