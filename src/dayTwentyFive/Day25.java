package dayTwentyFive;
import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;  
import org.hibernate.boot.Metadata;  
import org.hibernate.boot.MetadataSources;  
import org.hibernate.boot.registry.StandardServiceRegistry;  
import org.hibernate.boot.registry.StandardServiceRegistryBuilder; 
import javax.persistence.Entity;
public class Day25 {

	public static void main(String[] args) {
	
		 StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
         Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
         SessionFactory factory = meta.getSessionFactoryBuilder().build();  
         Session session = factory.openSession();  
         Transaction t = session.beginTransaction();  
        CustomerD c1=new CustomerD();    
         c1.setPanCardNo(1535);    
         c1.setName("Arunima Chaudhary");    
         c1.setAge(19);    
         c1.setBalance(200000);
         session.save(c1);  
         t.commit();  
         System.out.println("successfully saved");    
          factory.close();  
          session.close();     
      //  System.out.println(  t.getStatus());
	}

}
