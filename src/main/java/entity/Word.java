package entity;

import java.util.HashSet;
import java.util.Set;
import org.hibernate.Hibernate;

public class Word {

    private Long wordId;
    private String name;
    private String lang;
    private Pack pack;
    private int progress;
    private Set<Translation> translations = new HashSet<Translation>(0);
    private Picture picture;
    
    public Word(){
        
    }
    
    public Long getWordId(){return wordId;}
    
    public void setWordId(Long wordId){this.wordId = wordId;}
    
    public String getName(){return name;}
    
    public void setName(String name){this.name = name;}
    
    public String getLang(){return lang;}
    
    public void setLang(String lang){this.lang = lang;}
    
    public Pack getPack(){return pack;}
    
    public void setPack(Pack pack){this.pack = pack;}
    
    public int getProgress(){return progress;}
    
    public void setProgress(int progress){this.progress = progress;}
    
    public Set<Translation> getTranslations(){return translations;}
    
    public void setTranslations(Set<Translation> translations){this.translations = translations;}
    
    public Picture getPicture(){return picture;}
    
    public void setPicture(Picture picture){this.picture = picture;}
    
    @Override
    public String toString(){
        Hibernate.initialize(pack);
        Hibernate.initialize(picture);
        return "Word{" +
                "id=" + wordId +
                ", name=" + name +
                ", lang=" + lang +
                ", pack=" + pack +
                ", progress=" + progress +
                ", picture=" + picture +
                "}";
    }
}
