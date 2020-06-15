package Model;

import Model.Subject;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author Admin
 */
public class SubjectTest {

    @Test
    public void EqualsFuntionTest0() {
        Subject s = new Subject("1", "SQA", 3);
        assertTrue(s.equals(s));
    }

    @Test
    public void EqualsFuntionTest1() {
        Subject s1 = new Subject("1", "SQA", 3);
        Subject s2 = new Subject("1", "SQA", 3);
        assertTrue(s1.equals(s2));
    }

    @Test
    public void EqualsFuntionTest2() {
        Subject s1 = new Subject("1", "SQA", 3);
        Subject s2 = new Subject("2", "SQA", 3);
        assertFalse(s1.equals(s2));
    }

    @Test
    public void EqualsFuntionTest3() {
        Subject s1 = new Subject("1", "SQA", 3);
        Subject s2 = new Subject("1", "PTTK", 3);
        assertFalse(s1.equals(s2));
    }

    @Test
    public void EqualsFuntionTest4() {
        Subject s1 = new Subject("1", "SQA", 3);
        Subject s2 = new Subject("1", "PTTK", 2);
        assertFalse(s1.equals(s2));
    }

    @Test
    public void EqualsFuntionTest5() {
        Subject s1 = new Subject("1", "SQA", 3);
        Subject s2 = new Subject("2", "PTTK", 4);
        assertFalse(s1.equals(s2));
    }

    @Test
    public void EqualsFuntionTest6() {
        Subject s1 = new Subject("1", "SQA", 3);
        Subject s2 = new Subject();
        assertFalse(s1.equals(s2));
    }

    @Test
    public void EqualsFuntionTest7() {
        Subject s1 = new Subject("1", "SQA", 3);
        Object s2 = new Object();
        assertFalse(s1.equals(s2));
    }
}
