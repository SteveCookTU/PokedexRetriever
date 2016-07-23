package com.ezpzstreamz.pokedexretriever;

import me.sargunvohra.lib.pokekotlin.model.*;

import java.io.EOFException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("all")
class MenuItemMethods {

    //region Berries
    public static void getBerries() {
        System.out.print("Enter a berry ID or 'all' to list: ");
        String input = PokedexRetriever.getScanner().nextLine();
        while (!input.equalsIgnoreCase("all") && !PokedexRetriever.isInt(input) && !input.equalsIgnoreCase("back")) {
            PokedexRetriever.clearConsole();
            System.out.print("Enter a berry ID or 'all' to list: ");
            input = PokedexRetriever.getScanner().nextLine();
        }
        if (!input.equalsIgnoreCase("back")) {
            if (input.equalsIgnoreCase("all")) {
                PokedexRetriever.clearConsole();
                boolean success = false;
                while (!success) {
                    try {
                        System.out.println("Retrieving data...");
                        String data = namedApiResourcesToString(PokedexRetriever.getApi().getBerryList(0, 70).getResults(), true);
                        PokedexRetriever.clearConsole();
                        System.out.print(data);
                        success = true;
                    } catch (Exception e) {
                        PokedexRetriever.clearConsole();
                        if (!(e.getCause() instanceof EOFException)) {
                            System.out.println("An error occurred retrieving the data: " + e.getCause() + ". Retrying...");
                        }
                    }
                }
                getBerries();
            } else if (PokedexRetriever.isInt(input)) {
                PokedexRetriever.clearConsole();
                boolean success = false;
                while (!success) {
                    try {
                        System.out.println("Retrieving data...");
                        Berry berry = PokedexRetriever.getApi().getBerry(Integer.parseInt(input));
                        PokedexRetriever.clearConsole();
                        System.out.println(
                                "ID: " + berry.getId() + "\n" +
                                        "Name: " + berry.getName().substring(0, 1).toUpperCase() + berry.getName().substring(1) + "\n" +
                                        "Growth Time: " + berry.getGrowthTime() + " hrs per stage\n" +
                                        "Max Harvest: " + berry.getMaxHarvest() + "\n" +
                                        "Natural Gift Power: " + berry.getNaturalGiftPower() + "\n" +
                                        "Natural Gift Type: " + berry.getNaturalGiftType().getName() + "\n" +
                                        "Size: " + berry.getSize() + "\n" +
                                        "Smoothness: " + berry.getSmoothness() + "\n" +
                                        "Soil Dryness: " + berry.getSoilDryness() + "\n" +
                                        "Firmness: " + berry.getFirmness().getName() + "\n" +
                                        "Flavors: " + berryFlavorMapsToString(berry.getFlavors()));
                        success = true;
                    } catch (Exception e) {
                        PokedexRetriever.clearConsole();
                        if (!(e.getCause() instanceof EOFException)) {
                            System.out.println("An error occurred retrieving the data: " + e.getCause() + ". Retrying...");
                        }
                    }
                }
                getBerries();
            }
        }
        PokedexRetriever.setInput("back");
    }

    public static void getBerryFirmness() {
        System.out.print("Enter a berry firmness ID or 'all' to list: ");
        String input = PokedexRetriever.getScanner().nextLine();
        while (!input.equalsIgnoreCase("all") && !PokedexRetriever.isInt(input) && !input.equalsIgnoreCase("back")) {
            PokedexRetriever.clearConsole();
            System.out.print("Enter a berry firmness ID or 'all' to list: ");
            input = PokedexRetriever.getScanner().nextLine();
        }
        if (!input.equalsIgnoreCase("back")) {
            if (input.equalsIgnoreCase("all")) {
                PokedexRetriever.clearConsole();
                boolean success = false;
                while (!success) {
                    try {
                        System.out.println("Retrieving data...");
                        String data = namedApiResourcesToString(PokedexRetriever.getApi().getBerryFirmnessList(0, 10).getResults(), true);
                        PokedexRetriever.clearConsole();
                        System.out.print(data);
                        success = true;
                    } catch (Exception e) {
                        PokedexRetriever.clearConsole();
                        if (!(e.getCause() instanceof EOFException)) {
                            System.out.println("An error occurred retrieving the data: " + e.getCause() + ". Retrying...");
                        }
                    }
                }
                getBerryFirmness();
            } else if (PokedexRetriever.isInt(input)) {
                PokedexRetriever.clearConsole();
                boolean success = false;
                while (!success) {
                    try {
                        System.out.println("Retrieving data...");
                        BerryFirmness berryFirmness = PokedexRetriever.getApi().getBerryFirmness(Integer.parseInt(input));
                        PokedexRetriever.clearConsole();
                        System.out.println(
                                "ID: " + berryFirmness.getId() + "\n" +
                                        "Name: " + berryFirmness.getName().substring(0, 1).toUpperCase() + berryFirmness.getName().substring(1) + "\n" +
                                        "Berries: " + namedApiResourcesToString(berryFirmness.getBerries(), false) +
                                        "Names: " + namesToString(berryFirmness.getNames()));
                        success = true;
                    } catch (Exception e) {
                        PokedexRetriever.clearConsole();
                        if (!(e.getCause() instanceof EOFException)) {
                            System.out.println("An error occurred retrieving the data: " + e.getCause() + ". Retrying...");
                        }
                    }
                }
                getBerryFirmness();
            }
        }
        PokedexRetriever.setInput("back");
    }

    public static void getFlavors() {
        System.out.print("Enter a flavor ID or 'all' to list: ");
        String input = PokedexRetriever.getScanner().nextLine();
        while (!input.equalsIgnoreCase("all") && !PokedexRetriever.isInt(input) && !input.equalsIgnoreCase("back")) {
            PokedexRetriever.clearConsole();
            System.out.print("Enter a flavor ID or 'all' to list: ");
            input = PokedexRetriever.getScanner().nextLine();
        }
        if (!input.equalsIgnoreCase("back")) {
            if (input.equalsIgnoreCase("all")) {
                PokedexRetriever.clearConsole();
                boolean success = false;
                while (!success) {
                    try {
                        System.out.println("Retrieving data...");
                        String data = namedApiResourcesToString(PokedexRetriever.getApi().getBerryFlavorList(0, 100).getResults(), true);
                        PokedexRetriever.clearConsole();
                        System.out.println(data);
                        success = true;
                    } catch (Exception e) {
                        PokedexRetriever.clearConsole();
                        if (!(e.getCause() instanceof EOFException)) {
                            System.out.println("An error occurred retrieving the data: " + e.getCause() + ". Retrying...");
                        }
                    }
                }
                getFlavors();
            } else if (PokedexRetriever.isInt(input)) {
                PokedexRetriever.clearConsole();
                boolean success = false;
                while (!success) {
                    try {
                        System.out.println("Retrieving data...");
                        BerryFlavor berryFlavor = PokedexRetriever.getApi().getBerryFlavor(Integer.parseInt(input));
                        PokedexRetriever.clearConsole();
                        System.out.println(
                                "ID: " + berryFlavor.getId() + "\n" +
                                        "Name: " + berryFlavor.getName().substring(0, 1).toUpperCase() + berryFlavor.getName().substring(1) + "\n" +
                                        "Berries: " + flavorBerryMapsToString(berryFlavor.getBerries()) +
                                        "Contest Type: " + namedApiResourcesToString(Arrays.asList(berryFlavor.getContestType()), false) +
                                        "Names: " + namesToString(berryFlavor.getNames()));
                        success = true;
                    } catch (Exception e) {
                        PokedexRetriever.clearConsole();
                        if (!(e.getCause() instanceof EOFException)) {
                            System.out.println("An error occurred retrieving the data: " + e.getCause() + ". Retrying...");
                        }
                    }
                }
                getFlavors();
            }
        }
        PokedexRetriever.setInput("back");
    }
    //endregion

    //region Contests
    public static void getContestTypes() {
        System.out.print("Enter a contest type ID or 'all' to list: ");
        String input = PokedexRetriever.getScanner().nextLine();
        while (!input.equalsIgnoreCase("all") && !PokedexRetriever.isInt(input) && !input.equalsIgnoreCase("back")) {
            PokedexRetriever.clearConsole();
            System.out.print("Enter a contest type ID or 'all' to list: ");
            input = PokedexRetriever.getScanner().nextLine();
        }
        if (!input.equalsIgnoreCase("back")) {
            if (input.equalsIgnoreCase("all")) {
                PokedexRetriever.clearConsole();
                boolean success = false;
                while (!success) {
                    try {
                        System.out.println("Retrieving data...");
                        String data = namedApiResourcesToString(PokedexRetriever.getApi().getContestTypeList(0, 100).getResults(), true);
                        PokedexRetriever.clearConsole();
                        System.out.println(data);
                        success = true;
                    } catch (Exception e) {
                        PokedexRetriever.clearConsole();
                        if (!(e.getCause() instanceof EOFException)) {
                            System.out.println("An error occurred retrieving the data: " + e.getCause() + ". Retrying...");
                        }
                    }
                }
                getContestTypes();
            } else if (PokedexRetriever.isInt(input)) {
                PokedexRetriever.clearConsole();
                boolean success = false;
                while (!success) {
                    try {
                        System.out.println("Retrieving data...");
                        ContestType contestType = PokedexRetriever.getApi().getContestType(Integer.parseInt(input));
                        PokedexRetriever.clearConsole();
                        System.out.println(
                                "ID: " + contestType.getId() + "\n" +
                                        "Name: " + contestType.getName().substring(0, 1).toUpperCase() + contestType.getName().substring(1) + "\n" +
                                        "Berry Flavor: " + namedApiResourcesToString(Arrays.asList(contestType.getBerryFlavor()), false) +
                                        "Names: " + contestNamesToString(contestType.getNames()));
                        success = true;
                    } catch (Exception e) {
                        PokedexRetriever.clearConsole();
                        if (!(e.getCause() instanceof EOFException)) {
                            System.out.println("An error occurred retrieving the data: " + e.getCause() + ". Retrying...");
                        }
                    }
                }
                getContestTypes();
            }
        }
        PokedexRetriever.setInput("back");
    }

    public static void getContestEffects() {
        System.out.print("Enter a contest effect ID or 'all' to list: ");
        String input = PokedexRetriever.getScanner().nextLine();
        while (!input.equalsIgnoreCase("all") && !PokedexRetriever.isInt(input) && !input.equalsIgnoreCase("back")) {
            PokedexRetriever.clearConsole();
            System.out.print("Enter a contest effect ID or 'all' to list: ");
            input = PokedexRetriever.getScanner().nextLine();
        }
        if (!input.equalsIgnoreCase("back")) {
            if (input.equalsIgnoreCase("all")) {
                PokedexRetriever.clearConsole();
                boolean success = false;
                while (!success) {
                    try {
                        System.out.println("Retrieving data...");
                        String data = apiResourcesToString(PokedexRetriever.getApi().getContestEffectList(0, 100).getResults(), true);
                        PokedexRetriever.clearConsole();
                        System.out.println("Contest Effects do not have designated names in game." + data);
                        success = true;
                    } catch (Exception e) {
                        PokedexRetriever.clearConsole();
                        if (!(e.getCause() instanceof EOFException)) {
                            System.out.println("An error occurred retrieving the data: " + e.getCause() + ". Retrying...");
                        }
                    }
                }
                getContestEffects();
            } else if (PokedexRetriever.isInt(input)) {
                PokedexRetriever.clearConsole();
                boolean success = false;
                while (!success) {
                    try {
                        System.out.println("Retrieving data...");
                        ContestEffect contestEffect = PokedexRetriever.getApi().getContestEffect(Integer.parseInt(input));
                        PokedexRetriever.clearConsole();
                        System.out.println(
                                "ID: " + contestEffect.getId() + "\n" +
                                        "Appeal: " + contestEffect.getAppeal() + "\n" +
                                        "Jam: " + contestEffect.getJam() + "\n" +
                                        "Effect Entries: " + effectsToString(contestEffect.getEffectEntries()) +
                                        "Flavor Text Entries: " + flavorTextsToString(contestEffect.getFlavorTextEntries()));
                        success = true;
                    } catch (Exception e) {
                        PokedexRetriever.clearConsole();
                        if (!(e.getCause() instanceof EOFException)) {
                            System.out.println("An error occurred retrieving the data: " + e.getCause() + ". Retrying...");
                        }
                    }
                }
                getContestEffects();
            }
        }
        PokedexRetriever.setInput("back");
    }

    public static void getSuperContestEffects() {
        System.out.print("Enter a super contest effect ID or 'all' to list: ");
        String input = PokedexRetriever.getScanner().nextLine();
        while (!input.equalsIgnoreCase("all") && !PokedexRetriever.isInt(input) && !input.equalsIgnoreCase("back")) {
            PokedexRetriever.clearConsole();
            System.out.print("Enter a super contest effect ID or 'all' to list: ");
            input = PokedexRetriever.getScanner().nextLine();
        }
        if (!input.equalsIgnoreCase("back")) {
            if (input.equalsIgnoreCase("all")) {
                PokedexRetriever.clearConsole();
                boolean success = false;

                while (!success) {
                    try {
                        System.out.println("Retrieving data...");
                        String data = apiResourcesToString(PokedexRetriever.getApi().getSuperContestEffectList(0, 100).getResults(), true);
                        PokedexRetriever.clearConsole();
                        System.out.println("Super Contest Effects do not have designated names in game." + data);
                        success = true;
                    } catch (Exception e) {
                        PokedexRetriever.clearConsole();
                        if (!(e.getCause() instanceof EOFException)) {
                            System.out.println("An error occurred retrieving the data: " + e.getCause() + ". Retrying...");
                        }
                    }
                }
                getSuperContestEffects();
            } else if (PokedexRetriever.isInt(input)) {
                boolean success = false;
                PokedexRetriever.clearConsole();
                while (!success) {
                    try {
                        System.out.println("Retrieving data...");
                        SuperContestEffect superContestEffect = PokedexRetriever.getApi().getSuperContestEffect(Integer.parseInt(input));
                        PokedexRetriever.clearConsole();
                        System.out.println(
                                "ID: " + superContestEffect.getId() + "\n" +
                                        "Appeal: " + superContestEffect.getAppeal() + "\n" +
                                        "Flavor Text Entries: " + flavorTextsToString(superContestEffect.getFlavorTextEntries()) +
                                        "Moves: " + namedApiResourcesToString(superContestEffect.getMoves(), false));
                        success = true;
                    } catch (Exception e) {
                        PokedexRetriever.clearConsole();
                        if (!(e.getCause() instanceof EOFException)) {
                            System.out.println("An error occurred retrieving the data: " + e.getCause() + ". Retrying...");
                        }
                    }
                }
                getSuperContestEffects();
            }
        }
        PokedexRetriever.setInput("back");
    }
    //endregion

    //region Encounters
    public static void getEncounterMethods() {
        System.out.print("Enter an encounter method ID or 'all' to list: ");
        String input = PokedexRetriever.getScanner().nextLine();
        while (!input.equalsIgnoreCase("all") && !PokedexRetriever.isInt(input) && !input.equalsIgnoreCase("back")) {
            PokedexRetriever.clearConsole();
            System.out.print("Enter an encounter method ID or 'all' to list: ");
            input = PokedexRetriever.getScanner().nextLine();
        }
        if (!input.equalsIgnoreCase("back")) {
            if (input.equalsIgnoreCase("all")) {
                PokedexRetriever.clearConsole();
                boolean success = false;
                while (!success) {
                    try {
                        System.out.println("Retrieving data...");
                        String data = namedApiResourcesToString(PokedexRetriever.getApi().getEncounterMethodList(0, 100).getResults(), true);
                        PokedexRetriever.clearConsole();
                        System.out.println(data);
                        success = true;
                    } catch (Exception e) {
                        PokedexRetriever.clearConsole();
                        if (!(e.getCause() instanceof EOFException)) {
                            System.out.println("An error occurred retrieving the data: " + e.getCause() + ". Retrying...");
                        }
                    }
                }
                getEncounterMethods();
            } else if (PokedexRetriever.isInt(input)) {
                PokedexRetriever.clearConsole();
                boolean success = false;
                while (!success) {
                    try {
                        System.out.println("Retrieving data...");
                        EncounterMethod encounterMethod = PokedexRetriever.getApi().getEncounterMethod(Integer.parseInt(input));
                        PokedexRetriever.clearConsole();
                        System.out.println(
                                "ID: " + encounterMethod.getId() + "\n" +
                                        "Name: " + encounterMethod.getName() + "\n" +
                                        "Order (sorting): " + encounterMethod.getOrder() + "\n" +
                                        "Names: " + namesToString(encounterMethod.getNames()));
                        success = true;
                    } catch (Exception e) {
                        PokedexRetriever.clearConsole();
                        if (!(e.getCause() instanceof EOFException)) {
                            System.out.println("An error occurred retrieving the data: " + e.getCause() + ". Retrying...");
                        }
                    }
                }
                getEncounterMethods();
            }
        }
        PokedexRetriever.setInput("back");
    }

    public static void getEncounterConditions() {
        System.out.print("Enter an encounter condition ID or 'all' to list: ");
        String input = PokedexRetriever.getScanner().nextLine();
        while (!input.equalsIgnoreCase("all") && !PokedexRetriever.isInt(input) && !input.equalsIgnoreCase("back")) {
            PokedexRetriever.clearConsole();
            System.out.print("Enter an encounter condition ID or 'all' to list: ");
            input = PokedexRetriever.getScanner().nextLine();
        }
        if (!input.equalsIgnoreCase("back")) {
            if (input.equalsIgnoreCase("all")) {
                PokedexRetriever.clearConsole();
                boolean success = false;
                while (!success) {
                    try {
                        System.out.println("Retrieving data...");
                        String data = namedApiResourcesToString(PokedexRetriever.getApi().getEncounterConditionList(0, 100).getResults(), true);
                        PokedexRetriever.clearConsole();
                        System.out.println(data);
                        success = true;
                    } catch (Exception e) {
                        PokedexRetriever.clearConsole();
                        if (!(e.getCause() instanceof EOFException)) {
                            System.out.println("An error occurred retrieving the data: " + e.getCause() + ". Retrying...");
                        }
                    }
                }
                getEncounterConditions();
            } else if (PokedexRetriever.isInt(input)) {
                PokedexRetriever.clearConsole();
                boolean success = false;
                while (!success) {
                    try {
                        System.out.println("Retrieving data...");
                        EncounterCondition encounterCondition = PokedexRetriever.getApi().getEncounterCondition(Integer.parseInt(input));
                        PokedexRetriever.clearConsole();
                        System.out.println(
                                "ID: " + encounterCondition.getId() + "\n" +
                                        "Name: " + encounterCondition.getName() + "\n" +
                                        "Values: " + namedApiResourcesToString(encounterCondition.getValues(), false) +
                                        "Names: " + namesToString(encounterCondition.getNames()));
                        success = true;
                    } catch (Exception e) {
                        PokedexRetriever.clearConsole();
                        if (!(e.getCause() instanceof EOFException)) {
                            System.out.println("An error occurred retrieving the data: " + e.getCause() + ". Retrying...");
                        }
                    }
                }
                getEncounterConditions();
            }
        }
        PokedexRetriever.setInput("back");
    }

