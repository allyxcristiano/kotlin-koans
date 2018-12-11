package ii_collections

fun Shop.getCustomersWhoOrderedProduct(product: Product): Set<Customer> {
    // Return the set of customers who ordered the specified product
    return this.customers.filter { customer -> customer.orderedProducts.any { it == product } }.toSet()
}

fun Customer.getMostExpensiveDeliveredProduct(): Product? {
    // Return the most expensive product among all delivered products
    // (use the Order.isDelivered flag)
    var productsDelivered: ArrayList<Product> = ArrayList()
    this.orders.filter { order -> order.isDelivered }.forEach { it -> productsDelivered.addAll(it.products) }
    return productsDelivered.maxBy { it.price }
}

fun Shop.getNumberOfTimesProductWasOrdered(product: Product): Int {
    // Return the number of times the given product was ordered.
    // Note: a customer may order the same product for several times.
    var numberOfTimesProductWasOrdered: Int = 0
    this.customers.forEach { customer ->
        customer.orders.forEach { order ->
            numberOfTimesProductWasOrdered += order.products.filter { it == product }.count()
        }
    }
    return numberOfTimesProductWasOrdered
}
