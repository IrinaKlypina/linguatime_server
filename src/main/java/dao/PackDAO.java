package dao;

import entity.Pack;
import java.sql.SQLException;
import java.util.List;

public interface PackDAO {
    // create
    void add(Pack pack) throws SQLException;
    
    // read
    List<Pack> getAll() throws SQLException;
    
    Pack getById(Long id) throws SQLException;
    
    // update
    void update(Pack pack) throws SQLException;
    
    // delete
    void remove(Pack pack) throws SQLException;
    
    
}
