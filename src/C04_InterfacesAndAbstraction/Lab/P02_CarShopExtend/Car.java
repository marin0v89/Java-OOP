package C04_InterfacesAndAbstraction.Lab.P02_CarShopExtend;

public interface Car {
    Integer TIRES = 4;

    String getModel();

    String getColor();

    Integer getHorsePower();

    String countryProduced();
}
