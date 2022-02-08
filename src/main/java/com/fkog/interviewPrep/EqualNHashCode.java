package com.fkog.interviewPrep;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class EqualNHashCode {
	public static void main(String[] args) {
		Person p1 = new Person(1);
		Person p2 = new Person(1);
		
		System.out.println(p1.equals(p2));
		
		Set<Person> set = new HashSet<>();
		
		set.add(p1);
		set.add(p2);
		
		System.out.println(set.size());
	}
}

class Person {
	private int age;

	Person(int age){
		this.age = age;
	}
	public int getAge() {
		return age;
	}
	@Override
	public int hashCode() {
		return Objects.hash(age);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return age == other.age;
	}

}