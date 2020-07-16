package C_TCP.TCPServerSocket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

//서버 소캣 클래스
public class ServerSocketMain {

    public static void main(String[] args) {

        try {

            ServerSocket serverSocket = new ServerSocket(6000); //서버를 6000포트로 해서 열어 둔다.
            System.out.println("waiting connect"); //클라이언트 가 접속 하기를 기다 린다.
            Socket socket = serverSocket.accept(); //소켓 접속 요청이 올때 까지 대기
            System.out.println("success connect client"); //접속 성공
            
            //출력을 위한 준비
            OutputStream outputStream = socket.getOutputStream(); //클라이언트 에 데이터 출력을 하기 위한 스트림 객체 생성
            PrintWriter out = new PrintWriter(outputStream, true); // 클라이언트 에서 데이터 출력을 위한 객체 생성
            
            //입력을 위한 준비
            InputStream input = socket.getInputStream(); //클라이언트 에서 입력 한 스트림 객체 생성
            BufferedReader in =  new BufferedReader(new InputStreamReader(input)); //클라이언트 에서 들어온 입력을 받아 오기
                                                                                    //위한 BufferedReader 객체 생성
            
            Scanner scanner = new Scanner(System.in); //입력을 위한 Scanner 객체 생성

            //무한 반복
            while (true){
                System.out.print("server input data : "); 
                String inputData = scanner.nextLine(); // 데이터 입력
                out.println(inputData); //클라이언트 에 서버에서 입력한 데이터 출력

                //클라이언트 에서 입력한 데이터 가 null 이 아니 라면
                if ((inputData = in.readLine()) != null){
                    //클라이언트 에서 보낸 메시지 출력
                    System.out.println("server rev : "+ inputData);
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
