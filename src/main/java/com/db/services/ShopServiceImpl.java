package com.db.services;

import com.db.models.Location;
import com.db.models.Shop;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.GeocodingApiRequest;
import com.google.maps.model.GeocodingResult;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


@Service("shopService")
public class ShopServiceImpl implements ShopService {

    private static final Logger log= Logger.getLogger(ShopServiceImpl.class.getName());
    final String API_KEY = "AIzaSyBKXsA9bYBeNaWy39agEzMQJyhjfqUHdZw";
    List<GeocodingResult[]> longLattList = new ArrayList<GeocodingResult[]>();
    List<Shop> shopList = new ArrayList<Shop>();

    public Shop create(Shop shop){
        shop.getAddress().setLocation(getLongLatt(shop));
        shopList.add(shop);
        return shop;
    }

    public List<Shop> nearBy(Shop shop){
        List<Shop> nearByShops = new ArrayList<Shop>();
        for(Shop sl: shopList){
            double difference = getDistance(shop.getAddress().getLocation().lat, shop.getAddress().getLocation().lng, sl.getAddress().getLocation().lat,sl.getAddress().getLocation().lng);
            if (difference <= 5){
                nearByShops.add(sl);
            }
        }
        return nearByShops;
    }

    public List<Shop> getAll() {
        return shopList;
    }

    public Location getLongLatt(Shop shop){
        GeoApiContext context = new GeoApiContext().setApiKey(API_KEY);
        GeocodingApiRequest req = GeocodingApi.newRequest(context).address(shop.getAddress().toString());

    // Synchronous call
        try {
            GeocodingResult[] results =  req.await();
            System.out.println(results[0].formattedAddress);
            longLattList.add(results);
            //req.await();
            // Handle successful request.
        } catch (Exception e) {
            // Handle error
            log.log(Level.SEVERE, e.toString());
        }
/*
        // Asynchronous call
        req.setCallback(new PendingResult.Callback<GeocodingResult[]>() {
            public void onResult(GeocodingResult[] result) {
                // Handle successful request.
                longLattList.add(result);
            }

            public void onFailure(Throwable e) {
                // Handle error.
                log.log(Level.SEVERE, e.toString());
            }
        });*/

        GeocodingResult[] geocodingResult = longLattList.get(longLattList.size() - 1);
        return new Location(geocodingResult[0].geometry.location.lat, geocodingResult[0].geometry.location.lng);
    }

    /**
     * Find distance between two (lat,long) points.
     */
    private double getDistance(Double lat1, Double long1, Double lat2, Double long2) {
        lat1 = lat1 * Math.PI / 180;
        long1 = long1 * Math.PI / 180;
        lat2 = lat2 * Math.PI / 180;
        long2 = long2 * Math.PI / 180;

        double dlong = long1 - long2;

        double t1 = Math.cos(lat2) * Math.sin(dlong);
        double t2 = Math.cos(lat1) * Math.sin(lat2) - Math.sin(lat1) * Math.cos(lat2) * Math.cos(dlong);
        double t3 = Math.sin(lat1) * Math.sin(lat2) + Math.cos(lat1) * Math.cos(lat2) * Math.cos(dlong);
        double ang_dist = Math.atan2(Math.sqrt(t1 * t1 + t2 * t2), t3);

        return ang_dist * 6371.01;
    }
}