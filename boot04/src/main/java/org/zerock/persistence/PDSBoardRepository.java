package org.zerock.persistence;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.zerock.domain.PDSBoard;

public interface PDSBoardRepository extends CrudRepository<PDSBoard, Long>{
	
	@Modifying
	@Query("delete from PDSFile f where f.fno = ?1")
	public int deletePDSFile(Long fno);


}
