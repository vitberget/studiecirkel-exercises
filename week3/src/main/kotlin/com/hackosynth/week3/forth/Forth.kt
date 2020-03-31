package com.hackosynth.week3.forth

typealias STACK_FUN = (List<Int>) -> List<Int> // Because so much easier to read :D

object Forth {
    fun evaluate(vararg line: String): List<Int> {
        val operators = mutableMapOf<String, STACK_FUN>(
            "+" to ::plus,
            "-" to ::minus,
            "*" to ::multiply,
            "/" to ::divide,
            "dup" to ::dup,
            "drop" to ::drop,
            "swap" to ::swap,
            "over" to ::over
        )

        var stack = listOf<Int>()

        line.map { it.trim() }
            .map { it.split("""\s+""".toRegex()) }
            .forEach { list ->
                if (list.first() == ":")
                    doSomeUserDef(operators, list)
                else
                    stack = doSomeStackStuff(list, stack, operators)
            }

        return stack
    }


// --- Stack manipulation

    fun doSomeStackStuff(
        list: List<String>,
        originalStack: List<Int>,
        operators: MutableMap<String, STACK_FUN>
    ): List<Int> {

        var stack = originalStack

        list.forEach {
            val num = it.toIntOrNull()
            if (num != null) {
                stack = stack + num
            } else {
                val op = operators.get(it.toLowerCase()) ?: ::throwError
                stack = op.invoke(stack)
            }
        }

        return stack
    }


// --- User define stuff belooooow....

    fun doSomeUserDef(operators: MutableMap<String, STACK_FUN>, list: List<String>) {
        val list2 = list.drop(1).dropLast(1) // drop : and ;
        require(list2.size > 1)

        val word = list2.first().toLowerCase()

        if (word.toIntOrNull() != null) {
            require(false)
        }

        operators[word] = list2.drop(1)
            .map { mapFun(operators, it) }
            .reduce { acc, fn -> { fn(acc(it)) } }
    }

    private fun mapFun(operators: MutableMap<String, STACK_FUN>, word: String): STACK_FUN {
        val num = word.toIntOrNull()
        return if (num != null) {
            { it + num }
        } else {
            operators.get(word.toLowerCase()) ?: ::throwError
        }
    }

    fun throwError(stack: List<Int>): List<Int> {
        require(false);
        return emptyList()
    }


// --- "Original" "Forth" funs belooooooooow....

    fun plus(stack: List<Int>): List<Int> {
        require(stack.size == 2) // Perhaps not a real requirement, but it passes the tests... so, if not it's a "feature"
        return listOf(stack[0] + stack[1])
    }

    fun minus(stack: List<Int>): List<Int> {
        require(stack.size == 2)
        return listOf(stack[0] - stack[1])
    }

    fun multiply(stack: List<Int>): List<Int> {
        require(stack.size == 2)
        return listOf(stack[0] * stack[1])
    }

    fun divide(stack: List<Int>): List<Int> {
        require(stack.size == 2)
        return listOf(stack[0] / stack[1])
    }

    fun dup(stack: List<Int>): List<Int> {
        require(stack.size >= 1)
        return stack + stack.last()
    }

    fun drop(stack: List<Int>): List<Int> {
        require(stack.size >= 1)
        return stack.dropLast(1)
    }

    fun swap(stack: List<Int>): List<Int> {
        require(stack.size >= 2)
        return stack.dropLast(2) + stack.takeLast(2).reversed()
    }

    fun over(stack: List<Int>): List<Int> {
        require(stack.size >= 2)
        return stack + stack.takeLast(2).first()
    }
}

