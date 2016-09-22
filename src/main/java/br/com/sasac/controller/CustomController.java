/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sasac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Matheus Herculano
 * @param <T>
 * @param <D>
 */
public class CustomController<T, D extends CrudRepository<T, Long>> {
 
    @Autowired
    private D repository;
    
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity get() {
        Iterable<T> t = repository.findAll();
        
        return new ResponseEntity(t, HttpStatus.OK);
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity getById(@PathVariable Long id) {
        T t = repository.findOne(id);
        
        return new ResponseEntity(t, HttpStatus.OK);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity save(@RequestBody T t) {
        repository.save(t);
        
        return new ResponseEntity(HttpStatus.OK);
    }
    
    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public ResponseEntity update(@RequestBody T t, @PathVariable Long id) {
        repository.save(t);
        
        return new ResponseEntity(HttpStatus.OK);
    }
    
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity delete( @PathVariable Long id) {
        repository.delete(id);
        
        return new ResponseEntity(HttpStatus.OK);
    }
    
}
