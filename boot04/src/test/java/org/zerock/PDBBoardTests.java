package org.zerock;

import static org.junit.Assert.*;

import java.util.Arrays;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.zerock.domain.PDSBoard;
import org.zerock.domain.PDSFile;
import org.zerock.persistence.PDSBoardRepository;

import lombok.extern.java.Log;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log
public class PDBBoardTests {

	@Autowired
	PDSBoardRepository repo;
	
	@Test
	public void testInsertPDS() {
		PDSBoard pds = new PDSBoard();
		pds.setPname("DOCUMENT 1 - 2");
		
		PDSFile file1 = new PDSFile();
		file1.setPdsfile("file1.doc");
		
		PDSFile file2 = new PDSFile();
		file2.setPdsfile("file2.doc");
		
		pds.setFiles(Arrays.asList(file1, file2));
		
		log.info("try to save pds");
		
		repo.save(pds);
	}
	
	@Transactional
	@Test
	public void deletePDSFile() {
		Long fno = 2L;
		
		int count = repo.deletePDSFile(fno);
		
		log.info("delete pdsfile : " + count);
	}

}
