package com.civil.userlocation.service;

import com.civil.userlocation.data.CacheMapClass;
import com.civil.userlocation.data.DataConnection;
import com.civil.userlocation.entity.City;
import com.civil.userlocation.entity.User;
import net.sf.geographiclib.Geodesic;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CalculationThread extends Thread {

    private String cityName;

    public CalculationThread(String cityName) {
        this.cityName = cityName;
    }

    /**
     * Starts in a new thread the computation of the List
     * and
     * add to cache map
     */
    public void run(){
        CacheMapClass.getInstance().getCacheMap().put(cityName,buildUserList(cityName));
    }

    /**
     * Find users who are listed as either living in given city,
     * or whose current coordinates are within 50 miles of given city.
     * @param cityName
     * @return
     */
    private List<User> buildUserList(String cityName) {

        DataConnection dataConnection = new DataConnection();
        List<User> resultList = new ArrayList<>();
        int distanceInMile = 50;
        City city = new City();
        city.setName(cityName);
        // set London coordinates
        city.setLatitude(51 + (30 / 60.0) + (26 / 60.0 / 60.0));
        city.setLongitude(0 - (7 / 60.0) - (39 / 60.0 / 60.0));

        String url = "https://bpdts-test-app.herokuapp.com/city/"+city.getName()+"/users";
        resultList.addAll(parseUserObject(dataConnection.getData(url)));
        url= "https://bpdts-test-app.herokuapp.com/users";
        resultList.addAll(getUsersWithinDistance(parseUserObject(dataConnection.getData(url)),city, distanceInMile));
        return resultList;
    }

    /**
     * Get users from the given list whose coordinates is within given distance given city
     * @param userList to find users
     * @param city
     * @param distanceInMile
     * @return List of Users
     */
    private  List<User> getUsersWithinDistance(List<User> userList, City city, int distanceInMile) {
        return userList.stream().filter(user ->
                ((Geodesic.WGS84.Inverse(
                        city.getLatitude(), city.getLongitude(), user.getLatitude(), user.getLongitude()).s12)/1609.34)
                        < distanceInMile).collect(Collectors.toList());
    }

    /**
     * parse Json object to User entity list
     * @param list of objects (JSONArray)
     * @return List of users
     */
    private  List<User> parseUserObject(List<Object> list) {
        List<User> userList = new ArrayList<>();
        JSONArray jsonArray = new JSONArray((list));
        for (int i = 0; i < jsonArray.length(); i++){
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            User user = new User();
            user.setId(jsonObject.getInt("id"));
            user.setFirst_name(jsonObject.getString("first_name"));
            user.setLast_name(jsonObject.getString("last_name"));
            user.setEmail(jsonObject.getString("email"));
            user.setIp_address(jsonObject.getString("ip_address"));
            user.setLatitude(jsonObject.getDouble("latitude"));
            user.setLongitude(jsonObject.getDouble("longitude"));
            userList.add(user);
        }
        return userList;
    }
}
