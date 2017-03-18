var fs = require("fs");

var oxford = require('project-oxford'),
   client = new oxford.Client('3113489958a9439594c5065b993da1b4');


client.emotion.analyzeEmotion({
	path: "Temp_Image/camera.jpg",
	}).then(function (response) {
	console.log(response);
});


