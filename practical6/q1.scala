type Product = (String, Int, Double)

def getProductNames(inventory: Map[Int, Product]): List[String] =
  inventory.values.map(_._1).toList

def calculateTotalValue(inventory: Map[Int, Product]): Double =
  inventory.values.map { case (_, quantity, price) => quantity * price }.sum // case does destructuring of the elements in the product

def isInventoryEmpty(inventory: Map[Int, Product]): Boolean =
  inventory.isEmpty

def mergeInventories(inv1: Map[Int, Product], inv2: Map[Int, Product]): Map[Int, Product] =
    // inv1 is the initial accumilator
  inv2.foldLeft(inv1) { case (acc, (id, (name, qty, price))) =>
    acc.get(id) match
      case Some((_, qty1, price1)) =>
        acc.updated(id, (name, qty1 + qty, price.max(price1)))
      case None =>
        acc.updated(id, (name, qty, price))
  }

def checkProductExists(inventory: Map[Int, Product], productId: Int): Option[Product] =
  inventory.get(productId)

@main def main() =
  val inventory1: Map[Int, Product] = Map(
    101 -> ("A", 10, 10.2),
    102 -> ("B", 20, 46.0),
    103 -> ("C", 15, 21.0)
  )

  val inventory2: Map[Int, Product] = Map(
    101 -> ("A", 5, 16.0),
    104 -> ("D", 8, 22.0)
  )

  println("Product Names in Inventory1:")
  println(getProductNames(inventory1))

  println("\nTotal Value of Inventory1:")
  println(calculateTotalValue(inventory1))

  println("\nIs Inventory1 Empty?")
  println(isInventoryEmpty(inventory1))


  val mergedInventory = mergeInventories(inventory1, inventory2)
  println("\nMerged Inventory:")
  println(mergedInventory)

  println("\nCheck if Product ID 102 Exists in Inventory1:")
  checkProductExists(inventory1, 102) match
    case Some(product) => println(s"Product 102 Details: $product")
    case None          => println("Product 102 not found in Inventory1")
