package com.liangx.practice.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketClientTest {

	public static void main(String[] args) {
		try(
			//建立客户端的socket连接对象
			Socket socket = new Socket("localhost", 8899);
			//根据soket连接对象获取输入流
			BufferedReader bReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//根据socket连接对象获取输出流
			PrintWriter pWriter = new PrintWriter(socket.getOutputStream());
		) {
			//向服务端发送消息
			pWriter.write("用户名：liangx; 密码：lx220807");
			pWriter.flush();
			
			//关闭socket输出流对象
			//pWriter.close();
			socket.shutdownOutput();
			
			String line = null;
			while ((line = bReader.readLine()) != null) {
				System.out.println("我是客户端，服务端说：" + line);
			}
			
			//关闭输入处理流
			socket.shutdownInput();
			//bReader.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
