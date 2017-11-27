import java.nio.file.Path;

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
    public void partitionFiles( Path path){

    }

    /**
     * Creates 5 thread and a ServerSocket in each thread
     */
    public void creatThreads(){

    }

    public static void main(String[] args) {
        System.out.println("Client start!");
        TCPServer server = new TCPServer();
        server.partitionFiles();
    }
}
