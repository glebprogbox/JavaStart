public class Solution {
    public static byte a;
    public static short b;
    public static int c;
    public static long d;

    public static void main(String[] args) {
        setValues(100);
    }

    public static void setValues(long value){
        a = (byte)value;
        b = (short)value;
        c = (int)value;
        d = value;
    }
}


--

public class Solution {
    long a = (long)(109 + 15);
    int b = (int)a * 2;
    short c = (short)(a / b);
    byte d = (byte)(a + b - c);
}
