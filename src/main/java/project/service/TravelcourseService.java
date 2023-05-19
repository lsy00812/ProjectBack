package project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import project.dto.TravelcourseDto;
import project.mapper.TravelcourseMapper;

@Service
public class TravelcourseService {

	@Autowired
	private TravelcourseMapper mapper;

	public List<TravelcourseDto> selectCourseList() throws Exception {
		return mapper.selectCourseList();
	}

	public int insertCourse(TravelcourseDto travelcourseDto) throws Exception {
		return mapper.insertCourse(travelcourseDto);
	}

	public TravelcourseDto selectCourseDetail(int travelcourseIdx) throws Exception {
		return mapper.selectCourseDetail(travelcourseIdx);
	}

	public int updateCourse(TravelcourseDto travelcourseDto) throws Exception {
		int updatedCount = mapper.updateCourse(travelcourseDto);
		return updatedCount;
	}

	public int deleteCourse(int travelcourseIdx) throws Exception {
		int deletedCount = mapper.deleteCourse(travelcourseIdx);
		return deletedCount;
	}
	
//	public List<TravelcourseDto> getTravelcourseUserId(String userId) throws Exception{
//		return mapper.getTravelcourseUserId(userId);
//	}

	

	
}
