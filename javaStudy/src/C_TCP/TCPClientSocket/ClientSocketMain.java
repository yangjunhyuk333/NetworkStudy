package C_TCP.TCPClientSocket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

//클라이언트 소캣 클래스
public class ClientSocketMain {

    public static void main(String[] args) {
        try {

            InetAddress inet = InetAddress.getLocalHost(); //로컬 호스트 를 이용한 inetAddress 객체 생성
            Socket socket = new Socket(inet, 6000); //socket 객체 생성 (ip 주소와 포트를 받는다.)
            System.out.println("connecting"); //connecting 출력

            OutputStream outputStream = socket.getOutputStream(); //서버 에 데이터 출력을 하기 위한 스트림 객체 생성
            PrintWriter out = new PrintWriter(outputStream, true); //서버 에 데이터 출력을 위한 PrintWriter 객체 생성

            InputStream inputStream = socket.getInputStream(); //서버 에서 입력 한 스트림 객체 생성
            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream)); //서버 에서 들어온 입력을 받아 오기
                                                                                        //위한 BufferedReader 객체 생성

            Scanner sc = new Scanner(System.in); //Scanner 객체 생성

            //무한 반복
            while(true) {
                String inputData = ""; //데이터 를 입력 받을 변수 선언

                //서버 에서 입력한 inputData 에 값이 null 이 아니 라면
                if((inputData = in.readLine()) != null){
                    //서버 에서 입력한 메시지 출력
                    System.out.println("Client rev : " + inputData);
                }

                //클라이언트 가 입력 받기를 기다 린다.
                System.out.println("client input data : ");

                //데이터 를 입력 받는다.
                inputData = sc.nextLine();

                //메시지 를 서버 에서 출력 한다.
                out.println(inputData);

                //위의 내용 들을 무한 반복
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
