package com.example.myfirstapp

// entry 함수
fun main() {
//    hellWorld()
//    println(add(4 , 9))
//    callName()
//    checkNum(1)
//    forLoop()
//    whileLoop()
    nullCheck()

}

// 1. 함수
// fun + 함수 이름의 형식으로 작성
// (옵션) 아무것도 리턴하지 않는 함수는 리턴 타입이 Unit (void와 같은 의미)

fun hellWorld(): Unit {
    println("Hello Kotlin World!")
}

// 무언가를 리턴한다면 반드시 리턴 타입을 지정해줘야한다.
fun add(a: Int, b: Int): Int {
    return a + b
}

// 2. val vs var
// val = value (바뀌지 않는 값. 상수. 값을 재할당 할 수 없다. )
// var = variable (바뀌는 값. 변수)
// 명시적으로 값이 지정되어 있으면 타입을 명시하지 않아도 자동 추론이 된다.

fun hi(){
    val a = 10

    var b = "Sori"
    b = "Kim"
}

// 3. String Template
// $ 뒤에 변수명
// 띄어쓰기 없이 이어서 string을 입력하고 싶을때는 ${}
// 달러표시를 string으로 쓸때는 역슬래쉬와 함께 작성
fun callName () {
    val name = "Sori"
    val lastName = "Hong"
    val price = "100"
    println("My name is $name")
    println("My name is ${name + lastName}I am Developer")
    println("This is \$${price}")
}

// 4. (1) 조건식 IF
fun maxBy(a: Int, b: Int) : Int {
    if (a > b) {
        return a
    } else return b
}

// if문을 작성할때 실제로 더 많이 사용하는 expression
fun maxBy2(a: Int, b: Int) = if(a > b) a else b

// (2) 조건식 When
fun checkNum(score: Int) {
   when(score) {
       0 -> println("This is 0")
       1 -> println("This is 1")
       2,3 -> println("This is 2 or 3")
   }

// when문의 축약형 expression (반드시 else가 필요하다)
    var b: Int = when(score) {
        1 -> 1
        2 -> 2
        else -> 3
    }
    println("b: ${b}")

// 구간 조건문을 작성할때 (expression으로 작성된 형태가 아니므로 else 생략 가능)
    when(score) {
        in 90..100 -> println("You are genius")
        in 10 .. 80 -> println("Not bad")
        else -> println("okay")
    }
}

// 참고: Expression vs Statement
// 어떤 작업을 해서 값을 만들고 반환하면 Expression (표현식)
// 코틀린의 모든 함수는 Expression이다. (아무것도 리턴하지 않는 함수도 Unit을 반환하는 함수기 때문에)
// Expression으로 사용할 수도 Statement로도 사용할 수 있다.
// 반면 자바는 void라는 리턴값이 없는 함수가 존재하기 때문에 이런 경우 Statement이다.


// 5. Array and List
// Array 는 처음에 크기를 지정해줘야한다.
// List는 1) (Immutable) List 2) Mutable List로 나뉜다.

fun array(){
    val array = arrayOf(1,"hey",3.5)
    val list = listOf(2,3,4)

    // array는 기본적으로 mutable이다. 사이즈를 변경하지만 않는다면, 값을 변경하는 것이 얼마든지 가능하다.
    // array[0] = 3   (0)

    // list는 기본적으로 immutable이다. 그래서 mutableList인 경우에만 값의 변경이 가능하다.
    // list[2] = 1    (X)
    var result = list.get(1)  //값을 가져오는 것만 가능하다.

    // 하지만 Mutable List의 경우 값의 변경이 가능한데, 대표적인 예가 arrayList이다.
    var arrayList = arrayListOf<Int>()
    arrayList.add(10)
    arrayList.add(20)
    arrayList[0] = 50
}

// 6. 반복문
// (1) for / While

fun forLoop(){
    val students = arrayListOf<String>("jenny", "sori", "rose")
    for (name in students) {
        println(name)
    }

    var sum: Int = 0
    // step 2는 2칸씩 건너가라는 의미 (1, 3, 5, 7, 9)
    for (i in 1..10 step 2) {
        sum += i
    }
    println(sum)

    // 10부터 1까지 반복문을 돌려라
    for (i in 10 downTo 1) {
        sum += i
    }

    // 1부터 99까지 반복문을 돌려라 ( for i in 1 .. 100과 구분하기)
    for (i in 1 until 100){
        sum += i
    }

    for ((index, name) in students.withIndex() ){
        println("${index + 1} 번째 학생: ${name}")
    }
}

fun whileLoop() {
    var index = 0
    while (index < 10) {
        println("current index: ${index}")
        index += 1
    }

}

// 7. NonNull / Nullable

fun nullCheck(){
   // Null pointer Exception
   // 자바에서는 컴파일 시점이 아니라 런타임 시점에서만 알 수 있기 때문에 돌려봐야지 에러를 파악할 수 있는 어려움이 있었다.
    // 이 문제를 코틀린은 컴파일 시점에 null 여부를 파악할 수 있도록 지원해주는 문법이 추가됨

    var name: String = "sori"
    var nullName: String? = null // nullable type은 ?를 붙여준다.

    var nameToUpperCase = name.uppercase() // (O)
    var nullNameToUpperCase = nullName?.uppercase()

    // ?: 엘비스 프레슬리 연산자
    val lastName : String? = null
    val fullName = name + " " + (lastName?: "No Last name")
    println(fullName)

    // !! NonNull 연산자 (이거 Null 아니야!) --> 하지만 사용을 지양해야 함. 확실하게 null이 아닐때에만 쓰기
    fun ignoreNulls(str: String?){
        val nonNull : String = str!!
        val upper = nonNull.uppercase()


        val email: String? = "rosie@medility.ai"
        email?.let{

        }
    }
}

// 8.





