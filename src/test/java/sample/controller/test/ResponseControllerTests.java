package sample.controller.test; 

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

//@RunWith(SpringJUnit4ClassRunner.class)
public class ResponseControllerTests {

    final String BASE_URL = "http://localhost:8080/";

    @Autowired
    //private WebApplicationContext wac;
    //private MockMvc mockMvc;

    @Before
    public void setup() {
        //this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void testResponse() throws Exception{
        /*
         this.mockMvc.perform(get("/")
                 .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                 .andExpect(status().isOk())
                 .andExpect(content().contentType("application/json"));
                 */
    }
}