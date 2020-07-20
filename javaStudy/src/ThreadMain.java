import static java.lang.Thread.sleep;

public class ThreadMain {
    public static void main(String[] args) {
        new Thread(() -> {
            try {
                sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println("안녕");

        }).start();

        new Thread(() -> {
            try {
                sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println("잘잤다!");

        }).start();
    }
}
