package com.diehao;

import com.diehao.demo.DemoFinder;
import com.diehao.demo.Demos;
import com.diehao.support.ContidiontReader;

class DFinderApplicationTest {

    public static void main(String[] args) {
        ContidiontReader reader = new ContidiontReader(new DemoFinder());

        Demos var0 = new Demos("小A", 2, "beijing");
        Demos var2 = new Demos("小B", 2, "zhengzhou");
        String df = reader.read(var0, var2);
        System.out.println(df);
    }

}
