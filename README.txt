READ ME 

Overview

This project is a final project "Easy Animator Application" ,using the classic Model-View-Controller architecture. In the model, we use two linkedhashmap lists to give the right shapes we need to use in the view. In the view, we design three kinds of view——textview, svgview and visual-view. In the controller, we use the controller to control whether to run animation of text, svg or visual.
IMPORTANT! How to run the Final project.
In order to run ,you need to give a command line.  “-in name-of-animation-file" -view "type-of-view" -out "where-output-show-go" -speed “integer-ticks-per-second”
type-of-view. Choosing from “text” “svg” “visual” to get the text, svg or the visual view.
speed. It must be an integer.

Model
Overview of model

In order to implement the function, we design three important interfaces to do this. They are ShapeInterface, MotionInterface and ProcessInterface. The first two interfaces are designed to help implement the final animation needed interface—ProcessInterface.
ShapeInterface and its implementation classes
ShapeInterface. In this interface, we design the functionalities that the shapes need to have.And we used an abstract class to implement the ShapeInterface and implement some common functionalities. We design two kinds of shapes which are rectangle and ellipse. If other want to use this code, they can add new shape type into this by extends from abstract class or implement the ShapeInterface.
AbstractShape. It is an abstract class from ShapeInterface and it is also the superclass of Rectangle and Ellipse. It implement most basic and common method that shapes need like getX and getWidth.
Rectangle.It is a subclass which extends from the AbstractShape. It represents the rectangle shape.
Ellipse.It is a subclass which extends from the AbstractShape. It represents the Ellipse shape.
Shapes. It is an enum class which contains two kinds of shape type. They are rectangle and ellipse.
MotionInterface and its implementation classes
MotionInterface.In this interface, we design the functionalities that the motions need to have. And we used an abstract class to implement the ShapeInterface and implement some common functionalities. 
ChangeColor. In this class , we change the red, green and blue value which determine the final color of the shape.
ChangePosition. In this class, we change the x and y coordinate of the shape.
ChangeSize.In this class, we change the width and height of the shape to change the size of the shape.
ProcessInterface and its implementation classes
ProcessInterface. It is an interface which has methods that the model needs.
ProcessImpl. It is almost the most important class in the final project. We used two hashmaplist to describe the animation. One is mapOfShapes and one is mapOfMotion. The mapOfShapes list is a list of shapes whose key is the uniquecode(name or label) of the certain shape and the value is the AbstractShape.  The mapOfMotions list of motions whose key is the uniquecode which can represent the certain shape and the value is a list which contains all the motions that shape has. We have some key method to help us implement the view we need. We have getsState method which can create a list which contains the shapes in a certain time and help us get the picture when we want to have a visual view.And we also have the toString method which help us to get the text view. There is somthing we need to mention. Our svg view also need string format. In order to do that , we have that method in the svgview.


View
Overview
We have three view types in this project. They are visual view, text view and svg view.We implement them in the classes.
Textview
It first describes the shapes that are part of the animation and their details. Next it describes how these shapes will move as the animation proceeds from start to finish.
Svgview
It is something like the textview. And it is in a certain format.By using the string builder, we translate the two important list(mapOfShape and mapOfMotions)to the svg format.
VisualView
The visual view use the getstate method in the ProcessImpl to get the list of shapes in a certain tick and then use the Swing(JFrame and JPanel)to paint it in the canvas. We can paint all the ticks in the given time and we get the animation.
Controller
Because there is only one controller so I delete the interface. In the controller, we run the animation by the method runAnimation and if the type of view is text view, it will call the runTextView and print the view in string . If the type of view is svg view, it will call the runSvgView and we can get the svgview in a file. And if the view is visual view, it will call the runVisualView. And by using a while loop, we get every tick’s picture and then we get the animation. 



STEP BY STEP (what changes did I made from the previous assignment during the project)
1.Add canvas to the model. I didn’t set the x,y, width and height of the canvas before. I add them to model when design the view.
2.Add red, green and blue value instead of Color. Because we need to calculate the tweening color when get the shapes during a motion.
3.Add view factory.I used the view factory to get the right view type in order to get the right view type and pass it to the controller to run the right animation.

