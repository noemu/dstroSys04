package de.unistgt.ipvs.vs.ex4.distributed_debugging_algorithm;

//you are not allowed to change this class structure
public class Process3 extends AbstractProcess {
	private VectorClock vectorClock;

	public Process3(Monitor monitor, AbstractProcess[] processes, int Id) {
		super(monitor, processes, Id);

		vectorClock = new VectorClock(this.Id, this.numberOfProcesses);
	}

	@Override
	public void run() {
		
		//TODO Implement processes3 (Listing 4) code here!
		
	}

}
