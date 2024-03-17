Feature: Check whether 2 CSV files are same
  Scenario: Checking the count of CSV files
    Given "data1.csv" and "data2.csv" are present
    Then Check whether "data1.csv" and "data2.csv" has same number of lines

  Scenario: Checking whether all data are same
    Given "data1.csv" and "data2.csv" are present
    Then Check whether all lines in "data1.csv" and "data2.csv" are same
