package com.japca.data;

/**
 * Created by Jakub krhovják on 4/7/18.
 */
//
public class PostData {

	private String name;

	private int age;

	public PostData() {
	}

	public PostData(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "PostData{" + "name='" + name + '\'' + ", age=" + age + '}';
	}
}