    public static void getEncounterConditionValues() {
        System.out.print("Enter an encounter condition value ID or 'all' to list: ");
        String input = PokedexRetriever.getScanner().nextLine();
        while (!input.equalsIgnoreCase("all") && !PokedexRetriever.isInt(input) && !input.equalsIgnoreCase("back")) {
            PokedexRetriever.clearConsole();
            System.out.print("Enter an encounter condition value ID or 'all' to list: ");
            input = PokedexRetriever.getScanner().nextLine();
        }
        if (!input.equalsIgnoreCase("back")) {
            if (input.equalsIgnoreCase("all")) {
                PokedexRetriever.clearConsole();
                boolean success = false;
                while (!success) {
                    try {
                        System.out.println("Retrieving data...");
                        String data = namedApiResourcesToString(PokedexRetriever.getApi().getEncounterConditionValueList(0, 100).getResults(), true);
                        PokedexRetriever.clearConsole();
                        System.out.println(data);
                        success = true;
                    } catch (Exception e) {
                        PokedexRetriever.clearConsole();
                        if (!(e.getCause() instanceof EOFException)) {
                            System.out.println("An error occurred retrieving the data: " + e.getCause() + ". Retrying...");
                        }
                    }
                }
                getEncounterConditionValues();
            } else if (PokedexRetriever.isInt(input)) {
                PokedexRetriever.clearConsole();
                boolean success = false;
                while (!success) {
                    try {
                        System.out.println("Retrieving data...");
                        EncounterConditionValue encounterConditionValue = PokedexRetriever.getApi().getEncounterConditionValue(Integer.parseInt(input));
                        PokedexRetriever.clearConsole();
                        System.out.println(
                                "ID: " + encounterConditionValue.getId() + "\n" +
                                        "Name: " + encounterConditionValue.getName() + "\n" +
                                        "Condition: " + namedApiResourcesToString(Arrays.asList(encounterConditionValue.getCondition()), false) +
                                        "Names: " + namesToString(encounterConditionValue.getNames()));
                        success = true;
                    } catch (Exception e) {
                        PokedexRetriever.clearConsole();
                        if (!(e.getCause() instanceof EOFException)) {
                            System.out.println("An error occurred retrieving the data: " + e.getCause() + ". Retrying...");
                        }
                    }
                }
                getEncounterConditionValues();
            }
        }
        PokedexRetriever.setInput("back");
    }
    //endregion

    //region Evolutions
    public static void getEvolutionChains() {
        System.out.print("Enter an evolution chain ID or 'all' to list: ");
        String input = PokedexRetriever.getScanner().nextLine();
        while (!input.equalsIgnoreCase("all") && !PokedexRetriever.isInt(input) && !input.equalsIgnoreCase("back")) {
            PokedexRetriever.clearConsole();
            System.out.print("Enter an evolution chain ID or 'all' to list: ");
            input = PokedexRetriever.getScanner().nextLine();
        }
        if (!input.equalsIgnoreCase("back")) {
            if (input.equalsIgnoreCase("all")) {
                PokedexRetriever.clearConsole();
                boolean success = false;
                while (!success) {
                    try {
                        System.out.println("Retrieving data...");
                        String data = apiResourcesToString(PokedexRetriever.getApi().getEvolutionChainList(0, 400).getResults(), true);
                        PokedexRetriever.clearConsole();
                        System.out.println("Evolution chains do not have designated names." + data);
                        success = true;
                    } catch (Exception e) {
                        PokedexRetriever.clearConsole();
                        if (!(e.getCause() instanceof EOFException)) {
                            System.out.println("An error occurred retrieving the data: " + e.getCause() + ". Retrying...");
                        }
                    }
                }
                getEvolutionChains();
            } else if (PokedexRetriever.isInt(input)) {
                PokedexRetriever.clearConsole();
                boolean success = false;
                while (!success) {
                    try {
                        System.out.println("Retrieving data...");
                        EvolutionChain evolutionChain = PokedexRetriever.getApi().getEvolutionChain(Integer.parseInt(input));
                        PokedexRetriever.clearConsole();
                        String babyTriggerItem = "none\n";
                        if (evolutionChain.getBabyTriggerItem() != null) {
                            babyTriggerItem = namedApiResourcesToString(Arrays.asList(evolutionChain.getBabyTriggerItem()), false);
                        }
                        System.out.println(
                                "ID: " + evolutionChain.getId() + "\n" +
                                        "Baby Trigger Item: " + babyTriggerItem +
                                        "Chain: " + chainLinkToString(evolutionChain.getChain()));
                        success = true;
                    } catch (Exception e) {
                        PokedexRetriever.clearConsole();
                        if (!(e.getCause() instanceof EOFException)) {
                            System.out.println("An error occurred retrieving the data: " + e.getCause() + ". Retrying...");
                        }
                    }
                }
                getEvolutionChains();
            }
        }
        PokedexRetriever.setInput("back");
    }

    public static void getEvolutionTriggers() {
        System.out.print("Enter an evolution trigger ID or 'all' to list: ");
        String input = PokedexRetriever.getScanner().nextLine();
        while (!input.equalsIgnoreCase("all") && !PokedexRetriever.isInt(input) && !input.equalsIgnoreCase("back")) {
            PokedexRetriever.clearConsole();
            System.out.print("Enter an evolution trigger ID or 'all' to list: ");
            input = PokedexRetriever.getScanner().nextLine();
        }
        if (!input.equalsIgnoreCase("back")) {
            if (input.equalsIgnoreCase("all")) {
                PokedexRetriever.clearConsole();
                boolean success = false;
                while (!success) {
                    try {
                        System.out.println("Retrieving data...");
                        String data = namedApiResourcesToString(PokedexRetriever.getApi().getEvolutionTriggerList(0, 10).getResults(), true);
                        PokedexRetriever.clearConsole();
                        System.out.println(data);
                        success = true;
                    } catch (Exception e) {
                        PokedexRetriever.clearConsole();
                        if (!(e.getCause() instanceof EOFException)) {
                            System.out.println("An error occurred retrieving the data: " + e.getCause() + ". Retrying...");
                        }
                    }
                }
                getEvolutionTriggers();
            } else if (PokedexRetriever.isInt(input)) {
                PokedexRetriever.clearConsole();
                boolean success = false;
                while (!success) {
                    try {
                        System.out.println("Retrieving data...");
                        EvolutionTrigger evolutionTrigger = PokedexRetriever.getApi().getEvolutionTrigger(Integer.parseInt(input));
                        PokedexRetriever.clearConsole();
                        System.out.println(
                                "ID: " + evolutionTrigger.getId() + "\n" +
                                        "Name: " + evolutionTrigger.getName() + "\n" +
                                        "Pokemon Species: " + namedApiResourcesToString(evolutionTrigger.getPokemonSpecies(), false) +
                                        "Names: " + namesToString(evolutionTrigger.getNames()));
                        success = true;
                    } catch (Exception e) {
                        PokedexRetriever.clearConsole();
                        if (!(e.getCause() instanceof EOFException)) {
                            System.out.println("An error occurred retrieving the data: " + e.getCause() + ". Retrying...");
                        }
                    }
                }
                getEvolutionTriggers();
            }
        }
        PokedexRetriever.setInput("back");
    }
    //endregion

    //region Games
    public static void getGenerations() {
        System.out.print("Enter a generation ID or 'all' to list: ");
        String input = PokedexRetriever.getScanner().nextLine();
        while (!input.equalsIgnoreCase("all") && !PokedexRetriever.isInt(input) && !input.equalsIgnoreCase("back")) {
            PokedexRetriever.clearConsole();
            System.out.print("Enter a generation ID or 'all' to list: ");
            input = PokedexRetriever.getScanner().nextLine();
        }
        if (!input.equalsIgnoreCase("back")) {
            if (input.equalsIgnoreCase("all")) {
                PokedexRetriever.clearConsole();
                boolean success = false;
                while (!success) {
                    try {
                        System.out.println("Retrieving data...");
                        String data = namedApiResourcesToString(PokedexRetriever.getApi().getGenerationList(0, 10).getResults(), true);
                        PokedexRetriever.clearConsole();
                        System.out.println(data);
                        success = true;
                    } catch (Exception e) {
                        PokedexRetriever.clearConsole();
                        if (!(e.getCause() instanceof EOFException)) {
                            System.out.println("An error occurred retrieving the data: " + e.getCause() + ". Retrying...");
                        }
                    }
                }
                getGenerations();
            } else if (PokedexRetriever.isInt(input)) {
                PokedexRetriever.clearConsole();
                boolean success = false;
                while (!success) {
                    try {
                        System.out.println("Retrieving data...");
                        Generation generation = PokedexRetriever.getApi().getGeneration(Integer.parseInt(input));
                        PokedexRetriever.clearConsole();
                        System.out.println(
                                "ID: " + generation.getId() + "\n" +
                                        "Name: " + generation.getName() + "\n" +
                                        "Names: " + namesToString(generation.getNames()) +
                                        "Abilities: " + namedApiResourcesToString(generation.getAbilities(), false) +
                                        "Main Region: " + namedApiResourcesToString(Arrays.asList(generation.getMainRegion()), false) +
                                        "Moves: " + namedApiResourcesToString(generation.getMoves(), false) +
                                        "Pokemon Species: " + namedApiResourcesToString(generation.getPokemonSpecies(), false) +
                                        "Types: " + namedApiResourcesToString(generation.getTypes(), false) +
                                        "Version Groups: " + namedApiResourcesToString(generation.getVersionGroups(), false));
                        success = true;
                    } catch (Exception e) {
                        PokedexRetriever.clearConsole();
                        if (!(e.getCause() instanceof EOFException)) {
                            System.out.println("An error occurred retrieving the data: " + e.getCause() + ". Retrying...");
                        }
                    }
                }
                getGenerations();
            }
        }
        PokedexRetriever.setInput("back");
    }

    public static void getPokedexes() {
        System.out.print("Enter a pokedex ID or 'all' to list: ");
        String input = PokedexRetriever.getScanner().nextLine();
        while (!input.equalsIgnoreCase("all") && !PokedexRetriever.isInt(input) && !input.equalsIgnoreCase("back")) {
            PokedexRetriever.clearConsole();
            System.out.print("Enter a pokedex ID or 'all' to list: ");
            input = PokedexRetriever.getScanner().nextLine();
        }
        if (!input.equalsIgnoreCase("back")) {
            if (input.equalsIgnoreCase("all")) {
                PokedexRetriever.clearConsole();
                boolean success = false;
                while (!success) {
                    try {
                        System.out.println("Retrieving data...");
                        String data = namedApiResourcesToString(PokedexRetriever.getApi().getPokedexList(0, 20).getResults(), true);
                        PokedexRetriever.clearConsole();
                        System.out.println(data);
                        success = true;
                    } catch (Exception e) {
                        PokedexRetriever.clearConsole();
                        if (!(e.getCause() instanceof EOFException)) {
                            System.out.println("An error occurred retrieving the data: " + e.getCause() + ". Retrying...");
                        }
                    }
                }
                getPokedexes();
            } else if (PokedexRetriever.isInt(input)) {
                PokedexRetriever.clearConsole();
                boolean success = false;
                while (!success) {
                    try {
                        System.out.println("Retrieving data...");
                        Pokedex pokedex = PokedexRetriever.getApi().getPokedex(Integer.parseInt(input));
                        PokedexRetriever.clearConsole();
                        String region = "none\n";
                        if (pokedex.getRegion() != null) {
                            region = namedApiResourcesToString(Arrays.asList(pokedex.getRegion()), false);
                        }
                        System.out.println(
                                "ID: " + pokedex.getId() + "\n" +
                                        "Name: " + pokedex.getName() + "\n" +
                                        "Is Main Series: " + pokedex.isMainSeries() + "\n" +
                                        "Descriptions: " + descriptionsToString(pokedex.getDescriptions()) +
                                        "Names: " + namesToString(pokedex.getNames()) +
                                        "Region: " + region +
                                        "Pokemon Entries: " + pokemonEntriesToString(pokedex.getPokemonEntries()) +
                                        "Version Groups: " + namedApiResourcesToString(pokedex.getVersionGroups(), false));
                        success = true;
                    } catch (Exception e) {
                        PokedexRetriever.clearConsole();
                        if (!(e.getCause() instanceof EOFException)) {
                            System.out.println("An error occurred retrieving the data: " + e.getCause() + ". Retrying...");
                        }
                    }
                }
                getPokedexes();
            }
        }
        PokedexRetriever.setInput("back");
    }

    public static void getVersions() {
        System.out.print("Enter a version ID or 'all' to list: ");
        String input = PokedexRetriever.getScanner().nextLine();
        while (!input.equalsIgnoreCase("all") && !PokedexRetriever.isInt(input) && !input.equalsIgnoreCase("back")) {
            PokedexRetriever.clearConsole();
            System.out.print("Enter a version ID or 'all' to list: ");
            input = PokedexRetriever.getScanner().nextLine();
        }
        if (!input.equalsIgnoreCase("back")) {
            if (input.equalsIgnoreCase("all")) {
                PokedexRetriever.clearConsole();
                boolean success = false;
                while (!success) {
                    try {
                        System.out.println("Retrieving data...");
                        String data = namedApiResourcesToString(PokedexRetriever.getApi().getVersionList(0, 30).getResults(), true);
                        PokedexRetriever.clearConsole();
                        System.out.println(data);
                        success = true;
                    } catch (Exception e) {
                        PokedexRetriever.clearConsole();
                        if (!(e.getCause() instanceof EOFException)) {
                            System.out.println("An error occurred retrieving the data: " + e.getCause() + ". Retrying...");
                        }
                    }
                }
                getVersions();
            } else if (PokedexRetriever.isInt(input)) {
                PokedexRetriever.clearConsole();
                boolean success = false;
                while (!success) {
                    try {
                        System.out.println("Retrieving data...");
                        Version version = PokedexRetriever.getApi().getVersion(Integer.parseInt(input));
                        PokedexRetriever.clearConsole();
                        System.out.println(
                                "ID: " + version.getId() + "\n" +
                                        "Name: " + version.getName() + "\n" +
                                        "Names: " + namesToString(version.getNames()) +
                                        "Version Group: " + namedApiResourcesToString(Arrays.asList(version.getVersionGroup()), false));
                        success = true;
                    } catch (Exception e) {
                        PokedexRetriever.clearConsole();
                        if (!(e.getCause() instanceof EOFException)) {
                            System.out.println("An error occurred retrieving the data: " + e.getCause() + ". Retrying...");
                        }
                    }
                }
                getVersions();
            }
        }
        PokedexRetriever.setInput("back");
    }

    public static void getVersionGroups() {
        System.out.print("Enter a version group ID or 'all' to list: ");
        String input = PokedexRetriever.getScanner().nextLine();
        while (!input.equalsIgnoreCase("all") && !PokedexRetriever.isInt(input) && !input.equalsIgnoreCase("back")) {
            PokedexRetriever.clearConsole();
            System.out.print("Enter a version group ID or 'all' to list: ");
            input = PokedexRetriever.getScanner().nextLine();
        }
        if (!input.equalsIgnoreCase("back")) {
            if (input.equalsIgnoreCase("all")) {
                PokedexRetriever.clearConsole();
                boolean success = false;
                while (!success) {
                    try {
                        System.out.println("Retrieving data...");
                        String data = namedApiResourcesToString(PokedexRetriever.getApi().getVersionGroupList(0, 20).getResults(), true);
                        PokedexRetriever.clearConsole();
                        System.out.println(data);
                        success = true;
                    } catch (Exception e) {
                        PokedexRetriever.clearConsole();
                        if (!(e.getCause() instanceof EOFException)) {
                            System.out.println("An error occurred retrieving the data: " + e.getCause() + ". Retrying...");
                        }
                    }
                }
                getVersionGroups();
            } else if (PokedexRetriever.isInt(input)) {
                PokedexRetriever.clearConsole();
                boolean success = false;
                while (!success) {
                    try {
                        System.out.println("Retrieving data...");
                        VersionGroup versionGroup = PokedexRetriever.getApi().getVersionGroup(Integer.parseInt(input));
                        PokedexRetriever.clearConsole();
                        System.out.println(
                                "ID: " + versionGroup.getId() + "\n" +
                                        "Name: " + versionGroup.getName() + "\n" +
                                        "Order (sorting): " + versionGroup.getOrder() + "\n" +
                                        "Generation: " + namedApiResourcesToString(Arrays.asList(versionGroup.getGeneration()), false) +
                                        "Move Learn Methods: " + namedApiResourcesToString(versionGroup.getMoveLearnMethods(), false) +
                                        "Pokedexes: " + namedApiResourcesToString(versionGroup.getPokedexes(), false) +
                                        "Regions: " + namedApiResourcesToString(versionGroup.getRegions(), false) +
                                        "Versions: " + namedApiResourcesToString(versionGroup.getVersions(), false));
                        success = true;
                    } catch (Exception e) {
                        PokedexRetriever.clearConsole();
                        if (!(e.getCause() instanceof EOFException)) {
                            System.out.println("An error occurred retrieving the data: " + e.getCause() + ". Retrying...");
                        }
                    }
                }
                getVersionGroups();
            }
        }
        PokedexRetriever.setInput("back");
    }
    //endregion

