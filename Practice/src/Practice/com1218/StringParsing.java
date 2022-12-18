package Practice.com1218;

class CustomString {
    private String str;
    private char[] charArr = new char[0];
    public CustomString(String str) {
        this.str = str;
    }

    public CustomString(char[] charArr) {
        this(new String(charArr));
    }

    public CustomString(char[] charArr, boolean isRaw) {
        char[] copyArr = new char[charArr.length];
        for(int i = 0; i<copyArr.length;i ++) {
            copyArr[i] = charArr[i];
        }
        this.charArr = copyArr;
//        this.charArr = charArr;
    }

    public void show() {
        System.out.println(str);
    }

    public char[] strToChar() {
        return this.str.toCharArray();
    }


}

public class StringParsing {
    public static void main(String[] args) {
        char[] cArr = "hello world!".toCharArray();
        CustomString str = new CustomString(cArr);
        str.show();
    }
}
