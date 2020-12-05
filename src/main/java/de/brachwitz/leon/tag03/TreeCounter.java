package de.brachwitz.leon.tag03;

public class TreeCounter
{
    public Integer countTrees(char[][] map, int right, int down)
    {
        int trees = 0;
        for (int i = 0; i * down < map.length; i++)
        {
            if (map[i * down][i * right % map[0].length] == '#')
            {
                trees++;
            }
        }
        return trees;
    }
}
