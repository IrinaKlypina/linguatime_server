package dao;

import entity.Word;
import java.sql.SQLException;
import java.util.List;

public interface WordDAO {
    // create
    void add(Word word) throws SQLException;
    
    // read
    List<Word> getAll() throws SQLException;
    
    Word getById(Long id) throws SQLException;
    
    // update
    void update(Word word) throws SQLException;
    
    // delete
    void remove(Word word) throws SQLException;
}
