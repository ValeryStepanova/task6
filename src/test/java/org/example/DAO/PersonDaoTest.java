package org.example.DAO;

import junit.framework.TestCase;
import org.example.DTO.PersonDTO;
import org.example.hibernateUtil.HibernateUtil;
import org.junit.Assert;

import javax.persistence.EntityManager;

import java.util.List;

public class PersonDaoTest extends TestCase {
    public void testCreate() {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        PersonDTO personDTO = TestUtil.build();
        PersonDao personDao = new PersonDao();
        personDao.create(personDTO);
        PersonDTO expectPerson = entityManager.find(PersonDTO.class, 1);
        entityManager.getTransaction().commit();
        entityManager.close();
        double delta = personDTO.getSalary() - expectPerson.getSalary();
        Assert.assertEquals(expectPerson.getAge(), personDTO.getAge());
        Assert.assertEquals(expectPerson.getAddress(), personDTO.getAddress());
        Assert.assertEquals(expectPerson.getLetter(), personDTO.getLetter());
        Assert.assertEquals(expectPerson.getPassport(), personDTO.getPassport());
        Assert.assertEquals(expectPerson.getSalary(), personDTO.getSalary(), delta);
        Assert.assertEquals(expectPerson.getDateOfBirthday(), personDTO.getDateOfBirthday());
    }

    public void testRead() {
        PersonDao personDao = new PersonDao();
        PersonDTO expectPerson = TestUtil.build();
        personDao.create(expectPerson);
        PersonDTO realPerson = personDao.read(1);
        double delta = realPerson.getSalary() - expectPerson.getSalary();
        Assert.assertEquals(expectPerson.getAge(), realPerson.getAge());
        Assert.assertEquals(expectPerson.getAddress(), realPerson.getAddress());
        Assert.assertEquals(expectPerson.getLetter(), realPerson.getLetter());
        Assert.assertEquals(expectPerson.getPassport(), realPerson.getPassport());
        Assert.assertEquals(expectPerson.getSalary(), realPerson.getSalary(), delta);
        Assert.assertEquals(expectPerson.getDateOfBirthday(), realPerson.getDateOfBirthday());
    }

    public void testUpdate() {
        PersonDTO person = TestUtil.build();
        int age = person.getAge();
        person.setAge(29);
        PersonDao personDao = new PersonDao();
        personDao.update(person);
        Assert.assertNotEquals(age, person.getAge());
    }


    public void testDelete() {
        PersonDao personDao = new PersonDao();
        PersonDTO expectPerson = TestUtil.build();
        personDao.create(expectPerson);
        PersonDTO realPerson = personDao.delete(1);
        double delta = realPerson.getSalary() - expectPerson.getSalary();
        Assert.assertEquals(expectPerson.getAge(), realPerson.getAge());
        Assert.assertEquals(expectPerson.getAddress(), realPerson.getAddress());
        Assert.assertEquals(expectPerson.getLetter(), realPerson.getLetter());
        Assert.assertEquals(expectPerson.getPassport(), realPerson.getPassport());
        Assert.assertEquals(expectPerson.getSalary(), realPerson.getSalary(), delta);
        Assert.assertEquals(expectPerson.getDateOfBirthday(), realPerson.getDateOfBirthday());
    }

    public void testFindAndSort() {
        PersonDao personDao = new PersonDao();
        personDao.create(TestUtil.build());
        personDao.create(TestUtil.buildPerson21());
        List<PersonDTO> list = personDao.findAndSort();
        Assert.assertEquals(2, list.size());
    }
}