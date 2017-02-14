package com.skobeev.model;

import com.skobeev.util.CheckDepName;
import net.sf.oval.constraint.CheckWith;
import net.sf.oval.constraint.Length;
import net.sf.oval.constraint.NotEmpty;
import net.sf.oval.constraint.NotNull;

public class Department {

    private Long id;

    @NotNull(message = "Field is empty")
    @NotEmpty(message = "Field is empty")
    @Length(min = 4, max = 20, message = "Name length must between 4 and 20")
    @CheckWith(value = CheckDepName.class, message = "such a name already exists")
    private String name;

    public Department() {

    }

    public Department(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
