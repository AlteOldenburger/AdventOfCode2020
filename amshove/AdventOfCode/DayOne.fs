module DayOne


let cartesian firstList secondList = 
    firstList
    |> List.collect (fun numberOfFirst -> 
        secondList
        |> List.map (fun numberOfSecond -> numberOfFirst, numberOfSecond)
    )


let combineWithEach list = cartesian list list

let multiply (firstNumber, secondNumber) =
    firstNumber * secondNumber

let sumsTo2020 = function
    | firstNumber, secondNumber -> firstNumber + secondNumber = 2020

let solvePartOne input =
    input
    |> combineWithEach
    |> List.filter sumsTo2020
    |> List.map multiply
    |> List.head
