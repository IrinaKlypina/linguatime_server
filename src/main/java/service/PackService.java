package service;

import bl.SessionUtil;
import dao.PackDAO;
import entity.Pack;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.query.Query;
import org.hibernate.Session;

public class PackService extends SessionUtil implements PackDAO {

    @Override
    public void add(Pack pack) throws SQLException {
        //open session with a transaction
        openTransactionSession();
        
        Session session = getSession();
        session.save(pack);
        
        //close session with a transaction
        closeTransactionSession();
    }

    @Override
    public List<Pack> getAll() throws SQLException {
        openTransactionSession();
        
        String sql = "SELECT * FROM pack";
        
        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Pack.class);
        List<Pack> packList = query.list();
        
        closeTransactionSession();
        
        return packList;
    }

    @Override
    public Pack getById(Long id) throws SQLException {
        openTransactionSession();
        
        String sql = "SELECT * FROM pack WHERE PACK_ID = :id";
        
        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Pack.class);
        query.setParameter("id", id);
        
        Pack pack = (Pack)query.getSingleResult();
        
        closeTransactionSession();
        
        return pack;
    }

    @Override
    public void update(Pack pack) throws SQLException {
        openTransactionSession();
        
        Session session = getSession();
        session.update(pack);
        
        closeTransactionSession();
    }

    @Override
    public void remove(Pack pack) throws SQLException {
        openTransactionSession();
        
        Session session = getSession();
        session.remove(pack);
        
        closeTransactionSession();
    }
    
}
        