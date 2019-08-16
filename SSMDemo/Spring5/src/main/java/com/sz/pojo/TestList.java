package com.sz.pojo;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class TestList {

    private String[] girls;

    private List<Dog> dogs;

    private Set<Integer> luckyNumbers;

    private Map<String, Dog> superDogs;

    private Properties properties;


    public String[] getGirls() {
        return girls;
    }

    public void setGirls(String[] girls) {
        this.girls = girls;
    }

    public List<Dog> getDogs() {
        return dogs;
    }

    public void setDogs(List<Dog> dogs) {
        this.dogs = dogs;
    }

    public Set<Integer> getLuckyNumbers() {
        return luckyNumbers;
    }

    public void setLuckyNumbers(Set<Integer> luckyNumbers) {
        this.luckyNumbers = luckyNumbers;
    }

    public Map<String, Dog> getSuperDogs() {
        return superDogs;
    }

    public void setSuperDogs(Map<String, Dog> superDogs) {
        this.superDogs = superDogs;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}
