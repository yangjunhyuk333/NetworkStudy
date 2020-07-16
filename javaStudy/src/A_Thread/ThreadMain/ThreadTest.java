package A_Thread.ThreadMain;

import A_Thread.ThreadStudy.ThreadExample;

public class ThreadTest {
    public static void main(String[] args) {
        ThreadExample threadExample = new ThreadExample();

        threadExample.printSleep();
        threadExample.start();
    }
}
