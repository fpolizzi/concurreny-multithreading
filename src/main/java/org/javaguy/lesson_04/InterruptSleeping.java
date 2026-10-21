/**
 * Created by fpolizzi on 10/21/26
 */
void main() throws InterruptedException {
    Thread worker = new Thread(() -> {
        try {
            IO.println("worker: going to sleep for 10 seconds");
            Thread.sleep(10_000);
            IO.println("worker: woke up normally");
        } catch (InterruptedException e) {
            IO.println("worker: interrupted while sleeping, cleaning up and exiting");
        }
    });

    worker.start();
    Thread.sleep(500);
    IO.println("main: asking worker to stop");
    worker.interrupt();
    worker.join();
    IO.println("main: worker has stopped");
}