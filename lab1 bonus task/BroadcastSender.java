import java.net.*;
import java.io.*;
import java.util.*;


public class BroadcastSender {

 
    public static void main(String[] args) throws IOException {
        broadcast("Hello I am 16-15SW24", InetAddress.getByName("255.255.255.255"));
    }
 
    public static void broadcast(
      String broadcastMessage, InetAddress address) throws IOException {
        DatagramSocket socket = new DatagramSocket();
        socket.setBroadcast(true);
 
        byte[] buffer = broadcastMessage.getBytes();
 
        DatagramPacket packet 
          = new DatagramPacket(buffer, buffer.length, address, 4445);
        socket.send(packet);
        //socket.close();

        DatagramPacket packet1 
        = new DatagramPacket(buffer, buffer.length, address, 4446);
        socket.send(packet1);
        //socket.close();

        DatagramPacket packet2 
        = new DatagramPacket(buffer, buffer.length, address, 4447);
        socket.send(packet2);

        DatagramPacket packet3 
        = new DatagramPacket(buffer, buffer.length, address, 4448);
        socket.send(packet3);
    }

List<InetAddress> listAllBroadcastAddresses() throws SocketException {
      List<InetAddress> broadcastList = new ArrayList<>();
      Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
      while (interfaces.hasMoreElements()) {
          NetworkInterface networkInterface = interfaces.nextElement();

          if (networkInterface.isLoopback() || !networkInterface.isUp()) {
              continue;
          }

          networkInterface.getInterfaceAddresses().stream()
            .map(a -> a.getBroadcast())
            .filter(Objects::nonNull)
            .forEach(broadcastList::add);
      }
      return broadcastList;
}
}