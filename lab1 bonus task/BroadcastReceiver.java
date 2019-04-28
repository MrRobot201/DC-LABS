import java.net.*;
import java.io.*;

public class BroadcastReceiver{
public static void main(String[] args)
{
if (args.length!=1)
System.out.println("This program requires a command line argument");
else
{
int port =Integer.parseInt(args[0]);
final int MAX_LEN=10;

try
{

DatagramSocket mySocket= new DatagramSocket(port);
byte[] buffer= new byte[MAX_LEN];
DatagramPacket datagram= new DatagramPacket(buffer, MAX_LEN);
mySocket.receive(datagram);
String message= new String(buffer);
System.out.println(message);
Thread.sleep(10000);
System.out.print("Exiting");
mySocket.close(); }


catch(Exception ex)

{ 
    ex.printStackTrace();
}}}}
