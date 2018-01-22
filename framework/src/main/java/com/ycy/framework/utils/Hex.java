package com.ycy.framework.utils;

/**
 * Created by yaocheng on 2017/5/20.
 */

public class Hex {
    private static final char[] DIGITS_LOWER = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public Hex() {
    }

    public static byte[] decodeHex(String s) throws NumberFormatException {
        int len = s.length();
        if ((len & 1) != 0) {
            throw new NumberFormatException("Odd number of characters.");
        } else {
            byte[] out = new byte[len >> 1];
            int i = 0;

            for (int j = 0; j < len; ++i) {
                int f = toDigit(s.charAt(j), j) << 4;
                ++j;
                f |= toDigit(s.charAt(j), j);
                ++j;
                out[i] = (byte) (f & 255);
            }

            return out;
        }
    }

    protected static char[] encodeHex(byte[] data, int offset, int length) {
        int l = length;
        char[] out = new char[length << 1];
        int i = offset;

        for (int j = 0; i < offset + l; ++i) {
            out[j++] = DIGITS_LOWER[(240 & data[i]) >>> 4];
            out[j++] = DIGITS_LOWER[15 & data[i]];
        }

        return out;
    }

    public static String encodeHexString(byte[] data, int offset, int length) {
        return data != null ? new String(encodeHex(data, offset, length)) : null;
    }

    public static String encodeHexString(byte[] data) {
        return data != null ? new String(encodeHex(data, 0, data.length)) : null;
    }

    protected static int toDigit(char ch, int index) throws NumberFormatException {
        int digit = Character.digit(ch, 16);
        if (digit == -1) {
            throw new NumberFormatException("Illegal hexadecimal character " + ch + " at index " + index);
        } else {
            return digit;
        }
    }
}
