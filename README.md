# Unite #
A social media application where users can connect with friends and discover new people based on common interests.


## Features: ##
1) User Registraion and Login
* Create user account by providing username and password credentials.
* The password must adhere to length restriction and username must not already exist or be null.
* The user can login to an existing user account though the Login UI.
* After login they can access the app features like making a profile, joining groups, sending friend requests etc.

2) Profile Management
* Create/Update user’s profile. 
* Text Fields to enter details such as profilename, date of birth, description, interests etc
* Option to edit values in these fields and update profile data in database with the click of update button

3) Friend Search and Manager
* By typing an exist user name, view this user’s friend list
* When you already logged in the system, you can add or delete friend
* You can only add the friend that exists in the database(i.e: has profile). 
* You can only delete the friend that is already in your friend list

4) Random Groups
* Be added into a group based on your declared interests
* “Random” groups are created by other users, who assign specific interests to the group
* When you request to be added into a “random” group, you’ll be added into a group that shares the most interests in common with you

5) General Groups
* Groups created by users adding their friends
* Not based on common interests
* No random factor

6) Messaging
* Each user can choose a group they joint, and sending message within the group. 
* After sending the first message, users can view all the message that has been within the group and react to it.

7) Message Reactions
* Reactions can be added or removed from a message by the user.
* The user can choose between a heart, smile emoji, or cry emoji.
* When the user views the message, the reactions associated with the message will also be displayed.

8) User Reporter
* Check if a message contains a list of sensitive word submitted by the user in the profile.
* Replace sensitive words in the message with "*'.
* Add user who send “bad words” to the block user list of receiver in the Profile.
* User can submit reports on message and user.

## Team Members: ##
1) Kushagra
2) Tejas
3) Jasmine
4) Ashley
5) Amir
6) Ellen
7) Hansel
8) Aurora
