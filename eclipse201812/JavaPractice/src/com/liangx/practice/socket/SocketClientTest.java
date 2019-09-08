package com.liangx.practice.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketClientTest {

	public static void main(String[] args) {
		try(
			//�����ͻ��˵�socket���Ӷ���
			Socket socket = new Socket("localhost", 8899);
			//����soket���Ӷ����ȡ������
			BufferedReader bReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//����socket���Ӷ����ȡ�����
			PrintWriter pWriter = new PrintWriter(socket.getOutputStream());
		) {
			//�����˷�����Ϣ
			pWriter.write("�û�����liangx; ���룺lx220807");
			pWriter.flush();
			
			//�ر�socket���������
			//pWriter.close();
			socket.shutdownOutput();
			
			String line = null;
			while ((line = bReader.readLine()) != null) {
				System.out.println("���ǿͻ��ˣ������˵��" + line);
			}
			
			//�ر����봦����
			socket.shutdownInput();
			//bReader.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
