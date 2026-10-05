/**
 * Created by fpolizzi on 9/6/26
 */

void main() throws InterruptedException {
    Thread worker = new Thread(() -> {
        try {
            Thread.sleep(60_000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }, "sleepy-worker");
    worker.start();
    worker.join();
}