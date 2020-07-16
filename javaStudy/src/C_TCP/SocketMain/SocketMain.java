package C_TCP.SocketMain;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class SocketMain {
    public static void main(String[] args) {

        try {

            InetAddress inet = InetAddress.getByName("google.com");
            Socket socket = new Socket(inet, 80);
            System.out.println("connect : " + socket.isConnected());
            PrintStream out = new PrintStream(socket.getOutputStream());
            out.println("GET / HTTP/1.1");
            out.println("Host: google.com");
            out.println("User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_0)" + " AppleWebKit/537.36 (KHTML, like Gecko)"
            + " Chrome/30.0.1599.101 Safari/537.36");
            out.println();

            InputStream input = socket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(input);
            BufferedReader in = new BufferedReader(inputStreamReader);

            String line = "";
            while( (line = in.readLine()) != null){
                System.out.println(line);
            }
            in.close();

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
