# My Personal Project

## Project proposal

My idea for my project is to design a **program that implements a personality test**. 
- The users shall be able to respond either 'true' or 'false' to a given statement, and these answers will be used to calculate their
scores in each of the *5 Big Five personality traits*.
- Their results will come out in a **list**, where each of the lines represent the score in one of the personality traits.
- The results will be presented in a scale of **0 to 5**.
- The users will be able to add famous people they believe have similar personality traits as them to their account information

This project is aimed at people who would like to have a (somewhat) scientifically reliable feedback on their personality 
traits but don't have the ***time*** or ***resources*** to attend sessions with a proper certified counselor.

Being a Cognitive Systems major, I'm very interested in the instersection between Psychology and Computer Science,
especially when this collaboration yields results that bring the general public closer to prominent theories within Psychology.

<br>

### User stories
As a user, I want to... 
- ... be able to perform the test
- ... be able to see my results right away
- ... be able to access the results from the last test I did
- ... add famous people who I think have similar personalities as me to my account information
- ... retrieve the list of people I believe are similar to me

- ... be able to save all the tests I've done in the past
- ... be able to save the similar personalities list I create
- ... when I select the quit option from the menu, I want to be reminded to save my test scores to file and have the option to do so or not.
- ... I want to be able to log-in again and have my information saved (account info, test scores and similar personalities list)


#### Phase 4: task 2

I chose the following option: 
**"Test and design a class in your model package that is robust. You must have at least one method that throws a checked exception. You must have one test for the case where the exception is expected and another where the exception is not expected."**

Now, the method **addQuestion(Question q)** in my QuizBuilder class throws a *QuestionInListException* when a person tried to add a question to the database that is already there.

<br>


#### Phase 4: task 3

- If I had had more time, I would have actually imported my questions from a Json file instead of instantiating them in the QuizBuilder class
- I would also have divided my GUI class more efficiently, adding more helper classes such as the QuizGUI class to deal with more specific behaviour
