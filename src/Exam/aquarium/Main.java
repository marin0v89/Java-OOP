package Exam.aquarium;


import Exam.aquarium.core.Engine;
import Exam.aquarium.core.EngineImpl;


public class Main {
    public static void main(String[] args) {
        Engine engine = new EngineImpl();
        engine.run();
    }
}
