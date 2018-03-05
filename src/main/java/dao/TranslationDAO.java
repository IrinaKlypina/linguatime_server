package dao;

import entity.Translation;
import java.sql.SQLException;
import java.util.List;

public interface TranslationDAO {
    // create
    void add(Translation translation) throws SQLException;
    
    // read
    List<Translation> getAll() throws SQLException;
    
    Translation getById(Long id) throws SQLException;
    
    // update
    void update(Translation translation) throws SQLException;
    
    // delete
    void remove(Translation translation) throws SQLException;
}
