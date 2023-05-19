package project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.dto.AccompanyDto;
import project.dto.IdealrealDto;
import project.dto.QnaDto;
import project.dto.TravelcourseDto;
import project.dto.TriedDto;
import project.mapper.MyPageMapper;

@Service
public class MyPageService {
	
	@Autowired
	private MyPageMapper mapper;

	public List<AccompanyDto> getUserId1(String userId) throws Exception {
		return mapper.getUserId1(userId);
	}
	
	public List<TravelcourseDto> getUserId(String userId) throws Exception {
		return mapper.getUserId(userId);
	}

	public List<IdealrealDto> getUserId2(String userId) throws Exception{
		return mapper.getUserId2(userId);
	}

	public List<QnaDto> getUserId3(String userId) throws Exception{
		return mapper.getUserId3(userId);
	}

	public List<TriedDto> getUserId4(String userId) throws Exception {
		return mapper.getUserId4(userId);
	}

	
}
	
