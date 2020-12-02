module DayOne

let combineWithEach list = List.allPairs list list

let multiply (firstNumber, secondNumber) =
    firstNumber * secondNumber


let sumsTo2020 = function
    | firstNumber, secondNumber, thirdNumber -> firstNumber + secondNumber + thirdNumber = 2020

let twoSumTo2020 (first, second) = sumsTo2020 (first, second, 0)

let solvePartOne input =
    input
    |> combineWithEach
    |> List.filter twoSumTo2020
    |> List.map multiply
    |> List.head

let combineThree list =
    seq {
        for i in list do
            for j in list do
                for k in list do
                    yield i, j, k
    }

let multiplyThree (first, second, third) = first * second * third

let solvePartTwo input =
    input
    |> combineThree
    |> Seq.filter sumsTo2020
    |> Seq.map multiplyThree
    |> Seq.head
