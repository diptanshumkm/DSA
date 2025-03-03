/*
✅ Calling t1.start() does NOT immediately run t1; it depends on the CPU scheduler.
✅ The main thread continues execution unless it is blocked (e.g., using join()).
✅ join() makes the main thread wait until t1 completes execution.
✅ When join() is called, the main thread moves to the WAITING state until t1 finishes.
✅ Multithreading is unpredictable; we cannot assume a fixed order of execution.

 * ❓ Does t1.start() immediately start executing t1, stopping the main thread?
✔️ No! t1.start() only moves t1 to the RUNNABLE state; the CPU decides when it will execute. The main thread continues unless join() is used.



*/


public class MyThread {
    
    public static class InnerMyThread extends Thread {

        public void run(){
            try {

                /** 
                 * When `run()` starts executing, the thread moves from 
                 * RUNNABLE → RUNNING state.
                 */

                System.out.println(Thread.currentThread().getName()+ " is running...");



                /** 
                 * Thread goes into TIMED_WAITING state for 2000ms 
                 * (because of `Thread.sleep(2000)`).  
                 */


                Thread.sleep(2000);


                /** 
                 * After sleep ends, the thread moves back to the RUNNING state 
                 * and then finishes execution, moving to the TERMINATED state.  
                 */

                System.out.println(Thread.currentThread().getName() + " is finished...");
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
    

    public static void main(String[] args) {
        InnerMyThread t1 = new InnerMyThread();


        /** 
         * `t1` is in the NEW state (it hasn't started yet). 
         * Printing `t1.getState()` will show NEW.  
         */

        System.out.println(t1.getState());

        /** 
         * `start()` moves `t1` from NEW → RUNNABLE state, 
         * waiting for CPU to schedule it.  
         */

        t1.start();

        /** 
         * `t1` is now either in RUNNABLE or RUNNING state, 
         * depending on CPU scheduling. 
         */

        System.out.println("State: "+t1.getState());
        
        try {

            /** 
             * The main thread sleeps for 100ms.  
             * During this time, `t1` may start running.  
             */

            Thread.sleep(100);

            /** 
             * Checking `t1.getState()` while it's running. 
             * It should be in RUNNING or TIMED_WAITING (if `sleep(2000)` has started).
             */


            System.out.println("Thread state while running: " + t1.getState());
            
              /** 
             * `join()` makes the main thread wait until `t1` finishes execution.  
             * During this time, the main thread moves to WAITING state.
             */
            
            t1.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }


        /** 
         * After `join()`, `t1` has finished execution and moves to TERMINATED state.  
         * This final state is printed.
         */

        System.out.println(t1.getState());

    }
    
}
