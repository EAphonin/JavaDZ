package seminar6.cw.task3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Task3 {
    public static void main(String[] args) {
        Set<Cat> cats = new HashSet<>();

        Cat cat1 = new Cat();
        cat1.name = "Boris";
        cat1.age = 10;
        cat1.poroda = "Bengal";
        cat1.owner = "Natali Ivanovna";

        Cat cat2 = new Cat();
        cat2.name = "Mari";
        cat2.age = 3;
        cat2.poroda = "Siberian";
        cat2.owner = "Vitali Andreevich";

        Cat cat3 = new Cat();
        cat3.name = "Foric";
        cat3.age = 7;
        cat3.poroda = "Sfincs";
        cat3.owner = "Dobrolub Stanislavovich";

        Cat cat4 = new Cat();
        cat4.name = "Boris";
        cat4.age = 10;
        cat4.poroda = "Bengal";
        cat4.owner = "Natali Ivanovna";

        cats.add(cat1);
        cats.add(cat2);
        cats.add(cat3);
        cats.add(cat4);

        printSet(cats);
        System.out.println(cat1.equals(cat4));

        printSet(findByAge(cats,5));
    }
    static void printSet(Set<Cat> cats){
        for (Cat cat: cats){
            System.out.println(cat);
        }

    }
    static Set<Cat> findByAge(Set<Cat> cats, int minAge){
        Set<Cat> list = new HashSet<>();
        for (Cat cat: cats){
            if (cat.age >= minAge){
                list.add(cat);
            }
        }
        return list;
    }
}
