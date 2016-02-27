package sample.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sample.contract.ErrorContract;
import sample.contract.v1.ResponseContractV1;
import sample.contract.v1.ResponseContractV1_1;
import sample.contract.v2.ResponseContractV2;

@RestController
public class ResponseController {
    @RequestMapping("/simple")
    public Object respond(@RequestHeader(value="Api-Version") String version) {
        Double v = 0.0;
        try {
            v = Double.parseDouble(version);
        } catch (NumberFormatException e) {
            return new ResponseEntity<ErrorContract>(
                new ErrorContract(1000, "Invalid or Missing Version"), 
                HttpStatus.BAD_REQUEST);
        }

        if (v == 1) {
             return new ResponseContractV1(v, "content");
        } else if (v == 1.1) {
            return new ResponseContractV1_1(v, "rev'd content");
        }
        else if (v == 2) {
             return new ResponseContractV2(v, "content", "new");
        } else {
             return new ResponseEntity<ErrorContract>(
                new ErrorContract(1001, "Unsupported Version"), 
                HttpStatus.BAD_REQUEST);
        }
    }
}
