package com;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Divider {
	
	String packageContent, clientIp;
	String[] values;
	int number, skt;
	boolean open = true;
	
	List<IndividualSocket> socketList = new ArrayList<IndividualSocket>();

	public Divider() {
		super();
		
		ServerSocket mainSocket;
		skt=3331;
		do {
			try {
				mainSocket = new ServerSocket(3330);
				Socket ss=mainSocket.accept();
				Scanner scanner = new Scanner(ss.getInputStream());
				PrintStream p = new PrintStream(ss.getOutputStream());
				packageContent = scanner.next();
				values = packageContent.split(";");
				if(values[2] != "close") {
					clientIp = values[0];
					generateSocket(clientIp, skt);
					p.println(skt);
					skt++;
					mainSocket = null;
				}else {
					close();
					}
			}catch(Exception e) {
				
			}
		}while(open);
		mainSocket = null;

	}

	public void generateSocket(String ip_address, int socket) {
		Thread socketThread;
		IndividualSocket s = new IndividualSocket(ip_address, socket);
		socketThread = new Thread(s);
		socketThread.start();
	}
	
	public void close() {
		open = false;
	}

}
