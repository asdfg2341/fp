def displayInventory(names: List[String], quantities: List[Int]): Unit = if names.isEmpty then return else {
    println(s"${names.head}: ${quantities.head}")
    displayInventory(names.tail, quantities.tail)
}

def restockItem(names: List[String], quantities: List[Int], name: String, quantity: Int): List[Int] = {
    val index = names.indexOf(name)
    if (index != -1) {
        return quantities.updated(index, quantities(index) + quantity)
    } else {
        println(s"Item $name not found in inventory.")
        return quantities
    }
}

def sellItem(names: List[String], quantities: List[Int], name: String, quantity: Int): List[Int] = {
    val index = names.indexOf(name)
    if (index != -1) {
        if (quantities(index) >= quantity) {
            quantities.updated(index, quantities(index) - quantity)
        } else {
            println(s"Not enough $name in stock to sell.")
            quantities
        }
    } else {
        println(s"Item $name not found in inventory.")
        quantities
    }
}
    


@main def main() =
    val names = List("Apples", "Bananas", "Oranges")
    var quantities = List(10, 5, 8)

    displayInventory(names, quantities)
    quantities = restockItem(names, quantities, "Apples", 5)
    displayInventory(names, quantities)

    quantities = sellItem(names, quantities, "Bananas", 2)
    displayInventory(names, quantities)