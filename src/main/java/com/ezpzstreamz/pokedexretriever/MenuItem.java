package com.ezpzstreamz.pokedexretriever;

class MenuItem {

    private String name;
    private int id;
    private String method;

    MenuItem(String name, int id, String method) {
        this.name = name;
        this.id = id;
        this.method = method;
    }

    String getName() {
        return name;
    }

    int getID() {
        return id;
    }

    String getMethod() {
        return method;
    }

}
