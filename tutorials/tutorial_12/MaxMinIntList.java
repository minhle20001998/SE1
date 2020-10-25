/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorials.tutorial_12;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author meota
 */
public class MaxMinIntList extends ArrayList<Integer> {

    public int getMin() {
        MaxMinIntList clone = (MaxMinIntList) this.clone();
        Collections.sort(clone);
        return clone.get(0);
    }

    public int getMax() {
        MaxMinIntList clone = (MaxMinIntList) this.clone();
        Collections.sort(clone);
        return clone.get(clone.size() - 1);
    }
}
