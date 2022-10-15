package Thread;

public class ComputeThread implements Runnable{
	ThreadFrame threadframe ;
	static public double result = 0;
	static public int i;
	String str1 = "";
	public ComputeThread(ThreadFrame t) {
		threadframe = t;
	}
	public void run() {
		long s=1;
		for(i=1;i<=30;i++)
		{
			//add code starting here

			// Write in the factorial expression (1!+2!...+30!).
			str1 += str1.isBlank() ? i + "!" : "+" + i + "!";

			// Multiply the current value of i by the previous factorial value. This calculates the factorial of i. (i! = (i-1)! * i).
			s *= i;

			// Add i! to the result.
			result += s;

			// Update the text of the output field.
			threadframe.output.setText(str1);

			// Update the progress of the progress bar.
			threadframe.jprogressBar.setValue(i);

			//add code stopping here

			try {
				Thread.sleep((long)(500 + 500 * Math.random()));
			} catch (InterruptedException e) {
				
				e.printStackTrace();
				System.out.println("Error in the first thread");
			}

		}
	}
}