package run;

import entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.text.html.parser.Entity;
import java.util.List;

/**
 * Created by Illko on 24.05.2017.
 */
public class Main {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("xxx");
        EntityManager manager = factory.createEntityManager();

        manager.getTransaction().begin();
//        manager.persist(new User("kolya", "123"));
//        manager.persist(new User("petya", "123"));
        User user = manager.find(User.class, 2);
        System.out.print(user);
        List<User> resultList = manager.createQuery
                ("select u from User u where u.password like '123' ", User.class).getResultList();
        user.setName("blabla");


        System.out.print(resultList);
        manager.getTransaction().commit();
        manager.close();
        factory.close();
    }
}
