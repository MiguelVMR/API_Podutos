package com.produtos.api_teste.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.produtos.api_teste.model.Produto;
public interface ProdutoRpositorio extends JpaRepository <Produto, Integer>  {
    
}
