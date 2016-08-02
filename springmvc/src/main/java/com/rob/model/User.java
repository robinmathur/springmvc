package com.rob.model;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonView;

@XmlRootElement(name="users")
public class User {
	
	public interface BasicDetail{}
	public interface FullDetail extends BasicDetail{};

	String firstName;
	String lastName;
	int age;
	
	public User(){
		
	}
	
	public User(String firstName, String lastName, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
	@JsonView(value=User.BasicDetail.class)
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	@JsonView(value=User.BasicDetail.class)
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@JsonView(value=User.FullDetail.class)
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + "]";
	}
	
	
}
