/**
 * Created by fpolizzi on 10/21/26
 */
void main() throws InterruptedException {
    var poller = new Poller();
    Thread thread = new Thread(poller);
    thread.start();

    Thread.sleep(350);
    poller.stop();
    thread.join();
}

class Poller implements Runnable {
    private volatile boolean running = true;

    void stop() {
        running = false;
    }

    @Override
    public void run() {
        while (running) {
            IO.println("polling for new messages...");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
        IO.println("poller stopped");
    }
}