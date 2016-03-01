package sample.controller.test; 

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.junit.Assert.*;

import sample.contract.v1.ResponseContractV1;
import sample.controller.ResponseController;

public class ResponseControllerV1Tests {

    final String BASE_URL = "http://localhost:8088/";

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setup() throws Exception {
        ResponseController instance = new ResponseController();
        this.mockMvc = MockMvcBuilders.standaloneSetup(instance).build();
    }

    @Test
    public void testController_success_simpleRequest() throws Exception {
        MockHttpServletRequestBuilder getRequest = get("/simple");
        getRequest.header("api-version", "1");
        ResultActions action = mockMvc.perform(getRequest).andExpect(status().isOk());
        MvcResult r = action.andReturn();
        String str = r.getResponse().getContentAsString();
        
        ObjectMapper mapper = new ObjectMapper();
        ResponseContractV1 c = mapper.readValue(str, ResponseContractV1.class);
        
        assertTrue("Id value is not correct", c.getId() == 1);
        assertTrue("Cant find V1 Content", c.getContent().indexOf("_V1Content") >=0);
    }
    
    @Test
    public void testController_fail_badRequest_noVersionHeader() throws Exception{
        
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/simple")).andReturn();
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