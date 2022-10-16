package ca.bcit.comp2601.quiz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Main Class
 *
 * @author Guilherme Trevisan
 * @version 0.0.1
 * @since 2022-10-14
 */
public class Main {
    public static void main(String[] args){

        Dog d1;
        Dog d2;
        Dog d3;
        List<Dog> dogs;

        dogs = new ArrayList();
        d1 = new Dog("Rex", 2020);
        d2 = new Dog("Mello", 2019);
        d3 = new Dog("Johnny", 2020);
        dogs.add(d1);
        dogs.add(d2);
        dogs.add(d3);

        Collections.sort(dogs);

        for (Dog dog : dogs)
        {
            dog.printDetails();
        }

        Student s1;
        Student s2;
        Bcit bcit;
        s1 = new Student("ABC1");
        s2 = new Student("ABC2");
        bcit = new Bcit();

        bcit.register(s1);
        bcit.register(s2);

        if (s1.equals(s2)){
            System.out.println("These students are equal");
        } else {
            System.out.println("These students are not equal");
        }

    }
}

