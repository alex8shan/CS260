import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerThread implements Runnable {
	private ServerSocket serverSocket = null;
	private Socket socket = null;
	private InputStream inStream;
	private DataOutputStream outStream;			//Why assign it to null? Also I have to change it from outputStream because 
	//it does not have writeLong method.
	private int threadNum;
	private String fileName;

	public ServerThread(int threadNum, String fileName) {
		this.threadNum = threadNum;
		this.fileName = "part (" + threadNum + ") " + fileName;
		System.out.println("Thread " + threadNum + " for "+ this.fileName + " is created");
	}

    public void createSocket() 
    {
        try 
        {
        	//create Server and start listening
            serverSocket = new ServerSocket(8000 + threadNum);
            //accept the connection
            socket = serverSocket.accept();
            //fetch the streams
            inStream = new DataInputStream(socket.getInputStream());
            outStream = new DataOutputStream(socket.getOutputStream());
            System.out.println("Connected");
        }
        catch (IOException io) 
        {
            io.printStackTrace();
        }
    }
    
    public void sendFile()
    {
    	final int MAX_BUFFER = 1000;
    	byte [] data = null;
    	int bufferSize = 0;
    	try
    	{
    		//write the filename below in the File constructor
    		File file = new File(fileName);
    		FileInputStream fileInput = new FileInputStream(file);
    		//get the file length
    		long fileSize = file.length();
    		
    		System.out.println("File size at server is: " + fileSize + " bytes");
    		//first send the size of the file to the client
    		outStream.writeLong(fileSize);
    		outStream.flush();

    		//Now send the file contents
    		if(fileSize > MAX_BUFFER){
    			bufferSize = MAX_BUFFER;
    		} else {
    			bufferSize = (int)fileSize;
    		}
    		data = new byte[bufferSize];
    		
    		long totalBytesRead = 0;
    		while(true)
    		{
    			//read upto MAX_BUFFER number of bytes from file
    			int readBytes = fileInput.read(data);
    			//send readBytes number of bytes to the client
        		outStream.write(data);
        		outStream.flush();

        		//stop if EOF
    			if(readBytes == -1){//EOF
    				break;
    			}
    			totalBytesRead = totalBytesRead + readBytes;
    			
    			//stop if fileLength number of bytes are read
    			if(totalBytesRead == fileSize){
    				break;
    			}
    			//update fileSize for the last remaining block of data
    			if((fileSize-totalBytesRead) < MAX_BUFFER){
    				bufferSize = (int) (fileSize-totalBytesRead);
    			}
    			//reinitialize the data buffer
    			data = new byte[bufferSize];
    		}
    		fileInput.close();
    		serverSocket.close();
    		socket.close();
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }

	@Override
	public void run() {
        createSocket();
        sendFile();
		System.out.println("Server file finished transfering.");
	}

}
