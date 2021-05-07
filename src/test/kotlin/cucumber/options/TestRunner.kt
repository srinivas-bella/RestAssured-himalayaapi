package cucumber.options

import io.cucumber.junit.Cucumber
import io.cucumber.junit.CucumberOptions
import org.junit.BeforeClass
import org.junit.runner.RunWith
import java.io.File
import java.io.IOException


@RunWith(Cucumber::class)
@CucumberOptions(
    features = ["src/test/kotlin/features"],
    glue = ["stepDefinitions"],
//    tags = "@Order",
//    tags = "@Cart",
//    tags = "@Stores",
//    tags = "@Menu",
//    tags = "@Menu or @MenuDataValidation",
//    tags = "@Stores or @StoreDataValidation",
//    tags = "@Stores or @StoreDataValidation or @Menu or @MenuDataValidation",
    monochrome = true,
    plugin = ["json:target/cucumber-reports.json"],
    publish = true

)

class TestRunner


