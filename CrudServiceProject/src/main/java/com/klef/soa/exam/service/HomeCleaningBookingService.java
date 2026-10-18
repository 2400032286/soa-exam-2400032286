package com.klef.soa.exam.service;

import java.util.List;

import com.klef.soa.exam.entity.HomeCleaningBookingEntity;

public interface HomeCleaningBookingService {

    HomeCleaningBookingEntity addHomeCleaning(HomeCleaningBookingEntity request);

    List<HomeCleaningBookingEntity> getAllHomeCleaning();

    HomeCleaningBookingEntity getHomeCleaningById(Long id);

    String deleteHomeCleaning(Long id);
}
