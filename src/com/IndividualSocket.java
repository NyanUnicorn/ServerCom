package com;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class IndividualSocket implements Runnable {
	
	int number, socket_number;
	String client_ip;
	boolean assigned;
	ServerSocket s1;

	public IndividualSocket(String client_ip, int socket_number) {
		this.client_ip = client_ip;
		this.socket_number = socket_number;
		
	}


	public void run() {
		
		do {
			try {
				s1 = new ServerSocket(socket_number);
				Socket ss=s1.accept();
				Scanner sc = new Scanner(ss.getInputStream());
				PrintStream p = new PrintStream(ss.getOutputStream());
				number = sc.nextInt();
				assigned = true;
						
			
				do{

					p.println(number*2);
					number = sc.nextInt();			
					
				}while (number>0);
				p.println(-1);
				
			}catch(Exception e) {
				
			}
		}while(!assigned);
		s1 = null;
	}

}
