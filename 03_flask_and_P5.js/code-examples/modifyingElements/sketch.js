var colorNameElement;
var myCanvas;
var myInput;

function setup() {
  myCanvas = createCanvas(800, 300);
  myCanvas.parent("myCanvasContainer");
  myCanvas.mousePressed(canvasPressed);

  colorNameElement = createSpan("default value");
  colorNameElement.parent("colorNameContainer");
  
  myInput = createInput("");
  myInput.parent("myInputContainer");
  
  var myButton = createButton("search");
  myButton.parent("myInputContainer");
  myButton.mousePressed(buttonPressed);
  
  noStroke();
}

function draw()
{
  fill(255,0,0);
  rect(0,0,width/2, height);
  fill(0,255,0);
  rect(width/2, 0, width, height);
}

function canvasPressed()
{
  if (mouseX<width/2) {
	colorNameElement.html("red");
  }
  else {
	colorNameElement.html("green");  
  }
}

function buttonPressed()
{
	colorNameElement.html("you pressed the button");
}
