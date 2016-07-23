package com.ezpzstreamz.pokedexretriever;

import me.sargunvohra.lib.pokekotlin.client.PokeApi;
import me.sargunvohra.lib.pokekotlin.client.PokeApiClient;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

class PokedexRetriever {

    private static HashMap<Integer, Menu> menus = new HashMap<>();
    private static Scanner kb;
    private static PokeApi pokeApi;
    private static String input;
    //private static VersionGroup version;
    private static Menu current;
    private static Menu main;

    public static void main(String[] args) {
        pokeApi = new PokeApiClient();
        kb = new Scanner(System.in);
        /*for (NamedApiResource vGroup : pokeApi.getVersionGroupList(0, 16).getResults()) {
            System.out.println(vGroup.getId() + ": " + vGroup.getName());
        }
        System.out.print("Select a pokemon game version: ");
        input = kb.nextLine();
        while (!isInt(input) || Integer.parseInt(input) < 1 || Integer.parseInt(input) > 16) {
            System.out.print("Select a pokemon game version: ");
            input = kb.nextLine();
        }
        version = pokeApi.getVersionGroup(Integer.parseInt(input));*/
        fillMenus();
        displayCurrentMenu();
        clearConsole();
    }

    @SuppressWarnings("all")
    static boolean isInt(String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private static void displayCurrentMenu() {
        if (current == main) {
            do {
                clearConsole();
                System.out.print(current + "Please select a menu item by number: ");
                input = kb.nextLine();
            }
            while ((!isInt(input) || Integer.parseInt(input) < 1 || Integer.parseInt(input) > current.size() - 1) && !input.equalsIgnoreCase("exit"));
            if (!input.equalsIgnoreCase("exit")) {
                current = menus.get(Integer.parseInt(input));
                displayCurrentMenu();
            }
        } else {
            do {
                clearConsole();
                System.out.print(current + "Please select a menu item by number: ");
                input = kb.nextLine();
            }
            while ((!isInt(input) || Integer.parseInt(input) < 1 || Integer.parseInt(input) > current.size() - 1) && !input.equalsIgnoreCase("back"));
            if (input.equalsIgnoreCase("back")) {
                current = main;
                displayCurrentMenu();
            } else {
                clearConsole();
                loadMenuOption();
                displayCurrentMenu();
            }

        }

    }

    private static void loadMenuOption() {
        try {
            Method method = MenuItemMethods.class.getMethod(current.get(Integer.parseInt(input)).getMethod());
            method.invoke(null);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private static void fillMenus() {

        //Main Menu
        main = new Menu();
        main.addAll(Arrays.asList(
                new MenuItem("Main Menu: ", 0, ""),
                new MenuItem("Berries", 1, ""),
                new MenuItem("Contests Menu", 2, ""),
                new MenuItem("Encounters", 3, ""),
                new MenuItem("Evolutions", 4, ""),
                new MenuItem("Games", 5, ""),
                new MenuItem("Items", 6, ""),
                new MenuItem("Machines", 7, ""),
                new MenuItem("Moves", 8, ""),
                new MenuItem("Locations", 9, ""),
                new MenuItem("Pokemon", 10, ""),
                new MenuItem("Utilities", 11, "")));
        current = main;

        //Berries
        Menu berries = new Menu();
        berries.addAll(Arrays.asList(
                new MenuItem("Berries Menu: ", 0, ""),
                new MenuItem("Berries", 1, "getBerries"),
                new MenuItem("Berry Firmness", 2, "getBerryFirmness"),
                new MenuItem("Flavors", 3, "getFlavors")));
        menus.put(1, berries);

        //Contests
        Menu contests = new Menu();
        contests.addAll(Arrays.asList(
                new MenuItem("Contests Menu: ", 0, ""),
                new MenuItem("Contest Types", 1, "getContestTypes"),
                new MenuItem("Contest Effects", 2, "getContestEffects"),
                new MenuItem("Super Contest Effects", 3, "getSuperContestEffects")));
        menus.put(2, contests);

        //Encounters
        Menu encounters = new Menu();
        encounters.addAll(Arrays.asList(
                new MenuItem("Encounters Menu: ", 0, ""),
                new MenuItem("Encounter Methods", 1, "getEncounterMethods"),
                new MenuItem("Encounter Conditions", 2, "getEncounterConditions"),
                new MenuItem("Encounter Condition Values", 3, "getEncounterConditionValues")));
        menus.put(3, encounters);

        //Evolutions
        Menu evolutions = new Menu();
        evolutions.addAll(Arrays.asList(
                new MenuItem("Evolutions Menu: ", 0, ""),
                new MenuItem("Evolution Chains", 1, "getEvolutionChains"),
                new MenuItem("Evolution Triggers", 2, "getEvolutionTriggers")));
        menus.put(4, evolutions);

        //Games
        Menu games = new Menu();
        games.addAll(Arrays.asList(
                new MenuItem("Games Menu: ", 0, ""),
                new MenuItem("Generations", 1, "getGenerations"),
                new MenuItem("Pokedexes", 2, "getPokedexes"),
                new MenuItem("Versions", 3, "getVersions"),
                new MenuItem("Version Groups", 4, "getVersionGroups")));
        menus.put(5, games);

        //Items
        Menu items = new Menu();
        items.addAll(Arrays.asList(
                new MenuItem("Items Menu: ", 0, ""),
                new MenuItem("Items", 1, "getItems"),
                new MenuItem("Item Attributes", 2, "getItemAttributes"),
                new MenuItem("Item Categories", 3, "ItemCategories"),
                new MenuItem("Item Fling Effects", 4, "getItemFlingEffects"),
                new MenuItem("Item Pockets", 5, "getItemPockets")));
        menus.put(6, items);

        //Machines
        Menu machines = new Menu();
        machines.addAll(Arrays.asList(
                new MenuItem("Machines Menu", 0, ""),
                new MenuItem("Machines", 1, "getMachines")));
        menus.put(7, machines);

        //Moves
        Menu moves = new Menu();
        moves.addAll(Arrays.asList(
                new MenuItem("Moves Menu: ", 0, ""),
                new MenuItem("Moves", 1, "getMoves"),
                new MenuItem("Move Ailments", 2, "getMoveAilments"),
                new MenuItem("Move Battle Styles", 3, "getMoveBattleStyles"),
                new MenuItem("Move Categories", 4, "getMoveCategories"),
                new MenuItem("Move Damage Classes", 5, "getMoveDamageClasses"),
                new MenuItem("Move Learn Methods", 6, "getMoveLearnMethods"),
                new MenuItem("Move Targets", 7, "getMoveTargets")));
        menus.put(8, moves);

        //Locations
        Menu locations = new Menu();
        locations.addAll(Arrays.asList(
                new MenuItem("Locations Menu: ", 0, ""),
                new MenuItem("Locations", 1, "getLocations"),
                new MenuItem("Location Areas", 2, "getLocationAreas"),
                new MenuItem("Pal Park Areas", 3, "getPalParkAreas"),
                new MenuItem("Regions", 4, "getRegions")));
        menus.put(9, locations);

        //Pokemon
        Menu pokemon = new Menu();
        pokemon.addAll(Arrays.asList(
                new MenuItem("Pokemon Menu: ", 0, ""),
                new MenuItem("Abilities", 1, "getAbilities"),
                new MenuItem("Characteristics", 2, "getCharacteristics"),
                new MenuItem("Egg Groups", 3, "getEggGroups"),
                new MenuItem("Genders", 4, "getGenders"),
                new MenuItem("Growth Rates", 5, "getGrowthRates"),
                new MenuItem("Natures", 6, "getNatures"),
                new MenuItem("Pokeathlon Stats", 7, "getPokeathlonStats"),
                new MenuItem("Pokemon", 8, "getPokemon"),
                new MenuItem("Pokemon Colors", 9, "getPokemonColors"),
                new MenuItem("Pokemon Forms", 10, "getPokemonForms"),
                new MenuItem("Pokemon Habitats", 11, "getPokemonHabitats"),
                new MenuItem("Pokemon Shapes", 12, "getPokemonShapes"),
                new MenuItem("Pokemon Species", 13, "getPokemonSpecies"),
                new MenuItem("Stats", 14, "getStats"),
                new MenuItem("Types", 15, "getTypes")));
        menus.put(10, pokemon);

        //Utilities
        Menu util = new Menu();
        util.addAll(Arrays.asList(
                new MenuItem("Utilities Menu: ", 0, ""),
                new MenuItem("Languages", 1, "getLanguages")));
        menus.put(11, util);
    }

    @SuppressWarnings("unused")
    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
        List<Map.Entry<K, V>> list =
                new LinkedList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
            public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        Map<K, V> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }

    static Scanner getScanner() {
        return kb;
    }

    static PokeApi getApi() {
        return pokeApi;
    }

    static void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    static void setInput(String in) {
        input = in;
    }

}
