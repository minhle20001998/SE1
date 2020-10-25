/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorials.tutorial_12;

/**
 *
 * @author meota
 */
public class list {

    public static void main(String[] args) {
        MaxMinIntList a = new MaxMinIntList();
        a.add(36);
        a.add(1);
        a.add(24);

        System.out.println(a.getMax());
        System.out.println(a.getMin());
        System.out.println(a);
    }

}
