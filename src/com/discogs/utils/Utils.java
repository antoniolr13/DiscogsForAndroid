package com.discogs.utils;

import java.io.InputStream;
import java.io.OutputStream;

import android.content.Context;
import android.net.ConnectivityManager;

public class Utils 
{
    public static void copyStream(InputStream is, OutputStream os)
    {
        final int buffer_size=1024;
        try
        {
            byte[] bytes=new byte[buffer_size];
            for(;;)
            {
              int count=is.read(bytes, 0, buffer_size);
              if(count==-1)
                  break;
              os.write(bytes, 0, count);
            }
        }
        catch(Exception ex){}
    }
    
    public static String splitToComponentTimes(long seconds)
    {
       int hours = (int) seconds / 3600;
       int remainder = (int) seconds - hours * 3600;
       int mins = remainder / 60;
       remainder = remainder - mins * 60;
       int secs = remainder;
       
       StringBuffer stringBuffer = new StringBuffer();
       
       if (hours > 0)
       {
    	   if (hours < 10)
    	   {
    		   stringBuffer.append("0");
    	   }
    	   
    	   stringBuffer.append(String.valueOf(hours));
    	   stringBuffer.append(":");
       }
       
       if (mins > 0)
       {
    	   if (mins < 10)
    	   {
    		   stringBuffer.append("0");
    	   }
    	   
    	   stringBuffer.append(String.valueOf(mins));
    	   stringBuffer.append(":");
       }
       else
       {
    	   stringBuffer.append("00");
    	   stringBuffer.append(":");
       }
       
       if (secs > 0)
       {
    	   if (secs < 10)
    	   {
    		   stringBuffer.append("0");
    	   }
    	   
    	   stringBuffer.append(String.valueOf(secs));
       }
       else
       {
    	   stringBuffer.append("00"); 
       }
       
       return stringBuffer.toString();
    }
    
    public static boolean checkInternetConnection(Context context) 
    {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        
        if (connectivityManager.getActiveNetworkInfo() != null
                && connectivityManager.getActiveNetworkInfo().isAvailable()
                && connectivityManager.getActiveNetworkInfo().isConnected()) 
        {
            return true;
        } 
        else 
        {
            return false;
        }
    }
}