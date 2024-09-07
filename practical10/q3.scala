class Account(val accountNumber: String, private var balance: Double) {
  def deposit(amount: Double): Unit = {
    require(amount > 0, "Deposit amount must be positive")
    balance += amount
  }

  def withdraw(amount: Double): Unit = {
    require(amount > 0, "Withdrawal amount must be positive")
    require(balance >= amount, "Insufficient funds")
    balance -= amount
  }

  def transfer(amount: Double, toAccount: Account): Unit = {
    require(amount > 0, "Transfer amount must be positive")
    this.withdraw(amount)
    toAccount.deposit(amount)
  }

  def getBalance: Double = balance
}

@main def main(): Unit = {
  val a = new Account("1", 4500)
  val b = new Account("2", 5600)

  a.transfer(1000.0, b)

  println(b.getBalance);
}