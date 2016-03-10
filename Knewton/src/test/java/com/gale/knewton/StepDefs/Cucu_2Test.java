package com.gale.knewton.StepDefs;


import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/com/gale/knewton/features",
tags={"@ASRCancle"},
dryRun = false,
snippets = SnippetType.UNDERSCORE,
monochrome = true,
//format = {"pretty" ,"html:target/cucumber","json:target/cucumber.json"})
plugin = { "progress","junit:target_json/Cucumber_junit.xml"})
    
public class Cucu_2Test{
}