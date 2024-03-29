package org.zerock.persistence;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.zerock.domain.PDSBoard;

public interface PDSFileRepository extends CrudRepository<PDSBoard, Long>{
	
	@Modifying
	@Query("update from pdsfile f set f.pdsfile = ?2 where f.fno = ?1")
	public int updatePDSFile(Long fno, String newFileName);

}
