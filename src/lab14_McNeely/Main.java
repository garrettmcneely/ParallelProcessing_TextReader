package lab14_McNeely;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		String textFile = "";
		
		try
        {
            BufferedReader br = new BufferedReader(new FileReader("alice.txt"));

            String lineOne = "";

            while(lineOne != null)
            {
                textFile += lineOne;
                lineOne = br.readLine();
            }

            br.close();
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("File was not found.");
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
		
		
		
		
		
        MyThread myThread1 = new MyThread(textFile.substring(0, textFile.length() / 4));
         
        MyThread myThread2 = new MyThread(textFile.substring(textFile.length() / 4, (textFile.length() / 4) * 2));

        MyThread myThread3 = new MyThread(textFile.substring((textFile.length() / 4) * 2, (textFile.length() / 4) * 3));

        MyThread myThread4 = new MyThread(textFile.substring((textFile.length() / 4) * 3));

        
        
        myThread1.run();
        myThread2.run();
        myThread3.run();
        myThread4.run();
		
		System.out.println("Starting parallel counting \"the\"....");
		
		try
        {
            myThread4.join();
            
            System.out.println("Finished parallel counting \"the\".");
        }
        catch (InterruptedException ex)
        {
            ex.printStackTrace();
        }
		

		
		int count = myThread1.count + myThread2.count + myThread3.count+ myThread4.count ;
        System.out.println("Number of times \" the \" appeared: " + count);
		
		
	}

}
