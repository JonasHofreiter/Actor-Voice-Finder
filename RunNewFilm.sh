#!/bin/bash

javac -cp "lib/*" -d classes src/AN/Webscraper/NewFilm.java

java -cp "classes:lib/*" AN.Webscraper.NewFilm
