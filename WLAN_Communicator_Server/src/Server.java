import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.nio.ByteBuffer;


public class Server {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			DatagramSocket serverSocket = new DatagramSocket(8888);
			byte[] data = new byte[1024];
			String message="";
			
			
			while(true){
				DatagramPacket receivedData = new DatagramPacket(data, data.length);
				
				
				serverSocket.receive(receivedData);
				data = receivedData.getData();
				for(int x=0;x<data.length;x++){
					if(data[x]!=0){
						char y=(char) data[x];
						message+=y;
					}
				}
				System.out.println(message);
				data = new byte[1024];
				message ="";
				
			}
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			System.out.println("SocketException:"+e.getMessage());
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("IOException:"+e.getMessage());
		}
	}

}
