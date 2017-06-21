package nwnu.info.hsc.utils;

import java.util.ArrayList;

public class ConvertUtil {
	public static ArrayList<String> stringToArray1(String str)               //将字符串转化为数组
	{
	   char[] array = str.toCharArray();
	   ArrayList<String> list = new ArrayList<String>();
        for(int i=0; i<array.length; i++ )
          list.add(Integer.toString(array[i]));        
		return list;
	}
	public  static StringBuffer arrayToString1(ArrayList<String> array)       //将数组转化为字符串
	{ 
		StringBuffer str = new StringBuffer();
		for(int i=0; i<array.size(); i++)
		{   String st = array.get(i);
		    for(int j=0; j < 5-st.length(); j++)
		    {
		       str.append("0");
		    }
			str.append(array.get(i));
		}
		return str;
	}
	 public static ArrayList<String> stringToArray2(String str)             //将字符串转化为容器数组里的字符串
		{
	        String newString = new String();
	    	if(str.length() % 5 == 1)
	    	  newString = "0" + str;
	        if(str.length() % 5 == 2)
	    	  newString = "0"+"0"+"0"+str;
	    	if(str.length() % 5 == 3)
	    	  newString = "0"+"0"+str;
	    	if(str.length() % 5 ==0)
	    	   newString = str;
	       ArrayList<String> list = new ArrayList<String>();
		   for(int startLocation=0,endLocation= 5; endLocation <= newString.length();startLocation+=5,endLocation+=5)
		     list.add(newString.substring(startLocation,endLocation));
		   return list;
		}
	 public  static String arrayToString2(ArrayList<String> array)        //将容器中的数组转化为字符串
		{ 
			StringBuffer string = new StringBuffer();
			String str =new String();
			for(int i=0; i<array.size(); i++)
				string.append((char)Integer.parseInt(array.get(i),10));
			str = string.toString();
			return str;
		}
}
