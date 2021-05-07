package resources

import io.restassured.builder.RequestSpecBuilder
import io.restassured.filter.log.RequestLoggingFilter
import io.restassured.filter.log.ResponseLoggingFilter
import io.restassured.http.ContentType
import io.restassured.path.json.JsonPath
import io.restassured.response.Response
import io.restassured.specification.RequestSpecification
import io.restassured.specification.ResponseSpecification
import org.junit.Assert
import sqlQueries
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException
import java.io.PrintStream
import java.sql.*
import java.util.*


open class Utilities {
    var con: Connection? = null
    var stmt: Statement? = null
    var query: String? = null
    var rs: ResultSet? = null
    var updtQuery: sqlQueries? = null
    var exeQuery: sqlQueries? = null

    var jp: JsonPath?=null
    var respsb: ResponseSpecification? = null

    @Throws(IOException::class)
    fun requestSpec(baseURI:String): RequestSpecification? {
        if (reqsb == null) {
            val log = PrintStream(FileOutputStream("logging.txt"))
            reqsb = RequestSpecBuilder().setBaseUri(getGlobalvalues(baseURI))
                .addFilter(RequestLoggingFilter.logRequestTo(log)).setContentType(ContentType.JSON)
                .addFilter(ResponseLoggingFilter.logResponseTo(log)).build()
            return reqsb
        }
        return reqsb
    }



    @Throws(IOException::class)
    fun getGlobalvalues(key: String): String {
        val prop = Properties()
        val fis = FileInputStream("src/test/kotlin/resources/global.properties")
        prop.load(fis)
        return prop.getProperty(key)
    }

    fun getStringFromJson(response: Response?, key: String?): String {
        val resp = response?.asString()
        jp = JsonPath(resp)
        return jp!!.getString(key)
    }

    fun getIntFromJson(response: Response?, key: String?): Int {
        val resp = response?.asString()
        jp = JsonPath(resp)
        return jp!!.getInt(key)
    }

    fun getListFromJson(response: Response?, key: String?): List<String> {
        val resp = response?.asString()
        jp = JsonPath(resp)
        return jp!!.getList(key)
    }

    @Throws(SQLException::class)
    fun createQuery() {
        var con = DriverManager.getConnection(getGlobalvalues("JDBC"), getGlobalvalues("userName"), getGlobalvalues("password"))
        Class.forName("org.postgresql.Driver")
        stmt = con!!.createStatement()
    }


    fun createConnection() {
        var con = DriverManager.getConnection(getGlobalvalues("JDBC"), getGlobalvalues("userName"), getGlobalvalues("password"))
        Class.forName("org.postgresql.Driver")
        stmt = con!!.createStatement()
    }

    @Throws(SQLException::class)
    fun executeQuery(serviceName: String?) {
        var con = DriverManager.getConnection(getGlobalvalues("JDBC"), getGlobalvalues("userName"), getGlobalvalues("password"))
        Class.forName("org.postgresql.Driver")
        exeQuery=sqlQueries.valueOf(serviceName!!)
        stmt = con!!.createStatement()
        println(exeQuery!!.resource.toString())
        var rs: Boolean
                = stmt!!.execute(exeQuery!!.getValue())

    }

    @Throws(SQLException::class)
    fun executeUpdate(query: String?) {
        var con = DriverManager.getConnection(getGlobalvalues("JDBC"), getGlobalvalues("userName"), getGlobalvalues("password"))
        Class.forName("org.postgresql.Driver")
        updtQuery=sqlQueries.valueOf(query!!)
        stmt = con!!.createStatement()
        var rs: Int
                = stmt!!.executeUpdate(updtQuery!!.getValue())
        print(rs)


    }

    @Throws(SQLException::class)
    fun assertRecords(name: String?) {
        while (rs!!.next()) {
            val myName = rs!!.getString(2)
            Assert.assertEquals(myName, name)
        }

    }

    @Throws(SQLException::class)
    fun closeConnection() {
        con!!.close()

    }

    companion object {
        var reqsb: RequestSpecification? = null
        var dbUrl: String? = null
        var username: String? = null
        var password: String? = null
        var database_driver: String? = null
    }

}
