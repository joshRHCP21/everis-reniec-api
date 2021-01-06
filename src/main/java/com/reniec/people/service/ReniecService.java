package com.reniec.people.service;

import com.reniec.people.entity.ReniecResponse;
import io.reactivex.Single;

public interface ReniecService
{
    Boolean existsByDocument(String document);
    Single<ReniecResponse> validateFingerPrint(String document);
}
