/*
 * 1️⃣ start()
✅ Starts a new thread and calls the run() method internally.
✅ Moves the thread from the NEW state to the RUNNABLE state.
✅ A thread can only be started once; calling start() again throws IllegalThreadStateException.

2️⃣ run()
✅ Defines the task that the thread will execute when started.
✅ If called directly like a normal method (without start()), it runs in the main thread, not a new thread.

3️⃣ sleep(milliseconds)
✅ Temporarily pauses the thread for a specified time.
✅ The thread moves to the TIMED_WAITING state.
✅ After sleep time completes, the thread goes back to RUNNABLE.
✅ Throws InterruptedException if interrupted while sleeping.

4️⃣ join()
✅ Makes the current thread wait until the specified thread (t1.join()) finishes execution.
✅ Moves the current thread to the WAITING state.
✅ Used to ensure a thread completes before another thread continues execution.

5️⃣ setPriority(int priority)
✅ Sets the priority of a thread (values range from 1 (MIN_PRIORITY) to 10 (MAX_PRIORITY)).
✅ Priority influences but does not guarantee execution order (depends on OS scheduling).

6️⃣ interrupt()
✅ Used to stop or wake up a sleeping/waiting thread.
✅ Throws InterruptedException if the thread is in sleep(), wait(), or join().
✅ If the thread is running, it just sets an internal flag (isInterrupted() returns true).

7️⃣ yield()
✅ Hints the scheduler that the current thread is willing to pause execution to let other threads run.
✅ Does not stop the thread; it only suggests giving CPU time to another thread of the same or higher priority.
✅ The OS may ignore this request, so execution is unpredictable.

8️⃣ setDaemon(true)
✅ Marks a thread as a daemon thread, which runs in the background and stops when all user threads finish.
✅ Used for tasks like garbage collection and background services.
✅ Must be called before start(), otherwise it throws IllegalThreadStateException.

 */

 public class SomeFunc{
    
    public static class InnerSomeFunc extends Thread{
        @Override
        public void run(){
            
            for(int i =0; i<=5; i++){
                System.out.println(Thread.currentThread().getName() + " running: "+ i);
                // Thread.yield();
            }
            
          
        }
        
    }

    public static void main(String[] args) throws InterruptedException {
        InnerSomeFunc t1 = new InnerSomeFunc();
        // InnerSomeFunc t2 = new InnerSomeFunc();
        // t2.start();        

        t1.setDaemon(true);

        t1.start();
        System.out.println("Main done");



    }
}