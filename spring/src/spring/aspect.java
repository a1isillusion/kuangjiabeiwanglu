package spring;

import java.util.concurrent.Future;

import org.springframework.stereotype.Component;

@Component(value="aspect")
public class aspect {
public void before() {
	System.out.println("before fuck");
}
public void after() {
	System.out.println("after fuck");
}
}
