package project.dto;

import lombok.Data;

@Data
public class TriedDto {
	//어디까지정보(음식,문화,장소)
	int triedIdx;			//어디까지인덱스
	String triedImg;		//어디까지 사진
	String triedContent;	//어디까지 내용
	String triedCreatedTime;//어디까지 작성시간
	String triedDeleted;	//삭제여부
	int triedCnt;			//조회수
	int triedRcmd;			//추천수
	String userId;			//유저아이디(외래키)
	int triedCategoryIdx;	//어디까지카테고리인덱스(외래키)
}
