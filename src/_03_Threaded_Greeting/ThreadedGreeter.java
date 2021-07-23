package _03_Threaded_Greeting;

public class ThreadedGreeter implements Runnable {
	int Num;
	ThreadedGreeter(int Num) {
		this.Num = Num;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Hello from thread " + this.Num);
		if (Num < 50) {
			new ThreadedGreeter(Num + 1).run();
		}
	}

}
