package com.companyname.schoolservice.controller;

import com.companyname.schoolservice.entity.School;
import com.companyname.schoolservice.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/school")
public class SchoolController {
    @Autowired
    private SchoolService schoolService;

    @PostMapping
    public School addSchool(@RequestBody School school){
        System.out.println("School Name: " + school.getSchoolName());
        System.out.println("Location: " + school.getLocation());
        System.out.println("Principal Name: " + school.getPrincipalName());
        return schoolService.addSchool(school);
    }
    @GetMapping
    public List<School> fetchSchools(){
        return  schoolService.fetchSchools();
    }
    @GetMapping("/{id}")
    public School fetchSchoolById(@PathVariable int id){
        return schoolService.fetchSchoolById(id);
    }
}
