package mybatis;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import resulttype.*;

public class mybatis {
public static void main(String[] args){
	try {
		String resource = "cong.xml";
		InputStream inputStream;
		inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		List<Object> name =  session.selectList("selectroom");
		System.out.println(name);
		room room1= (room)name.get(0);
		room1.setId(11);
		room1.setPrice(13214);
		session.insert("insertroom",room1);
	    name =  session.selectList("selectroom");
		System.out.println(name);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	
}
}