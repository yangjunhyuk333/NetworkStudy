package B_Runnable.RunnableMain;

import B_Runnable.RunnableStudy.RunnableExample;

public class RunnableTest {
    public static void main(String[] args) {
        RunnableExample runnableExample = new RunnableExample();

        runnableExample.printSleep();
        runnableExample.run();
    }
}
