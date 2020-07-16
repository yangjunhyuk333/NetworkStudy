package D_UDP.UDPFileReceiver;

import java.io.FileOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPFileReceiver {

    public static final int PORT = 8000; //포트
    public static final String DOWNLOAD = "C:\\download\\test.txt"; //받은 파일을 저장할 파일 경로

    public static void main(String[] args) {
        try {
            
            DatagramSocket datagramSocket = new DatagramSocket(PORT);//실제 데이터 의 전송을 책임 지는 DatagramSocket class 를 선언
            
            //서버 시작
            System.out.println("udp server start");

            //데이터 를 받을 공간 할당
            byte[] buff = new byte[10000];

            //주고 받을 데이터 와 관련된 DatagramPacket class 를 선언, buff 사이즈 만큼 받아 오는 데이터 양 설정
            DatagramPacket datagramPacket = new DatagramPacket(buff, buff.length); //packet 안에는 buff, buff 사이즈

            //datagramSocket 으로 packet 의 데이터 를 받아 온다.
            datagramSocket.receive(datagramPacket);

            //받은 데이터 를 파일로 저장
            FileOutputStream fileOutputStream = new FileOutputStream(DOWNLOAD);

            //1. 파일명 받아 오기
            String temp = new String(datagramPacket.getData()).trim();
            System.out.println("file name : " + temp);

            //2. 파일 용량
            datagramPacket.setData(new byte[1000000]);
            datagramSocket.receive(datagramPacket);

            //temp 변수에 파일 용량 받아 와서 저장
            temp = new String(datagramPacket.getData()).trim();

            //파일 용량 출력
            System.out.println("file size : " + temp);
            
            //파일 용량 저장
            long fileSize = Long.parseLong(temp);

            //3. 파일 전송
            long totalSize = 0; //총 파일 용량
            int readSize = 0; //읽어 온 파일 용량
            
            //무한 반복
            while (true){
                //datagramSocket 받아 오기
                datagramSocket.receive(datagramPacket);

                //readSize 에 buff 만큼의 파일 용량 받아서 저장
                readSize = datagramPacket.getLength();

                //총 파일 용량에 계속 더해줌
                totalSize += readSize;

                //파일 데이터 저장(경로는 DOWNLOAD)
                fileOutputStream.write(datagramPacket.getData(), datagramPacket.getOffset(), datagramPacket.getLength());

                //총 파일 용량이 이전에 저장 해둔 fileSize 의 값보다 크거나 같다면 반복문 탈출
                if(totalSize >= fileSize){
                    break;
                }
            }

            //총 파일 용량 출력
            System.out.println("totalSize: " + totalSize);

            //파일 저장 완료
            System.out.println("file save Complete");
            
            //파일 저장 종료
            fileOutputStream.close();
            
            //os 포트 반환
            datagramSocket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
