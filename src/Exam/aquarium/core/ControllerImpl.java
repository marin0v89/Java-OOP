package Exam.aquarium.core;

import Exam.aquarium.common.ConstantMessages;
import Exam.aquarium.common.ExceptionMessages;
import Exam.aquarium.entities.aquariums.Aquarium;
import Exam.aquarium.entities.aquariums.FreshwaterAquarium;
import Exam.aquarium.entities.aquariums.SaltwaterAquarium;
import Exam.aquarium.entities.decorations.Decoration;
import Exam.aquarium.entities.decorations.Ornament;
import Exam.aquarium.entities.decorations.Plant;
import Exam.aquarium.entities.fish.Fish;
import Exam.aquarium.entities.fish.FreshwaterFish;
import Exam.aquarium.entities.fish.SaltwaterFish;
import Exam.aquarium.repositories.DecorationRepository;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {
    private DecorationRepository decorations;
    private Map<String, Aquarium> aquariums;

    public ControllerImpl() {
        this.decorations = new DecorationRepository();
        this.aquariums = new LinkedHashMap<>();
    }

    @Override
    public String addAquarium(String aquariumType, String aquariumName) {
        if (!aquariumType.equals("FreshwaterAquarium") && !aquariumType.equals("SaltwaterAquarium")) {
            throw new NullPointerException(ExceptionMessages.INVALID_AQUARIUM_TYPE);
        }
        Aquarium aquarium = null;

        if (aquariumType.equals("FreshwaterAquarium")) {
            aquarium = new FreshwaterAquarium(aquariumName);
        } else {
            aquarium = new SaltwaterAquarium(aquariumName);
        }
        this.aquariums.putIfAbsent(aquariumName, aquarium);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_AQUARIUM_TYPE, aquariumType);
    }

    @Override
    public String addDecoration(String type) {
        if (!type.equals("Plant") && !type.equals("Ornament")) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_DECORATION_TYPE);
        }
        Decoration decoration = null;

        if (type.equals("Plant")) {
            decoration = new Plant();
        } else {
            decoration = new Ornament();
        }
        this.decorations.add(decoration);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_DECORATION_TYPE, type);
    }

    @Override
    public String insertDecoration(String aquariumName, String decorationType) {
        Decoration findByType = this.decorations.findByType(decorationType);

        if (findByType == null) {

            throw new IllegalArgumentException(String.format(ExceptionMessages.NO_DECORATION_FOUND, decorationType));
        }

        this.aquariums.get(aquariumName).addDecoration(findByType);
        this.decorations.remove(findByType);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_DECORATION_IN_AQUARIUM, decorationType, aquariumName);
    }

    @Override
    public String addFish(String aquariumName, String fishType, String fishName, String fishSpecies, double price) {
        Fish currentFish;

        if (fishType.equals("FreshwaterFish")) {
            currentFish = new FreshwaterFish(fishName, fishSpecies, price);
        } else if (fishType.equals("SaltwaterFish")) {
            currentFish = new SaltwaterFish(fishName, fishSpecies, price);
        } else {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_FISH_TYPE);
        }

        Aquarium aquarium = this.aquariums.get(aquariumName);

        if (!aquarium.getClass().getSimpleName().substring(0, 5).equals(fishType.substring(0, 5))) {
            return ConstantMessages.WATER_NOT_SUITABLE;
        }

        aquarium.addFish(currentFish);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_FISH_IN_AQUARIUM, fishType, aquariumName);
    }

    @Override
    public String feedFish(String aquariumName) {
        Aquarium aquarium = this.aquariums.get(aquariumName);
        aquarium.feed();

        return String.format(ConstantMessages.FISH_FED, aquarium.getFish().size());
    }

    @Override
    public String calculateValue(String aquariumName) {

        Aquarium aquarium = this.aquariums.get(aquariumName);

        return String.format(ConstantMessages.VALUE_AQUARIUM,
                aquariumName, aquarium.getFish().stream().mapToDouble(Fish::getPrice).sum()
                        + aquarium.getDecorations().stream().mapToDouble(Decoration::getPrice).sum());
    }

    @Override
    public String report() {
        return aquariums.values().stream().map(Aquarium::getInfo).collect(Collectors.joining());
    }
}
