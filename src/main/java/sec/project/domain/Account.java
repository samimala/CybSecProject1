package sec.project.domain;

import javax.persistence.Entity;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Account extends AbstractPersistable<Long> {
    @Index(name = "IDX_USERNAME")
    @Column(nullable = false, unique = true)
    private String username;
    private String password;
    private Boolean admin;

    public Account() {
        super();
    }

    public Account(String username, String password, Boolean admin) {
        this();
        this.username = username;
        this.password = password;
        this.admin = admin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean isAdmin) {
        this.admin = isAdmin;
    }

}
