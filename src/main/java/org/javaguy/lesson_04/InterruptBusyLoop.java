/**
 * Created by fpolizzi on 10/21/26
 */
void main() throws InterruptedException {
    Thread counter = new Thread(() -> {
        long count = 0;
        while (!Thread.currentThread().isInterrupted()) {
            count++;
        }
        IO.println("counter: stopped after " + count + " increments");
    });

    counter.start();
    Thread.sleep(200);
    counter.interrupt();
    counter.join();
    IO.println("main: done");
}