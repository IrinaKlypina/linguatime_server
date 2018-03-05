package service;

import bl.SessionUtil;
import dao.TranslationDAO;
import entity.Translation;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class TranslationService extends SessionUtil implements TranslationDAO{

    @Override
    public void add(Translation translation) throws SQLException {
        openTransactionSession();
        
        Session session = getSession();
        session.save(translation);
        
        closeTransactionSession();
    }

    @Override
    public List<Translation> getAll() throws SQLException {
        openTransactionSession();
        
        String sql = "SELECT * FROM translation";
        
        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Translation.class);
        List<Translation> translationList = query.list();
        
        closeTransactionSession();
        
        return translationList;
    }

    @Override
    public Translation getById(Long id) throws SQLException {
        openTransactionSession();
        
        String sql = "SELECT * FROM translation WHERE TRANSLATION_ID = :id";
        
        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Translation.class);
        query.setParameter("id", id);
        Translation translation = (Translation)query.getSingleResult();
        
        closeTransactionSession();
        
        return translation;
    }

    @Override
    public void update(Translation translation) throws SQLException {
        openTransactionSession();
        
        Session session = getSession();
        session.update(translation);
        
        closeTransactionSession();
    }

    @Override
    public void remove(Translation translation) throws SQLException {
        openTransactionSession();
        
        Session session = getSession();
        session.remove(translation);
        
        closeTransactionSession();
    }
    
}
