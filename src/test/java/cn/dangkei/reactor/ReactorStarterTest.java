package cn.dangkei.reactor;

import reactor.core.publisher.Flux;

public class ReactorStarterTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Flux<Integer> ints = Flux.range(1, 4)
				.map(i->{
					if(i<5)return i;
					throw new RuntimeException("Got to 4");
				});
//		ints.subscribe(); 
		ints.subscribe(i->System.out.println(i),
				error->System.err.println("Error: "+error),
				()->{System.out.print("完成");},
				sub->{
					sub.request(10);
				});
		
	}

}
