package stepDefinitions

import APIResources
import io.cucumber.datatable.DataTable
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import io.restassured.RestAssured
import io.restassured.response.Response
import io.restassured.specification.RequestSpecification
import org.junit.Assert
import resources.Utilities
import resources.TestPayLoad
import java.io.File
import java.io.IOException
import java.lang.*
import java.sql.*


class StoresSetDef : Utilities() {

    var request: RequestSpecification? = null
    var response: Response? = null
    var resource: APIResources? = null
    var tPayLoad: TestPayLoad = TestPayLoad()


    @Given("^Delete Old Reports$")
    fun deleteFiles() {
        var path = "target"
        val file = File(path)
        if (file.exists()) {
            val deleteCmd = "rm -r $path"
            val runtime = Runtime.getRuntime()
            try {
                runtime.exec(deleteCmd)
            } catch (e: IOException) {
            }
        }
    }

    @Given("^I had \"([^\"]*)\" Base URI and \"([^\"]*)\" parameters$")
    fun i_had_something_base_uri_and_something_parameters(baseURI:String,endPoint: String,dataTable: DataTable?) {
        val data = dataTable!!.asList()

        when {
            endPoint.equals("menu", true) -> {
                request = RestAssured.given().spec(requestSpec(baseURI))
                    .queryParam("menu_id", data[1])
            }
            endPoint.equals("datetime", true) -> {
                request = RestAssured.given().spec(requestSpec(baseURI))
                    .queryParam("datetime", data[1])

            }
            endPoint.equals("storeid", true) -> {
                request = RestAssured.given().spec(requestSpec(baseURI))
                    .queryParam("store_id", data[1])

            }
            endPoint.equals("Categories", true) -> {
                request = RestAssured.given().spec(requestSpec(baseURI))
                    .queryParam("store_id", data[4])
                    .queryParam("datetime", data[5])
                    .queryParam("menu_id", data[6])
                    .queryParam("serviceType",data[7])

            }
            endPoint.equals("Stores",true) -> {
                request = RestAssured.given().spec(requestSpec(baseURI))
                    .queryParam("latitude", data[4])
                    .queryParam("longitude", data[5])
                    .queryParam("serviceType", data[6])
                    .queryParam("sortBy", data[7])
            }

        }
    }

    @Given("^I had \"([^\"]*)\" Base URI and \"([^\"]*)\" parameters for \"([^\"]*)\"$")
    fun i_had_something_base_uri_and_something_parameters_for_stores(baseURL:String,condition: String,endPoint: String, dataTable: DataTable?)
    {
        when{
            endPoint.equals("Stores",true) ->{
                when {
                    condition.equals("incorrect value", true) -> {

                        val data = dataTable!!.asList()
                        request = RestAssured.given().spec(requestSpec(baseURL))
                            .queryParam("latitude", data[4])
                            .queryParam("longitude", data[5])
                            .queryParam("serviceType", data[6])
                            .queryParam("sortBy", data[7])
                    }

                    condition.equals("blank value", true) -> {

                        val data = dataTable!!.asList()
                        request = RestAssured.given().spec(requestSpec(baseURL))
                            .queryParam("latitude", data[4])
                            .queryParam("longitude", data[5])
                            .queryParam("serviceType", data[6])
                            .queryParam("sortBy", data[7])
                    }

                    condition.equals("incorrect key", true) -> {
                        val data = dataTable!!.asList()
                        request = RestAssured.given().spec(requestSpec(baseURL))
                            .queryParam("latitudejunk", data[4])
                            .queryParam("longitude", data[5])
                            .queryParam("serviceType", data[6])
                            .queryParam("sortBy", data[7])

                    }

                    condition.equals("blank key", true) -> {
                        val data = dataTable!!.asList()
                        request = RestAssured.given().spec(requestSpec(baseURL))
                            .queryParam("", data[4])
                            .queryParam("longitude", data[5])
                            .queryParam("serviceType", data[6])
                            .queryParam("sortBy", data[7])
                    }
                }

            }
            endPoint.equals("Menu",true) ->{
                when {
                    condition.equals("incorrect value", true) -> {

                        val data = dataTable!!.asList()
                        request = RestAssured.given().spec(requestSpec(baseURL))
                            .queryParam("menu_id", data[1])
                    }

                    condition.equals("blank value", true) -> {

                        val data = dataTable!!.asList()
                        request = RestAssured.given().spec(requestSpec(baseURL))
                            .queryParam("menu_id", data[1])
                    }

                    condition.equals("incorrect key", true) -> {
                        val data = dataTable!!.asList()
                        request = RestAssured.given().spec(requestSpec(baseURL))
                            .queryParam("menu_idjunk", data[1])
                    }

                    condition.equals("blank key", true) -> {
                        val data = dataTable!!.asList()
                        request = RestAssured.given().spec(requestSpec(baseURL))
                            .queryParam("", data[1])
                    }
                }

            }

        }

    }

