# CIMB Assessment

## How to Run the Test

1. Clone this branch
2. Create a new TestNg UITestRunner with the following properties. 

`-Dtags=@CIMBTest -Dbrowser=chrome -Dmaximise=true -Denvironment=https://www.cimb.com.sg/en/personal/home.html`
Note: if environment is not specified, it will default to CIMB MY website.

## How to Run using Maven Build
1. Run using command 
`clean verify -Dbrowser=chrome -Denvironment=https://www.cimb.com.sg/en/personal/home.html -Dmaximise=true` 


## How to view the report
1. In Intellij project, right-click to frameworkium-bdd > target then select Open In > Terminal.
2. In the terminal, type `allure serve` then hit Enter
3. A new browser tab will open for the allure report
