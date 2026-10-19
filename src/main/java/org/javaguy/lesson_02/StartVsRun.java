/**
 * Created by fpolizzi on 10/19/26
 */
void main() throws InterruptedException {
    Thread worker = new Thread(() -> IO.println("Running on: " + Thread.currentThread().getName()), "worker");

    worker.run();

    worker.start();
    worker.join();
}