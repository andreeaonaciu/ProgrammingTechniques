
public class Scheldular {
	Server server;//lista de servere
	/// multithreading partea asta se schimba si partea de afisare
	
	
	public Scheldular() {
		this.server = new Server();
		Thread th=new Thread(server);
		th.start();
	}

	public Server getServer() {
		return server;
	}

	public void setServer(Server server) {
		this.server = server;
	}
	
	public Task[] getTasks(){
		return server.getTasks();// cand o sa am mai multe serveruri colectie de taskuri
	}
	void dispatchThreadOnServer(Task t){
		System.out.println("Dispatch task on server :"  + t + "0");
		server.addTask(t);		
	}
	
	boolean isDone(){
		return server.isEmpty();
	}

}
