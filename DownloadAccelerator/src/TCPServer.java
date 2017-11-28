import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * The TCP server will:
 1. Partition the source file into 5 equal parts
 2. Create 5 threads and a ServerSocket in each thread
 3. Each ServerSocket will accept the connection from a client and will then send a partition to the client
 * @author Minghao Shan
 * @version 11/22/2017
 */
public class TCPServer {
    /**
     * Partition the source file into 5 equal parts
     * @param path
     */
	public static void splitFile(Path path) throws IOException
	{
		int size = (int) Files.size(path);
		int extraSize = size%5;
		int splitSize = size/5; 
		BufferedReader bReader = new BufferedReader(new FileReader(path.toString()));

		for(int i = 0; i < 5; i++)
		{
			File file = new File( i + path.toString());
			BufferedWriter bWriter = new BufferedWriter(new FileWriter(file));
			if(extraSize > 0)
			{
				//reads a single character
				for(int j = 0; j < (splitSize + 1); j++)
				{
					char data = (char) bReader.read();
					bWriter.write(data);
				}
				extraSize--;
			}
			else
			{
				for(int j = 0; j < (splitSize); j++)
				{
					char data = (char) bReader.read();
					bWriter.write(data);
				}
			}
			bWriter.close();
			System.out.println("File " + i +" has finished");
		}
		bReader.close();
	}

    /**
     * Creates 5 thread and a ServerSocket in each thread
     */
    public void createThreads(){

    }

    public static void main(String[] args) {
        System.out.println("Server start!");
        TCPServer server = new TCPServer();
        //split the files
        try {
			server.splitFile(Paths.get("test.txt"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //create 5 threads
        
    }
}
