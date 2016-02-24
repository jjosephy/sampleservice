package sample.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sample.contract.ErrorContractV1;
import sample.contract.ResponseContractV1;

@RestController
public class ResponseController {
    @RequestMapping("/simple")
    public Object respond(@RequestHeader(value="Api-Version") String version) {
        Double v = 0.0;
        try {
            v = Double.parseDouble(version);
        } catch (NumberFormatException e) {
            ErrorContractV1 err = new ErrorContractV1(1000, "Invalid or Missing Version");
            return new ResponseEntity<ErrorContractV1>(err, HttpStatus.BAD_REQUEST);
        }

        //return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);

        return new ResponseContractV1(v, "content");
    }
}
