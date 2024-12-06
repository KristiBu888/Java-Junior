package sem_3;

/**
     * Задача 1 ======== Разработайте класс Student с полями String name, int
     * age, transient double GPA (средний балл). Обеспечьте поддержку
     * сериализации для этого класса. Создайте объект класса Student и
     * инициализируйте его данными. Сериализуйте этот объект в файл.
     * Десериализуйте объект обратно в программу из файла. Выведите все поля
     * объекта, включая GPA, и обсудите, почему значение GPA не было
     * сохранено/восстановлено.
     */

import java.io.*;

public class Program {

        public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student user1 = new Student("Miyki", 22, 4.1);
        Student user2 = new Student("Lisa", 20, 4.0);

        try (FileOutputStream fileOutputStream = new FileOutputStream("Students_hw_3.bin"); ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(user1);
            System.out.println("\nОбъект User1 сериализован.");
            objectOutputStream.writeObject(user2);
            System.out.println("Объект User2 сериализован.");
        }

        try (FileInputStream fileInputStream = new FileInputStream("Students_hw_3.bin"); ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            user1 = (Student) objectInputStream.readObject();
            System.out.println("\nОбъект User1 десериализован.");
            user2 = (Student) objectInputStream.readObject();
            System.out.println("Объект User2 десериализован.");
        }

        System.out.println("\nОбъект User1:");
        System.out.println("Имя:          " + user1.getName());
        System.out.println("Возраст:      " + user1.getAge());
        System.out.println("Средний балл: " + user1.getGPA());

        System.out.println("\nОбъект User2:");
        System.out.println("Имя:          " + user2.getName());
        System.out.println("Возраст:      " + user2.getAge());
        System.out.println("Средний балл: " + user2.getGPA());
    }
}
