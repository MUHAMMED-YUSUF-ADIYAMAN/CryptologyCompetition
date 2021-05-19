import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SecondQuestion {


    public static void main(String[] args) {
        int sayac=0;

         ArrayList DISTNAME=new ArrayList();
        URL url;
        try {
            url = new URL("https://mii.com.tr/media/il_ilceler.xml");

        String sukur = new Scanner(url.openStream(), "UTF-8").useDelimiter("\\A").next();

        String GpRegex =
                "<DISTNAME[^>]*>(.*?)<\\s*/\\s*DISTNAME>\\s*.*\\s*" ;


        Pattern groupPattern = Pattern.compile(GpRegex);
        Matcher groupMatcher = groupPattern.matcher(sukur);
        while (groupMatcher.find()) {

            DISTNAME.add(groupMatcher.group(1));
          //  System.out.println(groupMatcher.group(1));
        }

        } catch (IOException e) {
            e.printStackTrace();
        }
        String enuzun = "mya";
        for(int num=0; num<DISTNAME.size(); num++)
        {
                int lenght=DISTNAME.get(num).toString().length();
                int bp=  0;
                String Kelime = (String) DISTNAME.get(num);
            for(int i=lenght-1;i>=0 ;i-- )
            {
                for(int j=i-1;j>=0;j--)
                {
                   if(Kelime.charAt(j) == Kelime.charAt(i)) {
                       bp=1;
                       break;
                   }

                }
            }

            if(bp==0)
            {
                System.out.println(Kelime);
                if(enuzun.length()<Kelime.length())
                    enuzun=Kelime;
            }
            bp=0;
        }
        System.out.println(enuzun+"-"+enuzun.length());

        }
    }


