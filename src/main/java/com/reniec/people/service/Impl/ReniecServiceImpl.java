package com.reniec.people.service.Impl;

import com.reniec.people.entity.ReniecResponse;
import com.reniec.people.service.ReniecService;
import io.reactivex.Single;
import org.springframework.stereotype.Service;

@Service
public class ReniecServiceImpl implements ReniecService
{

    @Override
    public Boolean existsByDocument(String document)
    {
        return true;
    }

    @Override
    public Single<ReniecResponse> validateFingerPrint(String document)
    {
        ReniecResponse response = new ReniecResponse("Core", true);
        return existsByDocument(document) == true ? Single.just(response) : null;
    }
}
