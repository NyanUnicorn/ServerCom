package com;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ServerCom {


	public static void main(String[] args) throws IOException {
		String packageContent;
		String[] values;
		int number, skt;
		boolean open = true;
		List<IndividualSocket> socketList = new ArrayList<IndividualSocket>();
		ServerSocket mainSocket;
		skt=3331;
		do {
			try {
				mainSocket = new ServerSocket(3330);
				Socket ss=mainSocket.accept();
				Scanner sc = new Scanner(ss.getInputStream());
				PrintStream p = new PrintStream(ss.getOutputStream());
				packageContent = sc.next();
				values = packageContent.split(";");
				
						
			
				do{
					generateSocket(skt);
					p.println(skt);
					skt++;
					number = sc.nextInt();			
					
				}while (number>0);
				p.println(-1);
				
			}catch(Exception e) {
				
			}
		}while(open);
		mainSocket = null;

	}

	private static void generateSocket(int socket) {
		try {
			ServerSocket s = new ServerSocket(socket);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
