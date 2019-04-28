import java.net.*;
import java.io.*;

public class MulticastReceiver2{

public static void main(String[] args)
{

try{

        MulticastSocket socket = new MulticastSocket(4446);
        InetAddress group = InetAddress.getByName("225.4.5.6");

        byte[] buf = new byte[256];

        socket.joinGroup(group);
        while (true) {
            DatagramPacket packet = new DatagramPacket(buf, buf.length);
            socket.receive(packet);
            String received = new String(
              packet.getData(), 0, packet.getLength());
            if ("end".equals(received)) {
                break;
            }

            System.out.println(received);
        }


        socket.leaveGroup(group);
        socket.close();}

        catch(Exception ex){

            ex.printStackTrace();
        }}}
