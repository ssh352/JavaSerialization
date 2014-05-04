package tcw.serialzation;

public class HelperUtils {

    final private static char[] hexArray = "0123456789ABCDEF".toCharArray();

    public static char[] bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return hexChars;
    }

    public static String prettyHex32bit(char[] chars, int columns) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            sb.append(chars[i]);
            if ((i + 1) % (columns * 2) == 0) {
                sb.append("\n");
            } else if ((i + 1) % 2 == 0) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static String prettyHex16(byte[] bytes) {
        char[] chars = bytesToHex(bytes);
        return prettyHex32bit(chars, 16);
    }

}
