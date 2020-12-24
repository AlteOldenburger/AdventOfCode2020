package de.mattes.ossenbeck.day.day07;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

public class Bag {
    private static final Pattern BAG_PATTERN = Pattern.compile("(\\d+) (\\w+ \\w+)");
    private final String name;
    private final Map<String, Integer> children = new HashMap<>();

    public Bag(String name, String regulation) {
        this.name = name;
        convertRegulation(regulation);
    }

    private void convertRegulation(String regulation) {
        var bagInformation = List.of(regulation.split("\\s,\\s"));

        for (var childBagInformation : bagInformation) {
            var matcher = BAG_PATTERN.matcher(childBagInformation);

            if (matcher.find()) {
                var numberOfBags = Integer.parseInt(matcher.group(1));
                var nameOfChildBag = matcher.group(2);

                children.put(nameOfChildBag, numberOfBags);
            }
        }
    }

    public String getName() {
        return name;
    }

    public boolean hasChild(String nameOfChild) {
        return children.containsKey(nameOfChild);
    }

    public Set<String> getNameOfChildBags() {
        return children.keySet();
    }

    public int getNumberOfChildBag(String nameOfChild) {
        return children.get(nameOfChild);
    }
}