package de.brachwitz.leon.tag03;

import de.brachwitz.leon.utils.FileReader;

import java.math.BigInteger;
import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        var fileReader = new FileReader();
        var input = fileReader.readCsvFile("/tag03/input.txt");

        var map = input.stream().map(String::toCharArray).toArray(char[][]::new);

        var treeCounter = new TreeCounter();
        System.out.println("Amount of trees " + treeCounter.countTrees(map, 3, 1));

        var slopes = new ArrayList<Integer>();

        slopes.add(treeCounter.countTrees(map, 1, 1));
        slopes.add(treeCounter.countTrees(map, 3, 1));
        slopes.add(treeCounter.countTrees(map, 5, 1));
        slopes.add(treeCounter.countTrees(map, 7, 1));
        slopes.add(treeCounter.countTrees(map, 1, 2));

        System.out.println("Product of amount of trees in multiple slopes: " + slopes.stream().map(BigInteger::valueOf).reduce(BigInteger::multiply).get());
    }
}
