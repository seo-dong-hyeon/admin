package com.example.study.service;

import com.example.study.ifs.CrudInterface;
import com.example.study.model.network.Header;
import com.example.study.model.network.reponse.ItemApiResponse;
import com.example.study.model.network.request.ItemApiRequest;

public class ItemApiLogicService implements CrudInterface<ItemApiRequest, ItemApiResponse> {

    @Override
    public Header<ItemApiResponse> create(Header<ItemApiRequest> request) {
        return null;
    }

    @Override
    public Header<ItemApiResponse> read(Long id) {
        return null;
    }

    @Override
    public Header<ItemApiResponse> update(Header<ItemApiRequest> request) {
        return null;
    }

    @Override
    public Header delete(Long id) {
        return null;
    }
}
