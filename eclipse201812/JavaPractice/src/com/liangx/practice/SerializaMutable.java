package com.liangx.practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.ArrayList;

class Person implements Serializable{
	private int age;
	private String name;
	
	public Person(int age, String name) {
		this.age = age;
		this.name = name;
	}
	
	private void writeObject(ObjectOutputStream oos) throws IOException {
		oos.writeObject(new StringBuffer(this.name).reverse());
		oos.writeInt(this.age);
	}
	
	private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
		this.name = ((StringBuffer)ois.readObject()).reverse().toString();
		this.age = ois.readInt();
	}
	
	//将person序列化为数组
	private Object writeReplace() throws ObjectStreamException {
		ArrayList<Object> list = new ArrayList<>();
		list.add(name);
		list.add(age);
		return list;
	}
	
	
	public int getAge() {
		return this.age;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}

public class SerializaMutable {

	public static void main(String[] args) {
		
		File file = new File("./src/com/liangx/practice/mutable.txt");
		try(
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		){
			Person p = new Person(12, "liangx");
			oos.writeObject(p);
			//修改后的person再次序列化依旧不会改变
			//p.setAge(22);
//			oos.writeObject(p);
//			System.out.println(((Person)ois.readObject()).getAge());
			
			ArrayList<Object> list = (ArrayList<Object>)ois.readObject();
			System.out.println(list.getClass().getName());
			System.out.println((String)list.get(0));
			System.out.println((Integer)list.get(1));
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
