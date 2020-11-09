This is for project Boiing CS 115


=============================================================================================================================================================================================
How to use the program?

Before running the program create a .txt file in the same folder as src, in the file it must only have the name of the shape and its parameters,
Then run the programe.

=============================================================================================================================================================================================

The types of shapes that can be made:

oval 
square
circle
rectangle
pacman

=============================================================================================================================================================================================

keys:

<..> => replace with your in put

<x> => (x-axis coordinates) 
<y> => (y-axis) 
<xv> => (The X velocity) 
<yv> => (The Y velocity) 
<isFilled> => (true/false for a colour fill in shape) 
<r> <g> <b> => (RGB values for standard colour) 
<insertion> => (insertion time) 
<flash> => (true/false if you want the shape to change to its second colour) 
<r1> <g1> <b1> => (RGB values for second colour)

=============================================================================================================================================================================================
File input for a oval:

oval <x> <y> <xv> <yv> <isFilled> <width> <height> <r> <g> <b> <insertion> <flash> <r1> <g1> <b1>

<width> => (the width) 
<height> => (the height)

=============================================================================================================================================================================================
File input for a rectangle:

rect <x> <y> <xv> <yv> <isFilled> <width> <height> <r> <g> <b> <insertion> <flash> <r1> <g1> <b1>

<width> => (the width) 
<height> => (the height)

=============================================================================================================================================================================================
File input for a circle:

circle <x> <y> <xv> <yv> <isFilled> <diameter> <r> <g> <b> <insertion> <flash> <r1> <g1> <b1>

<diameter> => (the diameter of the circle)

=============================================================================================================================================================================================
File input for a square:

square <x> <y> <xv> <yv> <isFilled> <side> <r> <g> <b> <insertion> <flash> <r1> <g1> <b1>

<side> => (the lenght of the square)

=============================================================================================================================================================================================
File input for a pacman:

pacman <x> <y> <xv> <yv> <isFilled> <size> <position> <sizeOfMouth> <r> <g> <b> <insertion> <flash> <r1> <g1> <b1>

<position> => (This integer is the direction that the pacman will face)
<sizeOfMouth> => (This integer is the angle size of the pacman's mouth)
To make a pacman the <sizeOfMouth> a number between 210 and 360 must be the range


=============================================================================================================================================================================================



Examples what the file should look like:

rect 20 20 1 -2 true 50 80 255 255 0 0 false 0 0 0
square 220 20 2 1 false 50 0 0 0 0 true 250 250 0
circle 220 120 2 3 false 80 0 0 255 2000 false 0 100 0
oval 320 120 1 3 true 80 50 100 0 100 2000 true 0 0 100
pacman 100 200 -1 3 true 100 70 290 255 255 0 2000 true 250 0 0
















