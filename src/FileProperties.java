import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileProperties {
    private int countLines;
    private int countChars;
    private int countBytes;
    private int countWords;
    File file;


    public FileProperties(File file) throws IOException {
        this.countLines = 0;
        this.countChars = 0;
        this.countBytes = 0;
        this.countWords = 0;
        this.file = file;

        FileReader fr = new FileReader(file);

        BufferedReader bufferedReader = new BufferedReader(fr);
        String s;
        while((s = bufferedReader.readLine()) != null) {
            this.countLines++;
            this.countChars += s.length();
            this.countBytes += s.getBytes(StandardCharsets.UTF_8 ).length;


            s = s.toLowerCase();
            boolean isThisWord = false;
            for(int i=0; i<s.length(); i++) {
                if(s.charAt(i) >= 97 && s.charAt(i) <= 122) {
                    isThisWord = true;
                }
                else if ((s.charAt(i) < 97 || s.charAt(i) > 122) && isThisWord) {
                    countWords++;
                    isThisWord = false;
                }
            }

        }




    }

    public int getCountLines(){
        return this.countLines;
    }

    public int getCountChars()  {
        return this.countChars;
    }
    public int getCountBytes() {
        return this.countBytes;
    }
    public int getCountWords() {
        return this.countWords;
    }
}
