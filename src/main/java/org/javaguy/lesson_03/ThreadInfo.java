/**
 * Created by fpolizzi on 10/20/26
 */
void main() throws InterruptedException {
    Thread worker = Thread.ofPlatform()
            .name("report-generator")
            .daemon(false)
            .priority(Thread.NORM_PRIORITY)
            .unstarted(() -> IO.println("generating report..."));

    printInfo(Thread.currentThread());
    printInfo(worker);
    worker.start();
    worker.join();
}

void printInfo(Thread thread) {
    IO.println("name=" + thread.getName()
            + " id=" + thread.threadId()
            + " state=" + thread.getState()
            + " daemon=" + thread.isDaemon()
            + " priority=" + thread.getPriority()
            + " virtual=" + thread.isVirtual());
}