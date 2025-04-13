package com.companyname.studentservice.client;

import com.companyname.studentservice.dto.School;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("SCHOOL-SERVICE")
public interface SchoolClient {

    @GetMapping("/school/{id}")
    School fetchSchoolById(@PathVariable("id") int schoolId);
}
