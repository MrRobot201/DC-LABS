import java.net.*;
import java.io.*;

public class MultiSender {
    public static void main(String[] args){
          // this application sends message using connectionless datagram socket
     if(args.length!=1)
         System.out.println("this program requires one command line argument");
     else{
         try{
            
    DatagramSocket socket = new DatagramSocket();
    InetAddress group = InetAddress.getByName("225.4.5.6");
    String multicastMessage = args[0];

    byte[] buf = multicastMessage.getBytes();
    
    DatagramPacket packet 
          = new DatagramPacket(buf, buf.length, group, 4446);
        socket.send(packet);
        socket.close();


         }
         catch(Exception e){
             e.printStackTrace();
         }
     } 
     }
     }