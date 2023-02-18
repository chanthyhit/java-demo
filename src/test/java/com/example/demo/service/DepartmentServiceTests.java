package com.example.demo.service;

import com.example.demo.controller.ShareController;
import com.example.demo.pojo.Department;
import com.example.demo.repository.DepartmentRepository;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class DepartmentServiceTests {
    Logger log = LoggerFactory.getLogger(ShareController.class);
    @Autowired
    DepartmentService service;
    @Mock
    DepartmentRepository repository;
    @Test
    public void findOneByIdTest(){
        int id = 1;
        Department expected = new Department(1,"401E","AAC01","DL","1");
        when(repository.findOneById(id)).thenReturn(expected);
        Department actual = service.findOneById(id);
        assertEquals(expected, actual);
    }

    @Test
    public void countGroupByLinesTest(){
        List<Department> departments = service.getDeps();
        Map<String, Long> lines = departments.stream().collect(Collectors.groupingBy(dep -> dep.getLine(),Collectors.counting()));
        lines.forEach((v, k)->log.info(String.format("%s -> %s", v, k)));
        assertEquals(2, lines.get("AAC01").intValue());
    }
}