    @When("^I call \"([^\"]*)\" endpoint with \"([^\"]*)\" http request$")
    fun i_call_something_endpoint_with_something_http_request(endPoint: String?, httprequest: String) {
        
        resource = APIResources.valueOf(endPoint!!)
        when (httprequest) {
            "Post" -> {
                response = request!!.`when`().post(resource!!.getValue())
            }
            "Get" -> {
                response = request!!.`when`().get(resource!!.getValue())
            }
            "Put" -> {
                response = request!!.`when`().put(resource!!.getValue())
            }
            "Delete" -> {
                response = request!!.`when`().delete(resource!!.getValue())
            }
        }
    }

    @Then("^API call should be done successfully with Status Code 200$")
    fun api_call_should_be_done_successfully_with_status_code_200() {
        Assert.assertEquals(200, response!!.statusCode)
    }

    @Then("^API call should be failed with Status Code \"([^\"]*)\"$")
    fun api_call_should_be_failed_with_status_code_something(statusCode: Int) {
        Assert.assertEquals(statusCode, response!!.statusCode)
    }

    @Then("^Response payload should have keys$")
    fun response_payload_should_have_keys(dataTable: DataTable?) {

        val data = dataTable?.asList()

        if (data != null) {
            for (i in data)
            {
                Assert.assertTrue(response!!.body.asString().contains(i))
            }
        }

    }

    @Then("^Response payload should have objects$")
    fun response_payload_should_have_objects(dataTable: DataTable?) {

        val data = dataTable?.asList()

        if (data != null) {
            for (i in data)
            {
                Assert.assertTrue(response!!.body.asString().contains(i))
            }
        }

    }

    @Then("^Response payload should have \"([^\"]*)\" object$")
    fun response_payload_should_have_something_object(obj: String) {

        Assert.assertTrue(response!!.body.asString().contains(obj))
    }

    @Then("^Response payload should have \"([^\"]*)\" list$")
    fun response_payload_should_have_something_list(lname: String) {

        Assert.assertTrue(response!!.body.asString().contains(lname))
    }

    @Then("^\"([^\"]*)\" object should have keys for \"([^\"]*)\"$")
    fun something_object_should_have_keys_for_something(obj: String, endPoint: String, dataTable: DataTable?) {
        val data = dataTable!!.asList()

        for (i in data) {

            when {
                endPoint.equals("items", true) -> {
                    Assert.assertTrue(getStringFromJson(response, "items").contains(i))
                }
                endPoint.equals("categories", true) -> {
                    when {
                        obj.equals("categories",true) or obj.equals("items",true) -> {
                            Assert.assertTrue(getStringFromJson(response, "$obj").contains(i))
                        }
                        obj.equals("combo",true) or obj.equals("items",true) -> {
                            Assert.assertTrue(getStringFromJson(response, "items.$obj").contains(i))
                        }
                        obj.equals("comboItems",true) or obj.equals("items",true) -> {
                            Assert.assertTrue(getStringFromJson(response, "items.combo.$obj").contains(i))
                            print(obj)
                        }
                    }
                }
                endPoint.equals("Stores", true) -> {
                    Assert.assertTrue(getStringFromJson(response, "stores.$obj").contains(i))
                }
            }
        }
    }

