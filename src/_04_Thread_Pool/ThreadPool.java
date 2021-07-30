package _04_Thread_Pool;

import java.util.concurrent.ConcurrentLinkedQueue;

public class ThreadPool {
	Thread[] Threads;
	ConcurrentLinkedQueue<Task> TaskQueue;
	ThreadPool(int TotalThreads) {
		Threads = new Thread[TotalThreads];
		for (int Loop = 0; Loop < Threads.length; Loop++) {
			Threads[Loop] = new Thread(new Worker(TaskQueue));
		}
		TaskQueue = new ConcurrentLinkedQueue<Task>();
	}
	void addTask(Task Tsak) {
		TaskQueue.add(Tsak);
	}
	void start() {
		TaskQueue.forEach((S) -> {
			S.perform();
		});
	}
}
