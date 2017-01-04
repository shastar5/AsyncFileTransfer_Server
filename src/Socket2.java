    import java.io.*;
import java.net.*;

public class Socket2 {

    public static void main(String[] args) throws IOException {
    	
    	// Port number
    	int port = 1156;
    	
    	// filesize temporary hardcoded
        int filesize=6022386; 
        
        // Get time to examine elapsed time
        long start = System.currentTimeMillis();
        
        int bytesRead;
        int current = 0;
        String filepath;

        // create socket
        ServerSocket servsock = new ServerSocket(port);
        
	        while (true) {
	        System.out.println("Waiting...2");
	
	        java.net.Socket sock = servsock.accept();
	        System.out.println("Accepted connection2 : " + sock);
	        	
	       
	        // receive file
	        byte [] mybytearray  = new byte [filesize];
	        InputStream is = sock.getInputStream();
	        
	        filepath = ("/Users/smartear/Desktop/" + System.currentTimeMillis() + ".mp4");
	        FileOutputStream fos = new FileOutputStream(filepath);
	        System.out.println(filepath);
	        
	        // destination path and name of file
	        BufferedOutputStream bos = new BufferedOutputStream(fos);
	        bytesRead = is.read(mybytearray,0,mybytearray.length);
	        current = bytesRead;
	
	        // start transferring
	        do {
	           bytesRead =
	              is.read(mybytearray, current, (mybytearray.length-current));
	           if(bytesRead >= 0) current += bytesRead;
	           System.out.println(bytesRead);
	        } while(bytesRead > -1);
	
	        bos.write(mybytearray, 0 , current);
	        bos.flush();
	        long end = System.currentTimeMillis();
	        
	        // Display elapsed time
	        System.out.println(end-start);
	        
	        // Close bufferstream and socket
	        // Do not need to care about it
	        bos.close();
	        sock.close();
          }
    }

}