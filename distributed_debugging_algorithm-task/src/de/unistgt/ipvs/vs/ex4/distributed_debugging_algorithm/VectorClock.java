package de.unistgt.ipvs.vs.ex4.distributed_debugging_algorithm;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

//you are not allowed to change this class structure
public class VectorClock {

	protected int[] vectorClock;
	private int processId;
	private int numberOfProcesses;

	public VectorClock(int processId, int numberOfProcesses) {
		vectorClock = new int[numberOfProcesses];
		this.numberOfProcesses = numberOfProcesses;
		this.processId = processId;
	}

	VectorClock(VectorClock other) {
		vectorClock = other.vectorClock.clone();
		processId = other.processId;
		numberOfProcesses = other.numberOfProcesses;

	}

	public void increment() {
		vectorClock[processId] += 1;

	}

	public int[] get() {
		// TODO
		// Complete a code to return the vectorClock value
		return vectorClock;

	}

	public void update(VectorClock other) {
		// TODO
		/*
		 * Implement Supermum operation
		 */
		int[] otherArray = other.get();

		for(int index = 0; index < numberOfProcesses; index++){
			vectorClock[index] = Math.max(vectorClock[index],otherArray[index]);
		}


	}

	public boolean checkConsistency(int otherProcessId, VectorClock other) {
		int[] otherArray = other.get();

		boolean firstCon =  otherArray[otherProcessId] >= vectorClock[otherProcessId];
		boolean secondCon = vectorClock[processId] >= otherArray[processId];


		return firstCon && secondCon;
		//TODO
		/*
		 * Implement a code to check if a state is consist regarding two vector clocks (i.e. this and other).
		 * See slide 41 from global state lecture.
		 */


	}

}
