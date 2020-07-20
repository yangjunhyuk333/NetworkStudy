package D_UDP.UDPFileSend;

import java.io.File;
import java.io.FileInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPFileSend {

    public static final String SENDFILE = "C:\\download\\a.txt"; //파일 경로
    public static final int PORT = 8000; //서버 포트
    public static final String SERVER_IP = "192.168.211.1"; //서버 주소

    public static void main(String[] args) {
        try {

            File file = new File(SENDFILE); //파일 정보

            //파일이 존재 하는지 여부를 검사 하고 존재 한다면 'true'를 반환
            if(file.exists()){

                DatagramSocket ds = new DatagramSocket(); //실제 데이터 의 전송을 책임 지는 DatagramSocket class 를 선언
                //데이터 공간 할당
                byte[] buff = new byte[10000];
                DatagramPacket dp; //주고 받을 데이터 와 관련된 DatagramPacket class 를 선언

                //1. 파일명
                String temp = file.getName(); //파일 명을 temp 변수에 저장
                
                //전달할 데이터 의 정보를 datagramPacket 에 저장
                dp = new DatagramPacket(
                        temp.getBytes(), //전달할 데이터
                        temp.length(), //전달 데이터 길이
                        InetAddress.getByName(SERVER_IP), //서버 주소
                        PORT //포트
                );
                
                //datagramPacket 을 datagramSocket 을 통해서 전송
                ds.send(dp);

                //2. 파일 사이즈
                temp = String.valueOf(file.length()); //파일 사이즈 를 temp 변수에 저장

                //전달할 데이터 의 정보를 datagramPacket 에 저장
                dp = new DatagramPacket(
                        temp.getBytes(), //전달할 데이터
                        temp.length(), //전달 데이터 길이
                        InetAddress.getByName(SERVER_IP), //서버 주소
                        PORT //포트
                );

                //datagramPacket 을 datagramSocket 을 통해서 전송
                ds.send(dp);

                //3. 파일 데이터

                //파일 경로를 담은 SENDFILE 변수를 FileInputStream class 로 경로 안에 있는 파일을 읽어 오는 코드
                FileInputStream fileInputStream = new FileInputStream(SENDFILE);

                int readSize = 0; //전달할 데이터 의 길이를 저장 하는 변수
                long totalSendData = 0; //총 데이터 의 길이를 저장 하는 변수

                //buff 의 크기 만큼 파일을 계속 읽어 오는 반복문 if readSize 가 -1이 되면 멈춘다.
                while((readSize = fileInputStream.read(buff)) != -1){

                    System.out.println("buff: " + fileInputStream.read(buff));

                    //10ms 딜레이
                    Thread.sleep(10);

                    //전달할 데이터 의 정보를 datagramPacket 에 저장
                    dp = new DatagramPacket(
                            buff, //전달할 데이터
                            readSize, //전달 데이터 길이
                            InetAddress.getByName(SERVER_IP), //서버 주소
                            PORT //서버 포트
                    );

                    //datagramPacket 을 datagramSocket 을 통해서 전송
                    ds.send(dp);

                    //총 데이터 의 크기를 저장
                    totalSendData += readSize;

                    //총 데이터 의 크기를 출력
                    System.out.println("send:  " + totalSendData);
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
