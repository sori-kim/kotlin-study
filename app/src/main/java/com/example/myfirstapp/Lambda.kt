package com.example.myfirstapp

// 1. Lambda
// 람다식은 우리가 마치 value 처럼 다룰 수 있는 익명함수이다.
// 1) 메소드에 파라미터로 값을 넘겨줄 수 있다.
// 2) return 값으로 사용할 수 있다.

// 1-1. Lambda 의 기본 문법
// val lambdaName: Type = {argumentList -> codeBody}


val square : (Int) -> (Int) = {number -> number * number}
// 아래처럼 쓰는 방식도 가능
// val square = { number: Int -> number * number }

val nameAge = {name: String, age: Int -> "My name is ${name} I'm ${age}" }


fun main(){
  println(square(12))
  println(nameAge("sori", 1000))
    val a = "sori said "
    val b = "mac said "
  println(a.pizzaIsGreat())
  println(b.pizzaIsGreat())
  println(extendString("ariana grande", 28))
  println(calculateGrade(99))

  val lambda = { number: Double ->
    number == 4.321
  }

  println(invokeLambda(lambda))
  // 함수 선언식을 람다로 선언한 경우가 아니라, 바로 중괄호로 값을 집어넣는 방법도 가능 (람다리터럴)
  println(invokeLambda({true}))
  println(invokeLambda({it > 3.22}))
  // 함수의 첫번째이자 마지막 파라미터가 람다식일때는 아래와 같이 소괄호를 생략한 형태를 사용할 수 있다.
  // 굉장히 많이 쓰는 패턴 (onClick 핸들러 등)
  println(invokeLambda { it > 3.22 } )


}

// 1-2. 확장 함수
// 클래스를 확장한다 = 있는 클래스중에서 또다른 기능을 추가하고싶을때 확장함수를 사용한다.

val pizzaIsGreat: String.() -> String = {
    this + "pizza is great!"
}


fun extendString(name: String, age: Int): String {
  // 확장함수의 파라미터가 하나일때는 it(아래 예제에서는 Int) 이라는 예약어를 통해서 파라미터를 받을 수 있다.
  // this가 가리키는 것은 확장함수가 불러줄 object(아래 예제에서는 String)
  val introduceMyself: String.(Int) -> String = {
    "I am ${this} and ${it} years old "
  }
  return name.introduceMyself(age)
}

// 1-3. 람다의 리턴
// 마지막 표현식이 리턴 값을 의미한다.
val calculateGrade: (Int) -> String = {
  when(it) {
    in 0..40 -> "fail"
    in 41..70 -> "pass"
    in 71..100 -> "perfect"
    else -> "Error"
  }
}

// 1-4. 람다를 표현하는 여러가지 방법
fun invokeLambda(lambda: (Double) -> Boolean) : Boolean {
  return lambda(5.2351)
}

// 1-5. 익명 내부 함수
// 익명 내부 함수가 다음의 조건을 충족한다면 람다로 작성할 수 있다.
// 1) Kotlin interface가 아닌 자바 인터페이스여야한다.
// 2) 그 인터페이스는 딱 하나의 메소드만 가져야 한다.
