package cn.dangkei.reactor;

import reactor.core.publisher.Mono;

public class ReactorThreadTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		final Mono<String> mono = Mono.just("hello ");

		Thread t = new Thread(() -> mono.map(msg -> msg + "thread ").subscribe(v -> {
			System.out.println(v+Thread.currentThread().getName());
		}));
		t.start();
		t.join();
	}

}
