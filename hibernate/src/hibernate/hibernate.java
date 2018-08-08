package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class hibernate {
public static Configuration cfg;
public static SessionFactory sessionfactory;
static{
cfg=new Configuration();
cfg.configure();
sessionfactory=cfg.buildSessionFactory();
}
public static Session getSession() {
	return sessionfactory.getCurrentSession();
	
}
}
