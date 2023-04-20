package sg.edu.nus.iss;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class App 
{
    public static void main( String[] args ) throws NumberFormatException, IOException
    {
        // 2 arguments
        // 1 argument for file
        // 1 argument for the port the server will start on

        String fileName = args[0];
        String port = args[1];

        // check if cookie file exists
        // close program if it does not exist

        File cookieFile = new File(fileName);
        if (!cookieFile.exists()) {
            System.out.println("Cookie file not found!");
            System.exit(0);
        }

        // establish server connection

        ServerSocket ss = new ServerSocket(Integer.parseInt(port));
        Socket socket = ss.accept();

        // store the data sent over from the client, e.g. get-cookie
        String msgReceived = "";

        // allows server to read/write over the communication channel
        try (InputStream is = socket.getInputStream()) {
            BufferedInputStream bis = new BufferedInputStream(is);
            DataInputStream dis = new DataInputStream(bis);
            
            try (OutputStream os = socket.getOutputStream()) {
                BufferedOutputStream bos = new BufferedOutputStream(os);
                DataOutputStream dos = new DataOutputStream(bos);

                // write our logic to receive and send
                while (!msgReceived.equals("close")) {
                    // slide 9 - receive message
                    msgReceived = dis.readUTF();

                    if (msgReceived.equals("get-cookie")) {
                        // instantiate Cookie.java
                        // get a random cookie
                        // send the random cookie out using DataOutputStream (dos.writeUTF(xxxxx))
                    }


                    // slide 10 - send message



                }
                
                // closes all output streams in reverse order
                dos.close();
                bos.close();
                os.close(); 

            } catch (EOFException e) {
            e.printStackTrace();
            }

            // closes all input streams in reverse order
            dis.close();
            bis.close();
            is.close();

        } catch (EOFException e) {
            socket.close();
            ss.close();
        }
    }
}
