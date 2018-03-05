package entity;

import java.util.HashSet;
import java.util.Set;
import org.hibernate.Hibernate;

public class Picture {
    
    private Long pictureId;
    private String link;
    private Word word;
    
    public Picture(){
        
    }
    
    public Long getPictureId(){return pictureId;}
    
    public void setPictureId(Long pictureId){this.pictureId = pictureId;}
    
    public String getLink(){return link;}
    
    public void setLink(String link){this.link = link;}
    
    public Word getWord(){return word;}
    
    public void setWord(Word word){this.word = word;}
    
    @Override
    public String toString(){
        Hibernate.initialize(word);
        return "Picture{" +
                "id=" + pictureId +
                ", link=" + link +
                ", word=" + word + 
                "}";
                
    }
}
