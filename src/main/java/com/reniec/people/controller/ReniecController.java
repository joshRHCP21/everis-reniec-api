package com.reniec.people.controller;

import com.reniec.people.entity.Person;
import com.reniec.people.entity.ReniecResponse;
import com.reniec.people.service.ReniecService;
import io.reactivex.Single;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/external/reniec")
@Api("/external/reniec")
public class ReniecController
{
    @Autowired
    ReniecService reniecService;

    @PostMapping("/validate")
    @ApiOperation(value = "Validate if people are registered by their Document Number", notes = "Retrieving Reniec Response", response = ReniecResponse.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = ReniecResponse.class)
    })
    public Single<ReniecResponse> validateFingerPrintByDocument(@RequestBody Person person)
    {
        return reniecService.validateFingerPrint(person.getDocument());
    }
}
