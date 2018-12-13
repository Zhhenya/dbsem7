package com.db.campus.property.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class RandomProviderServiceImpl implements RandomProviderService {

    private final Random random = new Random();

    @Override
    public int generateRandomNumber(int lowerBound, int upperBound) {
        return random.nextInt(upperBound) + lowerBound;
    }

    @Override
    public <T> T retrieveRandom(Iterable<T> iterable) {
        List<T> list = new ArrayList<>();
        iterable.forEach(list::add);
        return list.get(generateRandomNumber(0, list.size()));
    }
}
