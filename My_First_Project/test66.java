package My_First_Project;

class ThreadWithRunnable implements Runnable {
    public void run(){
        for ( int i = 0; i< 5; i++){
            System.out.print((Thread.currentThread().getName()));
            try {
                Thread.sleep(10);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}


public class test66 {
    public static void main(String [] args){
        Thread thread1 = new Thread(new ThreadWithRunnable());
        Thread thread2 = new Thread(new ThreadWithRunnable());
        
        thread2.setPriority(10);
        thread1.start();
        thread2.start();

        System.out.println(thread1.getPriority());
        
        System.out.println(thread2.getPriority());
    }
}