    //region Items
    public static void getItems() {
        System.out.print("Enter an item ID or 'all' to list: ");
        String input = PokedexRetriever.getScanner().nextLine();
        while (!input.equalsIgnoreCase("all") && !PokedexRetriever.isInt(input) && !input.equalsIgnoreCase("back")) {
            PokedexRetriever.clearConsole();
            System.out.print("Enter an item ID or 'all' to list: ");
            input = PokedexRetriever.getScanner().nextLine();
        }
        if (!input.equalsIgnoreCase("back")) {
            if (input.equalsIgnoreCase("all")) {
                PokedexRetriever.clearConsole();
                boolean success = false;
                while (!success) {
                    try {
                        System.out.println("Retrieving data...");
                        String data = namedApiResourcesToString(PokedexRetriever.getApi().getItemList(0, 800).getResults(), true);
                        PokedexRetriever.clearConsole();
                        System.out.println(data);
                        success = true;
                    } catch (Exception e) {
                        PokedexRetriever.clearConsole();
                        if (!(e.getCause() instanceof EOFException)) {
                            System.out.println("An error occurred retrieving the data: " + e.getCause() + ". Retrying...");
                        }
                    }
                }
                getItems();
            } else if (PokedexRetriever.isInt(input)) {
                PokedexRetriever.clearConsole();
                boolean success = false;
                while (!success) {
                    try {
                        System.out.println("Retrieving data...");
                        Item item = PokedexRetriever.getApi().getItem(Integer.parseInt(input));
                        PokedexRetriever.clearConsole();
                        String flingEffect = "none\n";
                        String flingPower = "none\n";
                        String babyTriggerFor = "none\n";
                        if (item.getFlingEffect() != null) {
                            flingEffect = namedApiResourcesToString(Arrays.asList(item.getFlingEffect()), false);
                        }
                        if (item.getFlingPower() != null) {
                            flingPower = item.getFlingPower().toString() + "\n";
                        }
                        if (item.getBabyTriggerFor() != null) {
                            babyTriggerFor = apiResourcesToString(Arrays.asList(item.getBabyTriggerFor()), false);
                        }
                        System.out.println(
                                "ID: " + item.getId() + "\n" +
                                        "Name: " + item.getName() + "\n" +
                                        "Cost: " + item.getCost() + "\n" +
                                        "Fling Power: " + flingPower +
                                        "Fling Effect: " + flingEffect +
                                        "Attributes: " + namedApiResourcesToString(item.getAttributes(), false) +
                                        "Category: " + item.getCategory() + "\n" +
                                        "Effect Entries: " + verboseEffectToString(item.getEffectEntries()) +
                                        "Flavor Text Entries: " + versionGroupFlavorTextsToString(item.getFlavorTextEntries()) +
                                        "Game Indicies: " + generationGameIndiciesToString(item.getGameIndices()) +
                                        "Names: " + namesToString(item.getNames()) +
                                        "Sprites: " + itemSpritesToString(item.getSprites()) +
                                        "Held By Pokemon: " + itemHolderPokemonToString(item.getHeldByPokemon()) +
                                        "Baby Trigger For (Evolution Chain): " + babyTriggerFor);
                        success = true;
                    } catch (Exception e) {
                        PokedexRetriever.clearConsole();
                        if (!(e.getCause() instanceof EOFException)) {
                            System.out.println("An error occurred retrieving the data: " + e.getCause() + ". Retrying...");
                        }
                    }
                }
                getItems();
            }
        }
        PokedexRetriever.setInput("back");
    }

    public static void getItemAttributes() {
        System.out.print("Enter an item attribute ID or 'all' to list: ");
        String input = PokedexRetriever.getScanner().nextLine();
        while (!input.equalsIgnoreCase("all") && !PokedexRetriever.isInt(input) && !input.equalsIgnoreCase("back")) {
            PokedexRetriever.clearConsole();
            System.out.print("Enter an item attribute ID or 'all' to list: ");
            input = PokedexRetriever.getScanner().nextLine();
        }
        if (!input.equalsIgnoreCase("back")) {
            if (input.equalsIgnoreCase("all")) {
                PokedexRetriever.clearConsole();
                boolean success = false;
                while (!success) {
                    try {
                        System.out.println("Retrieving data...");
                        String data = namedApiResourcesToString(PokedexRetriever.getApi().getItemAttributeList(0, 10).getResults(), true);
                        PokedexRetriever.clearConsole();
                        System.out.println(data);
                        success = true;
                    } catch (Exception e) {
                        PokedexRetriever.clearConsole();
                        if (!(e.getCause() instanceof EOFException)) {
                            System.out.println("An error occurred retrieving the data: " + e.getCause() + ". Retrying...");
                        }
                    }
                }
                getItemAttributes();
            } else if (PokedexRetriever.isInt(input)) {
                PokedexRetriever.clearConsole();
                boolean success = false;
                while (!success) {
                    try {
                        System.out.println("Retrieving data...");
                        ItemAttribute itemAttribute = PokedexRetriever.getApi().getItemAttribute(Integer.parseInt(input));
                        PokedexRetriever.clearConsole();
                        System.out.println(
                                "ID: " + itemAttribute.getId() + "\n" +
                                        "Name: " + itemAttribute.getName() + "\n" +
                                        "items: " + namedApiResourcesToString(itemAttribute.getItems(), false) +
                                        "Names: " + namesToString(itemAttribute.getNames()) +
                                        "Descriptions: " + descriptionsToString(itemAttribute.getDescriptions()));
                        success = true;
                    } catch (Exception e) {
                        PokedexRetriever.clearConsole();
                        if (!(e.getCause() instanceof EOFException)) {
                            System.out.println("An error occurred retrieving the data: " + e.getCause() + ". Retrying...");
                        }
                    }
                }
                getItemAttributes();
            }
        }
        PokedexRetriever.setInput("back");
    }

    public static void getItemCategories() {
        System.out.print("Enter an item category ID or 'all' to list: ");
        String input = PokedexRetriever.getScanner().nextLine();
        while (!input.equalsIgnoreCase("all") && !PokedexRetriever.isInt(input) && !input.equalsIgnoreCase("back")) {
            PokedexRetriever.clearConsole();
            System.out.print("Enter an item category ID or 'all' to list: ");
            input = PokedexRetriever.getScanner().nextLine();
        }
        if (!input.equalsIgnoreCase("back")) {
            if (input.equalsIgnoreCase("all")) {
                PokedexRetriever.clearConsole();
                boolean success = false;
                while (!success) {
                    try {
                        System.out.println("Retrieving data...");
                        String data = namedApiResourcesToString(PokedexRetriever.getApi().getItemCategoryList(0, 50).getResults(), true);
                        PokedexRetriever.clearConsole();
                        System.out.println(data);
                        success = true;
                    } catch (Exception e) {
                        PokedexRetriever.clearConsole();
                        if (!(e.getCause() instanceof EOFException)) {
                            System.out.println("An error occurred retrieving the data: " + e.getCause() + ". Retrying...");
                        }
                    }
                }
                getItemCategories();
            } else if (PokedexRetriever.isInt(input)) {
                PokedexRetriever.clearConsole();
                boolean success = false;
                while (!success) {
                    try {
                        System.out.println("Retrieving data...");
                        ItemCategory itemCategory = PokedexRetriever.getApi().getItemCategory(Integer.parseInt(input));
                        PokedexRetriever.clearConsole();
                        System.out.println(
                                "ID: " + itemCategory.getId() + "\n" +
                                        "Name: " + itemCategory.getName() + "\n" +
                                        "items: " + namedApiResourcesToString(itemCategory.getItems(), false) +
                                        "Names: " + namesToString(itemCategory.getNames()) +
                                        "Item Pocket: " + namedApiResourcesToString(Arrays.asList(itemCategory.getPocket()), false));
                        success = true;
                    } catch (Exception e) {
                        PokedexRetriever.clearConsole();
                        if (!(e.getCause() instanceof EOFException)) {
                            System.out.println("An error occurred retrieving the data: " + e.getCause() + ". Retrying...");
                        }
                    }
                }
                getItemCategories();
            }
        }
        PokedexRetriever.setInput("back");
    }

    public static void getItemFlingEffects() {
        System.out.print("Enter an item fling effect ID or 'all' to list: ");
        String input = PokedexRetriever.getScanner().nextLine();
        while (!input.equalsIgnoreCase("all") && !PokedexRetriever.isInt(input) && !input.equalsIgnoreCase("back")) {
            PokedexRetriever.clearConsole();
            System.out.print("Enter an item fling effect ID or 'all' to list: ");
            input = PokedexRetriever.getScanner().nextLine();
        }
        if (!input.equalsIgnoreCase("back")) {
            if (input.equalsIgnoreCase("all")) {
                PokedexRetriever.clearConsole();
                boolean success = false;
                while (!success) {
                    try {
                        System.out.println("Retrieving data...");
                        String data = namedApiResourcesToString(PokedexRetriever.getApi().getItemFlingEffectList(0, 10).getResults(), true);
                        PokedexRetriever.clearConsole();
                        System.out.println(data);
                        success = true;
                    } catch (Exception e) {
                        PokedexRetriever.clearConsole();
                        if (!(e.getCause() instanceof EOFException)) {
                            System.out.println("An error occurred retrieving the data: " + e.getCause() + ". Retrying...");
                        }
                    }
                }
                getItemFlingEffects();
            } else if (PokedexRetriever.isInt(input)) {
                PokedexRetriever.clearConsole();
                boolean success = false;
                while (!success) {
                    try {
                        System.out.println("Retrieving data...");
                        ItemFlingEffect itemFlingEffect = PokedexRetriever.getApi().getItemFlingEffect(Integer.parseInt(input));
                        PokedexRetriever.clearConsole();
                        System.out.println(
                                "ID: " + itemFlingEffect.getId() + "\n" +
                                        "Name: " + itemFlingEffect.getName() + "\n" +
                                        "Effect Entries: " + effectsToString(itemFlingEffect.getEffectEntries()) +
                                        "Items: " + namedApiResourcesToString(itemFlingEffect.getItems(), false));
                        success = true;
                    } catch (Exception e) {
                        PokedexRetriever.clearConsole();
                        if (!(e.getCause() instanceof EOFException)) {
                            System.out.println("An error occurred retrieving the data: " + e.getCause() + ". Retrying...");
                        }
                    }
                }
                getItemFlingEffects();
            }
        }
        PokedexRetriever.setInput("back");
    }

    public static void getItemPockets() {
        System.out.print("Enter an item fling effect ID or 'all' to list: ");
        String input = PokedexRetriever.getScanner().nextLine();
        while (!input.equalsIgnoreCase("all") && !PokedexRetriever.isInt(input) && !input.equalsIgnoreCase("back")) {
            PokedexRetriever.clearConsole();
            System.out.print("Enter an item fling effect ID or 'all' to list: ");
            input = PokedexRetriever.getScanner().nextLine();
        }
        if (!input.equalsIgnoreCase("back")) {
            if (input.equalsIgnoreCase("all")) {
                PokedexRetriever.clearConsole();
                boolean success = false;
                while (!success) {
                    try {
                        System.out.println("Retrieving data...");
                        String data = namedApiResourcesToString(PokedexRetriever.getApi().getItemPocketList(0, 10).getResults(), true);
                        PokedexRetriever.clearConsole();
                        System.out.println(data);
                        success = true;
                    } catch (Exception e) {
                        PokedexRetriever.clearConsole();
                        if (!(e.getCause() instanceof EOFException)) {
                            System.out.println("An error occurred retrieving the data: " + e.getCause() + ". Retrying...");
                        }
                    }
                }
                getItemPockets();
            } else if (PokedexRetriever.isInt(input)) {
                PokedexRetriever.clearConsole();
                boolean success = false;
                while (!success) {
                    try {
                        System.out.println("Retrieving data...");
                        ItemPocket itemPocket = PokedexRetriever.getApi().getItemPocket(Integer.parseInt(input));
                        PokedexRetriever.clearConsole();
                        System.out.println(
                                "ID: " + itemPocket.getId() + "\n" +
                                        "Name: " + itemPocket.getName() + "\n" +
                                        "Categories: " + namedApiResourcesToString(itemPocket.getCategories(), false) +
                                        "Names: " + namesToString(itemPocket.getNames()));
                        success = true;
                    } catch (Exception e) {
                        PokedexRetriever.clearConsole();
                        if (!(e.getCause() instanceof EOFException)) {
                            System.out.println("An error occurred retrieving the data: " + e.getCause() + ". Retrying...");
                        }
                    }
                }
                getItemPockets();
            }
        }
        PokedexRetriever.setInput("back");
    }
    //endregion

    //region Machines
    public static void getMachines() {
        //Coming Soon
        PokedexRetriever.setInput("back");
    }
    //endregion

    //region Moves
    public static void getMoves() {
        System.out.print("Enter a move ID or 'all' to list: ");
        String input = PokedexRetriever.getScanner().nextLine();
        while (!input.equalsIgnoreCase("all") && !PokedexRetriever.isInt(input) && !input.equalsIgnoreCase("back")) {
            PokedexRetriever.clearConsole();
            System.out.print("Enter a move ID or 'all' to list: ");
            input = PokedexRetriever.getScanner().nextLine();
        }
        if (!input.equalsIgnoreCase("back")) {
            if (input.equalsIgnoreCase("all")) {
                PokedexRetriever.clearConsole();
                boolean success = false;
                while (!success) {
                    try {
                        System.out.println("Retrieving data...");
                        String data = namedApiResourcesToString(PokedexRetriever.getApi().getMoveList(0, 650).getResults(), true);
                        PokedexRetriever.clearConsole();
                        System.out.println(data);
                        success = true;
                    } catch (Exception e) {
                        PokedexRetriever.clearConsole();
                        if (!(e.getCause() instanceof EOFException)) {
                            System.out.println("An error occurred retrieving the data: " + e.getCause() + ". Retrying...");
                        }
                    }
                }
                getMoves();
            } else if (PokedexRetriever.isInt(input)) {
                PokedexRetriever.clearConsole();
                boolean success = false;
                while (!success) {
                    try {
                        System.out.println("Retrieving data...");
                        Move move = PokedexRetriever.getApi().getMove(Integer.parseInt(input));
                        PokedexRetriever.clearConsole();
                        String contestCombos = "none\n";
                        String contestType = "none\n";
                        String contestEffect = "none\n";
                        String superContestEffect = "none\n";
                        String meta = "none\n";
                        if (move.getMeta() != null) {
                            meta = metaToString(move.getMeta());
                        }
                        if (move.getSuperContestEffect() != null) {
                            superContestEffect = apiResourcesToString(Arrays.asList(move.getSuperContestEffect()), false);
                        }
                        if (move.getContestEffect() != null) {
                            contestEffect = apiResourcesToString(Arrays.asList(move.getContestEffect()), false);
                        }
                        if (move.getContestType() != null) {
                            contestType = namedApiResourcesToString(Arrays.asList(move.getContestType()), false);
                        }
                        if (move.getContestCombos() != null) {
                            contestCombos = contestComboSetsToString(move.getContestCombos());
                        }
                        System.out.println(
                                "ID: " + move.getId() + "\n" +
                                        "Name: " + move.getName() + "\n" +
                                        "Accuracy: " + move.getAccuracy() + "\n" +
                                        "Effect Chance: " + move.getEffectChance() + "\n" +
                                        "PP: " + move.getPp() + "\n" +
                                        "Priority: " + move.getPriority() + "\n" +
                                        "Power: " + move.getPower() + "\n" +
                                        "Contest Combos: " + contestCombos +
                                        "Contest Type: " + contestType +
                                        "Contest Effect: " + contestEffect +
                                        "Damage Class: " + namedApiResourcesToString(Arrays.asList(move.getDamageClass()), false) +
                                        "Effect Entries: " + verboseEffectToString(move.getEffectEntries()) +
                                        "Effect Changes: " + abilityEffectChangesToString(move.getEffectChanges()) +
                                        "Generation: " + namedApiResourcesToString(Arrays.asList(move.getGeneration()), false) +
                                        "Meta: " + meta +
                                        "Names: " + namesToString(move.getNames()) +
                                        "Past Values: " + pastValuesToString(move.getPastValues()) +
                                        "Stat Changes: " + statChangesToString(move.getStatChanges()) +
                                        "Super Contest Effect: " + superContestEffect +
                                        "Target: " + namedApiResourcesToString(Arrays.asList(move.getTarget()), false) +
                                        "Type: " + namedApiResourcesToString(Arrays.asList(move.getType()), false));
                        success = true;
                    } catch (Exception e) {
                        PokedexRetriever.clearConsole();
                        if (!(e.getCause() instanceof EOFException)) {
                            System.out.println("An error occurred retrieving the data: " + e.getCause() + ". Retrying...");
                        }
                    }
                }
                getMoves();
            }
        }
        PokedexRetriever.setInput("back");
    }

    public static void getMoveAilments() {
        System.out.print("Enter a move ailment ID or 'all' to list: ");
        String input = PokedexRetriever.getScanner().nextLine();
        while (!input.equalsIgnoreCase("all") && !PokedexRetriever.isInt(input) && !input.equalsIgnoreCase("back")) {
            PokedexRetriever.clearConsole();
            System.out.print("Enter a move ailment ID or 'all' to list: ");
            input = PokedexRetriever.getScanner().nextLine();
        }
        if (!input.equalsIgnoreCase("back")) {
            if (input.equalsIgnoreCase("all")) {
                PokedexRetriever.clearConsole();
                boolean success = false;
                while (!success) {
                    try {
                        System.out.println("Retrieving data...");
                        String data = namedApiResourcesToString(PokedexRetriever.getApi().getMoveAilmentList(0, 20).getResults(), true);
                        PokedexRetriever.clearConsole();
                        System.out.println(data);
                        success = true;
                    } catch (Exception e) {
                        PokedexRetriever.clearConsole();
                        if (!(e.getCause() instanceof EOFException)) {
                            System.out.println("An error occurred retrieving the data: " + e.getCause() + ". Retrying...");
                        }
                    }
                }
                getMoveAilments();
            } else if (PokedexRetriever.isInt(input)) {
                PokedexRetriever.clearConsole();
                boolean success = false;
                while (!success) {
                    try {
                        System.out.println("Retrieving data...");
                        MoveAilment moveAilment = PokedexRetriever.getApi().getMoveAilment(Integer.parseInt(input));
                        PokedexRetriever.clearConsole();
                        System.out.println(
                                "ID: " + moveAilment.getId() + "\n" +
                                        "Name: " + moveAilment.getName() + "\n" +
                                        "Moves: " + namedApiResourcesToString(moveAilment.getMoves(), false) +
                                        "Names: " + namesToString(moveAilment.getNames()));
                        success = true;
                    } catch (Exception e) {
                        PokedexRetriever.clearConsole();
                        if (!(e.getCause() instanceof EOFException)) {
                            System.out.println("An error occurred retrieving the data: " + e.getCause() + ". Retrying...");
                        }
                    }
                }
                getMoveAilments();
            }
        }
        PokedexRetriever.setInput("back");
    }

