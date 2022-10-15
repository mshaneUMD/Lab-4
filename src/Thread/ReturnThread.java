package Thread;

public class ReturnThread extends Thread{
	ThreadFrame threadFrame;
	
	public ReturnThread(ThreadFrame threadFrame){
		this.threadFrame = threadFrame;
	}
	public void run() {
		// add code here starting. it is a loop for computing factorial with 30 evaluations

		// Stay in this loop until the Compute Thread is finished.
		while(ComputeThread.i != 30) {
			// Update the result field.
			threadFrame.resultfield.setText("" + ComputeThread.result);

			// Wait one second before checking again if the computation is finished.
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		// add code stopping here

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println("The second thread is wrong");
		}
		threadFrame.resultfield.setText("" + ComputeThread.result);
		ComputeThread.result = 0;
		ComputeThread.i = 1;
		threadFrame.button.setText("re-computing");
	}
}