package org.example.forum.dao;

import org.example.forum.entity.Response;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ResponseRepository extends JpaRepository<Response, Long> {

}
