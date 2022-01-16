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
                |       //Moved to .gifting         children preferences and budget
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
                |___Santa //modified            - The invoker of Command design pattern which
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

        Stage 2:

        First of all, I added the new fields "quantity" to InputGift and {"niceScoreBonus", "elf"}
to Child/InputChild. I used BUILDER DESIGN PATTERN for Child class for getting the niceScoreBonus.
These additional fields shouldn't appear in the output, so I tried to use @JsonIgnore to their
getters, but it also ignored them on input. So, I decided to make two classes for output in
the writer packege: OutputChild and OutputGift, only with fields needed.

        Secondly, I updated "NewChildrenCommand", "NewGiftsCommand", "UpdateChildrenCommand" with
the new classes fields, and then added "strategy" field to "InputAnnualChange".

        Afer that all worked corectly and I stated adding the new features.

        Implemented elves using Command Design Pattern.
        package elves:
            |
            |___ElfCommand              - Abstract class which contains the execute()
            |                              abstract method
            |
            |___PinkElf                 - Increases a child's budget by 30%
            |
            |
            |___BlackElf                - Decreases a child's budget by 30%
            |
            |
            |___YellowElf               - Searching for the cheapest gift Santa has in bag
            |                               of the child's(who didn't recieve any gift that year)
            |                               prefered category, and if the quantity it's not 0,
            |                               the Yellow Elf gives it to the child, no matter what his
            |                               budget is.
            |
            |___Elf                     - The invoker of ElfCommand Design Pattern which
                                            calls the correct command from all the above

        As WhiteElf doesn't bring any changes, I decided not to bring it into discussion.

        Implemented the ways of gift distribution using Command Design Pattern.
        package gifting
            |
            |___GiftCommand                  - Abstract class which contains the execute()
            |                                   abstract method
            |                                - Moved the additional methods that were in
            |                                   GiftDistributionCommand {"getCheapest", "buildGiftMap"},
            |                                   as i need them in all the strategies.
            |                                - Also moved the code that distributes the gifts by Categories
            |                                   based on the child's preferences and budget into the
            |                                   new method distributePreferedGift() which i used in all of
            |                                   the strategies below.
            |
            |___DistributionById             - It's the same command implemented at the Stage 1, but
            |                                   updating the decrease in the amount of gifts
            |
            |___DistributionByNiceScore      - I got the list of Childs from the database, which i sorted
            |                                   by the criterias given and than applied
            |                                   distributePreferedGift() method.
            |
            |___DistriburionByNiceScoreCity  - First of all I created a Map containing all populated cities
            |                                   and a list of Double values meaning children living there
            |                                   average scores
            |                                - Secondly I calculated the average score of each city and
            |                                   stored them in a Map<Cities, Double>
            |                                - Then I made a list of above map's entrySet which I sorted
            |                                   firstly descending by value, secondly alphabetical by name.
            |                                - In the end, I went to the list and used
            |                                   distributePreferedGifts() gifting childs by the order of
            |                                   the city they live in
            |
            |___Gifter                       - The invoker of GiftCommand Design Pattern which
                                                calls the correct command from all the above


            After that i added the functionality in Main, by the flow required.

            At this Stage of the project i haven't got any difficulties, only how to ignore that new fields
in the output, but I ended up making new output classes.
