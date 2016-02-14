package manytomany;

import dto.group;
import dto.user;
import myconfig.connection;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ManyToMany {

    public static void main(String[] args) {
        SessionFactory sf = connection.getSessionFactory();
        Session s = sf.openSession();
        Transaction t = s.beginTransaction();
        
        user u1 = new user(101, "Anjal");
        user u2 = new user(102, "Shreya");
        user u3 = new user(103, "Vidhi");
        user u4 = new user(104, "Pooja");
        
        group g1 = new group(1, "school");
        group g2 = new group(2, "college");
        group g3 = new group(3, "friends");
        
        g1.getSet().add(u1);
        g1.getSet().add(u2);
        g2.getSet().add(u1);
        g2.getSet().add(u4);
        g3.getSet().add(u1);
        g3.getSet().add(u2);
        g3.getSet().add(u3);
        
        u1.getS().add(g1);
        u1.getS().add(g2);
        u1.getS().add(g3);
        u2.getS().add(g1);
        u2.getS().add(g3);
        u3.getS().add(g3);
        u4.getS().add(g2);
        u4.getS().add(g3);
        
        s.save(u1);
        s.save(u2);
        s.save(u3);
        s.save(u4);
        s.save(g1);
        s.save(g2);
        s.save(g3);
        t.commit();
        s.close();
        sf.close();
    }
    
}
