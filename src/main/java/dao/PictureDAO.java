package dao;

import entity.Picture;
import java.sql.SQLException;
import java.util.List;

public interface PictureDAO {
    // create
    void add(Picture picture) throws SQLException;
    
    // read
    List<Picture> getAll() throws SQLException;
    
    Picture getById(Long id) throws SQLException;
    
    // update
    void update(Picture picture) throws SQLException;
    
    // delete
    void remove(Picture picture) throws SQLException;
    
}
