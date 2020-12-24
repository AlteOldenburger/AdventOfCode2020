package de.mattes.ossenbeck.day.day07;

import de.mattes.ossenbeck.day.PuzzleSolver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LuggageProcessor implements PuzzleSolver {
    private final Map<String, Bag> bags = new HashMap<>();

    public LuggageProcessor(List<String> aviationRegulations) {
        aviationRegulations.forEach(this::convertAndAdd);
    }

    @Override
    public Number solvePartOne() {
        return bags.values()
                   .stream()
                   .filter(this::containsGoldenBag)
                   .count();
    }

    @Override
    public Number solvePartTwo() {
        return countBags(bags.get("shiny gold")) - 1;
    }

    private void convertAndAdd(String line) {
        var rule = line.replaceAll("bags*\\.*", "")
                       .trim()
                       .split("\\s\\scontain\\s");

        var bag = new Bag(rule[0], rule[1]);
        bags.put(bag.getName(), bag);
    }

    private boolean containsGoldenBag(Bag bag) {
        if (bag.hasChild("shiny gold")) {
            return true;
        }
        for (var nameOfChildBag : bag.getNameOfChildBags()) {
            if (containsGoldenBag(bags.get(nameOfChildBag))) {
                return true;
            }
        }
        return false;
    }

    private long countBags(Bag bag) {
        var counter = 1;
        for (var nameOfChildBag : bag.getNameOfChildBags()) {
            counter += bag.getNumberOfChildBag(nameOfChildBag) * countBags(bags.get(nameOfChildBag));
        }
        return counter;
    }
}