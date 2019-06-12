package ru.graduation.votesystem.to;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public abstract class NamedTo extends BaseTo {

    @NotBlank
    @Size(min = 2, max = 100)
    protected String name;

    public NamedTo(Integer id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
