package com.example.serverTest.global.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageRequest {

    private int page;
    private int size;

    public PageRequest(int page, int size) {
        this.page = page;
        this.size = size;
    }

}
