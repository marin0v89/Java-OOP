package C02_Encapsulation.Lab.P04_FirstAndReserveTeam;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Team {

    private String name;
    private List<Person> firstTeam;
    private List<Person> reserveTeam;

    public Team(String name) {
        this.name = name;
        this.firstTeam = new LinkedList<>();
        this.reserveTeam = new LinkedList<>();
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addPlayer(Person person){
        if (person.getAge()<40){
            firstTeam.add(person);
        }else {
            reserveTeam.add(person);
        }
    }

    public List<Person> getFirstTeam(){
        return Collections.unmodifiableList(this.firstTeam);
    }
    public List<Person> getReserveTeam(){
        return Collections.unmodifiableList(this.reserveTeam);
    }

}
