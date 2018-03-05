package service;

import bl.SessionUtil;
import dao.UserDAO;
import entity.User;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class UserService extends SessionUtil implements UserDAO{

    @Override
    public void add(User user) throws SQLException {
        openTransactionSession();
        
        Session session = getSession();
        session.save(user);
        
        closeTransactionSession();
    }

    @Override
    public List<User> getAll() throws SQLException {
        openTransactionSession();
        
        String sql = "SELECT * FROM user";
        
        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(User.class);
        List<User> userList = query.list();
        
        closeTransactionSession();
        
        return userList;
    }

    @Override
    public User getById(Long id) throws SQLException {
        openTransactionSession();
        
        String sql = "SELECT * FROM user WHERE USER_ID = :id";
        
        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(User.class);
        query.setParameter("id", id);
        User user = (User)query.getSingleResult();
        
        closeTransactionSession();
        
        return user;
    }

    @Override
    public void update(User user) throws SQLException {
        openTransactionSession();
        
        Session session = getSession();
        session.update(user);
        
        closeTransactionSession();
    }

    @Override
    public void remove(User user) throws SQLException {
        openTransactionSession();
        
        Session session = getSession();
        session.remove(user);
        
        closeTransactionSession();
    }
    
}