    public static void getMoveBattleStyles() {
        System.out.print("Enter a move battle style ID or 'all' to list: ");
        String input = PokedexRetriever.getScanner().nextLine();
        while (!input.equalsIgnoreCase("all") && !PokedexRetriever.isInt(input) && !input.equalsIgnoreCase("back")) {
            PokedexRetriever.clearConsole();
            System.out.print("Enter a move battle style ID or 'all' to list: ");
            input = PokedexRetriever.getScanner().nextLine();
        }
        if (!input.equalsIgnoreCase("back")) {
            if (input.equalsIgnoreCase("all")) {
                PokedexRetriever.clearConsole();
                boolean success = false;
                while (!success) {
                    try {
                        System.out.println("Retrieving data...");
                        String data = namedApiResourcesToString(PokedexRetriever.getApi().getMoveAilmentList(0, 5).getResults(), true);
                        PokedexRetriever.clearConsole();
                        System.out.println(data);
                        success = true;
                    } catch (Exception e) {
                        PokedexRetriever.clearConsole();
                        if (!(e.getCause() instanceof EOFException)) {
                            System.out.println("An error occurred retrieving the data: " + e.getCause() + ". Retrying...");
                        }
                    }
                }
                getMoveBattleStyles();
            } else if (PokedexRetriever.isInt(input)) {
                PokedexRetriever.clearConsole();
                boolean success = false;
                while (!success) {
                    try {
                        System.out.println("Retrieving data...");
                        MoveBattleStyle moveBattleStyle = PokedexRetriever.getApi().getMoveBattleStyle(Integer.parseInt(input));
                        PokedexRetriever.clearConsole();
                        System.out.println(
                                "ID: " + moveBattleStyle.getId() + "\n" +
                                        "Name: " + moveBattleStyle.getName() + "\n" +
                                        "Names: " + namesToString(moveBattleStyle.getNames()));
                        success = true;
                    } catch (Exception e) {
                        PokedexRetriever.clearConsole();
                        if (!(e.getCause() instanceof EOFException)) {
                            System.out.println("An error occurred retrieving the data: " + e.getCause() + ". Retrying...");
                        }
                    }
                }
                getMoveBattleStyles();
            }
        }
        PokedexRetriever.setInput("back");
    }

    public static void getMoveCategories() {
        System.out.print("Enter a move category ID or 'all' to list: ");
        String input = PokedexRetriever.getScanner().nextLine();
        while (!input.equalsIgnoreCase("all") && !PokedexRetriever.isInt(input) && !input.equalsIgnoreCase("back")) {
            PokedexRetriever.clearConsole();
            System.out.print("Enter a move category ID or 'all' to list: ");
            input = PokedexRetriever.getScanner().nextLine();
        }
        if (!input.equalsIgnoreCase("back")) {
            if (input.equalsIgnoreCase("all")) {
                PokedexRetriever.clearConsole();
                boolean success = false;
                while (!success) {
                    try {
                        System.out.println("Retrieving data...");
                        String data = namedApiResourcesToString(PokedexRetriever.getApi().getMoveCategoryList(0, 15).getResults(), true);
                        PokedexRetriever.clearConsole();
                        System.out.println(data);
                        success = true;
                    } catch (Exception e) {
                        PokedexRetriever.clearConsole();
                        if (!(e.getCause() instanceof EOFException)) {
                            System.out.println("An error occurred retrieving the data: " + e.getCause() + ". Retrying...");
                        }
                    }
                }
                getMoveCategories();
            } else if (PokedexRetriever.isInt(input)) {
                PokedexRetriever.clearConsole();
                boolean success = false;
                while (!success) {
                    try {
                        System.out.println("Retrieving data...");
                        MoveCategory moveCategory = PokedexRetriever.getApi().getMoveCategory(Integer.parseInt(input));
                        PokedexRetriever.clearConsole();
                        System.out.println(
                                "ID: " + moveCategory.getId() + "\n" +
                                        "Name: " + moveCategory.getName() + "\n" +
                                        "Moves: " + namedApiResourcesToString(moveCategory.getMoves(), false) +
                                        "Descriptions: " + descriptionsToString(moveCategory.getDescriptions()));
                        success = true;
                    } catch (Exception e) {
                        PokedexRetriever.clearConsole();
                        if (!(e.getCause() instanceof EOFException)) {
                            System.out.println("An error occurred retrieving the data: " + e.getCause() + ". Retrying...");
                        }
                    }
                }
                getMoveCategories();
            }
        }
        PokedexRetriever.setInput("back");
    }

    public static void getMoveDamageClasses() {
        System.out.print("Enter a move damage class ID or 'all' to list: ");
        String input = PokedexRetriever.getScanner().nextLine();
        while (!input.equalsIgnoreCase("all") && !PokedexRetriever.isInt(input) && !input.equalsIgnoreCase("back")) {
            PokedexRetriever.clearConsole();
            System.out.print("Enter a move damage class ID or 'all' to list: ");
            input = PokedexRetriever.getScanner().nextLine();
        }
        if (!input.equalsIgnoreCase("back")) {
            if (input.equalsIgnoreCase("all")) {
                PokedexRetriever.clearConsole();
                boolean success = false;
                while (!success) {
                    try {
                        System.out.println("Retrieving data...");
                        String data = namedApiResourcesToString(PokedexRetriever.getApi().getMoveDamageClassList(0, 5).getResults(), true);
                        PokedexRetriever.clearConsole();
                        System.out.println(data);
                        success = true;
                    } catch (Exception e) {
                        PokedexRetriever.clearConsole();
                        if (!(e.getCause() instanceof EOFException)) {
                            System.out.println("An error occurred retrieving the data: " + e.getCause() + ". Retrying...");
                        }
                    }
                }
                getMoveDamageClasses();
            } else if (PokedexRetriever.isInt(input)) {
                PokedexRetriever.clearConsole();
                boolean success = false;
                while (!success) {
                    try {
                        System.out.println("Retrieving data...");
                        MoveDamageClass moveDamageClass = PokedexRetriever.getApi().getMoveDamageClass(Integer.parseInt(input));
                        PokedexRetriever.clearConsole();
                        System.out.println(
                                "ID: " + moveDamageClass.getId() + "\n" +
                                        "Name: " + moveDamageClass.getName() + "\n" +
                                        "Descriptions: " + descriptionsToString(moveDamageClass.getDescriptions()) +
                                        "Moves: " + namedApiResourcesToString(moveDamageClass.getMoves(), false) +
                                        "Names: " + namesToString(moveDamageClass.getNames()));
                        success = true;
                    } catch (Exception e) {
                        PokedexRetriever.clearConsole();
                        if (!(e.getCause() instanceof EOFException)) {
                            System.out.println("An error occurred retrieving the data: " + e.getCause() + ". Retrying...");
                        }
                    }
                }
                getMoveDamageClasses();
            }
        }
        PokedexRetriever.setInput("back");
    }

    public static void getMoveLearnMethods() {
        System.out.print("Enter a move learn method ID or 'all' to list: ");
        String input = PokedexRetriever.getScanner().nextLine();
        while (!input.equalsIgnoreCase("all") && !PokedexRetriever.isInt(input) && !input.equalsIgnoreCase("back")) {
            PokedexRetriever.clearConsole();
            System.out.print("Enter a move learn method ID or 'all' to list: ");
            input = PokedexRetriever.getScanner().nextLine();
        }
        if (!input.equalsIgnoreCase("back")) {
            if (input.equalsIgnoreCase("all")) {
                PokedexRetriever.clearConsole();
                boolean success = false;
                while (!success) {
                    try {
                        System.out.println("Retrieving data...");
                        String data = namedApiResourcesToString(PokedexRetriever.getApi().getMoveLearnMethodList(0, 10).getResults(), true);
                        PokedexRetriever.clearConsole();
                        System.out.println(data);
                        success = true;
                    } catch (Exception e) {
                        PokedexRetriever.clearConsole();
                        if (!(e.getCause() instanceof EOFException)) {
                            System.out.println("An error occurred retrieving the data: " + e.getCause() + ". Retrying...");
                        }
                    }
                }
                getMoveLearnMethods();
            } else if (PokedexRetriever.isInt(input)) {
                PokedexRetriever.clearConsole();
                boolean success = false;
                while (!success) {
                    try {
                        System.out.println("Retrieving data...");
                        MoveLearnMethod moveLearnMethod = PokedexRetriever.getApi().getMoveLearnMethod(Integer.parseInt(input));
                        PokedexRetriever.clearConsole();
                        System.out.println(
                                "ID: " + moveLearnMethod.getId() + "\n" +
                                        "Name: " + moveLearnMethod.getName() + "\n" +
                                        "Descriptions: " + descriptionsToString(moveLearnMethod.getDescriptions()) +
                                        "Names: " + namesToString(moveLearnMethod.getNames()) +
                                        "Version Groups: " + namedApiResourcesToString(moveLearnMethod.getVersionGroups(), false));
                        success = true;
                    } catch (Exception e) {
                        PokedexRetriever.clearConsole();
                        if (!(e.getCause() instanceof EOFException)) {
                            System.out.println("An error occurred retrieving the data: " + e.getCause() + ". Retrying...");
                        }
                    }
                }
                getMoveLearnMethods();
            }
        }
        PokedexRetriever.setInput("back");
    }

    public static void getMoveTargets() {
        System.out.print("Enter a move target ID or 'all' to list: ");
        String input = PokedexRetriever.getScanner().nextLine();
        while (!input.equalsIgnoreCase("all") && !PokedexRetriever.isInt(input) && !input.equalsIgnoreCase("back")) {
            PokedexRetriever.clearConsole();
            System.out.print("Enter a move target ID or 'all' to list: ");
            input = PokedexRetriever.getScanner().nextLine();
        }
        if (!input.equalsIgnoreCase("back")) {
            if (input.equalsIgnoreCase("all")) {
                PokedexRetriever.clearConsole();
                boolean success = false;
                while (!success) {
                    try {
                        System.out.println("Retrieving data...");
                        String data = namedApiResourcesToString(PokedexRetriever.getApi().getMoveTargetList(0, 15).getResults(), true);
                        PokedexRetriever.clearConsole();
                        System.out.println(data);
                        success = true;
                    } catch (Exception e) {
                        PokedexRetriever.clearConsole();
                        if (!(e.getCause() instanceof EOFException)) {
                            System.out.println("An error occurred retrieving the data: " + e.getCause() + ". Retrying...");
                        }
                    }
                }
                getMoveTargets();
            } else if (PokedexRetriever.isInt(input)) {
                PokedexRetriever.clearConsole();
                boolean success = false;
                while (!success) {
                    try {
                        System.out.println("Retrieving data...");
                        MoveTarget moveTarget = PokedexRetriever.getApi().getMoveTarget(Integer.parseInt(input));
                        PokedexRetriever.clearConsole();
                        System.out.println(
                                "ID: " + moveTarget.getId() + "\n" +
                                        "Name: " + moveTarget.getName() + "\n" +
                                        "Descriptions: " + descriptionsToString(moveTarget.getDescriptions()) +
                                        "Moves: " + namedApiResourcesToString(moveTarget.getMoves(), false) +
                                        "Names: " + namesToString(moveTarget.getNames()));
                        success = true;
                    } catch (Exception e) {
                        PokedexRetriever.clearConsole();
                        if (!(e.getCause() instanceof EOFException)) {
                            System.out.println("An error occurred retrieving the data: " + e.getCause() + ". Retrying...");
                        }
                    }
                }
                getMoveTargets();
            }
        }
        PokedexRetriever.setInput("back");
    }
    //endregion

    //region Locations
    public static void getLocations() {
        System.out.print("Enter a location ID or 'all' to list: ");
        String input = PokedexRetriever.getScanner().nextLine();
        while (!input.equalsIgnoreCase("all") && !PokedexRetriever.isInt(input) && !input.equalsIgnoreCase("back")) {
            PokedexRetriever.clearConsole();
            System.out.print("Enter a location ID or 'all' to list: ");
            input = PokedexRetriever.getScanner().nextLine();
        }
        if (!input.equalsIgnoreCase("back")) {
            if (input.equalsIgnoreCase("all")) {
                PokedexRetriever.clearConsole();
                boolean success = false;
                while (!success) {
                    try {
                        System.out.println("Retrieving data...");
                        String data = namedApiResourcesToString(PokedexRetriever.getApi().getLocationList(0, 700).getResults(), true);
                        PokedexRetriever.clearConsole();
                        System.out.println(data);
                        success = true;
                    } catch (Exception e) {
                        PokedexRetriever.clearConsole();
                        if (!(e.getCause() instanceof EOFException)) {
                            System.out.println("An error occurred retrieving the data: " + e.getCause() + ". Retrying...");
                        }
                    }
                }
                getLocations();
            } else if (PokedexRetriever.isInt(input)) {
                PokedexRetriever.clearConsole();
                boolean success = false;
                while (!success) {
                    try {
                        System.out.println("Retrieving data...");
                        Location location = PokedexRetriever.getApi().getLocation(Integer.parseInt(input));
                        PokedexRetriever.clearConsole();
                        System.out.println(
                                "ID: " + location.getId() + "\n" +
                                        "Name: " + location.getName() + "\n" +
                                        "Region: " + namedApiResourcesToString(Arrays.asList(location.getRegion()), false) +
                                        "Names: " + namesToString(location.getNames()) +
                                        "Game Indicies: " + generationGameIndiciesToString(location.getGameIndices()) +
                                        "Areas: " + namedApiResourcesToString(location.getAreas(), false));
                        success = true;
                    } catch (Exception e) {
                        PokedexRetriever.clearConsole();
                        if (!(e.getCause() instanceof EOFException)) {
                            System.out.println("An error occurred retrieving the data: " + e.getCause() + ". Retrying...");
                        }
                    }
                }
                getLocations();
            }
        }
        PokedexRetriever.setInput("back");
    }

    public static void getLocationAreas() {
        System.out.print("Enter a location area ID or 'all' to list: ");
        String input = PokedexRetriever.getScanner().nextLine();
        while (!input.equalsIgnoreCase("all") && !PokedexRetriever.isInt(input) && !input.equalsIgnoreCase("back")) {
            PokedexRetriever.clearConsole();
            System.out.print("Enter a location area ID or 'all' to list: ");
            input = PokedexRetriever.getScanner().nextLine();
        }
        if (!input.equalsIgnoreCase("back")) {
            if (input.equalsIgnoreCase("all")) {
                PokedexRetriever.clearConsole();
                boolean success = false;
                while (!success) {
                    try {
                        System.out.println("Retrieving data...");
                        String data = namedApiResourcesToString(PokedexRetriever.getApi().getLocationAreaList(0, 725).getResults(), true);
                        PokedexRetriever.clearConsole();
                        System.out.println(data);
                        success = true;
                    } catch (Exception e) {
                        PokedexRetriever.clearConsole();
                        if (!(e.getCause() instanceof EOFException)) {
                            System.out.println("An error occurred retrieving the data: " + e.getCause() + ". Retrying...");
                        }
                    }
                }
                getLocationAreas();
            } else if (PokedexRetriever.isInt(input)) {
                PokedexRetriever.clearConsole();
                boolean success = false;
                while (!success) {
                    try {
                        System.out.println("Retrieving data...");
                        LocationArea locationArea = PokedexRetriever.getApi().getLocationArea(Integer.parseInt(input));
                        PokedexRetriever.clearConsole();
                        System.out.println(
                                "ID: " + locationArea.getId() + "\n" +
                                        "Name: " + locationArea.getName() + "\n" +
                                        "Game Index: " + locationArea.getGameIndex() + "\n" +
                                        "Encounter Method Rates: " + encounterMethodRatesToString(locationArea.getEncounterMethodRates()) +
                                        "Location: " + namedApiResourcesToString(Arrays.asList(locationArea.getLocation()), false) +
                                        "Names: " + namesToString(locationArea.getNames()) +
                                        "Pokemon Encounters: " + pokemonEncountersToString(locationArea.getPokemonEncounters()));
                        success = true;
                    } catch (Exception e) {
                        PokedexRetriever.clearConsole();
                        if (!(e.getCause() instanceof EOFException)) {
                            System.out.println("An error occurred retrieving the data: " + e.getCause() + ". Retrying...");
                        }
                    }
                }
                getLocationAreas();
            }
        }
        PokedexRetriever.setInput("back");
    }

    public static void getPalParkAreas() {
        System.out.print("Enter a pal park area ID or 'all' to list: ");
        String input = PokedexRetriever.getScanner().nextLine();
        while (!input.equalsIgnoreCase("all") && !PokedexRetriever.isInt(input) && !input.equalsIgnoreCase("back")) {
            PokedexRetriever.clearConsole();
            System.out.print("Enter a pal park area ID or 'all' to list: ");
            input = PokedexRetriever.getScanner().nextLine();
        }
        if (!input.equalsIgnoreCase("back")) {
            if (input.equalsIgnoreCase("all")) {
                PokedexRetriever.clearConsole();
                boolean success = false;
                while (!success) {
                    try {
                        System.out.println("Retrieving data...");
                        String data = namedApiResourcesToString(PokedexRetriever.getApi().getPalParkAreaList(0, 5).getResults(), true);
                        PokedexRetriever.clearConsole();
                        System.out.println(data);
                        success = true;
                    } catch (Exception e) {
                        PokedexRetriever.clearConsole();
                        if (!(e.getCause() instanceof EOFException)) {
                            System.out.println("An error occurred retrieving the data: " + e.getCause() + ". Retrying...");
                        }
                    }
                }
                getPalParkAreas();
            } else if (PokedexRetriever.isInt(input)) {
                PokedexRetriever.clearConsole();
                boolean success = false;
                while (!success) {
                    try {
                        System.out.println("Retrieving data...");
                        PalParkArea palParkArea = PokedexRetriever.getApi().getPalParkArea(Integer.parseInt(input));
                        PokedexRetriever.clearConsole();
                        System.out.println(
                                "ID: " + palParkArea.getId() + "\n" +
                                        "Name: " + palParkArea.getName() + "\n" +
                                        "Names: " + namesToString(palParkArea.getNames()) +
                                        "Pokemon Encounters: " + palParkEncounterSpeciesToString(palParkArea.getPokemonEncounters()));
                        success = true;
                    } catch (Exception e) {
                        PokedexRetriever.clearConsole();
                        if (!(e.getCause() instanceof EOFException)) {
                            System.out.println("An error occurred retrieving the data: " + e.getCause() + ". Retrying...");
                        }
                    }
                }
                getPalParkAreas();
            }
        }
        PokedexRetriever.setInput("back");
    }

