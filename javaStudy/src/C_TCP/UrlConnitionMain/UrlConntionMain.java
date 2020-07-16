package C_TCP.UrlConnitionMain;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class UrlConntionMain {

    public static void main(String[] args) {
        try {

            URL url = new URL("http://google.com:80");
            URLConnection uc = url.openConnection();
            InputStream input = uc.getInputStream();
            InputStreamReader inReader = new InputStreamReader(input);
            BufferedReader in = new BufferedReader(inReader);

            String line = "";
            while((line = in.readLine()) != null){
                System.out.println(line);
            }
            in.close();

        } catch (Exception e){
            e.printStackTrace();
        }

    }

}
