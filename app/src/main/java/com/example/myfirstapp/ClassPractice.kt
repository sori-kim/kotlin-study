package com.example.myfirstapp

// kotlin은 파일이름과 클래스 이름이 일치하지 않아도 되고, 여러 클래스를 한 파일 안에 넣을 수 있다. (자바와의 차이점)

// open이라는 예약어를 통해서 다른 클래스가 상속 받을 수 있게 할 수 있다.
open class Human constructor (val name: String = "Anonymous" ) {
    // constructor의 parameter이름과 동일한 변수명을 사용할 때는 위 처럼 constructor를 작성하면서 val을 한번에 할당 할 수 있다.
    // 아래 구문과 위는 동일한 역할을 함
    // val name = name
    // constructor 또한 생략 가능
    // consturctor에 디폴트값을 입력하면, 값이 비어있는 class 또한 생성을 한다.(값을 넣지 않고 class를 생성하는 것이 가능해짐)

    // 부생성자는 주생성자의 위임을 받아야한다. this라는 예약어를 통해 위임을 받으면 된다.
    constructor(name: String, age: Int): this(name) {
        println("My name is ${name}, ${age} years old.")
    }


    // 클래스를 초기화할때 어떤 동작을 수행하게 하고 싶은지 정의할 수 있다.
    // init은 주생성자의 일부라서 부생성자를 아무리 만들어도 init이 가장 먼저 실행된다.

    init {
        println("New human has been born!!")
    }

    fun eatingCake(){
        println("This is so yummyyyy!")
    }

   open fun singASong(){
        println("lalalala")
    }
}


class Korean : Human(){
  // 어떤 클래스의 함수나 값을 이 클래스에서만 특징적으로 사용하고 싶을때 주로 override를 사용한다.
  // super를 사용하면 원본의 함수를 사용할 수 있다.
  // 상속은 클래스 하나만 할 수 있다.
    override fun singASong(){
      super.singASong()
      println("라라랄라")
      println("my name is ${name}")
    }
}

fun main(){
//    val human = Human("sori")

//    val stranger = Human()

//    val sister = Human("sodam", 33)

    val korean = Korean()
    korean.singASong()

//    human.eatingCake()

//    println("this human's name is ${human.name}")
}