package com.actmos.sdk.station.common;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 日期工具类
 *
 * @author zhiguang@crossevery.com
 * @version 1.0
 * @created 2018年3月15日 下午2:47:26
 */
public class DateUtil {

    private DateUtil() {
    }

    public static final String SDF_LONG = "yyyy-MM-dd HH:mm:ss,SSS";
    public static final String SDF_STANDARD = "yyyy-MM-dd HH:mm:ss";
    public static final String SDF_FORMAT = "yyyy-MM-dd HH:mm";
    public static final String SDF_SHORT = "yyyy-MM-dd";
    public static final String SDF_SHORT_SPOT = "yyyy.MM.dd";
    public static final String SDF_YYYYMMDD = "yyyyMMdd";
    public static final String SDF_YYMMDDHHMMSS = "yyMMddHHmmss";
    public static final String SDF_MSEC = "yyyyMMddHHmmssSSS";
    public static final String SDF_SEC = "yyyyMMddHHmmss";
    public static final String SDF_YEAR = "yyyy";
    public static final String SDF_MD = "MMdd";

    public static final String SDF_HHMM = "HH:mm";

    private static final ReentrantLock lock = new ReentrantLock();

    private static Map<String, ThreadLocal<SimpleDateFormat>> sdfMap = new HashMap<String, ThreadLocal<SimpleDateFormat>>();

    private static SimpleDateFormat getSdf(final String pattern) {
        ThreadLocal<SimpleDateFormat> tl = sdfMap.get(pattern);
        if (tl == null) {
            lock.lock();
            try {
                tl = sdfMap.get(pattern);
                if (tl == null) {
                    tl = new ThreadLocal<SimpleDateFormat>() {
                        @Override
                        protected SimpleDateFormat initialValue() {
                            return new SimpleDateFormat(pattern);
                        }
                    };
                    sdfMap.put(pattern, tl);
                }
            } finally {
                lock.unlock();
            }
        }
        return tl.get();
    }

    public static String format(Date date, String pattern) {
        return getSdf(pattern).format(date);
    }

    public static Date parse(String dateString, String pattern) throws ParseException {
        return getSdf(pattern).parse(dateString);
    }

    public static long getCurrentTimeMillis() {
        long mTime = System.currentTimeMillis();
        return mTime / 1000L;
    }

