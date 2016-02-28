package sample.controller.test; 

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.*;
import sample.controller.ResponseController;

public class ResponseControllerTests {

    final String BASE_URL = "http://localhost:8080/";

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setup() throws Exception {
        ResponseController instance = new ResponseController();
        this.mockMvc = MockMvcBuilders.standaloneSetup(instance).build();
    }

    @Test
    public void testController_fail_badRequest_noVersionHeader() throws Exception{
        
        //MockHttpServletRequestBuilder getRequest = get("/simple");
        //ResultActions results = mockMvc.perform(getRequest);
        //results.andExpect(status().isBadRequest());
        //.andExpect(content().contentType(MediaType.APPLICATION_JSON))
        //.andExpect(jsonPath("$.person.name").value("Jason"));
        
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                .get("/simple").accept(MediaType.APPLICATION_JSON)).andReturn();

        Exception ex = result.getResolvedException();
        if (ex == null) {
            fail("expected exception is null");
        }
        
        assertTrue(
                "Unexpected Exception Message",
                ex.getMessage().equals("Missing request header 'Api-Version' for method parameter of type String"));
        assertTrue(
                "Status Codes do not match",
                result.getResponse().getStatus() == HttpStatus.BAD_REQUEST.value());
    }
}