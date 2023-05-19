package project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import project.dto.AccompanyDto;
import project.dto.IdealrealDto;
import project.dto.QnaDto;
import project.dto.TravelcourseDto;
import project.dto.TriedDto;

@Mapper
public interface MyPageMapper {

	List<TravelcourseDto> getUserId(@Param("userId") String userId);
	
	List<AccompanyDto> getUserId1(@Param("userId") String userId);

	List<IdealrealDto> getUserId2(@Param("userId") String userId);

	List<QnaDto> getUserId3(@Param("userId") String userId);

	List<TriedDto> getUserId4(@Param("userId") String userId);

	
	
}
