#!/bin/sh
cp=lib/h2-1.3.159.jar
weboptions="-web -webPort 8082" 
tcpoptions="-tcp -tcpPassword stoph2 -tcpPort 9092"
dboptions="-ifExists -baseDir res/database"
java -cp $cp org.h2.tools.Server $weboptions $tcpoptions $dboptions
