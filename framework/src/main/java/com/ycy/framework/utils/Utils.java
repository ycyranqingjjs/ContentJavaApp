package com.ycy.framework.utils;

import android.Manifest;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.provider.ContactsContract;
import android.support.v4.content.FileProvider;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

import com.ycy.framework.base.FBaseApplication;
import com.ycy.framework.config.FrameworkConfig;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static android.content.Context.WINDOW_SERVICE;

/**
 * Created by yaocheng on 2017/5/11.
 */

public class Utils {
    public static final long MB = 1024L * 1024L;
    public static final long GB = 1024L * MB;
    public static final long KB_10 = 10L * 1024L;

    public static boolean isPhoneNo(String mobiles) {
        if (TextUtils.isEmpty(mobiles)) {
            return false;
        }
        try {
            Long.parseLong(mobiles);
            return true;
        } catch (Exception e) {

        }
//        return false;
//
//        Pattern p = Pattern.compile("^1[34578]\\d{9}");
//
//        Matcher m = p.matcher(mobiles);
//
//        return m.matches();
        return false;

    }

    public static boolean isCheckCode(String mobiles) {

        Pattern p = Pattern.compile("^\\d{4}");

        Matcher m = p.matcher(mobiles);

        return m.matches();

    }

    public static boolean isCheckPassword(String password) {
        return isPassWord(password);
    }

//    public static boolean isPassWord(String mobiles) {
//        Pattern pattern = Pattern.compile("^[^\\u4E00-\\u9FA5\\uF900-\\uFA2D\\u0020]{8,16}$");
//        if (pattern.matcher(mobiles).matches()) {
//            int size = 0;
//            Pattern number = Pattern.compile(".*\\d+.*");
//            if (number.matcher(mobiles).matches()) {
//                size += 1;
//            }
//            Pattern chara = Pattern.compile(".*[a-zA-Z]+.*");
//            if (chara.matcher(mobiles).matches()) {
//                size += 1;
//            }
//            Pattern special = Pattern.compile(".*[^A-Za-z0-9]+.*");
//            if (special.matcher(mobiles).matches()) {
//                size += 1;
//            }
//            if (size >= 2) {
//                return true;
//            }
//        }
//        return false;
//
//
//    }

    /**
     * 1、8～16位，不可以是纯数字
     * 2、密码允许使用数字、小写字母、大写字母和常见特殊字符
     * 3、常见特殊字符以iOS端的密码键盘为准
     * 包括空格及[]{}#%^*+=_\|~<>€£¥•.,?!’-/:;()$&@“
     *
     * @param mobiles
     * @return
     */

    public static boolean isPassWord(String mobiles) {
        Pattern pattern = Pattern.compile("^(?![0-9]*$)[A-Za-z0-9\\u0020\\u005b\\u005d\\u007b\\u007d\\u0023\\u0025\\u005e\\u002a\\u002b\\u003d\\u005f\\u005c\\u007c\\u007e\\u003c\\u003e\\u20ac\\u00a3\\u00a5\\u2022\\u002e\\u002c\\u003f\\u0021\\u2019\\u002d\\u002f\\u003a\\u003b\\u0028\\u0029\\u0024\\u0026\\u0040\\u201c]{8,16}$");
        if (pattern.matcher(mobiles).matches()) {
            return true;
        }
        return false;
    }
//    public static boolean isPassWord(String mobiles) {
//        Pattern chinese = Pattern.compile("[\\u4E00-\\u9FA5\\uF900-\\uFA2D]");
//        if(chinese.matcher(mobiles).matches()){
//            return false;
//        }
//        Pattern space = Pattern.compile("[\\u0020]");
//        if(space.matcher(mobiles).matches()){
//            return false;
//        }
//        Pattern number = Pattern.compile("[0-9]");
//        Pattern char = Pattern.compile("[A-Za-z]");
//
//        Matcher m = chineseAndSpace.matcher(mobiles);
//
//        return m.matches();
//
//    }

    /**
     * 判断qq是否可用
     *
     * @param context
     * @return
     */
    public static boolean isQQClientAvailable(Context context) {
        return isInstalled(context, "com.tencent.mobileqq");
    }

    /**
     * 判断微信是否可用
     *
     * @param context
     * @return
     */
    public static boolean isWeixinAvailable(Context context) {
        return isInstalled(context, "com.tencent.mm");
    }


