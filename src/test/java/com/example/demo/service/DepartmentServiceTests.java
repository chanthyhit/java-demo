package com.example.demo.service;

import com.example.demo.pojo.Department;
import com.example.demo.repository.DepartmentRepository;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("dev")
public class DepartmentServiceTests {
    @Autowired
    DepartmentService service;
    @Mock
    DepartmentRepository repository;
    @Test
    public void findOneByIdTest(){
        int id = 1;
        Department expected = new Department(1,"401A","AAC01","DL","1");
        when(repository.findOneById(id)).thenReturn(expected);
        Department actual = service.findOneById(id);
        assertEquals(expected, actual);
    }
}
