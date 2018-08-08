package redis;

import org.apache.commons.codec.digest.DigestUtils;

import redis.clients.jedis.Jedis;

public class redistest {
public static void main(String[] args) {
    //连接本地的 Redis 服务
    Jedis jedis = new Jedis("localhost");
    System.out.println("连接成功");
    //查看服务是否运行
    System.out.println("服务正在运行: "+jedis.ping());
    jedis.set("md5:opps","1");
    jedis.del("md5:opps");
    if(jedis.exists("md5:opps"))System.out.println("chenggong");
	System.out.println(DigestUtils.md5Hex("123456"));
	
}
}
