package com.liangx.practice.socket;

import java.net.Socket;
import java.net.ServerSocket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class SocketServerTest {

	public static void main(String[] args) {
		try (
			ServerSocket serverSocket = new ServerSocket(8899);	
		) {
			Socket socket = null;
			int socketCount = 0;
			System.out.println("*** �����������������ȴ��ͻ��˵����� ***");
			while (true) {
				socket = serverSocket.accept();
				ServerThread serverThread = new ServerThread(socket);
				serverThread.start();
				
				socketCount++;
				System.out.println("��ǰ�ͻ���������Ϊ��" + socketCount);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class ServerThread extends Thread {
	
	private Socket socket;
	
	public ServerThread(Socket socket) {
		this.socket = socket;
	}
	
	public void run() {
		try(
			BufferedReader bReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter pWriter = new PrintWriter(socket.getOutputStream());
		) {
			String line = null;
			while ((line = bReader.readLine()) != null) {
				System.out.println("���Ƿ���ˣ��ͻ��ˣ�" + socket.getInetAddress().getHostAddress() + "��˵��" + line);
			}
			//�ر�������
			//bReader.close();
			socket.shutdownInput();
			
			pWriter.write("��ӭ����");
			pWriter.flush();
			socket.shutdownOutput();
			//pWriter.close();
			
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}
}












