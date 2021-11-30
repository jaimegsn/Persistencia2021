package com.example.atv5.dao;
import com.example.atv5.model.Funcionario;
import com.example.atv5.util.JPAUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.*;
import java.sql.SQLException;
import java.util.List;

@Repository
public class FuncJPADAO implements FuncDAO {
    @Autowired
    EntityManager manager;

    @Override
    public void insert(Funcionario funcionario){
            manager = JPAUtil.getEntityManager();
            JPAUtil.beginTransaction();
            manager.persist(funcionario);
            JPAUtil.commit();
    }

    @Override
    public List<Funcionario> search() throws SQLException {
        manager = JPAUtil.getEntityManager();
        List<Funcionario> funcionarios = manager.createQuery("select f from Funcionario as f", Funcionario.class).getResultList();
        return funcionarios;
    }

    @Override
    public void delete(int id) throws SQLException {
        manager = JPAUtil.getEntityManager();
        Funcionario funcionario = getFuncionario(id);
        JPAUtil.beginTransaction();
        manager.remove(funcionario);
        JPAUtil.commit();
    }

    @Override
    public void update(Funcionario funcionario) throws SQLException {
        manager = JPAUtil.getEntityManager();
        JPAUtil.beginTransaction();
        manager.merge(funcionario);
        JPAUtil.commit();
    }

    @Override
    public Funcionario getFuncionario(int id) {
        manager = JPAUtil.getEntityManager();
        return manager.find(Funcionario.class, id);
    }
}