    @Then("^\"([^\"]*)\" list should have objects with keys for \"([^\"]*)\"$")
    fun something_list_should_have_objects_with_keys_for_something(obj: String, endPoint: String, dataTable: DataTable?) {
        val data = dataTable!!.asList()
        for (i in data) {

            when {
                endPoint.equals("items", true) -> {
                    Assert.assertTrue(getStringFromJson(response, "items").contains(i))
                }
                endPoint.equals("categories", true) -> {
                    Assert.assertTrue(getStringFromJson(response, "categories").contains(i))
                }
                endPoint.equals("Stores", true) -> {
                    Assert.assertTrue(getStringFromJson(response, "stores.$obj").contains(i))
                }
                endPoint.equals("Cart", true) -> {
                    if(obj.equals("addOn",true))
                    {
                        Assert.assertTrue(getStringFromJson(response, "items.$obj").contains(i))
                    }
                    else
                    {
                        Assert.assertTrue(getStringFromJson(response, "$obj").contains(i))
                    }
                }
                endPoint.equals("Order", true) -> {
                    Assert.assertTrue(getStringFromJson(response, "$obj").contains(i))
                }

            }
        }
    }

    @Then("^\"([^\"]*)\" in \"([^\"]*)\" object for all the stores should NOT be null$")
    fun something_in_something_object_for_all_the_stores_should_not_be_null(key: String, obj: String) {
        val listCount = getIntFromJson(response, "stores.size()")

        for (i in 0 until listCount) {
            Assert.assertFalse(getStringFromJson(response, "stores[$i].$obj.$key").equals(null))
        }
    }

    @Then("^\"([^\"]*)\" in \"([^\"]*)\" object for all items should NOT be null$")
    fun something_in_something_object_for_all_items_should_not_be_null(key: String, obj: String) {
        val listCount = getIntFromJson(response, "$obj.size()")

        for (i in 0 until listCount) {
            Assert.assertFalse(getStringFromJson(response, "$obj[$i].$key").equals(null))
        }
    }

    @Then("^JSON should have keys$")
    fun json_should_have_keys(dataTable: DataTable) {
        val data = dataTable.asList()
        for (i in data) {
            Assert.assertTrue(response!!.body.asString().contains(i))
        }
    }


    @Given("^I am connected with the database$")
    fun i_am_connected_with_the_database() {
        createConnection()
    }


    @When("^I run the \"([^\"]*)\" setup$")
    @Throws(Throwable::class)
    fun i_run_the_setup(serviceName: String?) {
        executeQuery(serviceName)
    }

    @When("^I run the \"([^\"]*)\" query$")
    @Throws(Throwable::class)
    fun i_run_the_update_query(query: String?) {
        executeUpdate(query)
    }


    @Then("^I should see the result as \"([^\"]*)\"$")
    @Throws(Throwable::class)
    fun i_should_see_the_result_as(name: String?) {
        assertRecords(name)
    }

    @Then("^\"([^\"]*)\" key for \"([^\"]*)\" should have value \"([^\"]*)\"$")
    fun something_key_for_something_should_have_value_something(key: String, endpoint: String, value: String)
    {
        if (endpoint.equals("Combo Items",true))
        {
            Assert.assertEquals(value,getStringFromJson(response, "items[0].$key"))
        }
        else if(endpoint.equals("Items",true))
        {
            Assert.assertEquals(value,getStringFromJson(response, "items[1].$key"))
        }
        else if(endpoint.equals("Orders",true))
        {
            Assert.assertEquals(value,getStringFromJson(response, "$key"))
        }
        else
        {
            Assert.assertEquals(value,getStringFromJson(response, "$endpoint[0].$key"))
        }
    }

    @Then("^\"([^\"]*)\" list in \"([^\"]*)\" should have values$")
    fun something_list_in_something_should_have_values(key: String, obj: String, dataTable: DataTable)
    {
        val value = dataTable.asList()
        if(key.equals("items",true) and obj.equals("categories",true))
        {
            Assert.assertEquals(value.toString(),getStringFromJson(response, "$obj[0].$key"))
        }

    }