    public static void getRegions() {
        System.out.print("Enter a region ID or 'all' to list: ");
        String input = PokedexRetriever.getScanner().nextLine();
        while (!input.equalsIgnoreCase("all") && !PokedexRetriever.isInt(input) && !input.equalsIgnoreCase("back")) {
            PokedexRetriever.clearConsole();
            System.out.print("Enter a region ID or 'all' to list: ");
            input = PokedexRetriever.getScanner().nextLine();
        }
        if (!input.equalsIgnoreCase("back")) {
            if (input.equalsIgnoreCase("all")) {
                PokedexRetriever.clearConsole();
                boolean success = false;
                while (!success) {
                    try {
                        System.out.println("Retrieving data...");
                        String data = namedApiResourcesToString(PokedexRetriever.getApi().getRegionList(0, 10).getResults(), true);
                        PokedexRetriever.clearConsole();
                        System.out.println(data);
                        success = true;
                    } catch (Exception e) {
                        PokedexRetriever.clearConsole();
                        if (!(e.getCause() instanceof EOFException)) {
                            System.out.println("An error occurred retrieving the data: " + e.getCause() + ". Retrying...");
                        }
                    }
                }
                getRegions();
            } else if (PokedexRetriever.isInt(input)) {
                PokedexRetriever.clearConsole();
                boolean success = false;
                while (!success) {
                    try {
                        System.out.println("Retrieving data...");
                        Region region = PokedexRetriever.getApi().getRegion(Integer.parseInt(input));
                        PokedexRetriever.clearConsole();
                        System.out.println(
                                "ID: " + region.getId() + "\n" +
                                        "Name: " + region.getName() + "\n" +
                                        "Locations: " + namedApiResourcesToString(region.getLocations(), false) +
                                        "Main Generation: " + namedApiResourcesToString(Arrays.asList(region.getMainGeneration()), false) +
                                        "Names: " + namesToString(region.getNames()) +
                                        "Pokedexes: " + namedApiResourcesToString(region.getPokedexes(), false) +
                                        "Version Groups: " + namedApiResourcesToString(region.getVersionGroups(), false));
                        success = true;
                    } catch (Exception e) {
                        PokedexRetriever.clearConsole();
                        if (!(e.getCause() instanceof EOFException)) {
                            System.out.println("An error occurred retrieving the data: " + e.getCause() + ". Retrying...");
                        }
                    }
                }
                getRegions();
            }
        }
        PokedexRetriever.setInput("back");
    }
    //endregion

    //region Pokemon
    public static void getAbilities() {
        System.out.print("Enter an ability ID or 'all' to list: ");
        String input = PokedexRetriever.getScanner().nextLine();
        while (!input.equalsIgnoreCase("all") && !PokedexRetriever.isInt(input) && !input.equalsIgnoreCase("back")) {
            PokedexRetriever.clearConsole();
            System.out.print("Enter an ability ID or 'all' to list: ");
            input = PokedexRetriever.getScanner().nextLine();
        }
        if (!input.equalsIgnoreCase("back")) {
            if (input.equalsIgnoreCase("all")) {
                PokedexRetriever.clearConsole();
                boolean success = false;
                while (!success) {
                    try {
                        System.out.println("Retrieving data...");
                        String data = namedApiResourcesToString(PokedexRetriever.getApi().getAbilityList(0, 255).getResults(), true);
                        PokedexRetriever.clearConsole();
                        System.out.println(data);
                        success = true;
                    } catch (Exception e) {
                        PokedexRetriever.clearConsole();
                        if (!(e.getCause() instanceof EOFException)) {
                            System.out.println("An error occurred retrieving the data: " + e.getCause() + ". Retrying...");
                        }
                    }
                }
                getAbilities();
            } else if (PokedexRetriever.isInt(input)) {
                PokedexRetriever.clearConsole();
                boolean success = false;
                while (!success) {
                    try {
                        System.out.println("Retrieving data...");
                        Ability ability = PokedexRetriever.getApi().getAbility(Integer.parseInt(input));
                        PokedexRetriever.clearConsole();
                        System.out.println(
                                "ID: " + ability.getId() + "\n" +
                                        "Name: " + ability.getName() + "\n" +
                                        "Is Main Series: " + ability.isMainSeries() + "\n" +
                                        "Generation: " + namedApiResourcesToString(Arrays.asList(ability.getGeneration()), false) +
                                        "Effect Entries: " + verboseEffectToString(ability.getEffectEntries()) +
                                        "Effect Changes: " + abilityEffectChangesToString(ability.getEffectChanges()) +
                                        "Flavor Text Entries: " + abilityFlavorTextsToString(ability.getFlavorTextEntries()) +
                                        "Pokemon: " + abilityPokemonToString(ability.getPokemon()));
                        success = true;
                    } catch (Exception e) {
                        PokedexRetriever.clearConsole();
                        if (!(e.getCause() instanceof EOFException)) {
                            System.out.println("An error occurred retrieving the data: " + e.getCause() + ". Retrying...");
                        }
                    }
                }
                getAbilities();
            }
        }
        PokedexRetriever.setInput("back");
    }

    public static void getCharacteristics() {
        System.out.print("Enter a characteristic ID or 'all' to list: ");
        String input = PokedexRetriever.getScanner().nextLine();
        while (!input.equalsIgnoreCase("all") && !PokedexRetriever.isInt(input) && !input.equalsIgnoreCase("back")) {
            PokedexRetriever.clearConsole();
            System.out.print("Enter a characteristic ID or 'all' to list: ");
            input = PokedexRetriever.getScanner().nextLine();
        }
        if (!input.equalsIgnoreCase("back")) {
            if (input.equalsIgnoreCase("all")) {
                PokedexRetriever.clearConsole();
                boolean success = false;
                while (!success) {
                    try {
                        System.out.println("Retrieving data...");
                        String data = apiResourcesToString(PokedexRetriever.getApi().getCharacteristicList(0, 30).getResults(), true);
                        PokedexRetriever.clearConsole();
                        System.out.println("Characteristics do not have designated names." + data);
                        success = true;
                    } catch (Exception e) {
                        PokedexRetriever.clearConsole();
                        if (!(e.getCause() instanceof EOFException)) {
                            System.out.println("An error occurred retrieving the data: " + e.getCause() + ". Retrying...");
                        }
                    }
                }
                getCharacteristics();
            } else if (PokedexRetriever.isInt(input)) {
                PokedexRetriever.clearConsole();
                boolean success = false;
                while (!success) {
                    try {
                        System.out.println("Retrieving data...");
                        Characteristic characteristic = PokedexRetriever.getApi().getCharacteristic(Integer.parseInt(input));
                        PokedexRetriever.clearConsole();
                        System.out.println(
                                "ID: " + characteristic.getId() + "\n" +
                                        "Gene Modulo: " + characteristic.getGeneModulo() + "\n" +
                                        "Possible Values: " + intArrayToString(characteristic.getPossibleValues()) + "\n" +
                                        "Descriptions: " + descriptionsToString(characteristic.getDescriptions()));
                        success = true;
                    } catch (Exception e) {
                        PokedexRetriever.clearConsole();
                        if (!(e.getCause() instanceof EOFException)) {
                            System.out.println("An error occurred retrieving the data: " + e.getCause() + ". Retrying...");
                        }
                    }
                }
                getCharacteristics();
            }
        }
        PokedexRetriever.setInput("back");
    }

    public static void getEggGroups() {
        System.out.print("Enter an egg group ID or 'all' to list: ");
        String input = PokedexRetriever.getScanner().nextLine();
        while (!input.equalsIgnoreCase("all") && !PokedexRetriever.isInt(input) && !input.equalsIgnoreCase("back")) {
            PokedexRetriever.clearConsole();
            System.out.print("Enter an egg group ID or 'all' to list: ");
            input = PokedexRetriever.getScanner().nextLine();
        }
        if (!input.equalsIgnoreCase("back")) {
            if (input.equalsIgnoreCase("all")) {
                PokedexRetriever.clearConsole();
                boolean success = false;
                while (!success) {
                    try {
                        System.out.println("Retrieving data...");
                        String data = namedApiResourcesToString(PokedexRetriever.getApi().getEggGroupList(0, 20).getResults(), true);
                        PokedexRetriever.clearConsole();
                        System.out.println(data);
                        success = true;
                    } catch (Exception e) {
                        PokedexRetriever.clearConsole();
                        if (!(e.getCause() instanceof EOFException)) {
                            System.out.println("An error occurred retrieving the data: " + e.getCause() + ". Retrying...");
                        }
                    }
                }
                getEggGroups();
            } else if (PokedexRetriever.isInt(input)) {
                PokedexRetriever.clearConsole();
                boolean success = false;
                while (!success) {
                    try {
                        System.out.println("Retrieving data...");
                        EggGroup eggGroup = PokedexRetriever.getApi().getEggGroup(Integer.parseInt(input));
                        PokedexRetriever.clearConsole();
                        System.out.println(
                                "ID: " + eggGroup.getId() + "\n" +
                                        "Name: " + eggGroup.getName() + "\n" +
                                        "Names: " + namesToString(eggGroup.getNames()) +
                                        "Pokemon Species: " + namedApiResourcesToString(eggGroup.getPokemonSpecies(), false));
                        success = true;
                    } catch (Exception e) {
                        PokedexRetriever.clearConsole();
                        if (!(e.getCause() instanceof EOFException)) {
                            System.out.println("An error occurred retrieving the data: " + e.getCause() + ". Retrying...");
                        }
                    }
                }
                getEggGroups();
            }
        }
        PokedexRetriever.setInput("back");
    }

    public static void getGenders() {
        System.out.print("Enter a gender ID or 'all' to list: ");
        String input = PokedexRetriever.getScanner().nextLine();
        while (!input.equalsIgnoreCase("all") && !PokedexRetriever.isInt(input) && !input.equalsIgnoreCase("back")) {
            PokedexRetriever.clearConsole();
            System.out.print("Enter a gender ID or 'all' to list: ");
            input = PokedexRetriever.getScanner().nextLine();
        }
        if (!input.equalsIgnoreCase("back")) {
            if (input.equalsIgnoreCase("all")) {
                PokedexRetriever.clearConsole();
                boolean success = false;
                while (!success) {
                    try {
                        System.out.println("Retrieving data...");
                        String data = namedApiResourcesToString(PokedexRetriever.getApi().getGenderList(0, 10).getResults(), true);
                        PokedexRetriever.clearConsole();
                        System.out.println(data);
                        success = true;
                    } catch (Exception e) {
                        PokedexRetriever.clearConsole();
                        if (!(e.getCause() instanceof EOFException)) {
                            System.out.println("An error occurred retrieving the data: " + e.getCause() + ". Retrying...");
                        }
                    }
                }
                getGenders();
            } else if (PokedexRetriever.isInt(input)) {
                PokedexRetriever.clearConsole();
                boolean success = false;
                while (!success) {
                    try {
                        System.out.println("Retrieving data...");
                        Gender gender = PokedexRetriever.getApi().getGender(Integer.parseInt(input));
                        PokedexRetriever.clearConsole();
                        System.out.println(
                                "ID: " + gender.getId() + "\n" +
                                        "Name: " + gender.getName() + "\n" +
                                        "Pokemon Species Details: " + pokemonSpeciesGendersToString(gender.getPokemonSpeciesDetails()) +
                                        "Required For Evolution: " + namedApiResourcesToString(gender.getRequiredForEvolution(), false));
                        success = true;
                    } catch (Exception e) {
                        PokedexRetriever.clearConsole();
                        if (!(e.getCause() instanceof EOFException)) {
                            System.out.println("An error occurred retrieving the data: " + e.getCause() + ". Retrying...");
                        }
                    }
                }
                getGenders();
            }
        }
        PokedexRetriever.setInput("back");
    }

    public static void getGrowthRates() {
        System.out.print("Enter a growth rate ID or 'all' to list: ");
        String input = PokedexRetriever.getScanner().nextLine();
        while (!input.equalsIgnoreCase("all") && !PokedexRetriever.isInt(input) && !input.equalsIgnoreCase("back")) {
            PokedexRetriever.clearConsole();
            System.out.print("Enter a growth rate ID or 'all' to list: ");
            input = PokedexRetriever.getScanner().nextLine();
        }
        if (!input.equalsIgnoreCase("back")) {
            if (input.equalsIgnoreCase("all")) {
                PokedexRetriever.clearConsole();
                boolean success = false;
                while (!success) {
                    try {
                        System.out.println("Retrieving data...");
                        String data = namedApiResourcesToString(PokedexRetriever.getApi().getGrowthRateList(0, 10).getResults(), true);
                        PokedexRetriever.clearConsole();
                        System.out.println(data);
                        success = true;
                    } catch (Exception e) {
                        PokedexRetriever.clearConsole();
                        if (!(e.getCause() instanceof EOFException)) {
                            System.out.println("An error occurred retrieving the data: " + e.getCause() + ". Retrying...");
                        }
                    }
                }
                getGrowthRates();
            } else if (PokedexRetriever.isInt(input)) {
                PokedexRetriever.clearConsole();
                boolean success = false;
                while (!success) {
                    try {
                        System.out.println("Retrieving data...");
                        GrowthRate growthRate = PokedexRetriever.getApi().getGrowthRate(Integer.parseInt(input));
                        PokedexRetriever.clearConsole();
                        System.out.println(
                                "ID: " + growthRate.getId() + "\n" +
                                        "Name: " + growthRate.getName() + "\n" +
                                        "Formula: " + growthRate.getFormula() + "\n" +
                                        "Descriptions: " + descriptionsToString(growthRate.getDescriptions()) +
                                        "Levels: " + growthRateExperienceLevelsToString(growthRate.getLevels()) +
                                        "Pokemon Species: " + namedApiResourcesToString(growthRate.getPokemonSpecies(), false));
                        success = true;
                    } catch (Exception e) {
                        PokedexRetriever.clearConsole();
                        if (!(e.getCause() instanceof EOFException)) {
                            System.out.println("An error occurred retrieving the data: " + e.getCause() + ". Retrying...");
                        }
                    }
                }
                getGrowthRates();
            }
        }
        PokedexRetriever.setInput("back");
    }

    public static void getNatures() {
        System.out.print("Enter a nature ID or 'all' to list: ");
        String input = PokedexRetriever.getScanner().nextLine();
        while (!input.equalsIgnoreCase("all") && !PokedexRetriever.isInt(input) && !input.equalsIgnoreCase("back")) {
            PokedexRetriever.clearConsole();
            System.out.print("Enter a nature ID or 'all' to list: ");
            input = PokedexRetriever.getScanner().nextLine();
        }
        if (!input.equalsIgnoreCase("back")) {
            if (input.equalsIgnoreCase("all")) {
                PokedexRetriever.clearConsole();
                boolean success = false;
                while (!success) {
                    try {
                        System.out.println("Retrieving data...");
                        String data = namedApiResourcesToString(PokedexRetriever.getApi().getNatureList(0, 30).getResults(), true);
                        PokedexRetriever.clearConsole();
                        System.out.println(data);
                        success = true;
                    } catch (Exception e) {
                        PokedexRetriever.clearConsole();
                        if (!(e.getCause() instanceof EOFException)) {
                            System.out.println("An error occurred retrieving the data: " + e.getCause() + ". Retrying...");
                        }
                    }
                }
                getNatures();
            } else if (PokedexRetriever.isInt(input)) {
                PokedexRetriever.clearConsole();
                boolean success = false;
                while (!success) {
                    try {
                        System.out.println("Retrieving data...");
                        Nature nature = PokedexRetriever.getApi().getNature(Integer.parseInt(input));
                        PokedexRetriever.clearConsole();
                        String decreasedStat = "none\n";
                        String increasedStat = "none\n";
                        String likesFlavor = "none\n";
                        String hatesFlavor = "none\n";
                        if (nature.getDecreasedStat() != null) {
                            decreasedStat = namedApiResourcesToString(Arrays.asList(nature.getDecreasedStat()), false);
                        }
                        if (nature.getIncreasedStat() != null) {
                            increasedStat = namedApiResourcesToString(Arrays.asList(nature.getIncreasedStat()), false);
                        }
                        if (nature.getLikesFlavor() != null) {
                            likesFlavor = namedApiResourcesToString(Arrays.asList(nature.getLikesFlavor()), false);
                        }
                        if (nature.getHatesFlavor() != null) {
                            hatesFlavor = namedApiResourcesToString(Arrays.asList(nature.getHatesFlavor()), false);
                        }
                        System.out.println(
                                "ID: " + nature.getId() + "\n" +
                                        "Name: " + nature.getName() + "\n" +
                                        "Decreased Stat: " + decreasedStat +
                                        "Increased Stat: " + increasedStat +
                                        "Hates Flavor: " + hatesFlavor +
                                        "Likes Flavor: " + likesFlavor +
                                        "Pokeathlon Stat Changes: " + natureStatChangesToString(nature.getPokeathlonStatChanges()) +
                                        "Move Battle Style Preferences: " + moveBattleStylePreferncesToString(nature.getMoveBattleStylePreferences()) +
                                        "Names: " + namesToString(nature.getNames()));
                        success = true;
                    } catch (Exception e) {
                        PokedexRetriever.clearConsole();
                        if (!(e.getCause() instanceof EOFException)) {
                            System.out.println("An error occurred retrieving the data: " + e.getCause() + ". Retrying...");
                        }
                    }
                }
                getNatures();
            }
        }
        PokedexRetriever.setInput("back");
    }

