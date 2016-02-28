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
import sample.converter.TypeConverter;
import sample.model.CanonicalDataModel;

@RestController
public class ResponseController {
    @RequestMapping("/simple")
    public Object respond(@RequestHeader(value="Api-Version") String version) {
        
        // Parse Header and if not present or invalid return BAD_REQUEST
        Double v = 0.0;
        try {
            v = Double.parseDouble(version);
        } catch (NumberFormatException e) {
            return new ResponseEntity<ErrorContract>(
                new ErrorContract(1000, "Invalid or Missing Version"), 
                HttpStatus.BAD_REQUEST);
        }
        
        // Go get some data somewhere
        CanonicalDataModel m = new CanonicalDataModel();

        // Switch on Version and return right contract from Model
        if (v == 1) {
             return TypeConverter.ConvertModelToContractV1(m);
        } else if (v == 1.1) {
            return TypeConverter.ConvertModelToContractV1_1(m);
        }
        else if (v == 2) {
             return TypeConverter.ConvertModelToContractV2(m);
        } else {
             return new ResponseEntity<ErrorContract>(
                new ErrorContract(1001, "Unsupported Version"), 
                HttpStatus.BAD_REQUEST);
        }
    }
}
