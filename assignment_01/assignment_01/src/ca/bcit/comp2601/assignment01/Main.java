package ca.bcit.comp2601.assignment01;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Guilherme Trevisan
 * @version 0.0.1
 * @since 2022-10-10
 */

public class Main {
    public static void main(String[] args) {

        List dates;
        dates = new ArrayList<>();

        Date d1;
        Date d2;
        Date d3;
        Date d4;
        d1 = new Date(31, 12, 2020);
        d2 = d1.next().next().next();
        d3 = new Date(1, 1, 2021);
        d4 = d3.previous().previous().previous();

        dates.add(d1);
        dates.add(d2);
        dates.add(d3);
        dates.add(d4);
//        dates.forEach(System.out::println);
        System.out.println("______");

        Collections.sort(dates);
//        dates.forEach(System.out::println); // TODO, CHECK IF FOLLOWS HIS DESIRED PATTERN

        Teacher s;
        Date born = new Date(30, 12, 1975);
        Name name = new Name("tiGer", "woODs");
        s = new Teacher(born, name, "    ");

    }
}