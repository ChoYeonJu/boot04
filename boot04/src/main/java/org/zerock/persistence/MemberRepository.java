package org.zerock.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.zerock.domain.Member;

public interface MemberRepository extends CrudRepository<Member, String>{
	
	@Query("select m.uid, count(p) from member m left outer join profile p " + " on m.uid = p.member where m.uid = ?1 group by m")
	public List<Object[]> getMemberWithProfileCount(String uid);
	
	@Query("select m, p from member m left outer join profile p " + " on m.uid = p.member where m.uid =?1 and p.current = true")
	public List<Object[]> getMemberWithProfile(String uid);

	
}
