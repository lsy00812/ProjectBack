package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import project.service.ProjectService;

@Slf4j
@RestController
public class ApiController {
	
	@Autowired
	private ProjectService projectService;
	
}
