package sample.controller;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.autoconfigure.web.AbstractErrorController;
import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Basic Controller which is called for unhandled errors
 */
@Controller
@RequestMapping("/error")
public class AppErrorController extends AbstractErrorController {

    private final ErrorProperties errorProperties;
    
   
    public AppErrorController() {
        super(new DefaultErrorAttributes());
        this.errorProperties = null;
    }
    
    public AppErrorController(ErrorAttributes errorAttributes, ErrorProperties errorProperties) {
        super(errorAttributes);
        this.errorProperties = errorProperties;
    }
    
    @ResponseBody
    public ResponseEntity<Object> error(HttpServletRequest request) {
        HttpStatus status = getStatus(request);
        //RequestAttributes body = new ServletRequestAttributes(request);
        
        java.util.Map<String, Object> model = getErrorAttributes(request, true);
        return new ResponseEntity<Object>(model, status);
    }
    
    public HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request
                .getAttribute("javax.servlet.error.status_code");
        if (statusCode != null) {
            try {
                return HttpStatus.valueOf(statusCode);
            }
            catch (Exception ex) {
            }
        }
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }

    @Override
    public String getErrorPath() {
    // TODO Auto-generated method stub
    return null;
    }

    public ErrorProperties getErrorProperties() {
    return errorProperties;
    }
}