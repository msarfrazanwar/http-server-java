import java.net.*;
import java.io.*;
import java.util.Date;
public class SimpleHTTPServer {

    public static void main(String arga[]){
        try{
            final ServerSocket server = new ServerSocket(8080);

            System.out.println("Listening for connection on port 8080.....");

             while (true){


                final Socket client = server.accept();
             // 1. Read HTTP request from the client socket
             // 2. Prepare an HTTP response
             // 3. Send HTTP response to the client
             // 4. Close the socket

            InputStreamReader isr =  new InputStreamReader(client.getInputStream());
            BufferedReader reader = new BufferedReader(isr);
            String line = reader.readLine();
            while (!line.isEmpty()) {
                System.out.println(line);
                line = reader.readLine();
            }


                Date today = new Date();
                String httpResponse = "HTTP/1.1 200 OK\r\n\r\n" + today;
                client.getOutputStream().write(httpResponse.getBytes("UTF-8"));

            }


        }catch(Exception e){
            System.out.println(e);
        }
    }
}
