package edu.postgraduate.programExercise.reflection;

import edu.postgraduate.programExercise.bean.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author QRX
 * @email QRXwzx@outlook.com
 * @date 2020-02-26
 */
public class ReflectionTest {

    @Test
    public void testGetMethod() throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<Person> clazz = Person.class;
        // 1.通过方法名和参数列表获取指定方法对象
        Method showNation = clazz.getDeclaredMethod("showNation", String.class);
        // 2.设置权限，保证找到的方法是可以访问的
        showNation.setAccessible(true);
        // 3.实例方法，只能使用实例对象调用，因此需要先实例化一个对象。
        Person person = clazz.newInstance();
        // invoke会返回和该方法一样的返回值对象。
        Object returnValue = showNation.invoke(person, "CHN");
        System.out.println(returnValue);

        // 静态方法的获取。静态资源就写这个类的Class对象或者写null就可以
        Method showDesc = clazz.getDeclaredMethod("showDesc");
        showDesc.setAccessible(true);
        // 这三种都可以
        System.out.println(showDesc.invoke(clazz));
        System.out.println(showDesc.invoke(Person.class)); // 这种比较规范。规范的获取并调用静态方法。
        System.out.println(showDesc.invoke(null));
    }

    @Test
    public void testGetField() throws IllegalAccessException, InstantiationException, NoSuchFieldException {
        Class<Person> clazz = Person.class;

        Person person = clazz.newInstance();
        System.out.println(person.getAge());
        // 实例属性，只有对某个特定对象才有意义。
        Field age = clazz.getDeclaredField("age");
        age.setAccessible(true);
        age.set(person, 12);
        System.out.println(person.getAge());
    }


    @Test
    public void testGetPackage() {
        Class<Person> clazz = Person.class;
        System.out.println(clazz.getPackage());
    }

    @Test
    public void testGetInterface() throws ClassNotFoundException {
        Class<Person> clazz = Person.class;
        Class<?>[] interfaces = clazz.getInterfaces();
        System.out.println(interfaces.length);
        for (Class<?> anInterface : interfaces) {
            System.out.println(anInterface);
        }
    }

    @Test
    public void testGetMethod2() {
        try {
            Class<?> clazz = Class.forName("edu.postgraduate.programExercise.bean.Student");
            System.out.println("getDeclaredMethods");
            // 可以获取目标类中定义的所有方法，包括权限是private的。无法获取父类中定义的方法
            Method[] declaredMethods = clazz.getDeclaredMethods();
            for (Method declaredMethod : declaredMethods) {
                System.out.println(declaredMethod);
                Annotation[] annotations = declaredMethod.getAnnotations();
                for (Annotation annotation : annotations) {
                    System.out.print(annotation + " \t");
                }
                System.out.println();
                System.out.println(Modifier.toString(declaredMethod.getModifiers()));
                System.out.println(declaredMethod.getReturnType().getName());
                System.out.println("--------------------------------------");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testGetMethod1() {
        try {
            Class<?> clazz = Class.forName("edu.postgraduate.programExercise.bean.Student");
            System.out.println("getDeclaredMethods");
            // 可以获取目标类中定义的所有方法，包括权限是private的。无法获取父类中定义的方法
            Method[] declaredMethods = clazz.getDeclaredMethods();
            for (Method declaredMethod : declaredMethods) {
                System.out.println(declaredMethod);
            }

            System.out.println("************************************");
            System.out.println("getMethods");
            // 可以获取到父类中的方法，但是仅限权限是public的
            Method[] methods = clazz.getMethods();
            for (Method method : methods) {
                System.out.println(method);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    // 体会newInstance的动态性
    @Test
    public void testGetObjDynamically() {
        String[] classNames = {"CaculatorDemo", "Customer", "Dog", "Person", "Student"};
        String packageName = "edu.postgraduate.programExercise.bean.";
        for (String className : classNames) {
            String classPath = packageName + className;
            try {
                System.out.println(getInstance(classPath));
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }
    }

    private Object getInstance(String classPath)
            throws
            ClassNotFoundException,
            IllegalAccessException,
            InstantiationException {
        Class<?> aClass = Class.forName(classPath);
        return aClass.newInstance();
    }



    // 了解classLoader
    @Test
    public void testClassLoader() {
        ClassLoader systemClassLoader = ReflectionTest.class.getClassLoader();
        System.out.println("system class loader: " + systemClassLoader); // 自定义类由系统类加载器加载进内存
        ClassLoader extClassLoader = systemClassLoader.getParent();
        System.out.println("extension class loader: " + extClassLoader); // 系统类加载器的父类时拓展类加载器
        ClassLoader bootstarpClassLoader = extClassLoader.getParent(); // 获取不到
        System.out.println("bootstrap class loader: " + bootstarpClassLoader);

        /*
            1.String是有classLoader的。输出结果为null说明String是由bootstrap class loader加载进内存的
            2.自引导型的class loader真的无法被获取。
         */
        ClassLoader classLoader = String.class.getClassLoader();
        System.out.println("String class loader: " + classLoader);
    }


    @Test
    public void testClass() {
        Class clazz1 = Object.class; // 类可以
        Class clazz2 = Comparable.class; // 接口可以
        Class clazz3 = String[].class; // 数组可以
        Class clazz4 = int[][].class; // 二维数组可以
        Class clazz5 = ElementType.class; // 枚举类可以
        Class clazz6 = Override.class; // 注解可以
        Class clazz7 = int.class; // 基本数据类型可以
        Class clazz8 = void.class; // void可以
        Class clazz9 = Class.class; // Class本身也可以

        int[] a = new int[10];
        int[] b = new int[100];
        Class clazz10 = a.getClass();
        Class clazz11 = b.getClass();
        // 只要元素类型和维度一样，数组的class就是一样的
        System.out.println(clazz10 == clazz11);

    }

    // 获取一个Class实例对象
    /*
        使用自动引入变量的方式引入的变量，发现系统自动推测的泛型类型是不一样的。这也许能给我们一点启示。
        方式1是直接写死的，所以系统可以断定这个类就是一个Person类
        方式2通过一个引用获取类。这个引用也可以用于Person类的子类，所以系统推测他是一个Person的子类
        方式3和4完全动态，在静态阶段无法判定这个类是否存在，所以泛型声明为？泛型范围为负无穷到正无穷
     */
    @Test
    public void testGetClass() throws ClassNotFoundException {
        // 1.
        Class<Person> clazz1 = Person.class;
        System.out.println(clazz1);
        // 2.
        Person p = new Person();
        Class<? extends Person> clazz2 = p.getClass();
        System.out.println(clazz2);
        // 3.
        Class<?> clazz3 = Class.forName("edu.postgraduate.programExercise.bean.Person");
        System.out.println(clazz3);
        // 4.
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class<?> clazz4 = classLoader.loadClass("edu.postgraduate.programExercise.bean.Person");
        System.out.println(clazz4);

        System.out.println(clazz1 == clazz2);
        System.out.println(clazz1 == clazz3);
        System.out.println(clazz1 == clazz4);
    }
}
