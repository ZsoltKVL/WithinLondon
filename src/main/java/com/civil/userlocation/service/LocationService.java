package com.civil.userlocation.service;

import com.civil.userlocation.data.CacheMapClass;
import com.civil.userlocation.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {

    /**
     *  if the answer was already computed by the system the method will return with the value
     *  else
     *  responds to the caller immediately with a message
     *  and
     *  starts in an asynchronous way the computation of the value
     * @param city
     * @return
     */
    public ResponseEntity<?> getUsersWithinDistanceOfCity(String city) {
        List<User> userList = CacheMapClass.getInstance().getCacheMap().get(city);
        if (userList != null && 0 < userList.size()){
            return new ResponseEntity<>(userList, HttpStatus.CREATED.OK);
        }
        CalculationThread calculationThread = new CalculationThread(city);
        calculationThread.start();
        return new ResponseEntity<>("we’re calculating the answer, please come back in few minutes...", HttpStatus.CREATED.OK);
    }

}
