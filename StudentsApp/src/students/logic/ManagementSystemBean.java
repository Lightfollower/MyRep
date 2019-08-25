package students.logic;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import students.entity.Students;

@Stateless
public class ManagementSystemBean implements ManagementSystemLocal
{
    @PersistenceContext
    private EntityManager em;

    public Students getStudents(int studentId)
    {
        System.out.println("em start");
        return em.find(Students.class, studentId);

    }

    public void identification (){
        System.out.println("I'am em");
    }

    public void persist(Object object)
    {
        em.persist(object);
    }
}