    /**
     * 判断球球是否可用
     *
     * @param context
     * @return
     */
    public static boolean isQIUQIUInstalled(Context context) {
        return isInstalled(context, "com.ztgame.bob");
    }


    public static boolean isInstalled(Context c, String pkgName) {
        PackageManager mPm = c.getPackageManager();
        if (mPm == null) {
            return false;
        } else {
            PackageInfo pkginfo = null;

            try {
                pkginfo = mPm.getPackageInfo(pkgName, 0);
            } catch (PackageManager.NameNotFoundException e) {
            } catch (Exception e) {
                if (FrameworkConfig.DEBUG) {
                    LogUtil.e("yaocheng", "[cached]", e);

                }
            }

            return pkginfo != null;
        }
    }


    public static boolean supportsViewElevation() {
        return (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP);
    }

    public static boolean hit(View v, float x, float y) {
        final int tx = (int) (ViewCompat.getTranslationX(v) + 0.5f);
        final int ty = (int) (ViewCompat.getTranslationY(v) + 0.5f);
        final int left = v.getLeft() + tx;
        final int right = v.getRight() + tx;
        final int top = v.getTop() + ty;
        final int bottom = v.getBottom() + ty;

        return (x >= left) && (x <= right) && (y >= top) && (y <= bottom);
    }


    /**
     * 把byte大小转成GB 大小
     *
     * @param bytes
     * @return
     */
    public static float bytesToGBytes(long bytes) {
        return bytes / (1024f * 1024f * 1024f);
    }

    /**
     * 把bytes大小转化成MB 大小
     *
     * @param bytes
     * @return
     */
    public static float bytesToMBytes(long bytes) {
        return bytes / (1024f * 1024f);
    }

    /**
     * 把bytes换成kb表示
     *
     * @param bytes
     * @return
     */
    public static float bytesToKBytes(long bytes) {
        return bytes / 1024f;
    }


    /**
     * 保留两位有效数字
     *
     * @param f
     * @return
     */
    private static String trimToTwoNum(float f) {
        double val = Math.round(f * 100) / 100.0;
        return String.valueOf(val);
    }

    public static void closeKeybord(View v, Context context) {
        InputMethodManager imm = (InputMethodManager) context.getApplicationContext()
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
    }

    public static String getReadableSize(long size) {
        return getReadableSize(size, true);
    }

    private static String getReadableSize(long size, boolean hasFloat) {
        String[] strings = getReadableSizeAndUnit(size, null, hasFloat);
        return strings[0] + " " + strings[1];
    }


    private static String[] getReadableSizeAndUnit(long size, String[] segments, boolean hasFloat) {
        final int readableStringArrayLength = 2;

        if (segments == null) {
            segments = new String[readableStringArrayLength];
        }

        if (size < KB_10) {
            float val = bytesToKBytes(size);
            segments[0] = hasFloat ? trimToTwoNum(val) : String.valueOf((int) val);
            segments[1] = "KB";
        } else if (size < GB) {
            float val = bytesToMBytes(size);
            if (hasFloat) {
                segments[0] = trimToTwoNum(val);
            } else {
                //避免出现0MB
                if (val < 1){
                    val = 1;
                }
                segments[0] = String.valueOf((int) val);
            }
            segments[1] = "MB";
        } else {
            //GB的单位还是要带小数点的
            float val = bytesToGBytes(size);
            segments[0] = trimToTwoNum(val);
            segments[1] = "GB";
        }
        return segments;
    }

    public static String getReadableCount(long count) {
        if (count < 100000) {
            return String.valueOf(count);
        }
        if (count < 100000000) {
            return count / 10000 + "万";
        }
        if (count < 10000000000l) {
            return String.format(Locale.ENGLISH, "%.3f亿", count / 100000000d);
        }
        if (count < 100000000000l) {
            return count / 100000000 + "亿";
        }
        return "...";

    }

    public static String getReadableScore(int score) {
        return score + "";
//        String values;
////        if (score == (int) score) {
////            values = (int) score +"";
////        } else {
////            values = String.format(Locale.ENGLISH, "%.1f", score);
////        }
//        values = String.format(Locale.ENGLISH, "%.1f", score);
//        return values;
    }

