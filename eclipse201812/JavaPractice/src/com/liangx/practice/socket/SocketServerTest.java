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
			System.out.println("*** 服务器即将启动，等待客户端的连接 ***");
			while (true) {
				socket = serverSocket.accept();
				ServerThread serverThread = new ServerThread(socket);
				serverThread.start();
				
				socketCount++;
				System.out.println("当前客户端连接数为：" + socketCount);
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
				System.out.println("我是服务端，客户端（" + socket.getInetAddress().getHostAddress() + "）说：" + line);
			}
			//关闭输入流
			//bReader.close();
			socket.shutdownInput();
			
			pWriter.write("欢迎您！");
			pWriter.flush();
			socket.shutdownOutput();
			//pWriter.close();
			
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}
}












