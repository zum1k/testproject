package by.smuglyakov.testproject.model;

import java.util.Objects;


public class Unit {
    private long timestamp;
    private Integer value;

    public Unit(Integer value, long timestamp) {
        this.timestamp = timestamp;
        this.value = value;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Unit unit = (Unit) o;
        return timestamp == unit.timestamp && Objects.equals(value, unit.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timestamp, value);
    }
}
