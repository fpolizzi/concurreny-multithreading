/**
 * Created by fpolizzi on 10/15/26
 */
void main() throws InterruptedException {
    long start = System.currentTimeMillis();

    cook("Chopping vegetables", 600);
    cook("Grilling steak", 800);
    cook("Plating dessert", 400);

    IO.println("Total: " + (System.currentTimeMillis() - start) + " ms");
}

void cook(String task, long millis) throws InterruptedException {
    IO.println(task + "...");
    Thread.sleep(millis);
    IO.println(task + " done");
}