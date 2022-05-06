package cn.dangkei.reactor;

import java.util.List;

import reactor.core.publisher.Flux;

public class Person {

	String name;

	public Person(String name) {
		this.name = name;
	}

	private PersonListener personListener;

	public void registerListener(PersonListener personListener) {
		this.personListener = personListener;
	}

	public void eat(List<String> foods) {
		if (personListener != null) {
			for(String food:foods) {
				this.personListener.doEat(food);
				System.out.println("人吃"+food);
			}
			
		}
		
	}

	public void run() {
		if (personListener != null) {
			Event event = new Event(this);
			this.personListener.doRun(event);
		}
		System.out.println("人跑步");
	}
}
