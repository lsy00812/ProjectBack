package project.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import project.dto.AccompanyDto;
import project.dto.IdealrealDto;
import project.dto.QnaDto;
import project.dto.TravelcourseDto;
import project.dto.TriedDto;
import project.service.MyPageService;

@Slf4j
@RestController
public class MyPageController {
	
	
	@Autowired
	private MyPageService service;
	
	
	@GetMapping("/api/mypage/{userId}")
	public ResponseEntity<Map<String,Object>> getUserId(@PathVariable("userId") String userId) throws Exception {
		
			
		userId = userId.replace("-",",");
		Map<String, Object> map = new HashMap<>();
		
		
		List<TravelcourseDto> travelcourse = service.getUserId(userId);
		map.put("travelcourse", travelcourse);
		
		List<AccompanyDto> accompany = service.getUserId1(userId);
		map.put("accompany", accompany);
		
		List<IdealrealDto> Idealreal = service.getUserId2(userId);
		map.put("Idealreal", Idealreal);
		
		List<QnaDto> Qna = service.getUserId3(userId);
		map.put("Qna", Qna);
		
		List<TriedDto> Tried = service.getUserId4(userId);
		map.put("Tried", Tried);
		
		return ResponseEntity.status(HttpStatus.OK).body(map);
	}
	

	
}
