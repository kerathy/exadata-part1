package com.example.dagger2scopeandsubcomponentspart2;

public class WarriorPresenter {

    private Warrior warrior;

    public WarriorPresenter(Warrior warrior) {
        this.warrior = warrior;
    }

    public Warrior getWarrior() {
        return warrior;
    }
}
