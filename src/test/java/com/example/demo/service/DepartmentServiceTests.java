package com.example.demo.service;

import com.example.demo.pojo.Department;
import com.example.demo.repository.DepartmentRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class DepartmentServiceTests {
    @Autowired
    DepartmentService service;
    @Mock
    DepartmentRepository repository;
    @Test
    public void findOneByIdTest(){
        System.out.println("================================");
        int id = 1;
        Department expected = new Department(1,"401E","AAC01","DL","1");
        when(repository.findOneById(id)).thenReturn(expected);
        Department actual = service.findOneById(id);
        assertEquals(expected, actual);
    }
}
