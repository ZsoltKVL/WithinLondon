package com.civil.userlocation.data;

import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

public class DataConnection {

    /**
     * Get data from given URL.
     * @param url
     * @return List of Object (JSON Array)
     */
    public List<Object> getData(String url) {
        return  WebClient.builder().
                build().
                get().
                uri(url).
                retrieve().bodyToMono(List.class).
                block();
    }

}
