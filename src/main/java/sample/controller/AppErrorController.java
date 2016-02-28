package sample.controller;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.autoconfigure.web.AbstractErrorController;
import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import sample.contract.ErrorContract;

/**
 * Basic Controller which is called for unhandled errors
 */
@RestController
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
    @RequestMapping("/error")
    public ResponseEntity<ErrorContract> error(HttpServletRequest request) {
        HttpStatus status = getStatus(request);
        if (status == HttpStatus.NOT_FOUND) {
            return new ResponseEntity<ErrorContract>(new ErrorContract(1004, "NotFound"), status);
        } else {
            java.util.Map<String, Object> model = getErrorAttributes(request, true);
            return new ResponseEntity<ErrorContract>(new ErrorContract(1005, model.get("message").toString()), status);
        }
    }
    
    public HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
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
        return null;
    }

    public ErrorProperties getErrorProperties() {
        return errorProperties;
    }
}