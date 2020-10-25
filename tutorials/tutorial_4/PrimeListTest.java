/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorials.tutorial_4;

import java.util.LinkedList;

/**
 *
 * @author meota
 */
public class PrimeListTest {

    public static void main(String[] args) {
        LinkedList<Integer> prime = new LinkedList<Integer>();
        prime.add(2);
        PrimeList p = new PrimeList(prime);
        for (int i = 0; i < 10; i++) {
            p.iterator().next();
        }

        System.out.println(p);

    }
}
