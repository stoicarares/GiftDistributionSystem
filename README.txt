// Stoica Rares-Tiberiu 321CA

    FIrst of all I had to get the data from the input files. I made my classes
to stock the information and put them into the "fileio" package:
    fileio |
           |____InputChild          - Information about child from input
           |
           |____InputGift           - Information about gift from input
           |
           |____InitialData         - Contains 1 list of InputChild and 1 of InputGifts
           |
           |____InputChildUpdate    - Information about child's updates
           |
           |____InputAnnualChanges  - Contains: new santa budget, list of: InputChild,
           |                             InputGifts, InputChildUpdate
           |
           |____Input               - Contains all the information read
           |
           |____InputReader         - Helper for reading from the file usint ObjectMapper
           |
           |____Child               - Additional class for child for storing more
                                        infotmation than given on input(Ex: AssingedBudget)

        After that I made a database to store the information Santa needs to make every
child happy on Christmas successfuly. I used a SINGLETON pattern for that.

        I started the implementation with getting the cildren's average scores using
STRATEGY design pattern, named ScoreStrategy. I developed 4 strategies, 1 for each
age type:
        package strategy:
                |
                |___BabyScoreStrategy --> Assigned score - 10.0;
                |
                |___KidScoreStrategy  --> Assigned score - Arithmetic average of
                |                                            his scores
                |
                |___TeenScoreStrateg  --> Assigned score - Weighted average of
                |                                            his scores
                |
                |___YoungAdultScoreStrategy --> No formula, just put it's score on
                                                    null in case of expansion of the
                                                    project

        I used a FACTORY design pattern combined with strategy to choose the corect
instantiation of a strategy, depending on child's age, using class ScoreStrategyFactory.

        For the rest of the Santa's work, I used COMMAND design pattern to simplify his job.

        package command:
                |
                |___Command                     - Abstract class which contains the execute
                |                                   abstract method
                |
                |___IncreaseAgeCommand          - At the end of each ear, every child's age
                |                                   is increased by one
                |
                |___EliminateYoungAdultsCommand - Deletes the children whose age is more
                |                                   than 18
                |
                |___SetAssignedBudgetCommand    - Sets the budget for each child depending
                |                                   on their AverageScore
                |
                |___GiftDistributionCommand     - Helps Santa to share gifts based on
                |                                   children preferences and budget
                |
                |___UpdateChildrenCommand       - Updates all children's information given
                |                                   on input at a specific year
                |
                |___UpdateNewGiftsCommand       - Adds new children in the Santa's database
                |
                |
                |___UpdateNewGiftsCommand       - Adds new gifts in the Santa's database.
                |
                |
                |___Invoker                     - The invoker of Command design pattern which
                                                    calls the correct command from all the above

        To store the output I made 2 specific classes:

        package writer:
                |
                |___ChildrenOutput  - A class which contains a list of Child(children) for getting
                |                        the correct output format.
                |                   - It stores all the children gifted in the current year.
                |                   - I made deep copy from the database on each list a child has
                |
                |___Writer          - A list of ChildrenOutput(List of Child) where to store the
                                         the result of all years combined to write it in the output
                                         files

        I had difficulties at the beggining of the project on thinking how to implement what i am
required using design patterns, because in my mind I was sure that it can be easily developed without
any. After making the strategy, i realized that they simplify my work and the code is more clear. That
had me using the command pattern which helped me a lot. These combined made the code easy to read and
understand and also open to extension.
