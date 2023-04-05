package com.produtos.api_teste.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.produtos.api_teste.model.Produto;
@Repository
public interface ProdutoRpositorio extends JpaRepository <Produto, Integer>  {
    
}
