package com.produtos.api_teste.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import com.produtos.api_teste.model.Produto;
import com.produtos.api_teste.model.execption.ResourseNotfaund;


@Repository
public class ProdutoRpositorio {
    // Simulando um banco de dados 
    private List <Produto> produtos = new ArrayList<Produto>();
     private Integer ultimoId  = 0;

    /**
     * Método para retornar uma lista de produtos 
     * @return lista de produtos 
     * 
    */
     public List <Produto> obterTodos(){
        return produtos;

     }
     /**
      * Método que retorna o produto encontrado pelo seu Id.
      * @param id do produto que sera localizado.
      * @return Retorna um produto que seja  encontrado pelo seu Id
      */
    public Optional <Produto> obterPorId(Integer id){
        return produtos
        .stream()
        .filter(produto -> produto.getId() == id)
        .findFirst();

    }
    /**
     * Método para adcionar produto na lista 
     * @param produto que será adcionado
     * @return produto que será adcionado na lista
     */
    public Produto adicionar (Produto produto){
        ultimoId ++;
        produto.setId(ultimoId);
        produtos.add(produto);
        return produto;
    }
    /**
     * Metodo para deletar o produto por Id
     * @param id do produto a ser deletado
     */
    public void deletar (Integer id){
        produtos.removeIf(produto -> produto.getId() == id);

    }
    /**
     * Metodo para atualziar o produto na lista 
     * @param produto que sera atualizado
     * @return Reporna o produto apos atualziar a lista 
     */
    public Produto atualizar(Produto produto){
        // Encontrar o produto na lista.
        Optional<Produto> produtoEncontrado = obterPorId(produto.getId());
        if(produtoEncontrado.isEmpty()){
            throw new ResourseNotfaund("Produto não encontrado");
        }

        //Eu tenho que remover o produto antigo da lista. 
        deletar(produto.getId());
        
        // Depois adcionar o produtudo atualziado na lista
        produtos.add(produto);

        return produto;

    }
}

