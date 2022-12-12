package by.grsu.rogachevskay.main;

import by.grsu.rogachevskay.immovables.db.model.Person;

public class Main {

	public static void main(String[] args) {
		System.out.println("run program");

		Person person = new Person();
		person.setId(1);

		System.out.println(person);

	}

}
