package B_Runnable.RunnableStudy;

public class RunnableExample implements Runnable{

    public void printSleep(){
        System.out.println("난 잘거야!");
    }

    @Override
    public void run() {
        try {

            Thread.sleep(500);

           for (int i = 1; i < 4; i++){
               System.out.println(i + "초");

               Thread.sleep(1000);
           }

           Thread.sleep(500);

        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("잘잤당!!");
    }
}