    @Then("^\"([^\"]*)\" key in \"([^\"]*)\" object of \"([^\"]*)\" should have value \"([^\"]*)\"$")
    fun something_key_in_something_object_of_something_should_have_value_something(key: String,obj: String,endpoint: String,value: String)
    {
        if(endpoint.equals("STORES",true)){
            Assert.assertEquals(value,getStringFromJson(response, "stores[0].$obj.$key"))
        }

        else if(endpoint.equals("Categories",true))
        {
            if(obj.equals("combo",true))
            {
                Assert.assertEquals(value,getStringFromJson(response, "items[0].$obj.$key"))
            }

            else if(obj.equals("comboItems",true))
            {
                Assert.assertEquals(value,getStringFromJson(response, "items[0].combo.$obj[0].$key"))
            }

            else if(obj.equals("info",true))
            {
                Assert.assertEquals(value,getStringFromJson(response, "items[1].$obj.$key"))
            }
        }
    }
    @Then("^\"([^\"]*)\" key in \"([^\"]*)\" list of \"([^\"]*)\" should have values$")
    fun something_key_in_something_list_of_something_should_have_values(key: String,obj: String,endpoint: String,dataTable: DataTable)
    {
        val value = dataTable.asList()

        for (i in 0 until value.size)
        {
            if(endpoint.equals("STORES",true))
            {
                if(value[i] != "null")
                {
                    Assert.assertEquals(value[i],getStringFromJson(response, "stores[0].$obj[$i].$key"))
                }
            }

            else if(endpoint.equals("Categories",true))
            {
                if(obj.equals("comboItems",true))
                {
                    Assert.assertEquals(value[i],getStringFromJson(response, "items[0].combo.$obj[$i].$key"))
                }

                else if(obj.equals("itemPrice",true))
                {
                    Assert.assertEquals(value[i],getStringFromJson(response, "items[1].info.$obj[$i].$key"))
                }

                else if(obj.equals("addOn",true))
                {
                    Assert.assertEquals(value[i],getStringFromJson(response, "items[1].info.$obj[$i].$key"))
                }
            }
        }
    }

    @Then("^\"([^\"]*)\" key in \"([^\"]*)\" list of \"([^\"]*)\" should have value \"([^\"]*)\"$")
    fun something_key_in_something_list_of_something_should_have_value_something(key: String,obj: String,endpoint: String,value: String)
    {
        if(endpoint.equals("STORES",true))
        {
            Assert.assertTrue(getStringFromJson(response, "stores[0].$obj.$key").contains(value))
        }
    }

    @Given("^I had \"([^\"]*)\" Base URI$")
    fun i_had_something_base_uri(baseURI:String)
    {
        request = RestAssured.given().spec(requestSpec(baseURI))

    }

    @Given("^I had \"([^\"]*)\" request payload$")
    fun i_had_something_request_payload(payload: String)
    {
        when {
            payload.equals("ValidCart", true) -> {
                request = request?.body(tPayLoad.cart_input_payload(1))
            }
            payload.equals("InvalidCart", true) -> {
                request = request?.body(tPayLoad.cart_input_payload(111))
            }
            payload.equals("Order", true) -> {
                request = request?.body(tPayLoad.order_input_payload())
            }
            payload.equals("OrderNew", true) -> {
                request = request?.body(tPayLoad.order_status_update_input_payload(1))
            }
            payload.equals("OrderInProgress", true) -> {
                request = request?.body(tPayLoad.order_status_update_input_payload(2))
            }
            payload.equals("OrderCompleted", true) -> {
                request = request?.body(tPayLoad.order_status_update_input_payload(3))
            }
            payload.equals("InvalidOrder", true) -> {
                request = request?.body(tPayLoad.invalid_order_payload())
            }
        }
    }

    @Then("^delete the order records$")
    fun delete_the_order_records() {

        var orderId = getIntFromJson(response,"id")

        var con = DriverManager.getConnection(getGlobalvalues("JDBC"), getGlobalvalues("userName"), getGlobalvalues("password"))
        Class.forName("org.postgresql.Driver")
        var deleteQuery="delete from \"OrderItem\" where \"OrderId\" ="+orderId+";\n" +
                "delete from orders where \"UserDetailsId\" ="+orderId+";\n" +
                "delete from \"UserDetails\" where \"Id\" ="+orderId+";"
//        stmt = con!!.createStatement()
//        var rs: Int
//                = stmt!!.executeUpdate(deleteQuery)
        con!!.createStatement().executeUpdate(deleteQuery)

    }

}




