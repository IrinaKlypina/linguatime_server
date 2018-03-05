package entity;

import java.util.HashSet;
import java.util.Set;
import org.hibernate.Hibernate;

public class Translation {
    
    private Long translationId;
    private String name;
    private Word word;
    
    public Translation(){
        
    }
    
    public Long getTranslationId(){return translationId;}
    
    public void setTranslationId(Long translationId){this.translationId = translationId;}
    
    public String getName(){return name;}
    
    public void setName(String name){this.name = name;}
    
    public Word getWord(){return word;}
    
    public void setWord(Word word){this.word = word;}
    
    @Override
    public String toString(){
        Hibernate.initialize(word);
        return "Translation{" +
                "id=" + translationId +
                ", name=" + name +
                ", word=" + word +
                "}";
    }
}
