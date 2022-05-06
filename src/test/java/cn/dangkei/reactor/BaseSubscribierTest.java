package cn.dangkei.reactor;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import org.reactivestreams.Subscription;

import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;

public class BaseSubscribierTest {
	public static void main(String[] args) {
		
		SampleSubscriber<Integer> ss = new SampleSubscriber<Integer>();
		Flux<Integer> ints = Flux.range(1, 4);
		//ints.subscribe(ss);
		
		
		Flux.range(1, 10)
	    .doOnRequest(r -> System.out.println("request of " + r))
	    .subscribe(new BaseSubscriber<Integer>() {
	      @Override
	      public void hookOnSubscribe(Subscription subscription) {
	        request(1);
	      }
	      @Override
	      public void hookOnNext(Integer integer) {
	        System.out.println("Cancelling after having received " + integer);
	        request(1);
	        cancel();
	      }
	    });
		
	}
}
