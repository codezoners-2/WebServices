var canvas;
var jsonobject;
var padding=50;

/////DOM STUFF
var searchTermSpan;
var keywordInput;
var searchTerm = "";
var speechDataSpan;

function setup() {
  //step 1
  //step 2
  //step 3
  //step 4
  
  //step 5
  //step 6

  //step 7 
  //step 8
  //step 9
  //step 10
  
  //step 11
  //step 12
}

function draw() {
  background(255);
  stroke(0); noFill();
  rect(0,0,width-1,height-1);
  if (jsonobject)
  {
	  drawStatistics();
	  drawYears();
  }
}

function drawStatistics()
{
  noStroke();
  //step 15
  //step 16
  //step 17
  //step 18
  //step 19
  
  var closestSpeech = {}
  var closestYearDistance=99999;
    
  for (var x=0; x<totalentries; x++)
  {
	  //step 20
	  //step 21.a
	  //step 21.b
	  
	  var xLoc = map(year, startyear, endyear, 0+padding, width-padding); //start later, end sooner on canvas
	  var diam = map(freq, minfreq, maxfreq, 0, 60);	  
	  if (party=="democrat") fill(0,0,255,60);
	  else if (party=="republican") fill(255,0,0,60);
	  else fill(0,255,0,100);
	  ellipse(xLoc, height/2, diam, diam);
	  	  
	  if (dist(mouseX,mouseY,xLoc,height/2)<closestYearDistance && freq>0)
	  {
		  closestSpeech["year"]=year;
		  closestSpeech["dist"]=dist(mouseX,mouseY,xLoc,height/2);
		  closestSpeech["xcoord"]=xLoc;
		  closestSpeech["president"]=jsonobject.statistics[x].president;
		  closestSpeech["party"]=jsonobject.statistics[x].party;
		  closestSpeech["diam"]=diam;
		  closestSpeech["freq"]=freq;
		  closestYearDistance = closestSpeech["dist"];
	  }
  }
  
  //SETTING HTML STRING
  htmlString="";
  if (dist(mouseX,mouseY,closestSpeech["xcoord"],height/2)<50 && closestSpeech["freq"]>0)
  {
	  stroke(0); strokeWeight(2); noFill();
	  ellipse(closestSpeech["xcoord"],height/2,closestSpeech["diam"],closestSpeech["diam"]);
	  htmlString = '<h4><strong>President:</strong> ' + closestSpeech["president"] + '</h4>';
	  htmlString += '<h4><strong>Year:</strong> ' +  closestSpeech["year"] + '</h4>';
	  htmlString += '<h4><strong>Party:</strong> ' +  closestSpeech["party"] + '</h4>';
	  htmlString += '<h4><strong>Frequency:</strong> ' +  closestSpeech["freq"] + '</h4>';
  }
  //step 22
}

function drawYears()
{
	var min = jsonobject.startyear;
	var max = jsonobject.endyear;
	var yearsToDisplay=10;
	
	for (var x=0;x<yearsToDisplay;x++)
	{
		var xcoord = map(x,0,yearsToDisplay-1,padding,width-padding);
		var year = int(map(x,0,yearsToDisplay-1,min,max));
		noStroke(); fill(0);
		text(year, xcoord-textWidth(year)/2, 15);
		stroke(200); strokeWeight(1);
		line(xcoord,20,xcoord,height);
	}
}

function fetchStatistics()
{
  //step 13
  //step 14
  //jsonobject = loadJSON('http://localhost:8080/search/'+searchTerm);
}
