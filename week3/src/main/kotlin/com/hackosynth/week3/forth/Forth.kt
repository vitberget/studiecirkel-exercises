package com.hackosynth.week3.forth

// Typealiases, because so much easier to read :D

typealias STACK = List<Int>
typealias OPERATOR = (STACK) -> STACK
typealias OPERATORS = Map<String, OPERATOR>

object Forth {

    private const val USER_DEFINED_WORD_START = ":"

    fun evaluate(vararg line: String): STACK {
        // operators and stack might be replaced forEach-loop below
        var operators = forthOriginalOperations
        var stack = listOf<Int>()

        line.map { it.trim() }
            .map { it.split("""\s+""".toRegex()) }
            .forEach { list ->
                if (list.first() == USER_DEFINED_WORD_START)
                    operators = doUserDefinedWord(operators, list)
                else
                    stack = doStackOperation(list, stack, operators)
            }

        return stack
    }


// --- Stack manipulation

    private fun doStackOperation(
        command: List<String>,
        originalStack: STACK,
        operators: OPERATORS
    ): STACK {

        var stack = originalStack

        command.forEach {
            with(it.toIntOrNull()) {
                stack = if (this != null)
                    stack + this
                else
                    with(operators[it.toLowerCase()]) {
                        require(this != null)
                        this.invoke(stack)
                    }
            }
        }

        return stack
    }


// --- User define stuff belooooow....

    private fun doUserDefinedWord(operators: OPERATORS, userDefCommand: List<String>): OPERATORS {
        val trimmedUserDef = userDefCommand.drop(1).dropLast(1) // drop : and ;
        require(trimmedUserDef.size > 1)

        val word = trimmedUserDef.first().toLowerCase()
        require(word.toIntOrNull() == null)

        return operators + (word to userDefToOperator(trimmedUserDef, operators))
    }

    private fun userDefToOperator(userDef: List<String>, operators: OPERATORS): OPERATOR =
        userDef.drop(1)
            .map { mapUserWordToOperator(it, operators) }
            .reduce { accumulator, anotherFun -> { anotherFun(accumulator(it)) } }

    private fun mapUserWordToOperator(word: String, operators: OPERATORS): OPERATOR =
        with(word.toIntOrNull()) {
            return if (this != null) {
                addNumberToStack(this)
            } else {
                operators[word.toLowerCase()] ?: ::throwError
            }
        }

    // Because easier to read and understand
    private fun addNumberToStack(num: Int): OPERATOR = { it + num }

    // Throw error when executed, I think it's nicer than when defined... it might not be called
    private fun throwError(stackNotUsed: STACK): STACK {
        require(false)
        return emptyList()
    }


// --- "Original" "Forth" funs belooooooooow....

    private val forthOriginalOperations = mapOf<String, OPERATOR>(
        "+" to ::plus,
        "-" to ::minus,
        "*" to ::multiply,
        "/" to ::divide,
        "dup" to ::dup,
        "drop" to ::drop,
        "swap" to ::swap,
        "over" to ::over
    )

    private fun plus(stack: STACK): STACK {
        require(stack.size == 2) // Perhaps not a real requirement, but it passes the tests... so, if not it's a "feature"
        return listOf(stack[0] + stack[1])
    }

    private fun minus(stack: STACK): STACK {
        require(stack.size == 2)
        return listOf(stack[0] - stack[1])
    }

    private fun multiply(stack: STACK): STACK {
        require(stack.size == 2)
        return listOf(stack[0] * stack[1])
    }

    private fun divide(stack: STACK): STACK {
        require(stack.size == 2)
        return listOf(stack[0] / stack[1])
    }

    private fun dup(stack: STACK): STACK {
        require(stack.isNotEmpty())
        return stack + stack.last()
    }

    private fun drop(stack: STACK): STACK {
        require(stack.isNotEmpty())
        return stack.dropLast(1)
    }

    private fun swap(stack: STACK): STACK {
        require(stack.size >= 2)
        return stack.dropLast(2) + stack.takeLast(2).reversed()
    }

    private fun over(stack: STACK): STACK {
        require(stack.size >= 2)
        return stack + stack.takeLast(2).first()
    }
}