    public static String getReadableTimeForRoom(long time, long offset, SimpleDateFormat format) {
        //        long curTime = System.currentTimeMillis();
        if (time > 0) {
            long serverTime = System.currentTimeMillis() + offset;
            long gap = serverTime - time;
            if (FrameworkConfig.DEBUG) {
                String values = format.format(new Date(time));
                LogUtil.i("yaocheng", values + " " + gap + "   " + serverTime + "   " + time);
            }

//            if (gap > DateUtils.DAY_IN_MILLIS * 7) {
//                String values = format.format(new Date(time));
//                if (FrameworkConfig.DEBUG) {
//                    LogUtil.i("yaocheng", "" + values);
//                }
//                return values;
//            }

            if (gap > DateUtils.DAY_IN_MILLIS) {
                return gap / DateUtils.DAY_IN_MILLIS + "天";
            }
            if (gap > DateUtils.HOUR_IN_MILLIS) {
                return gap / DateUtils.HOUR_IN_MILLIS + "小时";
            }
            if (gap > DateUtils.MINUTE_IN_MILLIS) {
                return gap / DateUtils.MINUTE_IN_MILLIS + "分钟";
            }
            if (gap >= DateUtils.SECOND_IN_MILLIS) {
                return gap / DateUtils.SECOND_IN_MILLIS + "秒";
            }
        }
        return "刚刚";
    }

    public static String getReadableTime(long time, long offset, SimpleDateFormat format) {
        //        long curTime = System.currentTimeMillis();
        if (time > 0) {
            long serverTime = System.currentTimeMillis() + offset;
            long gap = serverTime - time;
            if (FrameworkConfig.DEBUG) {
                String values = format.format(new Date(time));
                LogUtil.i("yaocheng", values + " " + gap + "   " + serverTime + "   " + time);
            }

            if (gap > DateUtils.DAY_IN_MILLIS * 7) {
                String values = format.format(new Date(time));
                if (FrameworkConfig.DEBUG) {
                    LogUtil.i("yaocheng", "" + values);
                }
                return values;
            }

            if (gap > DateUtils.DAY_IN_MILLIS) {
                return gap / DateUtils.DAY_IN_MILLIS + "天前";
            }
            if (gap > DateUtils.HOUR_IN_MILLIS) {
                return gap / DateUtils.HOUR_IN_MILLIS + "小时前";
            }
            if (gap > DateUtils.MINUTE_IN_MILLIS) {
                return gap / DateUtils.MINUTE_IN_MILLIS + "分钟前";
            }
            if (gap >= 3 * DateUtils.SECOND_IN_MILLIS) {
                return gap / DateUtils.SECOND_IN_MILLIS + "秒前";
            }
        }
        return "刚刚";
    }

    public static String getReadableTimeForRoom(long time, long offset) {
        return getReadableTimeForRoom(time, offset, new SimpleDateFormat("yyyy年MM月dd日"));
    }

    public static String getReadableTime(long time, long offset) {
        return getReadableTime(time, offset, new SimpleDateFormat("yyyy年MM月dd日"));
    }


    public static String getReadableTimeShort(long time, long offset) {
        return getReadableTime(time, offset, new SimpleDateFormat("MM月dd日"));
    }
//    0﹤x≦1分钟，显示“x秒前”，x取整数部分；
//            1分钟﹤x≦60分钟，显示“x分钟前”，x取整数部分；
//            60分钟﹤x≦24小时，显示“x小时前”，x取整数部分；
//            24小时﹤x≦7天，显示“x天前”，x取整数部分；
//    x﹥7天：今年显示具体日期:月/日（今年），如“5月20日”；去年及以前显示具体日期:年／月/日，如“2016年5月20日”

    public static final String HASH_MD5 = "MD5";

    public static byte[] getHash(String hashName, byte[] buf) {
        try {
            MessageDigest m = MessageDigest.getInstance(hashName);
            m.update(buf);
            return m.digest();
        } catch (Exception var4) {
            return null;
        }
    }

