package com.db.campus.property.service;

public interface RandomProviderService {

    int generateRandomNumber(int lowerBound, int upperBound);

    <T> T retrieveRandom(Iterable<T> iterable);

}
