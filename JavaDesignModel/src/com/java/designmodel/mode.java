package com.java.designmodel;

import java.io.Serializable;
import java.util.Objects;

public class mode implements Serializable {
    String name;
    int count;
    String type;

     
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        mode mode = (mode) o;
        return count == mode.count &&
                name.equals(mode.name) &&
                type.equals(mode.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, count, type);
    }
}
