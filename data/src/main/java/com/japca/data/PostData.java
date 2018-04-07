package com.japca.data;

/**
 * Created by Jakub krhovják on 4/7/18.
 */
public class PostData {

	final String name;

	final int age;

	public PostData(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "PostData{" + "name='" + name + '\'' + ", age=" + age + '}';
	}
}


