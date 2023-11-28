package com.dh;

import com.dh.demo.DemoFinder;
import com.dh.demo.Demos;
import com.dh.support.ContidiontReader;

class DFinderApplicationTest {

    public static void main(String[] args) {
        ContidiontReader reader = new ContidiontReader(new DemoFinder());

        Demos var0 = new Demos("小A", 2, "beijing");
        Demos var2 = new Demos("小B", 2, "zhengzhou");
        String df = reader.read(var0, var2);
        System.out.println(df);
    }

}
