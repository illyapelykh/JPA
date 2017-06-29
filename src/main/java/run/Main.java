package run;

import entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * Created by Illko on 24.05.2017.
 */
public class Main {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("UnitName");
        EntityManager manager = factory.createEntityManager();

        manager.getTransaction().begin();
//        manager.persist(new User("kolya", "123"));
//        manager.persist(new User("petya", "123"));
//        User user = manager.find(User.class, 2);
//        System.out.print(user);
//        List<User> resultList = manager.createQuery
//                ("select u from User u where u.password like '123' ", User.class).getResultList();
//        user.setName("blabla");
//        System.out.print(resultList);

//        manager.persist(new User("Семен", "1234"));

//        CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
//        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
//        Root root = criteriaQuery.from(User.class);
//        TypedQuery<User> typedQuery = manager.createQuery(criteriaQuery);
//        System.out.println(typedQuery.getResultList());

        CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);

        Predicate predicate1 = criteriaBuilder.equal(root.get("password"), "1234");
        Predicate predicate2 = criteriaBuilder.equal(root.get("name"), "vasya");
        Predicate predicate3 = criteriaBuilder.or(predicate1, predicate2);
        criteriaQuery.select(root).where(predicate3);
        TypedQuery<User> typedQuery = manager.createQuery(criteriaQuery);
        System.out.println(typedQuery.getResultList());


        manager.getTransaction().commit();
        manager.close();
        factory.close();
    }
}
