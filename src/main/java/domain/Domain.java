package domain;

import bl.HibernateUtil;
import entity.*;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.Hibernate;
import service.*;

public class Domain {

    public static void main(String args[]) throws SQLException {
        PackService packService = new PackService();
        PictureService pictureService = new PictureService();
        TranslationService translationService = new TranslationService();
        UserService userService = new UserService();
        WordService wordService = new WordService();
        
        User user = new User();
//        userService.add(user);
        
        Pack pack = new Pack();
        pack.setName("Standart pack");
        
        Picture picture = new Picture();
        picture.setLink("C:/linguatime/pic/test.jpg");
        
        Translation translation = new Translation();
        translation.setName("имя");
        
        Word word = new Word();
        word.setLang("en");
        word.setName("name");
        word.setProgress(0);
        
        // Links
        
        pack.setUser(user);
        user.getPacks().add(pack);
        
        word.setPack(pack);
        pack.getWords().add(word);
        
        picture.setWord(word);
        word.setPicture(picture);
        
        translation.setWord(word);
        word.getTranslations().add(translation);
        
//        packService.add(pack);
//        pictureService.add(picture);
//        translationService.add(translation);
//        wordService.add(word);

        Word w = wordService.getById(1L);
        Hibernate.initialize(w);
        System.out.println(w);
        
        HibernateUtil.shutdown();
    }

}
