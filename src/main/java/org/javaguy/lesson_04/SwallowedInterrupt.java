/**
 * Created by fpolizzi on 10/21/26
 */
void main() throws InterruptedException {
    Thread broken = new Thread(() -> worker("broken", false));
    Thread fixed = new Thread(() -> worker("fixed", true));

    broken.start();
    fixed.start();
    Thread.sleep(300);

    broken.interrupt();
    fixed.interrupt();

    fixed.join();
    broken.join(Duration.ofSeconds(2));
    IO.println("broken thread still alive after 2s? " + broken.isAlive());
    System.exit(0);
}

void worker(String name, boolean restoreInterrupt) {
    while (!Thread.currentThread().isInterrupted()) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            if (restoreInterrupt) {
                Thread.currentThread().interrupt();
            }
        }
    }
    IO.println(name + ": stopped cleanly");
}