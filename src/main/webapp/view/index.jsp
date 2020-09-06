<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Hello ${name}!</title>

<script src="https://code.jquery.com/jquery-3.5.1.js"
	integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/knockout/3.5.0/knockout-min.js"></script>
	
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.form/4.3.0/jquery.form.min.js" 
	integrity="sha384-qlmct0AOBiA2VPZkMY3+2WqkHtIQ9lSdAsAn5RUJD/3vA5MKDgSGcdmIv4ycVxyn" 
	crossorigin="anonymous"></script>

<script src="js/knockout-mapping.js"></script>	
	
<script src="js/app.js"></script>

<link rel="stylesheet"
	href="https://unpkg.com/purecss@2.0.3/build/pure-min.css"
	integrity="sha384-cg6SkqEOCV1NbJoCu11+bm0NvBRc8IYLRGXkmNrqUBfTjmMYwNKPWBTIKyw9mHNJ"
	crossorigin="anonymous">

</head>
<body>
	<h2 class="hello-title">Knockout Demo</h2>

	<form id="optionsForm" class="pure-form" action="update" method="post">
		<fieldset>
			<legend>A compact inline form</legend>
			<input type="text" placeholder="Gender" name="gender"/> 
			<input type="text" placeholder="Age" name="age" />

			<button type="submit" class="pure-button pure-button-primary">Submit</button>
		</fieldset>
	</form>
	
	<span id="initialUIConfigHolder" style="display:none">${initialUIConfig}</span>
	
	<div data-bind="visible: eligibleForMaleOptions" style="display:none">
		<h5>Male Options Block</h5>
	</div>
	
	<div data-bind="visible: eligibleForFemaleOptions" style="display:none">
		<h5>Female Options Block</h5>
	</div>
	
	<div data-bind="visible: eligibleForPensionOptions" style="display:none">
		<h5>Pension Options Block</h5>
	</div>
</body>

</html>