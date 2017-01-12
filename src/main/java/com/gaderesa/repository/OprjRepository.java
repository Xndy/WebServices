package com.gaderesa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.gaderesa.domain.Oprj;

public interface OprjRepository extends CrudRepository<Oprj, String>{

	@Query(value="SELECT new com.gaderesa.domain.Oprj(o.prjCode, o.prjName) FROM Oprj o")
	public List<Oprj> getAllProjects();
	
	
}
