# ocr-sample
A Spring Boot web app that stands up a sample service to parse OCR'ed business cards into useable contact information

## Background
This exercise assumes you are working for a company that just created a smartphone app that allows users to take a picture
of a business card, and extract information to create contacts. The OCR portion has been created, and you are tasked with
implemented the parsing code to pull out a Name, Phone Number, and Email Address from this data.

## Thought Process
If this is a mobile app, chances are the OCR'ing of a picture is being offloaded to a cloud solution or an open source API, 
and not being performed natively on the device. Because of this, I decided to create a simple REST endpoint to accomplish 
this task. Also, if you have created an app to OCR business cards, chases are you want to send a lot of meta information to 
some online service to enhance parsing, or to collect metrics and usage statistics anyway. And being a web service, you could 
easily replicate and localize this service for speed/availability, and not have to worry about native libraries or OS updates 
on a mobile device. You could also swap out your parsing code without requiring a mobile app update for all users.

## How It Works
This is a Spring Boot application that will run a local webserver with a very, very simple UI to help you test out the 
parsing endpoint. The UI was only included to allow quick testing of the end point without requiring curl or poster or 
any extra tools.

On the server side, the `BusinessCardParser` class creates a simple iterative algorithm to attempt to parse the most 
recognizable fields (email, phone number) first, before attempting to parse the human name. The `NameParser` uses the 
[StanfordNLP](https://nlp.stanford.edu/) Java libraries to extract a `PERSON` entity from text.
