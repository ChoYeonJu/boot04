package org.zerock.domain;

import java.security.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "tbl_free_replies")
@EqualsAndHashCode(of = "rno")
public class FreeBoardReply {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long rno;
	private String reply;
	private String replayer;

	@CreationTimestamp
	private Timestamp replydate;
	@UpdateTimestamp
	private Timestamp updatedate;
	
	@ManyToOne
	private FreeBoard board;
}
