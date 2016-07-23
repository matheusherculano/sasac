/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sasac.daos;

import br.com.sasac.models.Teste;
import br.com.sasac.repositories.TesteRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Matheus
 */
@Repository
public class TesteDao {
    
    @Autowired
    TesteRepository repository;

    @PersistenceContext
    private EntityManager manager;
    
    public void save(Teste product)
   {
      repository.save(product);
   }
    
    public Teste findById(Integer id)
   {
      return manager.find(Teste.class, id);
   }
    
    public List<Teste> getAll()
   {
       List<Teste> list;
       list = (List<Teste>) repository.findAll();
       return list;
   }

}
