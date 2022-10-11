<table><tr><td> <em>Assignment: </em> IT114 - Sockets Part 1 - 3</td></tr>
<tr><td> <em>Student: </em> Grimm Cato (gc359)</td></tr>
<tr><td> <em>Generated: </em> 10/10/2022 8:39:24 PM</td></tr>
<tr><td> <em>Grading Link: </em> <a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-007-F22/it114-sockets-part-1-3/grade/gc359" target="_blank">Grading</a></td></tr></table>
<table><tr><td> <em>Instructions: </em> <ol><li>Create a new branch for this assignment</li><li>Go through the socket lessons and get each part implemented (parts 1-3)</li><ol><li>You'll probably want to put them into their own separate folders/packages</li></ol><li>Create a new folder called Part3HW</li><li>Create an empty m4_submission.md file in Part3HW (or skip this step and download the file at the end)</li><ol><li>Add/commit/push the branch</li><li>Create a pull request to main and keep it open</li></ol><li>Copy the the Part3 code into this new folder (Part3HW)</li><li>Git add/commit all of the sample code and the Part3HW code</li><li>Implement two of the following <b>server-side</b> activities for all connected clients (majority of the logic should be processed server-side and broadcasted to all clients if/when applicable)</li><ol><li>Simple number guesser where all clients can attempt to guess</li><ol><li>Hint: may want separate commands to start, stop, and guess (or starting lasts for x rounds then stops)</li><li>No need to implement complexities like strikes</li></ol><li>Coin toss command (random heads or tails)</li><li>Dice roller given a command and text format of "roll #d#" (i.e., roll 2d6)</li><li>Math game (server outputs a basic equation, first person to guess it correctly gets congradulated and a new equation is given)</li><ol><li>Hint: may want separate start, stop, answer commands (or starting lasts for x rounds then stops)</li></ol><li>Private message (a client can send a message targetting another client where only the two can see the messages)</li><li>Message shuffler (randomizes the order of the characters of the given message)</li></ol><li>Fill in the below deliverables</li><li>Save and generated the markdown or markdown file</li><li>Update the m4_submission.md file in the Part3HW folder</li><li>Add/commit/push your changes</li><li>Merge the pull request</li><li>From the M4-Sockets branch, navigate to your m4_submission.md file on github and copy the link</li><li>Submit the direct link to Canvas</li></ol></td></tr></table>
<table><tr><td> <em>Deliverable 1: </em> Baseline </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="http://via.placeholder.com/400x120/009955/fff?text=Complete"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add as many screenshots as necessary to show basic communication among 3 clients and 1 server</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://github.com/gc359/IT114-007/blob/main/pics/part1-hw4.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>3 clients all connected at once with each client sending different messages with<br>identifiers respective to their threads<br></p>
</td></tr>
</table></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 2: </em> Feature Implementation 1 </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="http://via.placeholder.com/400x120/009955/fff?text=Complete"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> What feature did you pick? Briefly explain how you implemented it</td></tr>
<tr><td> <em>Response:</em> <ol><li>Coin toss command (random heads or tails)</li></ol><div>This method can be called when the<br>user sends a message containing the string "flip". I implemented this by using<br>Math.random. The number generated will be between 1 and 2 and if it<br>lands on 1, it returns heads. Otherwise, it will return tails</div><br></td></tr>
<tr><td> <em>Sub-Task 2: </em> Add screenshot(s) showing the implemented feature working</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://github.com/gc359/IT114-007/blob/main/pics/part2-hw4.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Multiple clients calling the flip command and returning either heads or tails respectively<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Add screenshot(s) of related code changes to highlight the new logic</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://github.com/gc359/IT114-007/blob/main/pics/part3-hw4.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Using math.random to generate a random number between 1 and 2. 1 will<br>return heads while 2 will return tails. Sending the string &quot;flip&quot; through the<br>client will trigger it<br></p>
</td></tr>
</table></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 3: </em> Feature Implementation 2 </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="http://via.placeholder.com/400x120/009955/fff?text=Complete"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> What feature did you pick? Briefly explain how you implemented it</td></tr>
<tr><td> <em>Response:</em> <ol><li>Message shuffler (randomizes the order of the characters of the given message)</li></ol><div>I created<br>a scramble method to handle the "shuffle" command. First it converts the string<br>into an array.&nbsp; Then it uses a for loop to iterate and rearrange<br>the elements and returns the finished output. For example, sending a text through<br>the client with the prefix "shuffle " will scramble all the characters in<br>the string.</div><br></td></tr>
<tr><td> <em>Sub-Task 2: </em> Add screenshot(s) showing the implemented feature working</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://github.com/gc359/IT114-007/blob/main/pics/part4-hw4.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>running on 3 separate clients, i sent &quot;shuffle this is a test&quot;. It<br>returned all of them successfully<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Add screenshot(s) of related code changes to highlight the new logic</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://github.com/gc359/IT114-007/blob/main/pics/part5-hw4.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>This is my scramble method where it changes the string into an array,<br>uses a for loop to rearrange it accordingly and returns a &quot;scrambled&quot; value<br></p>
</td></tr>
<tr><td><img width="768px" src="https://github.com/gc359/IT114-007/blob/main/pics/part6-hw4.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>this is where the processCommand detects the word &quot;shuffle&quot; and creates a new<br>string after removing &quot;shuffle &quot; with randomized character positions<br></p>
</td></tr>
</table></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 4: </em> Misc </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="http://via.placeholder.com/400x120/009955/fff?text=Complete"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Did you have an issues and how did you resolve them? If no issues, what did you learn during this assignment that you found interesting?</td></tr>
<tr><td> <em>Response:</em> <p>The main issue I had was not knowing where to implement the methods<br>in the Server.java file. I went to tutoring and Professor Toegel helped me<br>a lot.<br><br>Another issue I had was not saving but recompiling the file which<br>is why &quot;broadcast&quot; method wasn&#39;t working for me initially. He also helped me<br>out with that<br></p><br></td></tr>
<tr><td> <em>Sub-Task 2: </em> Pull request link</td></tr>
<tr><td> <a rel="noreferrer noopener" target="_blank" href="https://github.com/gc359/IT114-007/pull/6">https://github.com/gc359/IT114-007/pull/6</a> </td></tr>
</table></td></tr>
<table><tr><td><em>Grading Link: </em><a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-007-F22/it114-sockets-part-1-3/grade/gc359" target="_blank">Grading</a></td></tr></table>