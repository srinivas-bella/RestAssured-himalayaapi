enum class APIResources(var resource: String) {
    Stores("/stores"),
    random("/abc"),
    Menu("/menu/items"),
    Categories("menu/categories"),
    CartValidate("cart/validate"),
    Order("orders"),
    OrderStatusUpdate("orders/1"),
    InvalidOrder("orders/99999");

    fun APIResources(resource: String)
    {
        this.resource = resource
    }

    fun getValue() : String
    {
        return resource
    }

}