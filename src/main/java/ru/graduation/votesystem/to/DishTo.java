package ru.graduation.votesystem.to;

import java.math.BigDecimal;
import java.util.Objects;

public class DishTo extends NamedTo {

    private BigDecimal price;

    public DishTo(Integer id, String name, BigDecimal price) {
        super(id, name);
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DishTo dishTo = (DishTo) o;
        return name.equals(dishTo.name) &&
                price.equals(dishTo.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}