    public static void getPokeathlonStats() {
        System.out.print("Enter a pokeathlon stat ID or 'all' to list: ");
        String input = PokedexRetriever.getScanner().nextLine();
        while (!input.equalsIgnoreCase("all") && !PokedexRetriever.isInt(input) && !input.equalsIgnoreCase("back")) {
            PokedexRetriever.clearConsole();
            System.out.print("Enter a pokeathlon stat ID or 'all' to list: ");
            input = PokedexRetriever.getScanner().nextLine();
        }
        if (!input.equalsIgnoreCase("back")) {
            if (input.equalsIgnoreCase("all")) {
                PokedexRetriever.clearConsole();
                boolean success = false;
                while (!success) {
                    try {
                        System.out.println("Retrieving data...");
                        String data = namedApiResourcesToString(PokedexRetriever.getApi().getPokeathlonStatList(0, 10).getResults(), true);
                        PokedexRetriever.clearConsole();
                        System.out.println(data);
                        success = true;
                    } catch (Exception e) {
                        PokedexRetriever.clearConsole();
                        if (!(e.getCause() instanceof EOFException)) {
                            System.out.println("An error occurred retrieving the data: " + e.getCause() + ". Retrying...");
                        }
                    }
                }
                getPokeathlonStats();
            } else if (PokedexRetriever.isInt(input)) {
                PokedexRetriever.clearConsole();
                boolean success = false;
                while (!success) {
                    try {
                        System.out.println("Retrieving data...");
                        PokeathlonStat pokeathlonStat = PokedexRetriever.getApi().getPokeathlonStat(Integer.parseInt(input));
                        PokedexRetriever.clearConsole();
                        System.out.println(
                                "ID: " + pokeathlonStat.getId() + "\n" +
                                        "Name: " + pokeathlonStat.getName() + "\n" +
                                        "Names: " + namesToString(pokeathlonStat.getNames()) +
                                        "Affecting Natures: " + naturePokeathlonStatAffectSetsToString(pokeathlonStat.getAffectingNatures()));
                        success = true;
                    } catch (Exception e) {
                        PokedexRetriever.clearConsole();
                        if (!(e.getCause() instanceof EOFException)) {
                            System.out.println("An error occurred retrieving the data: " + e.getCause() + ". Retrying...");
                        }
                    }
                }
                getPokeathlonStats();
            }
        }
        PokedexRetriever.setInput("back");
    }

    public static void getPokemon() {
        System.out.print("Enter a pokemon ID or 'all' to list: ");
        String input = PokedexRetriever.getScanner().nextLine();
        while (!input.equalsIgnoreCase("all") && !PokedexRetriever.isInt(input) && !input.equalsIgnoreCase("back")) {
            PokedexRetriever.clearConsole();
            System.out.print("Enter a pokemon ID or 'all' to list: ");
            input = PokedexRetriever.getScanner().nextLine();
        }
        if (!input.equalsIgnoreCase("back")) {
            if (input.equalsIgnoreCase("all")) {
                PokedexRetriever.clearConsole();
                boolean success = false;
                while (!success) {
                    try {
                        System.out.println("Retrieving data...");
                        String data = namedApiResourcesToString(PokedexRetriever.getApi().getPokemonList(0, 800).getResults(), true);
                        PokedexRetriever.clearConsole();
                        System.out.println(data);
                        success = true;
                    } catch (Exception e) {
                        PokedexRetriever.clearConsole();
                        if (!(e.getCause() instanceof EOFException)) {
                            System.out.println("An error occurred retrieving the data: " + e.getCause() + ". Retrying...");
                        }
                    }
                }
                getPokemon();
            } else if (PokedexRetriever.isInt(input)) {
                PokedexRetriever.clearConsole();
                boolean success = false;
                while (!success) {
                    try {
                        System.out.println("Retrieving data...");
                        Pokemon pokemon = PokedexRetriever.getApi().getPokemon(Integer.parseInt(input));
                        PokedexRetriever.clearConsole();
                        String pokemonSprites = "none\n";
                        if (pokemon.getSprites() != null) {
                            pokemonSprites = pokemonSpritesToString(pokemon.getSprites());
                        }
                        System.out.println(
                                "ID: " + pokemon.getId() + "\n" +
                                        "Name: " + pokemon.getName() + "\n" +
                                        "Base Experience: " + pokemon.getBaseExperience() + "\n" +
                                        "Height: " + pokemon.getHeight() + "\n" +
                                        "Is Default: " + pokemon.isDefault() + "\n" +
                                        "Order (sorting): " + pokemon.getOrder() + "\n" +
                                        "Weight: " + pokemon.getWeight() + "\n" +
                                        "Abilities: " + pokemonAbilitiesToString(pokemon.getAbilities()) +
                                        "Forms: " + namedApiResourcesToString(pokemon.getForms(), false) +
                                        "Game Indicies: " + versionGameIndicesToString(pokemon.getGameIndices()) +
                                        "Held Items: " + pokemonHeldItemsToString(pokemon.getHeldItems()) +
                                        "Moves: " + pokemonMovesToString(pokemon.getMoves()) +
                                        "Sprites: " + pokemonSprites +
                                        "Species: " + namedApiResourcesToString(Arrays.asList(pokemon.getSpecies()), false) +
                                        "Stats: " + pokemonStatsToString(pokemon.getStats()) +
                                        "Types: " + pokemonTypesToString(pokemon.getTypes()));
                        success = true;
                    } catch (Exception e) {
                        PokedexRetriever.clearConsole();
                        if (!(e.getCause() instanceof EOFException)) {
                            System.out.println("An error occurred retrieving the data: " + e.getCause() + ". Retrying...");
                        }
                    }
                }
                getPokemon();
            }
        }
        PokedexRetriever.setInput("back");
    }

    public static void getPokemonColors() {
        System.out.print("Enter a pokemon color ID or 'all' to list: ");
        String input = PokedexRetriever.getScanner().nextLine();
        while (!input.equalsIgnoreCase("all") && !PokedexRetriever.isInt(input) && !input.equalsIgnoreCase("back")) {
            PokedexRetriever.clearConsole();
            System.out.print("Enter a pokemon color ID or 'all' to list: ");
            input = PokedexRetriever.getScanner().nextLine();
        }
        if (!input.equalsIgnoreCase("back")) {
            if (input.equalsIgnoreCase("all")) {
                PokedexRetriever.clearConsole();
                boolean success = false;
                while (!success) {
                    try {
                        System.out.println("Retrieving data...");
                        String data = namedApiResourcesToString(PokedexRetriever.getApi().getPokemonColorList(0, 10).getResults(), true);
                        PokedexRetriever.clearConsole();
                        System.out.println(data);
                        success = true;
                    } catch (Exception e) {
                        PokedexRetriever.clearConsole();
                        if (!(e.getCause() instanceof EOFException)) {
                            System.out.println("An error occurred retrieving the data: " + e.getCause() + ". Retrying...");
                        }
                    }
                }
                getPokemonColors();
            } else if (PokedexRetriever.isInt(input)) {
                PokedexRetriever.clearConsole();
                boolean success = false;
                while (!success) {
                    try {
                        System.out.println("Retrieving data...");
                        PokemonColor pokemonColor = PokedexRetriever.getApi().getPokemonColor(Integer.parseInt(input));
                        PokedexRetriever.clearConsole();
                        System.out.println(
                                "ID: " + pokemonColor.getId() + "\n" +
                                        "Name: " + pokemonColor.getName() + "\n" +
                                        "Names: " + namesToString(pokemonColor.getNames()) +
                                        "Pokemon Species: " + namedApiResourcesToString(pokemonColor.getPokemonSpecies(), false));
                        success = true;
                    } catch (Exception e) {
                        PokedexRetriever.clearConsole();
                        if (!(e.getCause() instanceof EOFException)) {
                            System.out.println("An error occurred retrieving the data: " + e.getCause() + ". Retrying...");
                        }
                    }
                }
                getPokemonColors();
            }
        }
        PokedexRetriever.setInput("back");
    }

    public static void getPokemonForms() {
        System.out.print("Enter a pokemon form ID or 'all' to list: ");
        String input = PokedexRetriever.getScanner().nextLine();
        while (!input.equalsIgnoreCase("all") && !PokedexRetriever.isInt(input) && !input.equalsIgnoreCase("back")) {
            PokedexRetriever.clearConsole();
            System.out.print("Enter a pokemon form ID or 'all' to list: ");
            input = PokedexRetriever.getScanner().nextLine();
        }
        if (!input.equalsIgnoreCase("back")) {
            if (input.equalsIgnoreCase("all")) {
                PokedexRetriever.clearConsole();
                boolean success = false;
                while (!success) {
                    try {
                        System.out.println("Retrieving data...");
                        String data = namedApiResourcesToString(PokedexRetriever.getApi().getPokemonFormList(0, 920).getResults(), true);
                        PokedexRetriever.clearConsole();
                        System.out.println(data);
                        success = true;
                    } catch (Exception e) {
                        PokedexRetriever.clearConsole();
                        if (!(e.getCause() instanceof EOFException)) {
                            System.out.println("An error occurred retrieving the data: " + e.getCause() + ". Retrying...");
                        }
                    }
                }
                getPokemonForms();
            } else if (PokedexRetriever.isInt(input)) {
                PokedexRetriever.clearConsole();
                boolean success = false;
                while (!success) {
                    try {
                        System.out.println("Retrieving data...");
                        PokemonForm pokemonForm = PokedexRetriever.getApi().getPokemonForm(Integer.parseInt(input));
                        PokedexRetriever.clearConsole();
                        System.out.println(
                                "ID: " + pokemonForm.getId() + "\n" +
                                        "Name: " + pokemonForm.getName() + "\n" +
                                        "Order (sorting): " + pokemonForm.getOrder() + "\n" +
                                        "Form Order: " + pokemonForm.getFormOrder() + "\n" +
                                        "Is Default: " + pokemonForm.isDefault() + "\n" +
                                        "Is Battle Only: " + pokemonForm.isBattleOnly() + "\n" +
                                        "Is Mega: " + pokemonForm.isMega() + "\n" +
                                        "Form Name: " + pokemonForm.getFormName() + "\n" +
                                        "Pokemon: " + namedApiResourcesToString(Arrays.asList(pokemonForm.getPokemon()), false) +
                                        "Sprites: " + pokemonFormSpritesToString(pokemonForm.getSprites()) +
                                        "Version Group: " + namedApiResourcesToString(Arrays.asList(pokemonForm.getVersionGroup()), false));
                        success = true;
                    } catch (Exception e) {
                        PokedexRetriever.clearConsole();
                        if (!(e.getCause() instanceof EOFException)) {
                            System.out.println("An error occurred retrieving the data: " + e.getCause() + ". Retrying...");
                        }
                    }
                }
                getPokemonForms();
            }
        }
        PokedexRetriever.setInput("back");
    }

    public static void getPokemonHabitats() {
        System.out.print("Enter a pokemon habitat ID or 'all' to list: ");
        String input = PokedexRetriever.getScanner().nextLine();
        while (!input.equalsIgnoreCase("all") && !PokedexRetriever.isInt(input) && !input.equalsIgnoreCase("back")) {
            PokedexRetriever.clearConsole();
            System.out.print("Enter a pokemon habitat ID or 'all' to list: ");
            input = PokedexRetriever.getScanner().nextLine();
        }
        if (!input.equalsIgnoreCase("back")) {
            if (input.equalsIgnoreCase("all")) {
                PokedexRetriever.clearConsole();
                boolean success = false;
                while (!success) {
                    try {
                        System.out.println("Retrieving data...");
                        String data = namedApiResourcesToString(PokedexRetriever.getApi().getPokemonHabitatList(0, 10).getResults(), true);
                        PokedexRetriever.clearConsole();
                        System.out.println(data);
                        success = true;
                    } catch (Exception e) {
                        PokedexRetriever.clearConsole();
                        if (!(e.getCause() instanceof EOFException)) {
                            System.out.println("An error occurred retrieving the data: " + e.getCause() + ". Retrying...");
                        }
                    }
                }
                getPokemonHabitats();
            } else if (PokedexRetriever.isInt(input)) {
                PokedexRetriever.clearConsole();
                boolean success = false;
                while (!success) {
                    try {
                        System.out.println("Retrieving data...");
                        PokemonHabitat pokemonHabitat = PokedexRetriever.getApi().getPokemonHabitat(Integer.parseInt(input));
                        PokedexRetriever.clearConsole();
                        System.out.println(
                                "ID: " + pokemonHabitat.getId() + "\n" +
                                        "Name: " + pokemonHabitat.getName() + "\n" +
                                        "Names: " + namesToString(pokemonHabitat.getNames()) +
                                        "Pokemon Species: " + namedApiResourcesToString(pokemonHabitat.getPokemonSpecies(), false));
                        success = true;
                    } catch (Exception e) {
                        PokedexRetriever.clearConsole();
                        if (!(e.getCause() instanceof EOFException)) {
                            System.out.println("An error occurred retrieving the data: " + e.getCause() + ". Retrying...");
                        }
                    }
                }
                getPokemonHabitats();
            }
        }
        PokedexRetriever.setInput("back");
    }

    public static void getPokemonShapes() {
        System.out.print("Enter a pokemon shape ID or 'all' to list: ");
        String input = PokedexRetriever.getScanner().nextLine();
        while (!input.equalsIgnoreCase("all") && !PokedexRetriever.isInt(input) && !input.equalsIgnoreCase("back")) {
            PokedexRetriever.clearConsole();
            System.out.print("Enter a pokemon shape ID or 'all' to list: ");
            input = PokedexRetriever.getScanner().nextLine();
        }
        if (!input.equalsIgnoreCase("back")) {
            if (input.equalsIgnoreCase("all")) {
                PokedexRetriever.clearConsole();
                boolean success = false;
                while (!success) {
                    try {
                        System.out.println("Retrieving data...");
                        String data = namedApiResourcesToString(PokedexRetriever.getApi().getPokemonShapeList(0, 15).getResults(), true);
                        PokedexRetriever.clearConsole();
                        System.out.println(data);
                        success = true;
                    } catch (Exception e) {
                        PokedexRetriever.clearConsole();
                        if (!(e.getCause() instanceof EOFException)) {
                            System.out.println("An error occurred retrieving the data: " + e.getCause() + ". Retrying...");
                        }
                    }
                }
                getPokemonShapes();
            } else if (PokedexRetriever.isInt(input)) {
                PokedexRetriever.clearConsole();
                boolean success = false;
                while (!success) {
                    try {
                        System.out.println("Retrieving data...");
                        PokemonShape pokemonShape = PokedexRetriever.getApi().getPokemonShape(Integer.parseInt(input));
                        PokedexRetriever.clearConsole();
                        System.out.println(
                                "ID: " + pokemonShape.getId() + "\n" +
                                        "Name: " + pokemonShape.getName() + "\n" +
                                        "Awesome Names: " + awesomeNamesToString(pokemonShape.getAwesomeNames()) +
                                        "Names: " + namesToString(pokemonShape.getNames()) +
                                        "Pokemon Species: " + namedApiResourcesToString(pokemonShape.getPokemonSpecies(), false));
                        success = true;
                    } catch (Exception e) {
                        PokedexRetriever.clearConsole();
                        if (!(e.getCause() instanceof EOFException)) {
                            System.out.println("An error occurred retrieving the data: " + e.getCause() + ". Retrying...");
                        }
                    }
                }
                getPokemonShapes();
            }
        }
        PokedexRetriever.setInput("back");
    }

    public static void getPokemonSpecies() {
        System.out.print("Enter a pokemon species ID or 'all' to list: ");
        String input = PokedexRetriever.getScanner().nextLine();
        while (!input.equalsIgnoreCase("all") && !PokedexRetriever.isInt(input) && !input.equalsIgnoreCase("back")) {
            PokedexRetriever.clearConsole();
            System.out.print("Enter a pokemon species ID or 'all' to list: ");
            input = PokedexRetriever.getScanner().nextLine();
        }
        if (!input.equalsIgnoreCase("back")) {
            if (input.equalsIgnoreCase("all")) {
                PokedexRetriever.clearConsole();
                boolean success = false;
                while (!success) {
                    try {
                        System.out.println("Retrieving data...");
                        String data = namedApiResourcesToString(PokedexRetriever.getApi().getPokemonSpeciesList(0, 730).getResults(), true);
                        PokedexRetriever.clearConsole();
                        System.out.println(data);
                        success = true;
                    } catch (Exception e) {
                        PokedexRetriever.clearConsole();
                        if (!(e.getCause() instanceof EOFException)) {
                            System.out.println("An error occurred retrieving the data: " + e.getCause() + ". Retrying...");
                        }
                    }
                }
                getPokemonSpecies();
            } else if (PokedexRetriever.isInt(input)) {
                PokedexRetriever.clearConsole();
                boolean success = false;
                while (!success) {
                    try {
                        System.out.println("Retrieving data...");
                        PokemonSpecies pokemonSpecies = PokedexRetriever.getApi().getPokemonSpecies(Integer.parseInt(input));
                        PokedexRetriever.clearConsole();
                        String evolvesFromSpecies = "none\n";
                        if (pokemonSpecies.getEvolvesFromSpecies() != null) {
                            evolvesFromSpecies = namedApiResourcesToString(Arrays.asList(pokemonSpecies.getEvolvesFromSpecies()), false);
                        }
                        System.out.println(
                                "ID: " + pokemonSpecies.getId() + "\n" +
                                        "Name: " + pokemonSpecies.getName() + "\n" +
                                        "Order (sorting): " + pokemonSpecies.getOrder() + "\n" +
                                        "Gender Rate: " + pokemonSpecies.getGenderRate() + "\n" +
                                        "Capture Rate: " + pokemonSpecies.getCaptureRate() + "\n" +
                                        "Base Happiness: " + pokemonSpecies.getBaseHappiness() + "\n" +
                                        "Is Baby: " + pokemonSpecies.isBaby() + "\n" +
                                        "Hatch Counter: " + pokemonSpecies.getHatchCounter() + "\n" +
                                        "Has Gender Differences: " + pokemonSpecies.getHasGenderDifferences() + "\n" +
                                        "Forms Switchable: " + pokemonSpecies.getFormsSwitchable() + "\n" +
                                        "Growth Rate: " + namedApiResourcesToString(Arrays.asList(pokemonSpecies.getGrowthRate()), false) +
                                        "Pokedex Numbers: " + pokemonSpeciesDexEntriesToString(pokemonSpecies.getPokedexNumbers()) +
                                        "Egg Groups: " + namedApiResourcesToString(pokemonSpecies.getEggGroups(), false) +
                                        "Color: " + namedApiResourcesToString(Arrays.asList(pokemonSpecies.getColor()), false) +
                                        "Shape: " + namedApiResourcesToString(Arrays.asList(pokemonSpecies.getShape()), false) +
                                        "Evolves From Species: " + evolvesFromSpecies +
                                        "Evolution Chain: " + apiResourcesToString(Arrays.asList(pokemonSpecies.getEvolutionChain()), false) +
                                        "Habitat: " + namedApiResourcesToString(Arrays.asList(pokemonSpecies.getHabitat()), false) +
                                        "Generation: " + namedApiResourcesToString(Arrays.asList(pokemonSpecies.getGeneration()), false) +
                                        "Names: " + namesToString(pokemonSpecies.getNames()) +
                                        "Pal Park Encounters: " + palParkEncounterAreasToString(pokemonSpecies.getPalParkEncounters()) +
                                        "Form Descriptions: " + descriptionsToString(pokemonSpecies.getFormDescriptions()) +
                                        "Genera: " + generaToString(pokemonSpecies.getGenera()) +
                                        "Varieties: " + pokemonSpeciesVarietyToString(pokemonSpecies.getVarieties()));
                        success = true;
                    } catch (Exception e) {
                        PokedexRetriever.clearConsole();
                        if (!(e.getCause() instanceof EOFException)) {
                            System.out.println("An error occurred retrieving the data: " + e.getCause() + ". Retrying...");
                        }
                    }
                }
                getPokemonSpecies();
            }
        }
        PokedexRetriever.setInput("back");
    }

