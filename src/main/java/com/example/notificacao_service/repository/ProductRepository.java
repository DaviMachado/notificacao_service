package com.example.notificacao_service.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.notificacao_service.domain.entity.ProductEntity;

public interface ProductRepository extends CrudRepository<ProductEntity, String> {

}
