package test;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features= {"classpath:features"}, //path to folder with .features
        glue = {"definition"}, //package name of class with Cucumber step definitions
        tags = {"@pet01"}
)
public class CucumberRunner {}
