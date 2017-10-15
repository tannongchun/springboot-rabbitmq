package com.example.rabbitserver.dto;

import java.io.Serializable;

/**
 * @author tannc
 * @create_time 2017/10/1514:32
 */
public class Foo  implements Serializable {

    private String name;

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Foo(String name) {
        this.name = name;
    }
}
