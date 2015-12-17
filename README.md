# Pattern Partner
Source code  and documentation for knit and crochet pattern application, called Pattern Partner

### Problem: 
Knit and crochet patterns are created by professional pattern writers and hobbyists in various different arrangements and layouts. While there are standard symbols to describe the pattern, they are rarely laid out in a standard way. Furthermore, they are often printed in PDF files or on web pages that render poorly on mobile devices and don't support helpful tools like highlighting what row you are on.

### Solution: 
A mobile-friendly application that takes patterns in a variety of file types (PDF, HTML web page, Word document) and formats the text in a standard, easy to read way, while preserving any charts and images. The files are saved into a library for users to use and reuse. The application supports row highlighting and has a row counter to keep track of repeats.

### What will I learn: 
Java processing of XML, creating an application that reads from and writes to files, possibly Android app development, using library files

### Rough Outline:
- Create an XML schema based on the KnitML schema for crochet patterns and clean up the KnitML documentation
- Write code to processes text files of knit or crochet patterns and creates an XML file for that pattern and save in a library location
- Write code (or utilize existing libraries) for handling PDF files and websites (by feeding in a URL)
- Write  code to read through the XML files in the library and display the pattern in a readable fashion that allows the user to highlight what row they are on with a click and activates a counter widget when there is a repeating row
- Package code for usage as an Android app (depending on time)
