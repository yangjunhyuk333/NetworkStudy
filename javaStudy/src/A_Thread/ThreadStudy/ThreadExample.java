package A_Thread.ThreadStudy;

public class ThreadExample extends Thread{

    //나 3초만 잘게 출력 함수
    public void printSleep(){
        System.out.println("나 3초만 잘게");
    }

    //쓰레드 작업
    @Override
    public void run() {

        //try: 작업을 실행 할 코드(애러가 발생 할 수 있는 코드)
        //catch: 오류가 나면 수행 되는 코드(오류 출력)

        try {

            //3초 카운트 출력
            for (int i = 1; i < 4; i++){

                System.out.println("시간: " + i + "초");

                sleep(1000);
            }

        }catch (InterruptedException e){
            e.printStackTrace();
        }
        
        System.out.println("잘잤다!");
    }
}
