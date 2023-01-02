package com.solvd.hospital.threads;

public class DeadLock {
    static class People {
        private final String name;
        public People (String name) {
            this.name = name;
        }
        public String getName() {
            return this.name;
        }
        public synchronized void bow(People bower) {
            System.out.format("%s: %s" + "  has bowed to me!%n", this.name, bower.getName());
            bower.bowBack(this);
        }
        public synchronized void bowBack(People bower) {
            System.out.format("%s: %s"
                            + " has bowed back to me!%n",
                    this.name, bower.getName());
        }
    }

    public static void main(String[] args) {
        final People alphonse =
                new People("Alphonse");
        final People gaston =
                new People("Gaston");
        new Thread(new Runnable() {
            @Override
            public void run() {
                // System.out.println("Thread 1");
                alphonse.bow(gaston);
                // System.out.println("Th: gaston bowed to alphonse");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                //  System.out.println("Thread 2");
                gaston.bow(alphonse);
                //  System.out.println("2.gaston waiting alph bowed");
            }
        }).start();
    }
}
