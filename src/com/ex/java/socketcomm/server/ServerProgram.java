package com.ex.java.socketcomm.server;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerProgram {
	
	//initialize socket and i/p stream
	private Socket socket=null;
	private ServerSocket server=null;
	private DataInputStream input=null;
	
	public ServerProgram(int port) {
		
		try {
			server=new ServerSocket(port);
			System.out.println("server started");
			System.out.println("waiting for client..");
			
			socket=server.accept();
			System.out.println("client accepted");
			
			// takes input from the client socket
			input = new DataInputStream(
			new BufferedInputStream(socket.getInputStream()));
			
			String line="";
			while(!line.equals("over")) {
				line=input.readUTF();
				System.out.println(line);
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("closing the connection");
		try {
			input.close();
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		ServerProgram server=new ServerProgram(8080);
	}

}