    public static Date addDays(Date date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, days);
        date = calendar.getTime();
        return date;
    }

    public static Date addMinutes(Date date, int minutes) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, minutes);
        date = calendar.getTime();
        return date;
    }

    public static long getNowMinFormat() {
        return getNowTimeFormat("yyyyMMddHHmm");
    }

    public static Long getNowTimeFormat(String pattern) {
        try{
            return Long.valueOf(format(new Date(), pattern));
        }catch (Exception ex) {
            return 0L;
        }

    }

    public static Integer date2int(Date date) {
        int result = 0;
        try {
            result = (int)(date.getTime()/1000);
        } catch (Exception e) {}
        return result;
    }

    //获取今天日期证书
    public static int getToday() {
        String today = DateUtil.format(new Date(), SDF_YYYYMMDD);
        return Integer.parseInt(today);
    }

    //获取前一天日期整数
    public static int getBeforeDay() {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date date=new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        date = calendar.getTime();
        String today = DateUtil.format(date, SDF_YYYYMMDD);
        return Integer.parseInt(today);
    }

    //获取前一年的年份
    public static int getBeforeYear() {
        String year = DateUtil.format(new Date(), SDF_YEAR);
        return Integer.parseInt(year) - 1;
    }

    /**
     * 获取月日
     * @return
     */
    public static int getMonthDay() {
        String monthDay = DateUtil.format(new Date(), SDF_MD);
        return Integer.parseInt(monthDay);
    }

    /**
     * 判断是不是今日
     */
    public static boolean isToday(Date date) {
        String ds1 = DateUtil.format(new Date(), SDF_YYYYMMDD);
        String ds2 = DateUtil.format(date, SDF_YYYYMMDD);
        return StringUtils.equals(ds1, ds2);
    }

    /**
     * 获取今日剩下的秒数
     */
    public static int getSecondsLeftToday() {
        return 86400 - (int) (DateUtils
            .getFragmentInSeconds(Calendar.getInstance(), Calendar.DATE));
    }

    /**
     * 获取今日零点零分零秒
     */
    public static Date getTodayZero() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获取指定日期前0点的时间戳
     * @param day
     * @return
     */
    public static Long getDateZeroTime(int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, day);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTimeInMillis() / 1000L;
    }

    /**
     * 将 Unix Timestamp转换为 ava.util.Date
     */
    public static Date unixTimestampToDate(int time) {
        long timestamp = time * 1000L;
        return new Date(timestamp);
    }

    /**
     * 计算两个日期间的天数
     * @param beginDate
     * @param endDate
     * @return
     */
    public static int diffDays(long beginDate, long endDate) {
        SimpleDateFormat formatter2  = new SimpleDateFormat("yyyyMMdd");
        try {
            Date beginD = formatter2.parse(String.valueOf(beginDate));
            Date endD = formatter2.parse(String.valueOf(endDate));
            return diffDays(beginD, endD);
        }catch (Exception ex) {}
        return -1;
    }

    /**
     * 比较两个日期的相差天数 (按自然日-忽略24小时制)
     *
     * @param beginDate 开始日期
     * @param endDate 结束日期
     */
    public static int diffDays(Date beginDate, Date endDate) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(beginDate);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(endDate);
        int day1 = cal1.get(Calendar.DAY_OF_YEAR);
        int day2 = cal2.get(Calendar.DAY_OF_YEAR);
        int year1 = cal1.get(Calendar.YEAR);
        int year2 = cal2.get(Calendar.YEAR);
        if (year1 != year2) {
            int timeDistance = 0;
            for (int i = year1; i < year2; i++) {
                if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0)    //闰年
                {
                    timeDistance += 366;
                } else    //不是闰年
                {
                    timeDistance += 365;
                }
            }
            return timeDistance + (day2 - day1);
        } else {
            return day2 - day1;
        }
    }

    /**
     * 获取星期几
     * @return  0-6  日，1，2，3，4，5，6
     */
    public static int getWeekDay() {
        Calendar calendar = Calendar.getInstance();
        Date date = new Date();
        calendar.setTime(date);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)-1;
        if(dayOfWeek <0)dayOfWeek=0;
        return dayOfWeek;
    }


    /**
     * 获取多少天后的时间
     * @param i
     * @return
     */
    public static String getDateTimePlusDay(int i) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime plusDays = now.plusDays(i);
        return plusDays.format(DateTimeFormatter.ofPattern(SDF_STANDARD));
    }


    /**
     * @param expireTime yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String getHexPushExpireTime(String expireTime) {
        LocalDateTime expireDateTime = LocalDateTime.parse(expireTime, DateTimeFormatter.ofPattern(SDF_STANDARD));
        long l;
        if (expireDateTime.isBefore(LocalDateTime.now())) {
            l = System.currentTimeMillis() / 1000 + 3600 * 24;
        } else {
            l = LocalDateTime.parse(expireTime, DateTimeFormatter.ofPattern(SDF_STANDARD)).toEpochSecond(ZoneOffset.of("+8"));
        }
        String hexTime = Long.toHexString(l);
        return hexTime.toUpperCase();
    }


    public static void main(String[] args) {
        System.out.println(DateUtil.format(new Date(1541088000958L), DateUtil.SDF_STANDARD));
        System.out.println(DateUtil.diffDays(20200501, 20200603));
        System.out.println(DateUtil.getDateZeroTime(-14));
        System.out.println(DateUtil.getDateZeroTime(14));
        System.out.println(DateUtil.getDateZeroTime(1));
    }

}
