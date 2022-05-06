package cn.dangkei.reactor;

public class Event {
	private Person person;

	public Event(Person person) {
		this.person = person;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
}
