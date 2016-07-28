package br.com.sasac.controller;

import br.com.sasac.model.Aluno;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/aluno")
@Transactional
public class AlunoController extends CustomController<Aluno, CrudRepository<Aluno, Long>>{
    
}
