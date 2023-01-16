package Practice.com1217;

class CustomStr {
    private String str;

    public CustomStr(String str) {
        this.str = str;
    }

    private boolean isChar(char[] splitedArray) {
        boolean result = true;
        char first = splitedArray[0];
        if(0 <= first && first < 128) {
            return true;
        }else {
            return false;
        }
    }

    public String firstWith() {
        char[] cArr = str.toCharArray();
        if (isChar(cArr)) {
            char[] temp = new char[1];
            temp[0] = cArr[0];
            return new String(temp);
        }else {
            byte[] bArr = str.getBytes();
            byte[] temp = new byte[3];
            for(int i = 0; i<temp.length; i++) {
                temp[i] = bArr[i];
            }
            return new String(temp);
        }
    }
}

public class strMethod {
    public static void main(String[] args) {
        CustomStr krStr = new CustomStr("안녕하세요");
        System.out.println(krStr.firstWith());
        CustomStr enStr = new CustomStr("*ello");
        System.out.println(enStr.firstWith());
    }
}
