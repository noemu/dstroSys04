package de.unistgt.ipvs.vs.ex4.distributed_debugging_algorithm;

//you are not allowed to change this class structure
public class DebugTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO
		/*
		 * To check part (b) set testpart to (1).
		 * To check part (b) and (c) set testpart to (2).
		 */
		int testpart = 1;
		boolean testResult = false;
		switch (testpart) {
		case 1:
			testResult = testPartb();
			break;
		case 2:
			testResult = testPartbc();
			break;
		}

		if (testResult)
			System.out.println("Test succeeded!");
		else
			System.out.println("Test failed!");
	}

	/**
	 * - check if the local variable values are correct.
	 * - check if the predicates check results are correct.
	 * - check only part (b).
	 */
	private static boolean testPartb() throws InterruptedException {

		System.out.println("Check only part (b) from the question (4)");

		// instantiation and run threads
		int numberOfProcesses = 2;
		Monitor monitor = new Monitor(numberOfProcesses);
		AbstractProcess[] processes = new AbstractProcess[numberOfProcesses];

		Process1 process1 = new Process1(monitor, processes, 0);
		processes[0] = process1;

		Process2 process2 = new Process2(monitor, processes, 1);
		processes[1] = process2;

		Thread process1Thread = new Thread(process1);
		Thread process2Thread = new Thread(process2);
		Thread monitorThread = new Thread(monitor);

		process1Thread.start();
		process2Thread.start();

		monitorThread.start();

		process1Thread.join();
		process2Thread.join();

		monitorThread.join();

		// checking ---------------

		// check local variables
		if (processes[0].getLocalVariable() != 10)
			return false;
		if (processes[1].getLocalVariable() != 25)
			return false;

		// check predicates
		boolean[] possiblyTruePredicatesIndex = monitor.getPossiblyTruePredicatesIndex();
		boolean[] definitelyTruePredicatesIndex = monitor.getDefinitelyTruePredicatesIndex();

		// predicate0
		if (possiblyTruePredicatesIndex[0] != true)
			return false;
		if (definitelyTruePredicatesIndex[0] != true)
			return false;

		// predicate1
		if (possiblyTruePredicatesIndex[1] != true)
			return false;
		if (definitelyTruePredicatesIndex[1] != false)
			return false;

		// predicate2
		if (possiblyTruePredicatesIndex[2] != false)
			return false;
		if (definitelyTruePredicatesIndex[2] != false)
			return false;

		return true;
	}

	/**
	 * - check if the local variable values are correct
	 * - check if the predicates check results are correct.
	 * - check part (b) and part (c).
	 */
	private static boolean testPartbc() throws InterruptedException {

		System.out.println("Check part (b)  and part (c) from the question (4)");

		// instantiation and run threads
		int numberOfProcesses = 3;
		Monitor monitor = new Monitor(numberOfProcesses);
		AbstractProcess[] processes = new AbstractProcess[numberOfProcesses];

		Process1 process1 = new Process1(monitor, processes, 0);
		processes[0] = process1;

		Process2 process2 = new Process2(monitor, processes, 1);
		processes[1] = process2;

		Process3 process3 = new Process3(monitor, processes, 2);
		processes[2] = process3;

		Thread process1Thread = new Thread(process1);
		Thread process2Thread = new Thread(process2);
		Thread process3Thread = new Thread(process3);
		Thread monitorThread = new Thread(monitor);

		process1Thread.start();
		process2Thread.start();
		process3Thread.start();

		monitorThread.start();

		process1Thread.join();
		process2Thread.join();
		process3Thread.join();

		monitorThread.join();

		// checking ---------------

		// check local variables
		if (processes[0].getLocalVariable() != 1)
			return false;
		if (processes[1].getLocalVariable() != 25)
			return false;
		if (processes[2].getLocalVariable() != 11)
			return false;

		// check predicates
		boolean[] possiblyTruePredicatesIndex = monitor.getPossiblyTruePredicatesIndex();
		boolean[] definitelyTruePredicatesIndex = monitor.getDefinitelyTruePredicatesIndex();

		// predicate0
		if (possiblyTruePredicatesIndex[0] != true)
			return false;
		if (definitelyTruePredicatesIndex[0] != true)
			return false;

		// predicate1
		if (possiblyTruePredicatesIndex[1] != true)
			return false;
		if (definitelyTruePredicatesIndex[1] != false)
			return false;

		// predicate2
		if (possiblyTruePredicatesIndex[2] != false)
			return false;
		if (definitelyTruePredicatesIndex[2] != false)
			return false;

		// predicate3
		if (possiblyTruePredicatesIndex[3] != true)
			return false;
		if (definitelyTruePredicatesIndex[3] != true)
			return false;

		return true;
	}
}