    public static void getStats() {
        System.out.print("Enter a stat ID or 'all' to list: ");
        String input = PokedexRetriever.getScanner().nextLine();
        while (!input.equalsIgnoreCase("all") && !PokedexRetriever.isInt(input) && !input.equalsIgnoreCase("back")) {
            PokedexRetriever.clearConsole();
            System.out.print("Enter a stat ID or 'all' to list: ");
            input = PokedexRetriever.getScanner().nextLine();
        }
        if (!input.equalsIgnoreCase("back")) {
            if (input.equalsIgnoreCase("all")) {
                PokedexRetriever.clearConsole();
                boolean success = false;
                while (!success) {
                    try {
                        System.out.println("Retrieving data...");
                        String data = namedApiResourcesToString(PokedexRetriever.getApi().getStatList(0, 10).getResults(), true);
                        PokedexRetriever.clearConsole();
                        System.out.println(data);
                        success = true;
                    } catch (Exception e) {
                        PokedexRetriever.clearConsole();
                        if (!(e.getCause() instanceof EOFException)) {
                            System.out.println("An error occurred retrieving the data: " + e.getCause() + ". Retrying...");
                        }
                    }
                }
                getStats();
            } else if (PokedexRetriever.isInt(input)) {
                PokedexRetriever.clearConsole();
                boolean success = false;
                while (!success) {
                    try {
                        System.out.println("Retrieving data...");
                        Stat stat = PokedexRetriever.getApi().getStat(Integer.parseInt(input));
                        PokedexRetriever.clearConsole();
                        String affectingMoves = "none\n";
                        String affectingNatures = "none\n";
                        String moveDamageClass = "none\n";
                        if (stat.getAffectingMoves() != null) {
                            affectingMoves = moveStatAffectSetsToString(stat.getAffectingMoves());
                        }
                        if (stat.getAffectingNatures() != null) {
                            affectingNatures = natureStatAffectSetsToString(stat.getAffectingNatures());
                        }
                        if (stat.getMoveDamageClass() != null) {
                            moveDamageClass = namedApiResourcesToString(Arrays.asList(stat.getMoveDamageClass()), false);
                        }
                        System.out.println(
                                "ID: " + stat.getId() + "\n" +
                                        "Name: " + stat.getName() + "\n" +
                                        "Game Index: " + stat.getGameIndex() + "\n" +
                                        "Is Battle Only: " + stat.isBattleOnly() + "\n" +
                                        "Affecting Moves: " + affectingMoves +
                                        "Affecting Natures: " + affectingNatures +
                                        "Characteristics: " + apiResourcesToString(stat.getCharacteristics(), false) +
                                        "Move Damage Class: " + moveDamageClass +
                                        "Names: " + namesToString(stat.getNames()));
                        success = true;
                    } catch (Exception e) {
                        PokedexRetriever.clearConsole();
                        if (!(e.getCause() instanceof EOFException)) {
                            System.out.println("An error occurred retrieving the data: " + e.getCause() + ". Retrying...");
                        }
                    }
                }
                getStats();
            }
        }
        PokedexRetriever.setInput("back");
    }

    public static void getTypes() {
        System.out.print("Enter a type ID or 'all' to list: ");
        String input = PokedexRetriever.getScanner().nextLine();
        while (!input.equalsIgnoreCase("all") && !PokedexRetriever.isInt(input) && !input.equalsIgnoreCase("back")) {
            PokedexRetriever.clearConsole();
            System.out.print("Enter a type ID or 'all' to list: ");
            input = PokedexRetriever.getScanner().nextLine();
        }
        if (!input.equalsIgnoreCase("back")) {
            if (input.equalsIgnoreCase("all")) {
                PokedexRetriever.clearConsole();
                boolean success = false;
                while (!success) {
                    try {
                        System.out.println("Retrieving data...");
                        String data = namedApiResourcesToString(PokedexRetriever.getApi().getTypeList(0, 10).getResults(), true);
                        PokedexRetriever.clearConsole();
                        System.out.println(data);
                        success = true;
                    } catch (Exception e) {
                        PokedexRetriever.clearConsole();
                        if (!(e.getCause() instanceof EOFException)) {
                            System.out.println("An error occurred retrieving the data: " + e.getCause() + ". Retrying...");
                        }
                    }
                }
                getTypes();
            } else if (PokedexRetriever.isInt(input)) {
                PokedexRetriever.clearConsole();
                boolean success = false;
                while (!success) {
                    try {
                        System.out.println("Retrieving data...");
                        Type type = PokedexRetriever.getApi().getType(Integer.parseInt(input));
                        PokedexRetriever.clearConsole();
                        String moveDamageClass = "none\n";
                        if(type.getMoveDamageClass() != null) {
                            moveDamageClass = namedApiResourcesToString(Arrays.asList(type.getMoveDamageClass()), false);
                        }
                        System.out.println(
                                "ID: " + type.getId() + "\n" +
                                        "Name: " + type.getName() + "\n" +
                                        "Damage Relations: " + typeRelationsToString(type.getDamageRelations()) +
                                        "Game Indicies: "+ generationGameIndiciesToString(type.getGameIndices()) +
                                        "Generation: " + namedApiResourcesToString(Arrays.asList(type.getGeneration()), false) +
                                        "Move Damage Class: " + moveDamageClass +
                                        "Names: " + namesToString(type.getNames()) +
                                        "Pokemon: " + typePokemonToString(type.getPokemon()) +
                                        "Moves: " + namedApiResourcesToString(type.getMoves(), false));
                        success = true;
                    } catch (Exception e) {
                        PokedexRetriever.clearConsole();
                        if (!(e.getCause() instanceof EOFException)) {
                            System.out.println("An error occurred retrieving the data: " + e.getCause() + ". Retrying...");
                        }
                    }
                }
                getTypes();
            }
        }
        PokedexRetriever.setInput("back");
    }
    //endregion

    //region Utilities
    public static void getLanguages() {
        System.out.print("Enter a language ID or 'all' to list: ");
        String input = PokedexRetriever.getScanner().nextLine();
        while (!input.equalsIgnoreCase("all") && !PokedexRetriever.isInt(input) && !input.equalsIgnoreCase("back")) {
            PokedexRetriever.clearConsole();
            System.out.print("Enter a language ID or 'all' to list: ");
            input = PokedexRetriever.getScanner().nextLine();
        }
        if (!input.equalsIgnoreCase("back")) {
            if (input.equalsIgnoreCase("all")) {
                PokedexRetriever.clearConsole();
                boolean success = false;
                while (!success) {
                    try {
                        System.out.println("Retrieving data...");
                        String data = namedApiResourcesToString(PokedexRetriever.getApi().getLanguageList(0, 15).getResults(), true);
                        PokedexRetriever.clearConsole();
                        System.out.println(data);
                        success = true;
                    } catch (Exception e) {
                        PokedexRetriever.clearConsole();
                        if (!(e.getCause() instanceof EOFException)) {
                            System.out.println("An error occurred retrieving the data: " + e.getCause() + ". Retrying...");
                        }
                    }
                }
                getLanguages();
            } else if (PokedexRetriever.isInt(input)) {
                PokedexRetriever.clearConsole();
                boolean success = false;
                while (!success) {
                    try {
                        System.out.println("Retrieving data...");
                        Language language = PokedexRetriever.getApi().getLanguage(Integer.parseInt(input));
                        PokedexRetriever.clearConsole();
                        System.out.println(
                                "ID: " + language.getId() + "\n" +
                                        "Name: " + language.getName() + "\n" +
                                        "Official: " + language.getOfficial() + "\n" +
                                        "Iso639: " + language.getIso639() + "\n" +
                                        "Iso3166: " + language.getIso3166() + "\n" +
                                        "Names: " + namesToString(language.getNames()));
                        success = true;
                    } catch (Exception e) {
                        PokedexRetriever.clearConsole();
                        if (!(e.getCause() instanceof EOFException)) {
                            System.out.println("An error occurred retrieving the data: " + e.getCause() + ". Retrying...");
                        }
                    }
                }
                getLanguages();
            }
        }
        PokedexRetriever.setInput("back");
    }
    //endregion

    private static String berryFlavorMapsToString(List<BerryFlavorMap> maps) {
        String response = "\n";
        for (BerryFlavorMap map : maps) {
            response += "\tPotency: " + map.getPotency() + "\tFlavor: " + map.getFlavor().getName() + "\n";
        }
        return response;
    }

    private static String flavorBerryMapsToString(List<FlavorBerryMap> maps) {
        String response = "\n";
        for (FlavorBerryMap map : maps) {
            response += String.format("\t%-17s %-20s" + "\n", "Potency: " + map.getPotency(), "Berry: " + map.getBerry().getName());
        }
        return response;
    }

    private static String namedApiResourcesToString(List<NamedApiResource> rsrcs, boolean single) {
        String response = "\n";
        for (NamedApiResource rsrc : rsrcs) {
            if (rsrc.getName() == null) {
                response += String.format((single ? "" : "\t") + "%-10s %-20s" + "\n", "ID: n/a", "Name: none");
            } else {
                response += String.format((single ? "" : "\t") + "%-10s %-20s" + "\n", "ID: " + rsrc.getId(), "Name: " + rsrc.getName());
            }
        }
        return response;
    }

    private static String apiResourcesToString(List<ApiResource> rsrcs, boolean single) {
        String response = "\n";
        for (ApiResource rsrc : rsrcs) {
            response += String.format((single ? "" : "\t") + "%-8s" + "\n", "ID: " + rsrc.getId());
        }
        return response;
    }

    private static String namesToString(List<Name> names) {
        String response = "\n";
        for (Name name : names) {
            response += String.format("\t%-15s %-20s" + "\n", "Language: " + name.getLanguage().getName().toUpperCase(), "Name: " + name.getName());
        }
        return response;
    }

    private static String contestNamesToString(List<ContestName> names) {
        String response = "\n";
        for (ContestName name : names) {
            response += String.format("\t%-17s %-15s %-20s" + "\n", "Color: " + name.getColor(), "Name: " + name.getName(), "Language: " + name.getLanguage().getName().toUpperCase());
        }
        return response;
    }

    private static String effectsToString(List<Effect> effects) {
        String response = "\n";
        for (Effect effect : effects) {
            response += String.format("\t%-15s %-30s" + "\n", "Language: " + effect.getLanguage().getName().toUpperCase(), "Effect: " + effect.getEffect());
        }
        return response;
    }

    private static String flavorTextsToString(List<FlavorText> entries) {
        String response = "\n";
        for (FlavorText entry : entries) {
            response += String.format("\t%-15s %-30s" + "\n", "Language: " + entry.getLanguage().getName().toUpperCase(), "Flavor Text: " + entry.getFlavorText().replace("\n", " "));
        }
        return response;
    }

    private static String abilityFlavorTextsToString(List<AbilityFlavorText> entries) {
        String response = "\n";
        for (AbilityFlavorText entry : entries) {
            response += String.format("\n\t%-15s %-20s\n\t%s" + "\n", "Language: " + entry.getLanguage().getName().toUpperCase(), "Version Group: " + entry.getVersionGroup().getName(), "Flavor Text: " + entry.getFlavorText().replace("\n", " "));
        }
        return response;
    }

    private static String descriptionsToString(List<Description> desciptions) {
        String response = "\n";
        for (Description description : desciptions) {
            response += String.format("\t%-15s %-30s" + "\n", "Language: " + description.getLanguage().getName().toUpperCase(), "Description: " + description.getDescription());
        }
        return response;
    }

