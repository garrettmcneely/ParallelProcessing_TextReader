package lab14_McNeely;

public class MyThread extends Thread{
	
	String text;
	
	public int count;
	
	
	public MyThread(String text)
	{
		this.text = text;
	}
	
	  @Override
	    public void run()
	    {
	        this.count = 0;
	        char[] characters = this.text.toCharArray();
	        
	     
	  /*      try
	        {
	        	this.sleep(5000);
	        }
	    	catch (InterruptedException ex)
	        {
	    		ex.printStackTrace();
	        }
     */
	        

	        for(int i = 0; i < characters.length - 3; i++)
	        {
	            if(characters[i] == 't')
	            {
	                if(characters[i + 1] == 'h')
	                {
	                    if(characters[i + 2] == 'e')
	                    {
	                        this.count++;
	                    }
	                }
	            }
	        }
	    }

	

}
