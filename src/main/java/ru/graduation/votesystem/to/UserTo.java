package ru.graduation.votesystem.to;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class UserTo extends NamedTo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Email
    @NotBlank
    @Size(max = 100)
    private String email;

    @Size(min = 5, max = 32, message = "length must between 5 and 32 characters")
    private String password;

    public UserTo(Integer id, String name, String email, String password) {
        super(id, name);
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserTo{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", id=" + id +
                '}';
    }
}
