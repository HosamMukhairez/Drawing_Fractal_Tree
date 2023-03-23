# Drawing_Fractal_Tree
Java code to drawing tree with leafs and branches. Every Branch has 10% probability to be dead branch. Randomly drawing red ball between any two coupled branches

* Project General Goal:
- This is tree drawer demo, to draw tree trunk, branches & leafs.



* Project Basic Parameters:
A tree is randomly generated based on the following parameters: 
• trunkThickness - The thickness of the tree trunk. The thickness of the branches is decreased by 30% every outward level.
• trunkLength - The length of the starting branch. The length of the branches is decreased by 30% every outward level.
• maxDepth - The max number of branches extending outward from the trunk before being capped with a leaf (trunk included) 
• leafSize - The size of the leaves. (It's color is GREEN).



* Project Main Approach:
- The class 'Scene' overrides the function 'paint' which the tree and the random red ball. The tree is drawn by calling drawTree() function, and the red ball is drawn by calling drawRedBall().
- The tree is drawn from the trunk to the leafs using the recursive logic. Starting from painting or drawing the left side of every live branch until reaches the leafs, then returns recursively to draw the right branches of every live branch until reaches the leafs. 
- The colour of the branches should go from dark brown in the trunk to light brown outwards.
- Each branch has a 10% chance of being dead.
- Dead branches have a grey colour.
- A red ball is drawn randomly between two child live branches in the tree.
- Every run creates different tree branches and leaf counts because branch dead is based on probability.
- Four main functions are used in code:
	1. drawLine() to draw the branch.
	2. fillOval() to draw the leafs and the random red ball. 
	3. setColor() to change the color based on requirments.
	4. setStroke() to set the thickness of the starting branch and outward brnaches.



* How to run the project

Way 1:
Double click on the jar file 'tree-1.0-SNAPSHOT-jar-with-dependencies.jar' included directly in the project folder.

Way 2:
javac TreeFrame.java

NOTE: Every single run draws different tree style, with different number of dead branches and different number of leafs.


