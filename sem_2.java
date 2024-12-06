/* Используя Reflection API, напишите программу,
 которая выводит на экран все методы класса String.
 */

import java.lang.reflect.Method;

public class sem_2 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> strings = Class.forName("java.lang.String");
        Method[] methods = strings.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("Метод: "+ method.getName());
        }
    }
}