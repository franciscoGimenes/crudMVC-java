package com.example.crudmvc.controller;

import com.example.crudmvc.model.Aluno;
import com.example.crudmvc.service.AlunoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @GetMapping("/")
    public String inicio() {
        return "redirect:/alunos";
    }

    @GetMapping("/alunos")
    public String listar(Model model) {
        model.addAttribute("alunos", alunoService.listarTodos());
        return "listar";
    }

    @GetMapping("/alunos/novo")
    public String novoFormulario(Model model) {
        model.addAttribute("aluno", new Aluno());
        return "formulario";
    }

    @PostMapping("/alunos/salvar")
    public String salvar(@ModelAttribute Aluno aluno) {
        alunoService.salvar(aluno);
        return "redirect:/alunos";
    }

    @GetMapping("/alunos/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Aluno aluno = alunoService.buscarPorId(id);
        model.addAttribute("aluno", aluno);
        return "formulario";
    }

    @GetMapping("/alunos/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        alunoService.deletar(id);
        return "redirect:/alunos";
    }

    @GetMapping("/alunos/detalhes/{id}")
    public String detalhes(@PathVariable Long id, Model model) {
        Aluno aluno = alunoService.buscarPorId(id);
        model.addAttribute("aluno", aluno);
        return "detalhes";
    }
}