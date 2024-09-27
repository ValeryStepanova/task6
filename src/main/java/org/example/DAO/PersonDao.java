package org.example.DAO;

import org.example.DTO.PersonDTO;
import org.example.hibernateUtil.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class PersonDao implements DAOPerson {
   public static final String SORT = "select* from person where age>21\n" +
           "order by dateTimeCreate asc;";
    @Override
    public void create(PersonDTO obj) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(obj);
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println("Пользователь добавлен");
    }

    @Override
    public PersonDTO update(PersonDTO obj) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(obj);
        entityManager.getTransaction().commit();
        entityManager.close();
        return obj;
    }

    @Override
    public PersonDTO read(int id) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        PersonDTO personDTO = entityManager.find(PersonDTO.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return personDTO;
    }

    @Override
    public PersonDTO delete(int id) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        PersonDTO personDTO = entityManager.find(PersonDTO.class, id);
        entityManager.remove(personDTO);
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println("Пользователь удален");
        return personDTO;
    }

    @Override
    public List<PersonDTO> findAndSort() {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        Query query = entityManager.createNativeQuery(SORT, PersonDTO.class);
        entityManager.getTransaction().commit();
        List<PersonDTO> list = query.getResultList(); //насколько это плохо?
        return list;
    }
}
