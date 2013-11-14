package com.goetzmaster.wlan_communicator;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import android.content.Context;
import android.widget.Toast;

public class Communicator implements Runnable {
	private Context context;
	private DatagramSocket socket;
	private InetAddress ip;
	private int port;
	private DatagramPacket packet;
	private String data;
	
	public Communicator(String message,Context context) {
		try {
			this.socket = new DatagramSocket();
			this.ip = InetAddress.getByName("10.0.0.3");
			this.port = 8888;
			this.data = "";
			this.data= message;
			this.context = context;
		}catch (SocketException e) {
			// TODO Auto-generated catch block
			Toast.makeText(context, "Socket Error!", Toast.LENGTH_LONG).show();
		}catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			Toast.makeText(context, "Unknown Host!", Toast.LENGTH_LONG).show();
		}
	}
	@Override
	public void run() {
		try {
			byte[] m = data.getBytes();
			packet = new DatagramPacket(m,data.length(),this.ip,this.port);
			socket.send(packet);
			data="";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			Toast.makeText(context, "Sending failed!", Toast.LENGTH_LONG).show();
		}
		
	}
	
	

}
