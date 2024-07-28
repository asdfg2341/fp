case class Book(title: String, author: String, isbn: String)

class Library {
    var library: Set[Book] = Set()

    def addBook(book: Book): Unit = {
        library += book
    }

    def removeBookByISBN(isbn: String): Unit = {
        library = library.filterNot(_.isbn == isbn)
    }

    def isBookInLibrary(isbn: String): Boolean = {
        library.exists(_.isbn == isbn)
    }

    def displayLibrary(): Unit = {
        library.foreach(book => println(s"Title: ${book.title}, Author: ${book.author}, ISBN: ${book.isbn}"))
    }

    def findBookByTitle(title: String): Option[Book] = {
        library.find(_.title.equalsIgnoreCase(title))
    }

    def displayBooksByAuthor(author: String): Unit = {
        library.filter(_.author.equalsIgnoreCase(author)).foreach(book => println(s"Title: ${book.title}, ISBN: ${book.isbn}"))
    }
}

@main def main(): Unit = {
    val library = Library()


    library.addBook(Book("The Hobbit", "J.R.R. Tolkien", "978-0547928227"))
    library.addBook(Book("1984", "George Orwell", "978-0451524935"))
    library.addBook(Book("To Kill a Mockingbird", "Harper Lee", "978-0061120084"))

    // library.displayLibrary()

    library.removeBookByISBN("978-0451524935")
    library.displayLibrary()

//     println(library.isBookInLibrary("978-0061120084"))

    // library.findBookByTitle("Harry potter").foreach(book => println(s"Found: Title: ${book.title}, Author: ${book.author}, ISBN: ${book.isbn}"))

//     library.displayBooksByAuthor("J.R.R. Tolkien")
}