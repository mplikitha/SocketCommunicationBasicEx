package com.ex.java.socketcomm.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientProgram {

	// Initializing Socket and I/O Stream
	private Socket socket = null;
	
	private DataInputStream inputStream = null;
	private DataOutputStream outputStream = null;

	public ClientProgram(String address, int port) {

		try {
			socket = new Socket(address, port);
			System.out.println("Connected");
			inputStream = new DataInputStream(System.in);
			outputStream = new DataOutputStream(socket.getOutputStream());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		String line = "";
		while (!line.equals("over")) {
			try {
				line = inputStream.readLine();
				outputStream.writeUTF(line);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
//closing connection
		try {
			inputStream.close();
			outputStream.close();
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		ClientProgram client = new ClientProgram("10.237.114.11", 8080);
	}

}
