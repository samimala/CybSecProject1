package sec.project.domain;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Column;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Account extends AbstractPersistable<Long> {
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

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean isAdmin) {
        this.admin = isAdmin;
    }

}
