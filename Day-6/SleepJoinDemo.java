package day6;

class SleepJoinDemo extends Thread {
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println("Thread: " + Thread.currentThread().getName() + " - Count: " + i);
            
            try {
                Thread.sleep(1000); 
                // Delay of 1 second
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        SleepJoinDemo t1 = new SleepJoinDemo();
        SleepJoinDemo t2 = new SleepJoinDemo();

        t1.start();

        try {
            t1.join(); 
            // Wait for t1 to finish before t2 starts
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        t2.start();
    }
}
