package _04_Thread_Pool;

import java.util.concurrent.ConcurrentLinkedQueue;

public class Worker implements Runnable {
	ConcurrentLinkedQueue<Task> TaskQueue;
	Worker(ConcurrentLinkedQueue<Task> TaskQueue) {
		this.TaskQueue = TaskQueue;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (!TaskQueue.isEmpty()) {
			TaskQueue.remove().perform();
		}
	}


}
