package hibernate;

import java.util.Iterator;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.Test;

public class hibernatedemo {
    @Test
	public void acation() {
	Session session=hibernate.getSession();
	Transaction tx=session.beginTransaction();
    List<user> user=session.createQuery("from user").list();
    for(user u:user)
    System.out.println(u);
	tx.commit();

}
}
