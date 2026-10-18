package com.klef.soa.exam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.soa.exam.entity.HomeCleaningBookingEntity;
import com.klef.soa.exam.repository.HomeCleaningBookingRepository;

@Service
public class HomeCleaningBookingServiceImpl implements HomeCleaningBookingService
{
    @Autowired
    private HomeCleaningBookingRepository repository;

    @Override
    public HomeCleaningBookingEntity addHomeCleaning(HomeCleaningBookingEntity request)
    {
       
        return repository.save(request);
    }

    @Override
    public List<HomeCleaningBookingEntity> getAllHomeCleaning()
    {
        return repository.findAll();
    }

    @Override
    public HomeCleaningBookingEntity getHomeCleaningById(Long id)
    {
        return repository.findById(id).orElse(null);
    }

    @Override
    public String deleteHomeCleaning(Long id) 
    {

        boolean status = repository.existsById(id);

        if (status)
        {
            repository.deleteById(id);
            return "Home Cleaning Booking Deleted Successfully";
        } 
        else 
        {
            return "Home Cleaning Booking ID not found";
        }
    }
}