    public static String getMD5(String values) {
        try {
            return getMD5(values.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            if (FrameworkConfig.DEBUG) {
                LogUtil.e("yaocheng", "", e);
            }
        }
        return "";
    }

    public static String getMD5(byte[] bytes) {
        return bytes != null && bytes.length != 0 ? Hex.encodeHexString(getHash(HASH_MD5, bytes)) : null;
    }

    //    public static String getMD5(InputStream inputStream) {
//        byte[] digest = null;
//        BufferedInputStream in = null;
//        try {
//            MessageDigest md = MessageDigest.getInstance("MD5");
//            in = new BufferedInputStream(inputStream);
//
//            int theByte;
//            byte[] buffer = new byte[1024];
//            while ((theByte = in.read(buffer)) != -1) {
//                md.update(buffer, 0, theByte);
//            }
//            digest = md.digest();
//        } catch (Exception e) {
//            if (FrameworkConfig.DEBUG) {
//                LogUtil.e("yaocheng", "", e);
//            }
//        } finally {
//            if (in != null) {
//                try {
//                    in.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        if (digest == null) {
//            return null;
//        } else {
//            return Hex.encodeHexString(digest);
//        }
//    }
    public static String getMD5(File file) {
        byte[] digest = MD5(file);
        if (digest == null) {
            return null;
        } else {
            return Hex.encodeHexString(digest);
        }
    }

    private static byte[] MD5(File file) {
        BufferedInputStream in = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            in = new BufferedInputStream(new FileInputStream(file));

            int theByte;
            byte[] buffer = new byte[1024];
            while ((theByte = in.read(buffer)) != -1) {
                md.update(buffer, 0, theByte);
            }
            in.close();

            return md.digest();
        } catch (Exception e) {
            if (FrameworkConfig.DEBUG) {
                LogUtil.e("yaocheng", "", e);
            }
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }

    private static int sWidth = -1;
    private static int sHeight = -1;
    private static int sDensityDpi = -1;

    public static int getScreenWidth() {
        if (sWidth == -1) {
            sWidth = FBaseApplication.INSTANCE.getResources().getDisplayMetrics().widthPixels;
        }
        return sWidth;
    }

    public static int getScreendensityDpi() {
        if (sDensityDpi == -1) {
            sDensityDpi = FBaseApplication.INSTANCE.getResources().getDisplayMetrics().densityDpi;
        }
        return sDensityDpi;
    }

    private static int getgetScreenHeightFromSystem() {
        WindowManager wm = (WindowManager) FBaseApplication.INSTANCE.getSystemService(WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            try {
                Point realSize = new Point();
                Display.class.getMethod("getRealSize", Point.class).invoke(display, realSize);
                return realSize.y;
            } catch (Exception ignored) {
            }
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH && Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR1) {
            try {
                int height = (Integer) Display.class.getMethod("getRawHeight").invoke(display);
                return height;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
        DisplayMetrics dm = new DisplayMetrics();
        display.getMetrics(dm);
        return FBaseApplication.INSTANCE.getResources().getDisplayMetrics().heightPixels;
    }

    public static int getScreenHeight() {

        if (sDensityDpi == -1) {
            sDensityDpi = getgetScreenHeightFromSystem();
        }
        return sDensityDpi;
    }


    public static boolean checkPermission(Context context, String permission) {
        boolean result = false;
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                Class<?> clazz = Class.forName("android.content.Context");
                Method method = clazz.getMethod("checkSelfPermission", String.class);
                int rest = (Integer) method.invoke(context, permission);
                if (rest == PackageManager.PERMISSION_GRANTED) {
                    result = true;
                } else {
                    result = false;
                }
            } catch (Exception e) {
                result = false;
            }
        } else {
            PackageManager pm = context.getPackageManager();
            if (pm.checkPermission(permission, context.getPackageName()) == PackageManager.PERMISSION_GRANTED) {
                result = true;
            }
        }
        return result;
    }

    public static String getDeviceInfo(Context context) {
        try {
            org.json.JSONObject json = new org.json.JSONObject();
            android.telephony.TelephonyManager tm = (android.telephony.TelephonyManager) context
                    .getSystemService(Context.TELEPHONY_SERVICE);
            String device_id = null;
            if (checkPermission(context, Manifest.permission.READ_PHONE_STATE)) {
                device_id = tm.getDeviceId();
            }
            String mac = null;
            FileReader fstream = null;
            try {
                fstream = new FileReader("/sys/class/net/wlan0/address");
            } catch (FileNotFoundException e) {
                fstream = new FileReader("/sys/class/net/eth0/address");
            }
            BufferedReader in = null;
            if (fstream != null) {
                try {
                    in = new BufferedReader(fstream, 1024);
                    mac = in.readLine();
                } catch (IOException e) {
                } finally {
                    if (fstream != null) {
                        try {
                            fstream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (in != null) {
                        try {
                            in.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            json.put("mac", mac);
            if (TextUtils.isEmpty(device_id)) {
                device_id = mac;
            }
            if (TextUtils.isEmpty(device_id)) {
                device_id = android.provider.Settings.Secure.getString(context.getContentResolver(),
                        android.provider.Settings.Secure.ANDROID_ID);
            }
            json.put("device_id", device_id);
            return json.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

/* 网上找的一段uri 和path转换的代码，貌似不错，先存下来看看，应该能用的上
   public static String getRealFilePath(Context context, final Uri uri) {
        if (null == uri)
            return null;
        final String scheme = uri.getScheme();
        String data = null;
        if (scheme == null)
            data = uri.getPath();
        else if (ContentResolver.SCHEME_FILE.equals(scheme)) {
            data = uri.getPath();
        } else if (ContentResolver.SCHEME_CONTENT.equals(scheme)) {
            Cursor cursor = context.getContentResolver().query(uri, new String[] { MediaStore.Images.ImageColumns.DATA }, null, null, null);
            if (null != cursor) {
                if (cursor.moveToFirst()) {
                    int index = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
                    if (index > -1) {
                        data = cursor.getString(index);
                    }

                }
                cursor.close();
            }
            if (data == null) {
                data = getImageAbsolutePath(context, uri);
            }

        }
        return data;
    }

    public static Uri getUri(final String filePath) {
        return Uri.fromFile(new File(filePath));
    }

    *//**
     * 根据Uri获取图片绝对路径，解决Android4.4以上版本Uri转换
     *
     * @param context
     * @param imageUri
     * @author yaoxing
     * @date 2014-10-12
     *//*
    @TargetApi(19)
    public static String getImageAbsolutePath(Context context, Uri imageUri) {
        if (context == null || imageUri == null)
            return null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT && DocumentsContract.isDocumentUri(context, imageUri)) {
            if (isExternalStorageDocument(imageUri)) {
                String docId = DocumentsContract.getDocumentId(imageUri);
                String[] split = docId.split(":");
                String type = split[0];
                if ("primary".equalsIgnoreCase(type)) {
                    return Environment.getExternalStorageDirectory() + "/" + split[1];
                }
            } else if (isDownloadsDocument(imageUri)) {
                String id = DocumentsContract.getDocumentId(imageUri);
                Uri contentUri = ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(id));
                return getDataColumn(context, contentUri, null, null);
            } else if (isMediaDocument(imageUri)) {
                String docId = DocumentsContract.getDocumentId(imageUri);
                String[] split = docId.split(":");
                String type = split[0];
                Uri contentUri = null;
                if ("image".equals(type)) {
                    contentUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                } else if ("video".equals(type)) {
                    contentUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                } else if ("audio".equals(type)) {
                    contentUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                }
                String selection = MediaStore.Images.Media._ID + "=?";
                String[] selectionArgs = new String[] { split[1] };
                return getDataColumn(context, contentUri, selection, selectionArgs);
            }
        } // MediaStore (and general)
        else if ("content".equalsIgnoreCase(imageUri.getScheme())) {
            // Return the remote address
            if (isGooglePhotosUri(imageUri))
                return imageUri.getLastPathSegment();
            return getDataColumn(context, imageUri, null, null);
        }
        // File
        else if ("file".equalsIgnoreCase(imageUri.getScheme())) {
            return imageUri.getPath();
        }
        return null;
    }

    public static String getDataColumn(Context context, Uri uri, String selection, String[] selectionArgs) {
        Cursor cursor = null;
        String column = MediaStore.Images.Media.DATA;
        String[] projection = { column };
        try {
            cursor = context.getContentResolver().query(uri, projection, selection, selectionArgs, null);
            if (cursor != null && cursor.moveToFirst()) {
                int index = cursor.getColumnIndexOrThrow(column);
                return cursor.getString(index);
            }
        } finally {
            if (cursor != null)
                cursor.close();
        }
        return null;
    }

    *//**
     * @param uri
     *                The Uri to check.
     * @return Whether the Uri authority is ExternalStorageProvider.
     *//*
    public static boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    *//**
     * @param uri
     *                The Uri to check.
     * @return Whether the Uri authority is DownloadsProvider.
     *//*
    public static boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    *//**
     * @param uri
     *                The Uri to check.
     * @return Whether the Uri authority is MediaProvider.
     *//*
    public static boolean isMediaDocument(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    */

    /**
     * @return Whether the Uri authority is Google Photos.
     *//*
    public static boolean isGooglePhotosUri(Uri uri) {
        return "com.google.android.apps.photos.content".equals(uri.getAuthority());
    }*/
    public static String findContactNameByNumber(long phoneNum) {

        String number = String.valueOf(phoneNum);


        if (TextUtils.isEmpty(number)) {
            return null;
        }

        final ContentResolver resolver = FBaseApplication.INSTANCE.getContentResolver();

        Uri lookupUri = null;
        String[] projection = new String[]{ContactsContract.PhoneLookup._ID, ContactsContract.PhoneLookup.DISPLAY_NAME};
        Cursor cursor = null;
        try {
            lookupUri = Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Uri.encode(number));
            cursor = resolver.query(lookupUri, projection, null, null, null);
        } catch (Exception ex) {
            if (FrameworkConfig.DEBUG) {
                LogUtil.e("yaocheng", "", ex);
            }
            try {
                lookupUri = Uri.withAppendedPath(android.provider.Contacts.Phones.CONTENT_FILTER_URL,
                        Uri.encode(number));
                cursor = resolver.query(lookupUri, projection, null, null, null);
            } catch (Exception e) {
                if (FrameworkConfig.DEBUG) {
                    LogUtil.e("yaocheng", "", e);
                }
            }
        }

        String ret = null;
        if (cursor != null && cursor.getCount() > 0 && cursor.moveToFirst()) {
            ret = cursor.getString(1);
        }
        try {
            if (cursor != null) {
                cursor.close();
            }
        } catch (Exception e) {
            if (FrameworkConfig.DEBUG) {
                LogUtil.e("yaocheng", "", e);
            }

        }
        return ret;

    }

    public static String trimTelNum(String telNum) {

        if (telNum == null || "".equals(telNum)) {
            return null;
        }
        telNum = telNum.replace("-", "");
        telNum = telNum.replaceAll("\\s*", "");

        if (substring(telNum, 0, 4).equals("0086")) {
            telNum = substring(telNum, 4);
        } else if (substring(telNum, 0, 3).equals("+86")) {

            telNum = substring(telNum, 3);
        } else if (substring(telNum, 0, 5).equals("00186")) {

            telNum = substring(telNum, 5);
        }

        return telNum;
    }

    private static String substring(String s, int from) {
        try {
            return s.substring(from);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    private static String substring(String s, int from, int len) {
        try {
            return s.substring(from, from + len);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static List<Long> findContactNumbers() {

        List list = new ArrayList();
        Uri uri = ContactsContract.Contacts.CONTENT_URI;
        ContentResolver contentResolver = FBaseApplication.INSTANCE.getContentResolver();
        Cursor cursor = contentResolver.query(uri, null, null, null, null);
        if (cursor != null) {
            try {
                while (cursor.moveToNext()) {
                    String id = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));//联系人ID
                    Cursor phones = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                            null,
                            ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = " + id,
                            null, null);
                    if (phones != null) {

                        try {
                            while (phones.moveToNext()) {
                                String phoneNumber = phones.getString(phones.getColumnIndex(
                                        ContactsContract.CommonDataKinds.Phone.NUMBER));
                                String phoneNumberRes = trimTelNum(phoneNumber);
                                try {
                                    long number = Long.parseLong(phoneNumberRes);
                                    if (list.contains(number)) {
                                        continue;
                                    }
                                    list.add(number);
                                } catch (Exception e) {
                                    if (FrameworkConfig.DEBUG) {
                                        LogUtil.e("yaocheng", "[cached]", e);
                                    }
                                }

                            }
                        } catch (Exception e) {
                            if (FrameworkConfig.DEBUG) {
                                LogUtil.e("yaocheng", "[cached]", e);
                            }
                        } finally {
                            if (phones != null) {
                                try {
                                    phones.close();
                                } catch (Throwable e) {
                                }
                            }
                        }
                    }


                }
            } catch (Exception e) {
                if (FrameworkConfig.DEBUG) {
                    LogUtil.e("yaocheng", "[cached]", e);
                }

            } finally {
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Throwable e) {
                    }
                }
            }

        }
        return list;

    }

    public static boolean startInstallActivity(Context c, File file) {
        Uri uri;
        Intent installIntent = new Intent(Intent.ACTION_VIEW);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            uri = FileProvider.getUriForFile(c, c.getPackageName() + ".provider", file);
            installIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        } else {
            uri = Uri.fromFile(file);
        }

        try {
            installIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            installIntent.setDataAndType(uri, "application/vnd.android.package-archive");//设置intent的数据类型
            c.startActivity(installIntent);
            return true;
        } catch (Exception e1) {
            if (FrameworkConfig.DEBUG) {
                LogUtil.e("yaocheng", "[cached]", e1);
            }
        }
        return false;
    }

}
