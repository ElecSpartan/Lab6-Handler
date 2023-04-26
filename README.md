# Lab6-Handler

I checked if not 1 argument 
checked for the name of the file extension
I used file class to create a file object
and finally checked if the file is empty

I used DOM Parser to read and write the xml file with help from the youtube and internet
I made a Container Class with datafields UUID LongName and ShortName so that every container will instantiate an object
I made an ArrayList so it has a dynamic size and use the sort method
to use the sort method I must implement Comparable interface in Container Class... it was easy as we are comparing Strings and String Class
has already CompareTo Implemented

I override toString in Container to it prints the format of the xml with the datafields in it

I created a file that has the name of the input file but ends with _mod.arxml
finally I made a for loop to use toString with each Container in the ArrayList to write in the output File


I implemented two exception handling 
one for empty file which is not handled
and one for wrong extension and it is handled
I handled it in the catch block