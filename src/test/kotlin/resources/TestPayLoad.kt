package resources

open class TestPayLoad{
    fun cart_input_payload(storeid: Int):String{
        return "{\n" +
                "  \"storeId\": "+storeid+",\n" +
                "  \"items\": [\n" +
                "    {\n" +
                "      \"id\": 100101,\n" +
                "      \"size\": \"single scoop\",\n" +
                "      \"productType\": 1,\n" +
                "      \"price\": 900,\n" +
                "      \"addOn\": [\n" +
                "        {\n" +
                "          \"id\": 3,\n" +
                "          \"price\": 900\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": 2,\n" +
                "          \"price\": 900\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 200101,\n" +
                "      \"size\": \"single scoop\",\n" +
                "      \"price\": 100.5,\n" +
                "      \"productType\": 1\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 300101,\n" +
                "      \"size\": \"S\",\n" +
                "      \"price\": 100.5,\n" +
                "      \"productType\": 1\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 117,\n" +
                "      \"size\": \"S\",\n" +
                "      \"price\": 100.5,\n" +
                "      \"productType\": 2\n" +
                "    }\n" +
                "  ]\n" +
                "}"
    }

    fun order_input_payload():String{
        return "{\n" +
                "    \"menuDetails\": [\n" +
                "        {\n" +
                "            \"menuId\": 1001,\n" +
                "            \"menuName\": \"aut-test1\",\n" +
                "            \"quantity\": 1\n" +
                "        },\n" +
                "        {\n" +
                "            \"menuId\": 1002,\n" +
                "            \"menuName\": \"aut-test2\",\n" +
                "            \"quantity\": 2\n" +
                "        },\n" +
                "        {\n" +
                "            \"menuId\": 1003,\n" +
                "            \"menuName\": \"aut-test3\",\n" +
                "            \"quantity\": 3\n" +
                "        }\n" +
                "    ],\n" +
                "    \"userDetails\": {\n" +
                "        \"email\": \"aut_test@email.com\"\n" +
                "    }\n" +
                "}"
    }

    fun order_status_update_input_payload(status: Int):String{
        return "{\n" +
                "    \"status\":"+status+"\n" +
                "}"
    }

    fun invalid_order_payload():String{
        return "{\n" +
                "    \"menuDetails\": [\n" +
                "        {\n" +
                "            \"menuId\": 1001,\n" +
                "            \"menuName\": \"qaaut12\",\n" +
                "            \"quantity\": 1\n" +
                "        },\n" +
                "        {\n" +
                "            \"menuId\": 1002,\n" +
                "            \"menuName\": \"qaaut2,\n" +
                "            \"quantity\": 2\n" +
                "        },\n" +
                "        {\n" +
                "            \"menuId\": 1003,\n" +
                "            \"menuName\": \"qaaut3\",\n" +
                "            \"quantity\": 1\n" +
                "        }\n" +
                "    ],\n" +
                "    \"userDetails\": {\n" +
                "        \"email\": \"test@email.com\"\n" +
                "    }\n" +
                "}"
    }
}