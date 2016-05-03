
public class Simulator implements Runnable{//task generator

	int time_limit=100;// time data structure jodaTime
	int minProcTime=1;//sec
	int maxProcTime=10;//sec
	Scheldular s;
	SimulatorFrame frame;
	
	public Simulator()
	{
	    s=new Scheldular();
		frame=new SimulatorFrame("SIMULATION");	
	}
	
	
	public void run() {
		// TODO Auto-generated method stub
		int currentTime=0;//jodatIME;
		while(currentTime<time_limit){ //cand iese din while sa continui sa fac display daca mai am taskuri
			currentTime++;
			int processTime=(int) (Math.random()*(maxProcTime-minProcTime)+minProcTime);
			///the arrival time is the current time
			Task t=new Task(currentTime,processTime);
			System.out.println("Generate task : " + t);
			s.dispatchThreadOnServer(t);
			
			frame.displayData(s.getServer().getTasks());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		while(!s.isDone()){
			frame.displayData(s.getServer().getTasks());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	public static void main(String[] args)
	{
		Simulator sim=new Simulator();
		Thread th =new Thread(sim);
		th.start();
	}
}
