class CoffeeMachine {
    var water = 400
    var milk = 540
    var beans = 120
    var dispCups = 9
    var cash = 550

    fun printState() {
        println()
        print(
            """
        The coffee machine has:
        $water of water
        $milk of milk
        $beans of coffee beans
        $dispCups of disposable cups
        $cash of money
    """.trimIndent()
        )
        println()
        println()
    }

    fun fill() {
        print("\nWrite how many ml of water do you want to add: ")
        water += readLine()!!.toInt()
        print("Write how many ml of milk do you want to add: ")
        milk += readLine()!!.toInt()
        print("Write how many grams of coffee beans do you want to add: ")
        beans += readLine()!!.toInt()
        print("Write how many disposable cups of coffee do you want to add: ")
        dispCups += readLine()!!.toInt()
    }

    fun buy() {
        println()
        print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ")
        when (readLine()!!) {
            "1" -> {
                if (water >= 250 && beans >= 16) {
                    water -= 250
                    beans -= 16
                    cash += 4
                    dispCups--
                    println("I have enough resources, making you a coffee!")
                } else println("Sorry, not enough water!")
            }

            "2" -> {
                if (water >= 350 && milk >= 75 && beans >= 20) {
                    water -= 350
                    milk -= 75
                    beans -= 20
                    cash += 7
                    dispCups--
                    println("I have enough resources, making you a coffee!")
                } else println("Sorry, not enough water!")
            }

            "3" -> {
                if (water >= 200 && milk >= 100 && beans >= 12) {
                    water -= 200
                    milk -= 100
                    beans -= 12
                    cash += 6
                    dispCups--
                    println("I have enough resources, making you a coffee!")
                } else println("Sorry, not enough water!")
            }

            "back" -> return
        }
        println()
    }

    fun take() {
        print("\nI gave you $$cash\n")
        cash = 0
    }
}

fun main() {
    val obj = CoffeeMachine()
    while (true) {
        print("Write action (buy, fill, take, remaining, exit): ")
        when (readLine()!!) {
            States.BUY.str -> obj.buy()
            States.FILL.str -> obj.fill()
            States.TAKE.str -> obj.take()
            States.REMAINING.str -> obj.printState()
            States.EXIT.str -> break
        }
    }
}

enum class States(val str: String) {
    BUY("buy"), FILL("fill"), TAKE("take"), REMAINING("remaining"), EXIT("exit")
}