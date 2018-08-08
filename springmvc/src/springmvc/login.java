package springmvc;  
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.RequestMapping;   
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import redis.clients.jedis.Jedis;  
@Controller  
public class login 
{  
  @RequestMapping("/login")
  public String login(HttpServletRequest request) {
	  Cookie[] cookies=request.getCookies();
	  for(Cookie cookie : cookies){
          if(cookie.getName().equals("md5")) {
        	  Jedis jedis = new Jedis("localhost");
        	  if(jedis.exists("md5:"+cookie.getValue())) {
        		  jedis.close();
        		  return "success.jsp";
        		  }
          }
      }
	  return "redirect:login.jsp";
  }
	
	
	
  @RequestMapping("/save")  
  public ModelAndView save(HttpServletRequest request,user user,HttpSession httpSession,HttpServletResponse response)  
  {   Jedis jedis = new Jedis("localhost");
      jedis.set("md5:"+DigestUtils.md5Hex(user.name+"redissalt"+user.password),"1");
      Cookie cookie=new Cookie("md5",DigestUtils.md5Hex(user.name+"redissalt"+user.password));
      cookie.setMaxAge(5*60);
      response.addCookie(cookie);
      ModelAndView mov=new ModelAndView();  
      mov.setViewName("success.jsp");
     // mov.addObject("userlist", userlist);
      jedis.close();
      return mov;  
  }  
  
 
  @RequestMapping("/quit")
  public String quit(HttpServletRequest request,HttpServletResponse response) {
	  Cookie[] cookies=request.getCookies();
	  for(Cookie cookie : cookies){
          if(cookie.getName().equals("md5")) {
        	  Jedis jedis = new Jedis("localhost");
        	  jedis.del("md5:"+cookie.getValue());
        	  jedis.close();
          }
      }
	  Cookie cookie=new Cookie("md5", "null");
	  cookie.setMaxAge(0);
	  response.addCookie(cookie);
	  return "login.jsp";
  }
  
  @RequestMapping("/sa")  
  public ModelAndView sa(HttpServletRequest request,user user,HttpSession httpSession)  
  {  
      ModelAndView mov=new ModelAndView();  
      mov.setViewName("success.jsp");
      user user1=new user();
      user1.name="gjb";
      user1.password="12345gjb";
      List<user> userlist=new ArrayList<user>();
      userlist.add(user1);
     // mov.addObject("userlist", userlist);
      return mov;  
  } 
}  