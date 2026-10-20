/**
 * Created by fpolizzi on 10/20/26
 */
void main() throws InterruptedException {
    Thread heartbeat = new Thread(() -> {
        while (true) {
            IO.println("heartbeat");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                return;
            }
        }
    });
    heartbeat.setDaemon(true);
    heartbeat.start();

    Thread.sleep(700);
    IO.println("main finished, JVM exits even though heartbeat never stops");
}