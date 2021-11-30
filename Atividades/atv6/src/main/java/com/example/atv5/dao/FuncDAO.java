package com.example.atv5.dao;
import com.example.atv5.model.Funcionario;
import java.sql.SQLException;
import java.util.List;

public interface FuncDAO {
    public void insert(Funcionario funcionario) throws SQLException;
    public List<Funcionario> search() throws SQLException;
    public void delete(int id) throws SQLException;
    public void update(Funcionario funcionario) throws SQLException;

    Funcionario getFuncionario(int id);
}

