package My_First_Project;

class ThreadWithRunnable implements Runnable {
    public void run() {
        try {
            Thread.sleep(10); // 0.01초간 스레드를 멈춤.
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
public class test67 {
    public static void main(String [] args){
        Thread thread0 = new Thread(new ThreadWithRunnable());
        thread0.start();
        System.out.println(thread0.getThreadGroup());

        ThreadGroup group = new ThreadGroup("myThread");
        group.setMaxPriority(7);
        
        Thread thread1 = new Thread(group, new ThreadWithRunnable());
        thread1.start();
        System.out.println(thread1.getThreadGroup());
    }
}
