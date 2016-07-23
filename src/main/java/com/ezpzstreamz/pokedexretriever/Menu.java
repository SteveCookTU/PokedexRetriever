package com.ezpzstreamz.pokedexretriever;

import java.util.ArrayList;

class Menu extends ArrayList<MenuItem> {

    @Override
    public String toString() {
        String response = "";
        for(int i = 0; i < this.size(); i++) {
            if(i == 0)
                response += this.get(i).getName() + "\n";
            else
                response += this.get(i).getID() + ": " + this.get(i).getName() + "\n";
        }
        return response;
    }

}
