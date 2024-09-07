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

  def applyInterest(): Unit = {
    if (balance > 0) {
      balance += balance * 0.05
    } else {
      balance += balance * 0.1
    }
  }
}

class Bank(val accounts: List[Account]) {
  def accountsWithNegativeBalances: List[Account] = {
    accounts.filter(_.getBalance < 0)
  }

  def totalBalance: Double = {
    accounts.map(_.getBalance).sum
  }

  def applyInterestToAllAccounts(): Unit = {
    accounts.foreach(_.applyInterest())
  }
}

@main def main(): Unit = {
  val a = new Account("1", 4500)
  val b = new Account("2", -5600)
  val c = new Account("3", 3000)
  val d = new Account("4", -1500)

  val bank = new Bank(List(a, b, c, d))

  println("Accounts with negative balances:")
  bank.accountsWithNegativeBalances.foreach(acc => println(acc.accountNumber))

  println(s"Total balance: ${bank.totalBalance}")

  bank.applyInterestToAllAccounts()

  println("Balances after applying interest:")
  bank.accounts.foreach(acc => println(s"Account ${acc.accountNumber}: ${acc.getBalance}"))
}