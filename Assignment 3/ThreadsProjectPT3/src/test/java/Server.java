import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Server implements Runnable {
	BlockingQueue<Task> queue;//are sincronizare intre add si get
    AtomicInteger waitingTime; 
    
    
    public Server()
    {
    	  queue=new LinkedBlockingQueue<Task>();
    	  waitingTime=new AtomicInteger(0); 
    }
    
	public AtomicInteger getWaitingTime() {
		return waitingTime;
	}

	public void setWaitingTime(AtomicInteger waitingTime) {
		this.waitingTime = waitingTime;
	}

	public void run() {
		// TODO Auto-generated method stub
		Task curT = null;
		while (true){
		try {
			
			curT = queue.take();
			System.out.println("Start processing task : " +curT);
			Thread.sleep(curT.getProcessTime()*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     waitingTime.addAndGet((-1)*curT.getProcessTime());
		}
	}
	
	void addTask(Task t){
		queue.add(t);
		waitingTime.addAndGet(t.getProcessTime());
	}
	
	
	Task[] getTasks(){
		Task[] tasks=new Task[queue.size()];
		queue.toArray(tasks);
		return tasks;
		
	}
	
	public BlockingQueue<Task> getQueue() {
		return queue;
	}

	public void setQueue(BlockingQueue<Task> queue) {
		this.queue = queue;
	}

	public boolean isEmpty() {
		return queue.isEmpty();
	}
  
}
