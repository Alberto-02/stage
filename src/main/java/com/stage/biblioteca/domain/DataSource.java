package com.stage.biblioteca.domain;

public class DataSource {

    private String name;
    private String url;
    private int port;

    public DataSource(String name, String url, int port) {

        this.name = name;
        this.url = url;
        this.port = port;
    }
}
