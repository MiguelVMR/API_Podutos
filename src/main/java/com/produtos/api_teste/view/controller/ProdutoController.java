package com.produtos.api_teste.view.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.api_teste.model.Produto;
import com.produtos.api_teste.services.ProdutoService;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;
    
    @GetMapping
    public List <Produto> ObterTodos(){
       return produtoService.obterTodos();
    }
    @GetMapping("/{id}")
    public Optional <Produto> obterPorId(@PathVariable Integer id){
        return produtoService.obterPorId(id);
    } 
    @DeleteMapping("/{id}")
    public String deletar (@PathVariable Integer id){
        produtoService.deletar(id);
        return "Produto com " + id +" foi deletado com sucesso!";
    }
    

    @ PostMapping
    public Produto adionar (@RequestBody  Produto produto ){
        return produtoService.adicionar(produto);
    }
    @PutMapping("/{id}")
    public Produto atualizar (@RequestBody Produto produto,@PathVariable Integer id ){
        return produtoService.atualizar(id, produto);

    }

}
