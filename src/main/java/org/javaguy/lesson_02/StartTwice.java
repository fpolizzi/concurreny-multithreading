/**
 * Created by fpolizzi on 10/19/26
 */
void main() throws InterruptedException {
    Thread worker = new Thread(() -> IO.println("working"));
    worker.start();
    worker.join();
    worker.start();
}