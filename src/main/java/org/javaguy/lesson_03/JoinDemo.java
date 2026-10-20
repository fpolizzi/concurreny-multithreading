/**
 * Created by fpolizzi on 10/20/26
 */
void main() throws InterruptedException {
    Thread download = new Thread(() -> {
        for (int percent = 25; percent <= 100; percent += 25) {
            pause(200);
            IO.println("download " + percent + "%");
        }
    });

    download.start();
    IO.println("main: waiting for the download");
    download.join();
    IO.println("main: download finished, opening file");

    Thread slow = new Thread(() -> pause(5_000));
    slow.start();
    boolean finished = slow.join(Duration.ofMillis(300));
    IO.println("slow thread finished in time? " + finished);
    slow.interrupt();
}

void pause(long millis) {
    try {
        Thread.sleep(millis);
    } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
    }
}