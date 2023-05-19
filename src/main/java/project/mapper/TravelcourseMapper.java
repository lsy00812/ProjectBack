package project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import project.dto.TravelcourseDto;

@Mapper
public interface TravelcourseMapper {

	int insertCourse(TravelcourseDto travelcourseDto) throws Exception;

	TravelcourseDto selectCourseDetail(int travelcourseDtoIdx) throws Exception;

	List<TravelcourseDto> selectCourseList() throws Exception;

	int updateCourse(TravelcourseDto travelcourseDto) throws Exception;

	int deleteCourse(int travelcourseIdx) throws Exception;
	
	List<TravelcourseDto> getTravelcourseUserId(String userId) throws Exception;
}
