package redis;

import org.apache.commons.codec.digest.DigestUtils;

import redis.clients.jedis.Jedis;

public class redistest {
public static void main(String[] args) {
    //���ӱ��ص� Redis ����
    Jedis jedis = new Jedis("localhost");
    System.out.println("���ӳɹ�");
    //�鿴�����Ƿ�����
    System.out.println("������������: "+jedis.ping());
    jedis.set("md5:opps","1");
    jedis.del("md5:opps");
    if(jedis.exists("md5:opps"))System.out.println("chenggong");
	System.out.println(DigestUtils.md5Hex("123456"));
	
}
}
