package version.thread.creation.logic;

public class ThreadSampleDemo {

    public static void nap() {
        try{
            Thread.sleep(5000);
        } catch(Exception ex) {

        }

    }

    public static void main(String[] args) throws InterruptedException {
        int MAX = 10000000;

        Thread thread = null;
        for (int i = 0; i < MAX; i++) {
           thread = new Thread(ThreadSampleDemo::nap);
           thread.start();
        }

        System.out.println("Started " + MAX + " threads");
        thread.join();
        System.out.println("done");
    }
}
