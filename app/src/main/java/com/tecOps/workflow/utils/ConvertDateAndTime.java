package com.tecOps.workflow.utils;

import android.net.ParseException;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ConvertDateAndTime {
private String date;
    public String convertDate(String date)
    {
        String[] parts = date.split(" ");
        this.date = parts[0];


        return this.date ;
    }

    public String convertTime(String time) {

        Date dateObj=null;
        try {
            final SimpleDateFormat sdf = new SimpleDateFormat("H:mm");
             dateObj = sdf.parse(time);

        } catch (final ParseException e) {
            e.printStackTrace();
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }


        return new SimpleDateFormat("K:mm a").format(dateObj);
    }
}
