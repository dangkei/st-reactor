package cn.dangkei.reactor;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;

import reactor.core.publisher.Flux;

public class ReactorCreateTest {

	public static void main(String[] args) {
		Person person = new Person("Tom ");
		// TODO Auto-generated method stub
		Flux<String> foods = Flux.create(sink -> {
			person.registerListener(new PersonListener() {
				@Override
				public void doRun(Event event) {
					// TODO Auto-generated method stub

				}

				@Override
				public void doEat(String food) {
					// TODO Auto-generated method stub
					sink.next(food);
					
				}
			});
		});
		
		//foods.just("apple","bread").subscribe();
		//person.run();
		List<String> lfoods = new ArrayList<String>();
		lfoods.add("apple");
		lfoods.add("duck");
		person.registerListener(new PersonListener() {

			@Override
			public void doEat(String food) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void doRun(Event event) {
				// TODO Auto-generated method stub
				
			}}  );
		person.eat(lfoods);
	}

}
