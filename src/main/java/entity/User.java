package entity;
 
import java.util.HashSet;
import java.util.Set;

public class User {
    
    private Long userId;
    private Set<Pack> packs = new HashSet<Pack>(0);
    
    public User(){
        
    }
    
    public Long getUserId(){return userId;}
    
    public void setUserId(Long userId){this.userId = userId;}
    
    public Set<Pack> getPacks(){return packs;}
    
    public void setPacks(Set<Pack> packs){this.packs = packs;}
    
    @Override
    public String toString(){
        return "User{" + 
                "id=" + userId +
                "}";
    }
}
