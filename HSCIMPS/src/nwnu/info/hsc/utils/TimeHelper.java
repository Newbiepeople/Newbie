package nwnu.info.hsc.utils;

import java.text.*;
import java.util.*;

public class TimeHelper {
	
	private static String CurrentTime;
	private static String CurrentDate;

	/**
	 * �õ���ǰ����� ���ظ�ʽ:yyyy
	 * 
	 * @return String
	 */
	public static String getCurrentYear() {
		java.util.Date NowDate = new java.util.Date();

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
		return formatter.format(NowDate);
	}

	/**
	 * �õ���ǰ���·� ���ظ�ʽ:MM
	 * 
	 * @return String
	 */
	public static String getCurrentMonth() {
		java.util.Date NowDate = new java.util.Date();

		SimpleDateFormat formatter = new SimpleDateFormat("MM");
		return formatter.format(NowDate);
	}

	/**
	 * �õ���ǰ������ ���ظ�ʽ:dd
	 * 
	 * @return String
	 */
	public static String getCurrentDay() {
		java.util.Date NowDate = new java.util.Date();

		SimpleDateFormat formatter = new SimpleDateFormat("dd");
		return formatter.format(NowDate);
	}
	/**
	 * �õ���ǰ��ʱ�䣬��ȷ������,��19λ ���ظ�ʽ:yyyy-MM-dd HH:mm:ss
	 * 
	 * @return String
	 */
	public static String getCurrentTime() {
		Date NowDate = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		CurrentTime = formatter.format(NowDate);
		return CurrentTime;
	}

	public static String getCurrentCompactTime() {
		Date NowDate = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		CurrentTime = formatter.format(NowDate);
		return CurrentTime;
	}
	public static String getYesterdayCompactTime() {
		Calendar cal = Calendar.getInstance(); 
		cal.add(cal.DATE, -1); 
		System.out.print(cal.getTime()); 
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		CurrentTime = formatter.format(cal.getTime());
		return CurrentTime;
	}
	public static String getYesterdayCompactTimeForFileName() {
		Calendar cal = Calendar.getInstance(); 
		cal.add(cal.DATE, -1); 
		System.out.print(cal.getTime()); 
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		CurrentTime = formatter.format(cal.getTime());
		return CurrentTime;
	}
	/**
	 * �õ���ǰ������,��10λ ���ظ�ʽ��yyyy-MM-dd
	 * 
	 * @return String
	 */
	public static String getCurrentDate() {
		Date NowDate = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		CurrentDate = formatter.format(NowDate);
		return CurrentDate;
	}
	/**
	 * �õ���ǰ������,��10λ ���ظ�ʽ��yyyy-MM-dd
	 * 
	 * @return String
	 */
	public static String getCurrentDate1() {
		Date NowDate = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy��MM��dd��");
		CurrentDate = formatter.format(NowDate);
		return CurrentDate;
	}
	/**
	 * �õ����µĵ�һ��,��10λ ���ظ�ʽ��yyyy-MM-dd
	 * 
	 * @return String
	 */
	public static String getCurrentFirstDate() {
		Date NowDate = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-01");
		CurrentDate = formatter.format(NowDate);
		return CurrentDate;
	}
	/**
	 * �õ����µ����һ��,��10λ ���ظ�ʽ��yyyy-MM-dd
	 * 
	 * @return String
	 * @throws ParseException 
	 */
	public static String getCurrentLastDate() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar= null;
		try {
			java.util.Date date =formatter.parse(getCurrentFirstDate());
			calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.add(Calendar.MONTH,1);
			calendar.add(Calendar.DAY_OF_YEAR, -1);
			 return formatDate(calendar.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
			return "";
		}
	}


