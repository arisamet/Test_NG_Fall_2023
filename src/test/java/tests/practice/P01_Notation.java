package tests.practice;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class P01_Notation {

    @Test @Ignore
    public void ABNergiz(){
        System.out.println("Nergiz");
    }

    @Test (priority = 1)
    public void Omer(){
        System.out.println("Omer");
    }
    @Test (priority = 30)
    public void TSenol (){
        System.out.println("Senol");
    }
    @Test (dependsOnMethods =  "ESenol")
    public void ZBugra(){
        System.out.println("Bugra Kaan");
    }
}
