package service;

import bl.SessionUtil;
import dao.WordDAO;
import entity.Word;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class WordService extends SessionUtil implements WordDAO{

    @Override
    public void add(Word word) throws SQLException {
        openTransactionSession();
        
        Session session = getSession();
        session.save(word);
        
        closeTransactionSession();
    }

    @Override
    public List<Word> getAll() throws SQLException {
        openTransactionSession();
        
        String sql = "SELECT * FROM word";
        
        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Word.class);
        List<Word> wordList = query.list();
        
        closeTransactionSession();
        
        return wordList;
    }

    @Override
    public Word getById(Long id) throws SQLException {
        openTransactionSession();
        
        String sql = "SELECT * FROM word WHERE WORD_ID = :id";
        
        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Word.class);
        query.setParameter("id", id);
        Word word = (Word)query.getSingleResult();
        
        closeTransactionSession();
        
        return word;
    }

    @Override
    public void update(Word word) throws SQLException {
        openTransactionSession();
        
        Session session = getSession();
        session.update(word);
        
        closeTransactionSession();
    }

    @Override
    public void remove(Word word) throws SQLException {
        openTransactionSession();
        
        Session session = getSession();
        session.remove(word);
        
        closeTransactionSession();
    }
    
}
