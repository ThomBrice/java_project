package card.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by isen on 27/01/2016.
 */
public class StoreDepartment {
    private String name;

    public StoreDepartment(String dep) {
        setName(dep);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

