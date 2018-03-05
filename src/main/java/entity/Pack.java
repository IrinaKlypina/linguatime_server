package entity;

import java.util.HashSet;
import java.util.Set;
import org.hibernate.Hibernate;

public class Pack {

    private Long packId;
    private String name;
    private User user;
    private Set<Word> words = new HashSet<Word>(0);
    
    public Pack(){
    
    }
    
    public Long getPackId(){return packId;}
    
    public void setPackId(Long packId){this.packId = packId;}
    
    public String getName(){return name;}
    
    public void setName(String name){this.name = name;}
    
    public User getUser(){return user;}
    
    public void setUser(User user){this.user = user;}
    
    public Set<Word> getWords(){return words;}
    
    public void setWords(Set<Word> words){this.words = words;}
    
    @Override
    public String toString(){
        Hibernate.initialize(user);
        return "Pack{" + 
                "id=" + packId + 
                ", name=" + name +
                ", user=" + user +
                "}";
    }
}
