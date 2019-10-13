package _09_Linear.ApiDemo;

import _09_Linear.AboutStudent.Student;

import java.util.*;

public class ListDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list = new LinkedList<>();
        list.add("adnad");
        list.add("xyz");
        list.add("def");
        list.remove("");
        Collections.sort(list);
        System.out.println(list);

        List<Student> list1 = new ArrayList<>();
        list1.add(new Student(15, "zhangsa"));
        list1.add(new Student(18, "asfgsa"));
        list1.add(new Student(33, "chancsa"));
        list1.add(new Student(11, "bbhangsa"));
        list1.add(new Student(16, "xhangsa"));
        Collections.sort(list1, Comparator.comparingInt(Student::getAge));
//        Comparator.comparingInt(Student::getAge);
        /** 朗姆大表达式
         *  Collections.sort(list1, (o1, o2) -> {
         *             return o1.getAge() - o2.getAge();
         *         }
         *
         *         );
         */
        System.out.println(list1);
        System.out.println("++++++++++++++++++");
        for (int i = 0; i < list1.size(); i++) {
            System.out.println(list1.get(i));
        }
        System.out.println("++++++++++++++++++");
        for (Student stu : list1) {
            System.out.println(stu);
        }
        System.out.println("++++++++++++++++++");
        Iterator<Student> iterator = list1.iterator();//Iterator 迭代器
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}
