package com.cop.backge09.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.cop.backge09.utils.utils.StringUtils;

public class DateTimeFormat {

	/** 
	 * <p>Title: getPastDate</p> 
	 * <p>Description: 获取过去第几天、月的日期 (格式：yyyy-MM-dd或者yyyy-mm)</p> 
	 * @param past     天数、月数
	 * @param type     day、month
	 * @param data     以data时间开始计算。  传空位当前时间
	 * @return 
	 */
	public static String getPastDate(int past,String type,String data) {  
		try {
			Calendar calendar = Calendar.getInstance();  
			calendar.setTime(new Date());//设置当前日期  
			if(type.equals("day"))
			{   
				SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
				if(StringUtils.isNotBlank(data))
					calendar.setTime(format1.parse(data));
				calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - past);  
				Date today = calendar.getTime();  
				String result = format1.format(today);  
				return result;  
			}
			else
			{
				SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM"); 
				if(StringUtils.isNotBlank(data))
					calendar.setTime(format1.parse(data));
				calendar.add(Calendar.MONTH, -past);//月份减一
				Date today = calendar.getTime();  
				String result = format1.format(today);  
				return result;  
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return  "0";
		}

	}  

	/** 
	 * <p>Title: getPastDate</p> 
	 * <p>Description: 获取过去第几天、月的日期 (格式MM月dd日或者yy年-MM月)</p> 
	 * @param past     天数、月数
	 * @param type     day、month
	 * @param data     以data时间开始计算。  传空位当前时间
	 * @return 
	 */
	public static String getPastDateSDF(int past,String type,String data) {  
		try {
			Calendar calendar = Calendar.getInstance();  
			calendar.setTime(new Date());//设置当前日期  
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat formatDay = new SimpleDateFormat("MM月dd日"); 
			SimpleDateFormat formatMonth = new SimpleDateFormat("yy年-MM月"); 
			if(type.equals("day"))
			{   
				if(StringUtils.isNotBlank(data))
					calendar.setTime(format.parse(data));
				calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - past);  
				Date today = calendar.getTime();  
				String result = formatDay.format(today);  
				return result;  
			}
			else
			{	if(StringUtils.isNotBlank(data))
				   calendar.setTime(format.parse(data));
			    calendar.add(Calendar.MONTH, -past);//月份减一
			    Date today = calendar.getTime();  
			    String result = formatMonth.format(today);  
			    return result;  
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "0";
		}
	} 

	/** 
	 * java 计算两个日期相差了几个月 
	 * @throws ParseException 
	 */  
	public static int  monthBad(String startTime,String  endTime)  { 
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");  
			Calendar bef = Calendar.getInstance();  
			Calendar aft = Calendar.getInstance();  
			bef.setTime(sdf.parse(startTime));
			aft.setTime(sdf.parse(endTime));  
			int result = aft.get(Calendar.MONTH) - bef.get(Calendar.MONTH);  
			int month = (aft.get(Calendar.YEAR) - bef.get(Calendar.YEAR)) * 12;  
			return  Math.abs(month + result);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}  
	} 
	/** 
	 * 通过时间秒毫秒数判断两个时间的间隔
	 * @throws ParseException 
	 */ 
	public static int differentDaysByMillisecond(String startTime,String endTime) 
	{

		try {
			SimpleDateFormat  sdf=new SimpleDateFormat("yyyy-MM-dd");
			Date date1;
			date1 = sdf.parse(startTime);
			Date date2=sdf.parse(endTime);
			int days = (int) ((date2.getTime() - date1.getTime()) / (1000*3600*24));
			return days;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}

	}
	/** 
	 * 获取过去第几天、月的日期 （从参数时间开始）
	 * 
	 * @param past 
	 * @return 2017-09-15
	 * @throws ParseException 
	 *//*  
	public static String getPastDate(String type,String data,int past)  {  
		Calendar calendar = Calendar.getInstance();  
		try {
			if(type.equals("day"))
			{   
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
				calendar.setTime(format.parse(data));
				calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - past);  
				Date today = calendar.getTime();  
				String result = format.format(today);  
				return result;  
			}
			else
			{
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
				calendar.setTime(new Date());//设置当前日期  
				calendar.add(Calendar.MONTH, -past);//月份减一
				Date today = calendar.getTime();  
				String result = format.format(today);  
				return result;  
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "0"; 
		}

	}  */
	public static void main(String[] args) {
		System.out.println(getPastDateSDF(1,"month","2017-09-03"));
	}
}
