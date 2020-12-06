Feature: Test monthly refiCalculator payment

@dataParameter
  Scenario Outline: verify monthly payment with input values
    Given a user is on the mortgage calculator homepage
    When mouse hover on Refinence and click on Refi Calculator
    And user entering "<homevalue>","<downpayment>","<loanterm>" and "<interest>" click on calculate button
    Then validate the monthly payment "<monthlypayment>" and return to homepage

    Examples:
      |homevalue|downpayment|loanterm|interest|monthlypayment|
      |500000   |70000      |25      |5       |$2,513.74     |
      |600000   |50000      |30      |6       |$3,297.53     |