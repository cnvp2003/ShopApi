package com.db.services;

import com.db.models.Shop;

import java.util.List;

public interface ShopService {
    Shop create(Shop shop);
    List<Shop> getAll();
    List<Shop> nearBy(Shop shop);
}