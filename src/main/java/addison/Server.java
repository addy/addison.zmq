package addison;

import org.zeromq.SocketType;
import org.zeromq.ZContext;
import org.zeromq.ZMQ;

public class Server
{
   public static void main(String[] args)
   {
      try (ZContext context = new ZContext())
      {
         // Socket to talk to clients
         ZMQ.Socket socket = context.createSocket(SocketType.REP);
         socket.bind("tcp://*:22317");

         while (!Thread.currentThread().isInterrupted())
         {
            byte[] reply = socket.recv(0);
            System.out.println("Received " + ": [" + new String(reply, ZMQ.CHARSET) + "]");
            socket.send(reply, 0);
         }
      }
   }
}
