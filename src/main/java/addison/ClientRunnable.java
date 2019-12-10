package addison;

import org.zeromq.SocketType;
import org.zeromq.ZContext;
import org.zeromq.ZMQ;

public class ClientRunnable implements Runnable
{
   private Thread thread;
   private final String threadName;
   
   public ClientRunnable(String threadName)
   {
      this.threadName = threadName;
   }

   @Override
   public void run()
   {
      try (ZContext context = new ZContext())
      {
         ZMQ.Socket socket = context.createSocket(SocketType.REQ);
         socket.connect("tcp://localhost:22317");

         for (int i = 0; i != 1000; i++)
         {
            socket.send(String.valueOf(Integer.parseInt(threadName) * 31 + i * 53).getBytes(ZMQ.CHARSET), 0);
            socket.recv(0);
         }
      }
   }

   public void start()
   {
      if (thread == null)
      {
         thread = new Thread(this, threadName);
         thread.start();
      }
   }
}
