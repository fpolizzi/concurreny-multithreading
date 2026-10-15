/**
 * Created by fpolizzi on 10/16/26
 */
void main() throws InterruptedException {
    long start = System.currentTimeMillis();

    Thread chop = new Thread(() -> cook("Chopping vegetables", 600));
    Thread grill = new Thread(() -> cook("Grilling steak", 800));
    Thread plate = new Thread(() -> cook("Plating dessert", 400));

    chop.start();
    grill.start();
    plate.start();

    chop.join();
    grill.join();
    plate.join();

    IO.println("Total: " + (System.currentTimeMillis() - start) + " ms");
}

void cook(String task, long millis) {
    IO.println(task + "...");
    try {
        Thread.sleep(millis);
    } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        return;
    }
    IO.println(task + " done");
}