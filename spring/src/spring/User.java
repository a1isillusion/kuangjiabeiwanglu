package spring;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component(value="User")
public class User {
public void say(){
    
	System.out.println("fuck you");
}

}
