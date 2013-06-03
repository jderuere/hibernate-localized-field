import com.jderuere.Person;
import com.jderuere.PersonDao;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Locale;

public class PersonDaoTest extends AbstractSpringDaoTest {

    @Autowired
    private PersonDao personDao;

    @Before
    public void persistPerson() {
        Person person = new Person();
        person.setId(1L);
        person.setJobTitle(Locale.ENGLISH, "developer");
        person.setJobTitle(Locale.FRENCH, "développeur");
        personDao.persist(person);
    }

    @Test
    public void localizedEnglish() {
        Person person = personDao.findById(1L);
        TestCase.assertEquals(person.getJobTitle(Locale.ENGLISH), "developer");
    }

    @Test
    public void localizedFrench() {
        Person person = personDao.findById(1L);
        TestCase.assertEquals(person.getJobTitle(Locale.FRENCH), "développeur");
        TestCase.assertTrue(true);
    }

    @Test
    public void localizedNotFound() {
        Person person = personDao.findById(1L);
        TestCase.assertEquals(person.getJobTitle(Locale.GERMAN), "developer");
        TestCase.assertTrue(true);
    }
}
