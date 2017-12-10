import java.net.Socket;
import java.io.*;

public class ClientThread implements Runnable{
	private Socket socket = null;
    private DataInputStream inStream = null;
    private DataOutputStream outStream = null;
    private int threadNum;
	//wait for file to download -> await termination
	public ClientThread(int threadNum){
		this.threadNum = threadNum;
	}
	
	public void createSocket()
    {
        try 
        {
        	//connect to localHost at given port #
            socket = new Socket("localhost", 8000 + threadNum);
            System.out.println("Connected");
            //fetch the streams
            inStream = new DataInputStream(socket.getInputStream());
            outStream = new DataOutputStream(socket.getOutputStream());
        } 
        catch (Exception u) 
        {
            u.printStackTrace();
        } 
    }

    public void receiveFile()
    {
    	byte [] data = null;
    	//decide the max buffer size in bytes
    	//a typical value for a tcp payload is 1000 bytes, this is because of
    	//the common MTU of the underlying ethernet of 1500 bytes
    	//HOWEVER their is no optimal value for tcp payload, just a best guess i.e. 1000 bytes
    	final int MAX_BUFFER = 1000;
    	try
    	{
    		//read the size of the file <- coming from Server
    		long fileSize = inStream.readLong();
    		
    		int bufferSize=0;
    		
    		//decide the data reading bufferSize
    		if(fileSize > MAX_BUFFER)
    			bufferSize = MAX_BUFFER;
    		else
    			bufferSize = (int)fileSize;
    		
    		data = new byte[bufferSize];
    		
    		//insert the path/name of your target file
    		FileOutputStream fileOut = new FileOutputStream("movie.mkv",true);		
    		
    		//now read the file coming from Server & save it onto disk
  
    		long totalBytesRead = 0;
    		while(true)
    		{
    			//read bufferSize number of bytes from Server
    			int readBytes = inStream.read(data,0,bufferSize);
    			int stringLength = inStream.read(data);
    			something = inStream.read(data, stringLength)

    			byte[] arrayBytes = new byte[readBytes];
    			System.arraycopy(data, 0, arrayBytes, 0, readBytes);
    			totalBytesRead = totalBytesRead + readBytes;
    			
    			if(readBytes>0)
    			{
    				//write the data to the file
    				fileOut.write(arrayBytes);
    	    		fileOut.flush();
    			}

    			//stop if fileSize number of bytes are read
    			if(totalBytesRead == fileSize)
    				break;
    			
    			//update fileSize for the last remaining block of data
    			if((fileSize-totalBytesRead) < MAX_BUFFER)
    				bufferSize = (int) (fileSize-totalBytesRead);
    			
    			//reinitialize the data buffer
    			data = new byte[bufferSize];
    		}
    		System.out.println("File Size is: "+fileSize + ", number of bytes read are: " + totalBytesRead);
    		
    		socket.close();
    		fileOut.close();
    		inStream.close();
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
	//1000 bytes to 10000 bytes.
	//byte buffer array of 1000 bytes
    @Override
	public void run() {
        createSocket();
        receiveFile();
	}

}
