import scala.io.StdIn.readLine

@main def main() = {
    val productList = getProductList()
    printProductList(productList)
    println(s"Total products: ${productList.length}")
}

def getProductList(): List[String] = {
    var products = List[String]()
    var input = ""
    println("Enter product names (type 'done' to finish):")
    while
        input != "done"
    do
        input = readLine()
        products = products :+ input
    products
}

def printProductList(products: List[String]): Unit = {
    products.zipWithIndex.foreach { case (product, index) =>
        println(s"${index + 1}. $product")
    }
}