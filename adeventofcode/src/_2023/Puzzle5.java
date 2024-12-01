package _2023;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Puzzle5 {

    public static void main(String[] args) throws IOException {
        List<String> inputs = Files.readAllLines(Paths.get("adeventofcode/src/_2023/Puzzle5Input.txt"));
        String seeds = inputs.get(0);
        String[] seedInput = seeds.split(" ");

        List<Puzzle5Domain> seedToSoils = buildPuzzle5Domain(inputs, 3, 46);
        List<Puzzle5Domain> soilToFertilizers = buildPuzzle5Domain(inputs, 48, 61);
        List<Puzzle5Domain> fertilizerToWaters = buildPuzzle5Domain(inputs, 63, 108);
        List<Puzzle5Domain> waterToLights = buildPuzzle5Domain(inputs, 110, 145);
        List<Puzzle5Domain> lightToTemps = buildPuzzle5Domain(inputs, 147, 160);
        List<Puzzle5Domain> tempToHumiditys = buildPuzzle5Domain(inputs, 162, 196);
        List<Puzzle5Domain> humidityToLocations = buildPuzzle5Domain(inputs, 198, 245);
        long nearestLocation = Long.MAX_VALUE;

        for (int i = 1; i < seedInput.length; i++) {
            long startSeed = Long.valueOf(seedInput[i]);
            long seedRange = Long.valueOf(seedInput[++i]);
            long endSeed = startSeed + seedRange;
            for (long seed = startSeed; seed <= endSeed; seed++) {

                Puzzle5Domain seedToSoil = getPuzzle5DomainMatch(seedToSoils, seed);
                long soil = findDestination(seedToSoil, seed);

                Puzzle5Domain soilToFertilizer = getPuzzle5DomainMatch(soilToFertilizers, soil);
                long fertilizer = findDestination(soilToFertilizer, soil);

                Puzzle5Domain fertilizerToWater = getPuzzle5DomainMatch(fertilizerToWaters, fertilizer);
                long water = findDestination(fertilizerToWater, fertilizer);

                Puzzle5Domain waterToLight = getPuzzle5DomainMatch(waterToLights, water);
                long light = findDestination(waterToLight, water);

                Puzzle5Domain lightToTemp = getPuzzle5DomainMatch(lightToTemps, light);
                long temp = findDestination(lightToTemp, light);

                Puzzle5Domain tempToHumidity = getPuzzle5DomainMatch(tempToHumiditys, temp);
                long humidity = findDestination(tempToHumidity, temp);

                Puzzle5Domain humidityToLocation = getPuzzle5DomainMatch(humidityToLocations, humidity);
                long location = findDestination(humidityToLocation, humidity);

                if (location < nearestLocation) {
                    nearestLocation = location;
                }
            }
        }
        System.out.println(nearestLocation);
    }

    public static void main1(String[] args) throws IOException {
        List<String> inputs = Files.readAllLines(Paths.get("adeventofcode/src/_2023/Puzzle5Input.txt"));
        String seeds = inputs.get(0);
        String[] seedInput = seeds.split(" ");
        List<Puzzle5Domain> seedToSoils = buildPuzzle5Domain(inputs, 3, 46);
        List<Puzzle5Domain> soilToFertilizers = buildPuzzle5Domain(inputs, 48, 61);
        List<Puzzle5Domain> fertilizerToWaters = buildPuzzle5Domain(inputs, 63, 108);
        List<Puzzle5Domain> waterToLights = buildPuzzle5Domain(inputs, 110, 145);
        List<Puzzle5Domain> lightToTemps = buildPuzzle5Domain(inputs, 147, 160);
        List<Puzzle5Domain> tempToHumiditys = buildPuzzle5Domain(inputs, 162, 196);
        List<Puzzle5Domain> humidityToLocations = buildPuzzle5Domain(inputs, 198, 245);
        long nearestLocation = Long.MAX_VALUE;

        for (int i = 1; i < seedInput.length; i++) {
            long seed = Long.valueOf(seedInput[i]);
            Puzzle5Domain seedToSoil = getPuzzle5DomainMatch(seedToSoils, seed);
            long soil = findDestination(seedToSoil, seed);

            Puzzle5Domain soilToFertilizer = getPuzzle5DomainMatch(soilToFertilizers, soil);
            long fertilizer = findDestination(soilToFertilizer, soil);

            Puzzle5Domain fertilizerToWater = getPuzzle5DomainMatch(fertilizerToWaters, fertilizer);
            long water = findDestination(fertilizerToWater, fertilizer);

            Puzzle5Domain waterToLight = getPuzzle5DomainMatch(waterToLights, water);
            long light = findDestination(waterToLight, water);

            Puzzle5Domain lightToTemp = getPuzzle5DomainMatch(lightToTemps, light);
            long temp = findDestination(lightToTemp, light);

            Puzzle5Domain tempToHumidity = getPuzzle5DomainMatch(tempToHumiditys, temp);
            long humidity = findDestination(tempToHumidity, temp);

            Puzzle5Domain humidityToLocation = getPuzzle5DomainMatch(humidityToLocations, humidity);
            long location = findDestination(humidityToLocation, humidity);

            if (location < nearestLocation) {
                nearestLocation = location;
            }
        }
        System.out.println(nearestLocation);
    }

    private static long findDestination(Puzzle5Domain puzzle5Domain, long seed) {
        return puzzle5Domain.destination() + (seed - puzzle5Domain.source());
    }

    private static Puzzle5Domain getPuzzle5DomainMatch(List<Puzzle5Domain> puzzle5Domains, long seed) {
        Puzzle5Domain seedToSoil = null;
        for (Puzzle5Domain puzzle5Domain : puzzle5Domains) {
            if (seed >= puzzle5Domain.source() && seed < (puzzle5Domain.source() + puzzle5Domain.range())) {
                seedToSoil = puzzle5Domain;
                break;
            }
        }
        if (seedToSoil != null) {
            return seedToSoil;
        }
        return new Puzzle5Domain(seed, seed, 0);
    }

    private static List<Puzzle5Domain> buildPuzzle5Domain(List<String> inputs, int start, int end) {
        List<Puzzle5Domain> puzzle5Domains = new ArrayList<>();
        for (int i = start; i < end; i++) {
            String input = inputs.get(i);
            String inputArray[] = input.split(" ");
            Puzzle5Domain puzzle5Domain = new Puzzle5Domain(Long.valueOf(inputArray[1]), Long.valueOf(inputArray[0]), Long.valueOf(inputArray[2]));
            puzzle5Domains.add(puzzle5Domain);
        }
        return puzzle5Domains;
    }
}
