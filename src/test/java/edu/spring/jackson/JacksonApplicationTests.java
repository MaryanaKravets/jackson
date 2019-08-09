package edu.spring.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.spring.jackson.controller.JController;
import edu.spring.jackson.dto.User;
import edu.spring.jackson.service.IUserService;
import edu.spring.jackson.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Map;
import java.util.Objects;

//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@RunWith(SpringJUnit4ClassRunner.class)
//@EnableAutoConfiguration
//@WebMvcTest
//@AutoConfigureMockMvc
//@ContextConfiguration(classes = JController.class)
@SpringBootTest
@RunWith(SpringRunner.class)
public class JacksonApplicationTests {
//@Autowired
//private MockMvc mockMvc;
  //  @MockBean
    private RestTemplate restTemplate;
    @LocalServerPort
    int randomServerPort;
   // @Autowired
   // @MockBean
    //private UserService  userService;
    //@MockBean
   // private IUserService iUserService;

    private String localURL = "http://localhost:" + randomServerPort;

//
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Test
    public void testController() {
        User user = new User("Iryna", "Antonyak", "iryna1984@ukr.net");
       // String URL = localURL + "/add";
        String URL="http://localhost:8080/add";
       // when(userService.printDataByEmail(any(User.class))).thenReturn(user);

        HttpEntity<User> httpEntity = new HttpEntity<>(user);
        ResponseEntity<HttpStatus> responseEntity = restTemplate.postForEntity(URL, httpEntity, HttpStatus.class);
        assertEquals(HttpStatus.CREATED, responseEntity.getBody());
    }

//    @Test
//    public void testController2() {
//        Map<String, Boolean> stringBooleanMap = Map.of("hw1", true, "hw2", false, "hw3", true);
//        String URL = localURL + "/{olena1995@gmail.com}/get";
//        ResponseEntity<User> responseEntity = restTemplate.getForEntity(localURL, User.class);
//
//
//        //User.builder().body()
//        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
//        assertEquals("Olena",responseEntity.getBody().getName());
//        assertEquals("Lisova", responseEntity.getBody().getSurName());
//        assertEquals(LocalDate.of(2019, 8, 2), responseEntity.getBody().getLastLoginDate());
//        assertEquals(1234, responseEntity.getBody().getAccessId());
//        assertEquals(stringBooleanMap, responseEntity.getBody().getHomeworkToIsDone());
//        }
    }

