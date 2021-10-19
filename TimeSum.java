import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TimeSum {

    public static void main(String[] args) throws IOException, ParseException {
        readFile("C:\\Users\\yi\\Desktop\\时刻表.txt");
    }


    static void readFile(String filePath) throws IOException, ParseException {

        FileInputStream fin = new FileInputStream(filePath);
        InputStreamReader reader = new InputStreamReader(fin);
        BufferedReader buffReader = new BufferedReader(reader);
        String strTmp = "";
        int second = 0;
        int min = 0;


        while((strTmp = buffReader.readLine())!=null){

            String pattern = "\\d{2}:\\d{2}";
            Pattern compile = Pattern.compile(pattern);
            Matcher matcher = compile.matcher(strTmp);

            if (matcher.find()){
                String group = matcher.group(0);
                String[] split = group.split(":");
                min += Integer.parseInt(split[0]);
                second += Integer.parseInt(split[1]);
            }

        }
        int sumsec = min*60 + second;

        int allmin = sumsec / 60;
        int ressec = sumsec % 60;
        int reshour = allmin / 60;
        int resmin = allmin % 60;
        System.out.println("总时间为"+reshour+":"+resmin+":"+ressec);


        buffReader.close();

    }
}
