package project.dto;

import lombok.Data;

@Data
public class TravelcourseDto {
	//여행코스정보
	int travelcourseIdx;				//여행코스인덱스
	String travelcourseCreatedtime;		//여행코스작성일
	int travelcourseCnt;				//여행코스조회수
	int travelcourseRcmd;				//여행코스추천수
	String travelcourseDeleted;			//삭제여부
	String userId;						//유저아이디(외래키)
}
