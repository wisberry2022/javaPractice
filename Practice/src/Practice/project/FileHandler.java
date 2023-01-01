package Practice.project;

import java.io.*;

class FileHandler {

    static final int READ = 0;
    static final int WRITE = 1;

    private File readFile;
    private File writeFile;
    private InputStream is = null;
    private OutputStream os = null;
    private BufferedInputStream bis = null;
    private BufferedOutputStream bos = null;

    FileHandler() {}

    FileHandler(String filename, int num) {
        if(num == 0) {
            this.readFile = new File(filename);
            this.createReadFile();
        }else if(num == 1) {
            this.writeFile = new File(filename);
            this.createWriteFile();
        }else {
            System.out.println("wrong input!");
        }

    }

    FileHandler(String readFile, String writeFile) {
        this.readFile = new File(readFile);
        this.writeFile = new File(writeFile);
        this.createReadFile();
        this.createWriteFile();
    }

    // readFile, writeFile 설정
    public FileHandler setRead(String readFile) {
        this.readFile = new File(readFile);
        this.createReadFile();
        return this;
    }

    public FileHandler setWrite(String writeFile) {
        this.writeFile = new File(writeFile);
        this.createWriteFile();
        return this;
    }

    public void setRW(String readFile, String writeFile) {
        this.readFile = new File(readFile);
        this.writeFile = new File(writeFile);
    }

    // InputStream 설정 메소드
    public void settingInput() {
        try {
            is = new FileInputStream(readFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void settingBis() {
        bis = new BufferedInputStream(is);
    }

    // OutputStream 설정 메소드
    public void settingBos() {
        bos = new BufferedOutputStream(os);
    }

    public void settingOutput() {
        try {
            os = new FileOutputStream(writeFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    // read 메소드
    public String read() {
        byte[] temp = new byte[(int)this.readFile.length()];
        try {
            for(int i = 0; i<temp.length; i++) {
                temp[i] = (byte)is.read();
            }
            return new String(temp);
        } catch (IOException e) {
            e.printStackTrace();
            return "error";
        }
    }

    public String Bufferead() {
        byte[] bArr = new byte[(int)this.readFile.length()];
        try {
            int su;
            String msg = "";
            for(int i = 0; i<bArr.length; i++) {
                bArr[i] = (byte)bis.read();
            }
            return new String(bArr);
        } catch (IOException e) {
            e.printStackTrace();
            return "error";
        }
    }

    // write 메소드
    public void write(String msg) {
        try {
            byte[] bArr = msg.getBytes();
            os.write(bArr);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void bufferWrite(String msg) {
        try {
            byte[] bArr = msg.getBytes();
            bos.write(bArr);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    // io close 메소드
    public void iClose() {
        try {
            if(is != null) is.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void bisClose() {
        if(bis != null)
            try {
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    public void oClose() {
        try {
            if(os != null) os.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void bosClose() {
        try {
            if(bos != null) bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void ioClose() {
        try {
            if(is != null) this.is.close();
            if(os != null) this.os.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    // private method
    private void createReadFile() {
        try {
            if(!readFile.exists()) readFile.createNewFile();
            else return;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createWriteFile() {
        try {
            if(!writeFile.exists()) writeFile.createNewFile();
            else return;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}