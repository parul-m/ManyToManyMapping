package dto;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "GRP")
public class group {
    @Id
    int group_id;
    String group_name;
    
    @ManyToMany(mappedBy = "s")
    Set<user> set = new HashSet<>();

    public group() {
    }

    public group(int group_id, String group_name) {
        this.group_id = group_id;
        this.group_name = group_name;
    }
    
    public Set<user> getSet() {
        return set;
    }

    public void setSet(Set<user> set) {
        this.set = set;
    }

    public int getGroup_id() {
        return group_id;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }
}
