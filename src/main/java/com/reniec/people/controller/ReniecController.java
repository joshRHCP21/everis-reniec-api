package com.reniec.people.controller;

import com.reniec.people.entity.Person;
import com.reniec.people.entity.ReniecResponse;
import com.reniec.people.service.ReniecService;
import io.reactivex.Single;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/external/reniec")
public class ReniecController
{
    @Autowired
    ReniecService reniecService;

    @PostMapping("/validate")
    public Single<ReniecResponse> validateFingerPrintByDocument(@RequestBody Person person)
    {
        return reniecService.validateFingerPrint(person.getDocument());
    }
}
