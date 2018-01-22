package com.ycy.framework.utils;


import java.io.FileInputStream;

/**
 * Created by yaocheng on 2017/4/28.
 */

public class LinuxUtil {
    public static String getCurrentProcessName() {
        FileInputStream fis = null;
        String name;
        try {
            fis = new FileInputStream("/proc/self/cmdline");
            byte[] e = new byte[256];
            int len;
            int b;
            for (len = 0; (b = fis.read()) > 0 && len < e.length; e[len++] = (byte) b) {
            }
            if (len <= 0) {
                return null;
            }
            String s = new String(e, 0, len, "UTF-8");
            name = s;
        } catch (Exception e) {
            LogUtil.e("yaocheng", "[catch]", e);
            return null;
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (Exception e) {
                }
            }
        }
        return name;
    }
}
