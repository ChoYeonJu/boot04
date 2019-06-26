package org.zerock;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.zerock.domain.PDSBoard;
import org.zerock.domain.PDSFile;
import org.zerock.persistence.PDSFileRepository;

import lombok.extern.java.Log;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log
@Commit
public class PDSBoardTests {
	
	@Autowired
	PDSFileRepository repo;
	
	@Transactional
	@Test
	public void testUpdateFileName1() {
		Long fno = 1L;
		String newName = "updatedFile1.doc";
		
		int count = repo.updatePDSFile(fno, newName);
		
		log.info("update count: " + count);
	}
	
	@Transactional
	@Test
	public void testUpdateFileName2() {
		String newName = "updateFile2.doc";
		
		Optional<PDSBoard> result = repo.findById(2L);
		
		result.ifPresent(pds -> {
			log.info("데이터가 존재하므로 update 시도");
			
			PDSFile target = new PDSFile();
			
			target.setFno(2L);
			target.setPdsfile(newName);
			
			int idx = pds.getFiles().indexOf(target);
			
			if(idx > -1) {
				List<PDSFile> list= pds.getFiles();
				list.remove(idx);
				list.add(target);
				pds.setFiles(list);
			}
			
			repo.save(pds);
		});
	}

}
