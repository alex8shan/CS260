/**
 * The TCP client will:
 1. Create 5 threads and a Socket object in each thread
 2. Each Socket object will request a connection to the corresponding Server's thread
 3. Once connection is established it will then accept a file partition from the Server and save it onto the disk
 4. Once all 5 threads are done downloading: the client program will then merge these 5 downloaded partitions into one file and save it onto the disk.
 * @author Minghao Shan
 * @version 11/22/2017
 */
public class TCPClient {
    //5 thread downloads files into 5 separated files.

    /**
     * Create 5 threads and a Socket object in each thread
     */
    public void creatThreads(){
    	for(int i = 0 ; i < 5; i++){
    		
    	}
    }

    /**
     *
     */
    public void mergeFile(String fileName){
    	
    }

    public static void main(String[] args) {
        System.out.println("Client start!");

        TCPClient client = new TCPClient();
        client.mergeFile("test.txt");
    }
}
