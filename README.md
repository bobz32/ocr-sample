# ocr-sample
A Spring Boot web app that stands up a sample service to parse OCR'ed business cards into useable contact information

## Background
This exercise assumes you are working for a company that just created a smartphone app that allows users to take a picture
of a business card and extract information to create a new contact. The OCR portion has been created, and you are tasked with
implemented the parsing code to pull out a Name, Phone Number, and Email Address from this data.

## Thought Process
If this is a mobile app, chances are the OCR'ing is being offloaded to a cloud solution or an external server call, 
and not being performed natively on the device. Because of this, I decided to create a simple REST endpoint to accomplish 
this task. This allows the flexibility of updating the data parsing code on the server without requiring your app be updated 
across all devices. This could also be extended to aggregate data from all calls, to help train the NLP algorithm and improve 
the parsing.

## How It Works
This is a Spring Boot application that will run a local webserver with a very simple UI to help test out the 
parsing endpoint. The UI was only included to allow quick testing of the end point without requiring curl or poster or 
any extra tools (not an example of UI design skills!) For now the endpoint is a simple `POST` of text/plain. In a 
more real world example, structured/validated JSON would be sent from the UI/app, and validated once again on the server.

On the server side, the `BusinessCardParser` class creates a simple iterative algorithm to attempt to parse the most 
recognizable fields (email, phone number) first, before attempting to parse the human name. The `NameParser` uses the 
[StanfordNLP](https://nlp.stanford.edu/) Java libraries to extract a `PERSON` entity from text.

## Requirements / Instructions

