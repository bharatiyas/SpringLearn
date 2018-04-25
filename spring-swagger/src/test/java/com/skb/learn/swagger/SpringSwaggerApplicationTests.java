package com.skb.learn.swagger;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.skb.learn.swagger.controller.DepartmentController;

// RunWith Annotation is provided by JUnit and we can plugin different runners with it like the Mockito runner
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SpringSwaggerApplicationTests {

	// Using MockMvc we can test the Controllers/RestControllers
	private MockMvc mockMvc;
	
	// InjectMocks mocks the required Class. and if there are any objects to be injected into the class
	// they will be injected as a Mock
	@InjectMocks
	private DepartmentController deptController;
	
	@Before
	public void setup() throws Exception {
		// Create an instance of MockMvc using MockMvcBuilders with the controller as setup 
		mockMvc = MockMvcBuilders.standaloneSetup(deptController)
				.build();
	}
	
	@Test
	public void testGetDepartments() throws Exception {
		mockMvc.perform(get("/swaggerapp/department/").accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
		//.andExpect(jsonPath("$.name", Matchers.is("Finance")));
		
		//.andExpect(arg0)
	}
}