	/**
     * ���õĸ�ʽ������
     *
     * @param date Date
     * @return String
     */
    public static String formatDate(java.util.Date date)
    {
        return formatDateByFormat(date,"yyyy-MM-dd");
    }
    /**
     * ��ָ���ĸ�ʽ����ʽ������
     *
     * @param date Date
     * @param format String
     * @return String
     */
    public static String formatDateByFormat(java.util.Date date,String format)
    {
        String result = "";
        if(date != null)
        {
            try
            {
                SimpleDateFormat sdf = new SimpleDateFormat(format);
                result = sdf.format(date);
            }
            catch(Exception ex)
            {
                
                ex.printStackTrace();
            }
        }
        return result;
    }
	/**
	 * �õ���ǰ���ڼ���ĳһ�����������ڣ������������� ���������currentdate : String ��ʽ yyyy-MM-dd add_day :
	 * int ���ظ�ʽ��yyyy-MM-dd
	 */
	public static String addDay(String currentdate, int add_day) {
		GregorianCalendar gc = null;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		int year, month, day;

		try {
			year = Integer.parseInt(currentdate.substring(0, 4));
			month = Integer.parseInt(currentdate.substring(5, 7)) - 1;
			day = Integer.parseInt(currentdate.substring(8, 10));

			gc = new GregorianCalendar(year, month, day);
			gc.add(GregorianCalendar.DATE, add_day);

			return formatter.format(gc.getTime());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * �õ���ǰ���ڼ���ĳһ�����������ڣ������������� ���������currentdate : String ��ʽ yyyy-MM-dd add_month :
	 * int ���ظ�ʽ��yyyy-MM-dd
	 */
	public static String addMonth(String currentdate, int add_month) {
		GregorianCalendar gc = null;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		int year, month, day;

		try {
			year = Integer.parseInt(currentdate.substring(0, 4));
			month = Integer.parseInt(currentdate.substring(5, 7)) - 1;
			day = Integer.parseInt(currentdate.substring(8, 10));

			gc = new GregorianCalendar(year, month, day);
			gc.add(GregorianCalendar.MONTH, add_month);

			return formatter.format(gc.getTime());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * �õ�endTime��beforeTime�����£������������� ���������endTime��beforeTime : String ��ʽǰ7λ�ĸ�ʽΪ yyyy-MM 
	 */
	public static int monthDiff(String beforeTime,String endTime){
		if(beforeTime==null||endTime==null){
			return 0;
		}
		int beforeYear,endYear,beforeMonth,endMonth;
		try {
			beforeYear = Integer.parseInt(beforeTime.substring(0, 4));
			endYear = Integer.parseInt(endTime.substring(0, 4));
			beforeMonth = Integer.parseInt(beforeTime.substring(5, 7)) - 1;
			endMonth = Integer.parseInt(endTime.substring(5, 7)) - 1;
			return (endYear-beforeYear)*12+(endMonth-beforeMonth);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * �õ���ǰ���ڼ���ĳһ�������ķ��� ���������currentdatetime : String ��ʽ yyyy-MM-dd HH:mm:ss
	 * add_minute : int ���ظ�ʽ��yyyy-MM-dd HH:mm:ss
	 */
	public static String addMinute(String currentdatetime, int add_minute) {
		GregorianCalendar gc = null;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		int year, month, day, hour, minute, second;

		try {
			year = Integer.parseInt(currentdatetime.substring(0, 4));
			month = Integer.parseInt(currentdatetime.substring(5, 7))-1;
			day = Integer.parseInt(currentdatetime.substring(8, 10));

			hour = Integer.parseInt(currentdatetime.substring(11, 13));
			minute = Integer.parseInt(currentdatetime.substring(14, 16));
			second = Integer.parseInt(currentdatetime.substring(17, 19));

			gc = new GregorianCalendar(year, month, day, hour, minute, second);
			gc.add(GregorianCalendar.MINUTE, add_minute);

			return formatter.format(gc.getTime());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * �õ���ǰ���ڼ���ĳһ���������� ���������currentdatetime : String ��ʽ yyyy-MM-dd HH:mm:ss
	 * add_second : int ���ظ�ʽ��yyyy-MM-dd HH:mm:ss
	 */
	public static String addSecond(String currentdatetime, int add_second) {
		GregorianCalendar gc = null;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		int year, month, day, hour, minute, second;

		try {
			year = Integer.parseInt(currentdatetime.substring(0, 4));
			month = Integer.parseInt(currentdatetime.substring(5, 7))-1;
			day = Integer.parseInt(currentdatetime.substring(8, 10));

			hour = Integer.parseInt(currentdatetime.substring(11, 13));
			minute = Integer.parseInt(currentdatetime.substring(14, 16));
			second = Integer.parseInt(currentdatetime.substring(17, 19));

			gc = new GregorianCalendar(year, month, day, hour, minute, second);
			gc.add(GregorianCalendar.SECOND, add_second);

			return formatter.format(gc.getTime());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static String addMinute1(String currentdatetime, int add_minute) {
		GregorianCalendar gc = null;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		int year, month, day, hour, minute, second;

		try {
			year = Integer.parseInt(currentdatetime.substring(0, 4));
			month = Integer.parseInt(currentdatetime.substring(5, 7)) - 1;
			day = Integer.parseInt(currentdatetime.substring(8, 10));

			hour = Integer.parseInt(currentdatetime.substring(8, 10));
			minute = Integer.parseInt(currentdatetime.substring(8, 10));
			second = Integer.parseInt(currentdatetime.substring(8, 10));

			gc = new GregorianCalendar(year, month, day, hour, minute, second);
			gc.add(GregorianCalendar.MINUTE, add_minute);

			return formatter.format(gc.getTime());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public static Date parseDate(String sDate) {
		SimpleDateFormat bartDateFormat = new SimpleDateFormat("yyyy-MM-dd");

		try {
			Date date = bartDateFormat.parse(sDate);
			return date;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return null;
	}

	/**
	 * �������ڼ�ʱ��
	 * 
	 * @param sDateTime
	 *            ���ڼ�ʱ���ַ���
	 * @return ����
	 */
	public static Date parseDateTime(String sDateTime) {
		SimpleDateFormat bartDateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");

		try {
			Date date = bartDateFormat.parse(sDateTime);
			return date;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return null;
	}

	/**
	 * ȡ��һ���µ����� date:yyyy-MM-dd
	 * 
	 * @throws ParseException
	 */
	public static int getTotalDaysOfMonth(String strDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = new GregorianCalendar();

		Date date = new Date();
		try {
			date = sdf.parse(strDate);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		calendar.setTime(date);
		int month = calendar.get(Calendar.MONTH) + 1; // �·�
		int day = calendar.getActualMaximum(Calendar.DAY_OF_MONTH); // ����
		return day;
	}
	
	
	public static long getDateSubDay(String startDate ,String endDate ) {
		Calendar calendar = Calendar.getInstance(); 
		SimpleDateFormat   sdf   =   new   SimpleDateFormat("yyyy-MM-dd"); 
		long theday = 0;
		try  {
			calendar.setTime(sdf.parse(startDate)); 
			long   timethis   =   calendar.getTimeInMillis(); 
			calendar.setTime(sdf.parse(endDate)); 
			long   timeend   =   calendar.getTimeInMillis(); 
			theday   =   (timethis   -   timeend)   /   (1000   *   60   *   60   *   24); 
		}catch(Exception e) {
			e.printStackTrace();
		}
		return theday;
	}
	
   public static void main(String[] args){ 
		System.out.println(TimeHelper.addSecond(TimeHelper.getCurrentTime(), -2) );
   }
}

