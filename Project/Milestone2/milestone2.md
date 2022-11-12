<table><tr><td> <em>Assignment: </em> IT114 Chatroom Milestone 2</td></tr>
<tr><td> <em>Student: </em> Grimm Cato (gc359)</td></tr>
<tr><td> <em>Generated: </em> 11/11/2022 9:25:06 PM</td></tr>
<tr><td> <em>Grading Link: </em> <a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-007-F22/it114-chatroom-milestone-2/grade/gc359" target="_blank">Grading</a></td></tr></table>
<table><tr><td> <em>Instructions: </em> <p>Implement the features from Milestone2 from the proposal document:&nbsp; <a href="https://docs.google.com/document/d/1ONmvEvel97GTFPGfVwwQC96xSsobbSbk56145XizQG4/view">https://docs.google.com/document/d/1ONmvEvel97GTFPGfVwwQC96xSsobbSbk56145XizQG4/view</a></p>
</td></tr></table>
<table><tr><td> <em>Deliverable 1: </em> Payload </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="http://via.placeholder.com/400x120/009955/fff?text=Complete"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Payload Screenshots</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/113853920/201450823-128cd4da-2efa-4627-9a69-bfe3840965b3.PNG"/></td></tr>
<tr><td> <em>Caption:</em> <p>Payload Screenshot #1<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/113853920/201450822-acf223ac-69cc-45b6-b799-b1cdf38c7658.PNG"/></td></tr>
<tr><td> <em>Caption:</em> <p>Payload Screenshot #2<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/113853920/201451749-2b7e8c41-4f45-4a33-ac69-c1fc1c45828d.PNG"/></td></tr>
<tr><td> <em>Caption:</em> <p>Payload Content <br></p>
</td></tr>
</table></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 2: </em> Server-side commands </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="http://via.placeholder.com/400x120/009955/fff?text=Complete"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Show the code for the mentioned commands</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/113853920/201451078-d0c1c960-02af-4ae7-bb17-39e4640a0d95.PNG"/></td></tr>
<tr><td> <em>Caption:</em> <p>/roll Code<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/113853920/201451086-ce3f2e5a-535c-4a92-bc56-bd41f349d1b7.PNG"/></td></tr>
<tr><td> <em>Caption:</em> <p>/flip Code<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Explain the logic/implementation of each commands</td></tr>
<tr><td> <em>Response:</em> <p>For both /roll and /flip, I used math.random to generate the number and<br>typecasted it into an integer.<br><br>The main difference is that /roll has a ceiling<br>of 6(a dice) while /flip has a ceiling of 2(a coin)<br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 3: </em> Text Display </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="http://via.placeholder.com/400x120/009955/fff?text=Complete"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Show the code for the various style handling</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/113853920/201451379-48eb5e23-1118-4062-85ae-ebef7c150db5.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Bold can be processed by wrapping the message with: !, Italics can be<br>processed by wrapping the message with: @, Underline can be processed by wrapping<br>the message with: #, Colors(Red, Blue, Green) can be processed by wrapping the<br>message with ,respectively, $,%,^.<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/113853920/201451381-b0bbb282-ccae-4374-b55a-1c4fdb64b3ac.PNG"/></td></tr>
<tr><td> <em>Caption:</em> <p>The message is broken down to an array and uses an if statement<br>to check for each character if it contains any of these characaters: !,@,#,$,%,^<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/113853920/201451382-5612a398-a062-46f6-9231-1866e15bdc58.PNG"/></td></tr>
<tr><td> <em>Caption:</em> <p>Finally, the message is combined together with String.join and broadcasted back by the<br>room<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Show source message and the result output in the terminal (note, you won't actually see the styles until Milestone3)</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/113853920/201452020-eb8b6fb4-fb80-49e0-8cb4-0f67dc2ef0de.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>I used &quot;$This$ %is% ^bold^ and <em>italic</em> and !<em>bold and italic</em>! too&quot; from<br>both TEST1(first client) and TEST2(second client) to make sure they broadcast to each<br>other and that the conversion is handled properly.<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Explain how you got each style applied</td></tr>
<tr><td> <em>Response:</em> <p>First, I checked if the message has the following characters: !,@,#,$,%,^<br>If the message<br>is wrapped accordingly with each character it will return the following:<br>! = bold,<br>@ = italics, # = underline, $ = red, % = blue, green<br>= ^<br>Then I converted the String into a string array so I can<br>use a for loop to iterate through each element and check for the<br>following characters: !,@,#,$,%,^<br>Once they have been converted by the for loop to the<br>proper html tags, the string array will be joined together by String.join it<br>will be broadcasted to the chatroom for the last time<br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 4: </em> Misc </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="http://via.placeholder.com/400x120/009955/fff?text=Complete"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Include the pull request for Milestone2 to main</td></tr>
<tr><td> <a rel="noreferrer noopener" target="_blank" href="https://github.com/gc359/IT114-007/pull/8">https://github.com/gc359/IT114-007/pull/8</a> </td></tr>
</table></td></tr>
<table><tr><td><em>Grading Link: </em><a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-007-F22/it114-chatroom-milestone-2/grade/gc359" target="_blank">Grading</a></td></tr></table>