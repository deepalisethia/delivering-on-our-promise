package com.amazon.ata.deliveringonourpromise.comparators;

import com.amazon.ata.deliveringonourpromise.types.Promise;
import java.util.Comparator;

public class PromiseAsinComparator implements Comparator<Promise> {
    @Override
    public int compare(Promise oi1, Promise oi2) {
        if (oi1.equals(oi2)) {
            return 0;
        } else {
            return oi1.getAsin().compareTo(oi2.getAsin());
        }
    }
}