    private static String chainLinkToString(ChainLink chain) {
        String response = "\n";
        response += "\tSpecies: " + "\n\t\t" + namedApiResourcesToString(Arrays.asList(chain.getSpecies()), true).replace("\n", "\n\t\t").trim();
        response += "\n\tIs Baby: " + chain.isBaby() + "\n";
        if (!chain.getEvolutionDetails().isEmpty()) {
            try {
                response += "\tEvolution Details: " + evolutionDetailToString(chain.getEvolutionDetails()) + "\n";
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        if (!chain.getEvolvesTo().isEmpty()) {
            for (ChainLink c : chain.getEvolvesTo()) {
                response += chainLinkToString(c);
            }
        }
        return response;
    }

    private static String evolutionDetailToString(List<EvolutionDetail> details) throws IllegalAccessException, InvocationTargetException {
        String response = "\n";
        for (EvolutionDetail detail : details) {
            response += "\t\tTrigger: " + "\n\t\t\t" + namedApiResourcesToString(Arrays.asList(detail.getTrigger()), true).replace("\n", "\n\t\t\t").trim();
            Method[] methods = detail.getClass().getMethods();
            for (Method method : methods) {
                if (method.getReturnType() == NamedApiResource.class &&
                        !method.getName().contains("component") &&
                        !method.getName().toLowerCase().contains("trigger")) {
                    if (method.invoke(detail) != null) {
                        response += "\n\t\t" + method.getName().replace("get", "").replaceAll("(\\p{Ll})(\\p{Lu})", "$1 $2") + ": " + "\n\t\t\t" + namedApiResourcesToString(Arrays.asList((NamedApiResource) method.invoke(detail)), true).replace("\n", "\n\t\t\t").trim();
                    }

                } else if (method.getReturnType() == Integer.class &&
                        !method.getName().contains("component")) {
                    if (method.invoke(detail) != null) {
                        response += "\n\t\t" + method.getName().replace("get", "").replaceAll("(\\p{Ll})(\\p{Lu})", "$1 $2") + ": " + method.invoke(detail);
                    }

                } else if (method.getReturnType() == boolean.class &&
                        !method.getName().contains("equals") &&
                        !method.getName().contains("component")) {
                    if (method.invoke(detail) != null) {
                        response += "\n\t\t" + method.getName().replace("get", "").replaceAll("(\\p{Ll})(\\p{Lu})", "$1 $2") + ": " + method.invoke(detail);
                    }
                } else if (method.getReturnType() == String.class &&
                        !method.getName().contains("String") &&
                        !method.getName().contains("component")) {
                    if (method.invoke(detail) != null && !((String) method.invoke(detail)).equalsIgnoreCase("")) {
                        response += "\n\t\t" + method.getName().replace("get", "").replaceAll("(\\p{Ll})(\\p{Lu})", "$1 $2") + ": " + method.invoke(detail);
                    }
                }
            }
        }
        return response;
    }

    private static String pokemonEntriesToString(List<PokemonEntry> entries) {
        String response = "\n";
        for (PokemonEntry entry : entries) {
            response += String.format("\t%-19s %-20s" + "\n", "Entry Number: " + entry.getEntryNumber(), "Name: " + entry.getPokemonSpecies().getName());
        }
        return response;
    }

    private static String verboseEffectToString(List<VerboseEffect> effects) {
        String response = "\n";
        for (VerboseEffect effect : effects) {
            response += String.format("\t%-15s %-20s\n\t%s" + "\n", "Language: " + effect.getLanguage().getName().toUpperCase(), "Short Effect: " + effect.getShortEffect(), "Effect: " + effect.getEffect().replace("\n:", ":").replace("\n\n", "\n\t"));
        }
        return response;
    }

    private static String versionGroupFlavorTextsToString(List<VersionGroupFlavorText> entries) {
        String response = "\n";
        for (VersionGroupFlavorText entry : entries) {
            response += String.format("\t%-15s %-30s\n\t%-30s" + "\n", "Language: " + entry.getLanguage().getName().toUpperCase(), "Version Group: " + entry.getVersionGroup().getName(), "Text: " + entry.getText().replace("\n", " "));
        }
        return response;
    }

    private static String generationGameIndiciesToString(List<GenerationGameIndex> indicies) {
        String response = "\n";
        for (GenerationGameIndex index : indicies) {
            response += String.format("\t%-17s %-30s" + "\n", "Game Index: " + index.getGameIndex(), "Generation: " + index.getGeneration().getName());
        }
        return response;
    }

    private static String itemSpritesToString(ItemSprites sprites) {
        return "\n\t" + sprites.getDefault() + "\n";
    }

    private static String itemHolderPokemonToString(List<ItemHolderPokemon> pokemon) {
        String response = "\n";
        for (ItemHolderPokemon poke : pokemon) {
            response += String.format("\tPokemon: \n\t\t%-8s %-30s" + "\n", "ID: " + poke.getPokemon().getId(), "Name: " + poke.getPokemon().getName());
            response += String.format("\tVersion Details: " + itemHolderPokemonVersionDetails(poke.getVersionDetails()));
        }
        return response;
    }

    private static String itemHolderPokemonVersionDetails(List<ItemHolderPokemonVersionDetail> details) {
        String response = "\n";
        for (ItemHolderPokemonVersionDetail detail : details) {
            response += String.format("\t\t%-15s %-20s\n", "Version: " + detail.getVersion().getName(), "Rarity: " + detail.getRarity());
        }
        return response;
    }

    private static String contestComboSetsToString(ContestComboSets sets) {
        String response = "\n";
        response += "\tNormal: " + contestComboDetailToString(sets.getNormalSet());
        response += "\n\tSuper: " + contestComboDetailToString(sets.getSuperSet());
        return response + "\n";
    }

    private static String contestComboDetailToString(ContestComboDetail detail) {
        String response = "\n";
        String useBefore = "none\n";
        String useAfter = "none\n";
        if (detail.getUseBefore() != null) {
            useBefore = namedApiResourcesToString(detail.getUseBefore(), true).replace("\n", "\n\t\t\t").trim();
        }
        if (detail.getUseAfter() != null) {
            useAfter = namedApiResourcesToString(detail.getUseAfter(), true).replace("\n", "\n\t\t\t").trim();
        }
        response += "\t\tUse Before: " + "\n\t\t\t" + useBefore;
        response += "\n\t\tUse After: " + "\n\t\t\t" + useAfter;
        return response;
    }

    private static String abilityEffectChangesToString(List<AbilityEffectChange> changes) {
        String response = "\n";
        for (AbilityEffectChange change : changes) {
            response += String.format("\t%-30s\n\t%-30s", "Version Group: " + change.getVersionGroup().getName(), "Effect Entries: " + effectsToString(change.getEffectEntries()).replace("\n\t", "\n\t\t"));
        }
        return response;
    }

    private static String metaToString(MoveMetaData metaData) {
        String response = "";
        Method[] methods = metaData.getClass().getMethods();
        for (Method method : methods) {
            if (method.getReturnType() == NamedApiResource.class &&
                    !method.getName().contains("component")) {
                try {
                    if (method.invoke(metaData) != null) {
                        response += "\n\t" + method.getName().replace("get", "").replaceAll("(\\p{Ll})(\\p{Lu})", "$1 $2") + ": \n\t\t" + namedApiResourcesToString(Arrays.asList((NamedApiResource) method.invoke(metaData)), true).replace("\n", "\n\t\t").trim();
                    }
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            } else if (method.getReturnType() == Integer.class &&
                    !method.getName().contains("component")) {
                try {
                    if (method.invoke(metaData) != null) {
                        response += "\n\t" + method.getName().replace("get", "").replaceAll("(\\p{Ll})(\\p{Lu})", "$1 $2") + ": " + method.invoke(metaData);
                    }
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            } else if (method.getReturnType() == int.class &&
                    !method.getName().contains("component") &&
                    !method.getName().contains("hash")) {
                try {
                    if (method.invoke(metaData) != null) {
                        response += "\n\t" + method.getName().replace("get", "").replaceAll("(\\p{Ll})(\\p{Lu})", "$1 $2") + ": " + method.invoke(metaData);
                    }
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        return response + "\n";
    }

    private static String pastValuesToString(List<PastMoveStatValues> values) {
        String response = "\n";
        for (PastMoveStatValues value : values) {
            String type = "null";
            if (value.getType() != null) {
                type = "\n\t\t" + namedApiResourcesToString(Arrays.asList(value.getType()), true).replace("\n", "\n\t\t").trim();
            }
            response += "\tAccuracy: " + value.getAccuracy() + "\n" +
                    "\tEffect Chance: " + value.getEffectChance() + "\n" +
                    "\tPower: " + value.getPower() + "\n" +
                    "\tPP: " + value.getPp() + "\n" +
                    "\tEffect Entries: " + verboseEffectToString(value.getEffectEntries()).replace("\n\t", "\n\t\t") +
                    "\tType: " + type + "\n" +
                    "\tVersion Group: \n\t\t" + namedApiResourcesToString(Arrays.asList(value.getVersionGroup()), true).replace("\n", "\n\t\t").trim() + "\n";
        }
        return response;
    }

    private static String statChangesToString(List<MoveStatChange> changes) {
        String response = "\n";
        for (MoveStatChange change : changes) {
            response += "\tChange: " + change.getChange() + "\n" +
                    "\tStat: \n\t\t" + namedApiResourcesToString(Arrays.asList(change.getStat()), true).replace("\n", "\n\t\t").trim() + "\n";
        }
        return response;
    }

    private static String encounterMethodRatesToString(List<EncounterMethodRate> rates) {
        String response = "\n";
        for (EncounterMethodRate rate : rates) {
            response += "\tEncounter Method: \n\t\t" + namedApiResourcesToString(Arrays.asList(rate.getEncounterMethod()), true).replace("\n", "\n\t\t").trim();
            response += "\n\tVersion Details: " + encounterVersionDetailsToString(rate.getVersionDetails());
        }
        return response;
    }

    private static String encounterVersionDetailsToString(List<EncounterMethodRateVersionDetail> details) {
        String response = "";
        for (EncounterMethodRateVersionDetail detail : details) {
            response += "\n\t\tRate: " + detail.getRate() + "\n";
            response += "\t\tVersion: \n\t\t\t" + namedApiResourcesToString(Arrays.asList(detail.getVersion()), true).replace("\n", "\n\t\t\t").trim();
        }
        return response + "\n";
    }

    private static String pokemonEncountersToString(List<PokemonEncounter> encounters) {
        String response = "\n";
        for (PokemonEncounter encounter : encounters) {
            response += "\tPokemon: \n\t\t" + namedApiResourcesToString(Arrays.asList(encounter.getPokemon()), true).replace("\n", "\n\t\t").trim();
            response += "\n\tVersion Details: " + versionEncounterDetailsToString(encounter.getVersionDetails());
        }
        return response;
    }

    private static String versionEncounterDetailsToString(List<VersionEncounterDetail> details) {
        String response = "\n";
        for (VersionEncounterDetail detail : details) {
            response += "\t\tVersion: \n\t\t\t" + namedApiResourcesToString(Arrays.asList(detail.getVersion()), true).replace("\n", "\n\t\t\t").trim();
            response += "\n\t\tMax Chance: " + detail.getMaxChance();
            response += "\n\t\tEncounter Details: " + encountersToString(detail.getEncounterDetails());
        }
        return response;
    }

    private static String encountersToString(List<Encounter> encounters) {
        String response = "";
        for (Encounter encounter : encounters) {
            response += "\n\t\t\tMin Level: " + encounter.getMinLevel();
            response += "\n\t\t\tMax Level: " + encounter.getMaxLevel();
            response += "\n\t\t\tCondition Values: \n\t\t\t\t" + namedApiResourcesToString(encounter.getConditionValues(), true).replace("\n", "\n\t\t\t\t").trim();
            response += "\n\t\t\tChance: " + encounter.getChance();
            response += "\n\t\t\tMethod: \n\t\t\t\t" + namedApiResourcesToString(Arrays.asList(encounter.getMethod()), true).replace("\n", "\n\t\t\t\t").trim();
        }
        return response + "\n";
    }

    private static String palParkEncounterSpeciesToString(List<PalParkEncounterSpecies> species) {
        String response = "";
        for (PalParkEncounterSpecies spec : species) {
            response += "\n\n\tBase Score: " + spec.getBaseScore() + "\n" +
                    "\tRate: " + spec.getRate() + "\n" +
                    "\tPokemon Species: \n\t\t" + namedApiResourcesToString(Arrays.asList(spec.getPokemonSpecies()), true).replace("\n", "\n\t\t").trim();
        }
        return response + "\n";
    }

    private static String abilityPokemonToString(List<AbilityPokemon> pokemon) {
        String response = "";
        for (AbilityPokemon poke : pokemon) {
            response += "\n\n\tIs Hidden: " + poke.isHidden() + "\n" +
                    "\tSlot: " + poke.getSlot() + "\n" +
                    "\tPokemon: \n\t\t" + namedApiResourcesToString(Arrays.asList(poke.getPokemon()), true).replace("\n", "\n\t\t").trim();
        }
        return response + "\n";
    }

    private static String intArrayToString(List<Integer> integers) {
        String response = " ";
        for (Integer integer : integers) {
            response += integer + ", ";
        }
        return response.substring(0, response.length() - 2).trim();
    }

    private static String pokemonSpeciesGendersToString(List<PokemonSpeciesGender> genders) {
        String response = "";
        for (PokemonSpeciesGender gender : genders) {
            response += "\n\n\tRate: " + gender.getRate() + "\n" +
                    "\tPokemon Species: \n\t\t" + namedApiResourcesToString(Arrays.asList(gender.getPokemonSpecies()), true).replace("\n", "\n\t\t").trim();
        }
        return response + "\n";
    }

    private static String growthRateExperienceLevelsToString(List<GrowthRateExperienceLevel> levels) {
        String response = "\n";
        for (GrowthRateExperienceLevel level : levels) {
            response += "\n\tLevel: " + level.getLevel() + "\n" +
                    "\tExperience: " + level.getExperience() + "\n";
        }
        return response + "\n";
    }

    private static String natureStatChangesToString(List<NatureStatChange> changes) {
        String response = "\n";
        for (NatureStatChange change : changes) {
            response += "\n\tMax Change: " + change.getMaxChange() + "\n" +
                    "\tPokeathlon Stat: \n\t\t" + namedApiResourcesToString(Arrays.asList(change.getPokeathlonStat()), true).replace("\n", "\n\t\t").trim() + "\n";
        }
        return response + "\n";
    }

    private static String moveBattleStylePreferncesToString(List<MoveBattleStylePreference> preferences) {
        String response = "\n";
        for (MoveBattleStylePreference preference : preferences) {
            response += "\n\tLow HP Preference: " + preference.getLowHpPreference() + "\n" +
                    "\tHigh HP Preference: " + preference.getHighHpPreference() + "\n" +
                    "\tMove Battle Style: \n\t\t" + namedApiResourcesToString(Arrays.asList(preference.getMoveBattleStyle()), true).replace("\n", "\n\t\t").trim() + "\n";
        }
        return response + "\n";
    }

    private static String naturePokeathlonStatAffectSetsToString(NaturePokeathlonStatAffectSets sets) {
        String response = "\n";
        response += "\n\tIncrease: " + naturePokeathlonStatAffectsToString(sets.getIncrease()) +
                "\n\tDecrease: " + naturePokeathlonStatAffectsToString(sets.getDecrease());
        return response;
    }

    private static String naturePokeathlonStatAffectsToString(List<NaturePokeathlonStatAffect> affects) {
        String response = "\n";
        for (NaturePokeathlonStatAffect affect : affects) {
            response += "\n\t\tMax Change: " + affect.getMaxChange() + "\n" +
                    "\t\tNature: \n\t\t\t" + namedApiResourcesToString(Arrays.asList(affect.getNature()), true).replace("\n", "\n\t\t\t").trim() + "\n";
        }
        return response;
    }

    private static String pokemonAbilitiesToString(List<PokemonAbility> abilities) {
        String response = "\n";
        for (PokemonAbility ability : abilities) {
            response += "\n\tIs Hidden: " + ability.isHidden() + "\n" +
                    "\tSlot: " + ability.getSlot() + "\n" +
                    "\tAbility: \n\t\t" + namedApiResourcesToString(Arrays.asList(ability.getAbility()), true).replace("\n", "\n\t\t").trim() + "\n";
        }
        return response + "\n";
    }

    private static String versionGameIndicesToString(List<VersionGameIndex> indices) {
        String response = "\n";
        for (VersionGameIndex index : indices) {
            response += "\n\tGame Index: " + index.getGameIndex() + "\n" +
                    "\tVersion: \n\t\t" + namedApiResourcesToString(Arrays.asList(index.getVersion()), true).replace("\n", "\n\t\t").trim() + "\n";
        }
        return response = "\n";
    }

    private static String pokemonHeldItemsToString(List<PokemonHeldItem> items) {
        String response = "\n";
        for (PokemonHeldItem item : items) {
            response += "\n\tItem: \n\t\t" + namedApiResourcesToString(Arrays.asList(item.getItem()), true).replace("\n", "\n\t\t").trim() + "\n" +
                    "\tVersion Details: " + pokemonHeldItemVersionsToString(item.getVersionDetails());
        }
        return response;
    }

    private static String pokemonHeldItemVersionsToString(List<PokemonHeldItemVersion> versions) {
        String response = "\n";
        for (PokemonHeldItemVersion version : versions) {
            response += "\n\t\tVersion: \n\t\t\t" + namedApiResourcesToString(Arrays.asList(version.getVersion()), true).replace("\n", "\n\t\t\t").trim() + "\n" +
                    "\t\tRarity: " + version.getRarity() + "\n";
        }
        return response;
    }

    private static String pokemonMovesToString(List<PokemonMove> moves) {
        String response = "\n";
        for (PokemonMove move : moves) {
            response += "\n\tMove: \n\t\t" + namedApiResourcesToString(Arrays.asList(move.getMove()), true).replace("\n", "\n\t\t").trim() + "\n" +
                    "\tVersion Group Details: " + pokemonMoveVersionsToString(move.getVersionGroupDetails());
        }
        return response;
    }

    private static String pokemonMoveVersionsToString(List<PokemonMoveVersion> versions) {
        String response = "\n";
        for (PokemonMoveVersion version : versions) {
            response += "\n\t\tMove Learn Method: \n\t\t\t" + namedApiResourcesToString(Arrays.asList(version.getMoveLearnMethod()), true).replace("\n", "\n\t\t\t").trim() + "\n" +
                    "\t\tVersion Group: \n\t\t\t" + namedApiResourcesToString(Arrays.asList(version.getVersionGroup()), true).replace("\n", "\n\t\t\t").trim() + "\n" +
                    "\t\tLevel Learned At: " + version.getLevelLearnedAt() + "\n";
        }
        return response;
    }

    private static String pokemonSpritesToString(PokemonSprites sprites) {
        String response = "\n";
        Method[] methods = sprites.getClass().getMethods();
        for (Method method : methods) {
            if (method.getReturnType() == String.class &&
                    method.getName().contains("get")) {
                try {
                    if (method.invoke(sprites) != null) {
                        response += "\t" + method.getName().replace("get", "").replaceAll("(\\p{Ll})(\\p{Lu})", "$1 $2") + ": " + method.invoke(sprites) + "\n";
                    }
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        return response;
    }

    private static String pokemonStatsToString(List<PokemonStat> stats) {
        String response = "\n";
        for (PokemonStat stat : stats) {
            response += "\n\tStat: " + namedApiResourcesToString(Arrays.asList(stat.getStat()), true).replace("\n", "\n\t\t").trim() + "\n" +
                    "\tEffort: " + stat.getEffort() + "\n" +
                    "\tBase Stat:" + stat.getBaseStat() + "\n";
        }
        return response + "\n";
    }

    private static String pokemonTypesToString(List<PokemonType> types) {
        String response = "\n";
        for (PokemonType type : types) {
            response += "\n\tSlot: " + type.getSlot() + "\n" +
                    "\tType: \n\t\t" + namedApiResourcesToString(Arrays.asList(type.getType()), true).replace("\n", "\n\t\t").trim() + "\n";
        }
        return response + "\n";
    }

    private static String pokemonFormSpritesToString(PokemonFormSprites sprites) {
        String response = "\n";
        Method[] methods = sprites.getClass().getMethods();
        for (Method method : methods) {
            if (method.getReturnType() == String.class &&
                    method.getName().contains("get")) {
                try {
                    if (method.invoke(sprites) != null) {
                        response += "\t" + method.getName().replace("get", "").replaceAll("(\\p{Ll})(\\p{Lu})", "$1 $2") + ": " + method.invoke(sprites) + "\n";
                    }
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        return response;
    }

    private static String awesomeNamesToString(List<AwesomeName> names) {
        String response = "\n";
        for (AwesomeName name : names) {
            response += String.format("\t%-15s %-20s" + "\n", "Language: " + name.getLanguage().getName().toUpperCase(), "Name: " + name.getAwesomeName());
        }
        return response;
    }

    private static String pokemonSpeciesDexEntriesToString(List<PokemonSpeciesDexEntry> entries) {
        String response = "\n";
        for (PokemonSpeciesDexEntry entry : entries) {
            response += "\n\tEntry Number: " + entry.getEntryNumber() + "\n" +
                    "\tPokedex: \n\t\t" + namedApiResourcesToString(Arrays.asList(entry.getPokedex()), true).replace("\n", "\n\t\t").trim() + "\n";
        }
        return response + "\n";
    }

    private static String palParkEncounterAreasToString(List<PalParkEncounterArea> areas) {
        String response = "\n";
        for (PalParkEncounterArea area : areas) {
            response += "\n\tBase Score: " + area.getBaseScore() + "\n" +
                    "\tRate: " + area.getRate() + "\n" +
                    "\tArea: \n\t\t" + namedApiResourcesToString(Arrays.asList(area.getArea()), true).replace("\n", "\n\t\t").trim() + "\n";
        }
        return response + "\n";
    }

    private static String generaToString(List<Genus> genera) {
        String response = "\n";
        for (Genus genus : genera) {
            response += "\n\tGenus: " + genus.getGenus() + "\n" +
                    "\tLanguage: \n\t\t" + namedApiResourcesToString(Arrays.asList(genus.getLanguage()), true).replace("\n", "\n\t\t").trim() + "\n";
        }
        return response + "\n";
    }

    private static String pokemonSpeciesVarietyToString(List<PokemonSpeciesVariety> varieties) {
        String response = "\n";
        for (PokemonSpeciesVariety variety : varieties) {
            response += "\n\tIs Default: " + variety.isDefault() + "\n" +
                    "\tPokemon: \n\t\t" + namedApiResourcesToString(Arrays.asList(variety.getPokemon()), true).replace("\n", "\n\t\t").trim() + "\n";
        }
        return response;
    }

    private static String moveStatAffectSetsToString(MoveStatAffectSets sets) {
        String response = "\n";
        response += "\n\tIncrease: " + moveStatAffectsToString(sets.getIncrease()) +
                "\n\tDecrease: " + moveStatAffectsToString(sets.getDecrease());
        return response + "\n";
    }

    private static String moveStatAffectsToString(List<MoveStatAffect> affects) {
        String response = "\n";
        for (MoveStatAffect affect : affects) {
            response += "\n\t\tChange: " + affect.getChange() + "\n" +
                    "\t\tMove: \n\t\t\t" + namedApiResourcesToString(Arrays.asList(affect.getMove()), true).replace("\n", "\n\t\t\t").trim() + "\n";
        }
        return response;
    }

    private static String natureStatAffectSetsToString(NatureStatAffectSets sets) {
        String response = "\n";
        response += "\n\tIncrease: \n\t\t" + namedApiResourcesToString(sets.getIncrease(), true).replace("\n", "\n\t\t").trim() + "\n" +
                "\n\tDecrease: \n\t\t" + namedApiResourcesToString(sets.getDecrease(), true).replace("\n", "\n\t\t").trim() + "\n";
        return response;
    }

    private static String typeRelationsToString(TypeRelations relations) {
        String response = "\n";
        Method[] methods = relations.getClass().getMethods();
        for (Method method : methods) {
            if (method.getReturnType() == List.class &&
                    method.getName().contains("get")) {
                try {
                    if (method.invoke(relations) != null) {
                        response += "\t" + method.getName().replace("get", "").replaceAll("(\\p{Ll})(\\p{Lu})", "$1 $2") + ": \n\t\t" + namedApiResourcesToString((List<NamedApiResource>) method.invoke(relations), true).replace("\n", "\n\t\t").trim() + "\n";
                    }
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        return response;
    }

    private static String typePokemonToString(List<TypePokemon> pokemon) {
        String response = "\n";
        for(TypePokemon poke : pokemon) {
            response += "\n\tSlot: " + poke.getSlot() + "\n" +
                    "\tPokemon: \n\t\t" + namedApiResourcesToString(Arrays.asList(poke.getPokemon()), true).replace("\n", "\n\t\t").trim() + "\n";
        }
        return response + "\n";
    }
}
