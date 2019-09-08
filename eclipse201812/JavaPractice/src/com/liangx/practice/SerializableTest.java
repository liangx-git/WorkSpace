package com.liangx.practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class People implements Serializable{
	
	private String name;
	private int age;
	
	public People(String name, int age) {
		this.name = name;
		this.age = age;
		System.out.println("有参构造函数");
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
}


public class SerializableTest {

	public static void main(String[] args) throws IOException, ClassNotFoundException{
		File file = new File("./src/com/liangx/practice/object.txt");
		try(
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		){
			oos.writeObject(new People("liangx", 24));
			People p = (People)ois.readObject();
			System.out.println(p.getClass().getName() + ", name = " + p.getName() + ", age = " + p.getAge());
		}
		
		

	}

}
