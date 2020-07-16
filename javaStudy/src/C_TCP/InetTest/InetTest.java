package C_TCP.InetTest;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class InetTest {

    public static void main(String[] args) {

        try{

            URL url = new URL("http://google.com:80");
            URLConnection uc = url.openConnection();
            InputStream input = uc.getInputStream();
            ReadableByteChannel sockCannel = Channels.newChannel(input);

            ByteBuffer buffer = ByteBuffer.allocate(1280);
            System.out.println("buffer : " + buffer);
            int readSize = sockCannel.read(buffer);
            System.out.println("read data : " + readSize);

            if(readSize > 0){
                String str = new String(buffer.array());
                System.out.println(str);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
