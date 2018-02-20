package test;
import org.mockito.Mockito;
import main.MyMockito;
import org.junit.Test;
import org.mockito.Spy;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MyMockitoTest {
    @Spy //Spy does not work on local objects
    MyMockito mm = Mockito.spy(new MyMockito());

    @Test
    public void testOutHowSpyWorks() {
        mm.size();
        verify(mm).size();
        assertEquals(8, mm.getCount());
    }

    @Test
    public void testOutHowSpyWorksOnAStaticMethodViaInstance() {
        mm.staticMethod();
        verify(mm).staticMethod();
    }

    @Test
    public void testOutHowSpyWorksOnAStaticMethodViaClass() {
        MyMockito.staticMethod();
        verify(mm).staticMethod();
    }

    @Test
    public void testOutHowMockWorks() {
        MyMockito mmLocal = mock(MyMockito.class);
        mmLocal.size();
        verify(mmLocal).size();
        assertEquals(7, mm.getCount());
    }

    @Test
    public void testOutHowMockWorksOnAStaticMethod() {
        MyMockito mmLocal = mock(MyMockito.class);
        mmLocal.staticMethod();
        verify(mmLocal).staticMethod();
        assertEquals(7, mm.getCount());
    }

    @Test
    public void getMethods() throws Exception {
        MyMockito mm = new MyMockito();
        final Method[] methods =
                MyMockito.class.getDeclaredMethods();
        for (int i = 0; i < methods.length; ++i) {
            System.out.println(i);
            methods[i].setAccessible(true);
            System.out.println(methods[i].getName());
            methods[i].setAccessible(true);
            Object ret = methods[i].invoke(mm);
        }
    }

    Test
    public void getMethodsMockitoClass() throws Exception {
        MyMockito mm = new MyMockito();
        final Method[] methods =
                MyMockito.class.getDeclaredMethods();
        for (int i = 0; i < methods.length; ++i) {
            System.out.println(i);
            methods[i].setAccessible(true);
            System.out.println(methods[i].getName());
            methods[i].setAccessible(true);
            Object ret = methods[i].invoke(mm);
        }
    }
    @Test
    public void getMemberData()
            throws Exception {
        final Field fields[] =
                MyMockito.class.getDeclaredFields();
        for (int i = 0; i < fields.length; ++i) {
            System.out.println(i);
            fields[i].setAccessible(true);
            System.out.println(fields[i].get(new MyMockito()));
            System.out.println(fields[i].getName());
            System.out.println(fields[i].getType());
        }
    }
}
