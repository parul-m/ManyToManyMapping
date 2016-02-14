package dto;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USR")
public class user {
    @Id
    int user_id;
    String user_name;
    
    @ManyToMany
    @JoinTable(
    name = "group_info",
    joinColumns = @JoinColumn(name = "uid"),
    inverseJoinColumns = @JoinColumn(name = "gid")
    )
    Set<group> s = new HashSet<>();

    public user() {
    }

    public user(int user_id, String user_name) {
        this.user_id = user_id;
        this.user_name = user_name;
    }
    
    public Set<group> getS() {
        return s;
    }

    public void setS(Set<group> s) {
        this.s = s;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
}
