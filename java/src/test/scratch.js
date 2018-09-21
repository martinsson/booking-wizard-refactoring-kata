[
    [tripType, departureCity]
    [departureCity, arrivalCity]
    [arrivalCity, dateLeave]
    [dateLeave, dateReturn]
    [dateLeave, showFlights]
    [dateLeave, multiple(showFlights, dateReturn)]
]

{exits: [dateReturn, showFlights]}

{exits: valuesOf(DateLeaveExitEnum.class)}

class DateLeaveController<DateLeaveExitEnum> {
    show(): [any, DateLeaveExitEnum] {

        if (toto  == 1) {
            navController.push(new DateReturnController())
            return [{}, DateLeaveExitEnum.DateReturn]
        } else {
            return [{}, DateLeaveExitEnum.ShowFlights]
        }

    }
}