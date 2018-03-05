package service;

import bl.SessionUtil;
import dao.PictureDAO;
import entity.Picture;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class PictureService extends SessionUtil implements PictureDAO{

    @Override
    public void add(Picture picture) throws SQLException {
        openTransactionSession();
        
        Session session = getSession();
        session.save(picture);
        
        closeTransactionSession();
    }

    @Override
    public List<Picture> getAll() throws SQLException {
        openTransactionSession();
        
        String sql = "SELECT * FROM picture";
        
        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Picture.class);
        List<Picture> pictureList = query.list();
        
        closeTransactionSession();
        
        return pictureList;
    }

    @Override
    public Picture getById(Long id) throws SQLException {
        openTransactionSession();
        
        String sql = "SELECT * FROM picture WHERE PICTURE_ID = :id";
        
        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Picture.class);
        query.setParameter("id", id);
        Picture picture = (Picture)query.getSingleResult();
        
        closeTransactionSession();
        
        return picture;
    }

    @Override
    public void update(Picture picture) throws SQLException {
        openTransactionSession();
        
        Session session = getSession();
        session.update(picture);
        
        closeTransactionSession();
    }

    @Override
    public void remove(Picture picture) throws SQLException {
        openTransactionSession();
        
        Session session = getSession();
        session.remove(picture);
        
        closeTransactionSession();
    }
    
}
