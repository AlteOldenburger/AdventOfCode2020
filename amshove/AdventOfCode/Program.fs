[<EntryPoint>]
let main argv =
    DayOne.solvePartOne Inputs.dayOne |> printfn "Solution of Day 1 part 1: %d"
    DayOne.solvePartTwo Inputs.dayOne |> printfn "Solution of Day 1 part 2: %d"
    0