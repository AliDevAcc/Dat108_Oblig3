 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Fra https://purecss.io/ -->
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
<title>Påmelding</title>
</head>
<body>
	<h2>Påmelding</h2>
	<form method="post" class="pure-form pure-form-aligned">
		<fieldset>
			<div class="pure-control-group">
				<label for="fornavn">Fornavn:</label> <input id="fnavn" type="text"
					name="fornavn" value="" /> 
					<font id="fnavn_2" color="red"></font>
			</div>
			<div class="pure-control-group">
				<label for="etternavn">Etternavn:</label> <input id="enavn" type="text"
					name="etternavn" value="" /> 
					<font id="enavn_2"color="red"></font>
			</div>
			<div class="pure-control-group">
				<label for="nr">Mobil (8 siffer):</label> <input id="nr" type="text"
					name="nr" value="" /> 
					<font id="nr_2" color="red"></font>
			</div>
			<div class="pure-control-group">
				<label for="password">Passord:</label> <input id="pass1" type="password"
					name="passord" value="" /> 
					<font id="pass1_2" color="red"></font>
			</div>
			<div class="pure-control-group">
				<label for="passordRepetert">Passord repetert:</label> <input id="pass2" type="password"
					type="pass2" name="passordRepetert" value="" /> 
					<font id="pass2_2" color="red"></font>
			</div>
			<div class="pure-control-group">
				<label id="kjonn1" for="kjonn">Kjønn:</label> <input type="radio" name="kjonn"
					value="mann"
					 />mann
				<input id="kjonn2"type="radio" name="kjonn" value="kvinne"
					 />kvinne
				<font id="kjonn3" color="red"></font>
			</div>
			<div class="pure-controls">
				<button id="button"  type="submit" class="pure-button pure-button-primary">Meld
					meg på</button>
			</div>
		</fieldset>
	</form>
		<script type="text/javascript" >var button = document.getElementById("button");





		let passordInput = document.getElementById("pass1");
		let passordInput2 = document.getElementById("pass2");
		let fNavnInput = document.getElementById("fnavn");
		let eNavnInput = document.getElementById("enavn");
		let nrInput = document.getElementById("nr");
		let mInput = document.getElementById("kjonn1");
		let kInput = document.getElementById("kjonn2");
		let btInput = document.getElementById("button");

		passordInput.addEventListener('input', click);
		passordInput2.addEventListener('input', Lik);
		fNavnInput.addEventListener('input', Fnavn);
		eNavnInput.addEventListener('input', Enavn);
		nrInput.addEventListener('input', Nr);
		button.addEventListener('click', Valid);


		function Valid() {
		    var kjonn1 = document.getElementById("kjonn1").value;
		    var kjonn2 = document.getElementById("kjonn2").value;
		    var kjonn3 = document.getElementById("kjonn3");

		    if (!(kjonn1.clicked == true) && !(kjonn2.clicked == true)) {
		        kjonn3.innerHTML = "";
		    } else {
		        kjonn3.innerHTML = "Må velge kjønn";
		    }
		}


		function Nr() {
		    var nr = document.getElementById("nr").value;
		    var nr_2 = document.getElementById("nr_2");

		    if (!(nr.length == 8)) {
		        nrInput.setAttribute("style", "border-color: red");
		        nr_2.innerHTML = "nr skal ha 8-siffer";
		    } else {
		        nrInput.setAttribute("style", "border-color: green");
		        nr_2.innerHTML = "";
		    }
		}

		function Fnavn() {
		    var fnavn = document.getElementById("fnavn").value;
		    var fnavn_2 = document.getElementById("fnavn_2");

		    if (!(fnavn.charAt(0) == fnavn.charAt(0).toUpperCase()) || fnavn.length < 2 || fnavn.length > 20) {
		        fNavnInput.setAttribute("style", "border-color: red");
		        fnavn_2.innerHTML = "Ugyldig Fornavn (Ps må ha stor forbokstav)";
		    } else {
		        fNavnInput.setAttribute("style", "border-color: green");
		        fnavn_2.innerHTML = "";
		    }
		}

		function Enavn() {
		    var enavn = document.getElementById("enavn").value;
		    var enavn_2 = document.getElementById("enavn_2");

		    if (!(enavn.charAt(0) == enavn.charAt(0).toUpperCase()) || enavn.length < 2 || enavn.length > 20) {
		        eNavnInput.setAttribute("style", "border-color: red");
		        enavn_2.innerHTML = "Ugyldig Etternavn (Ps må ha stor forbokstav)";
		    } else {
		        eNavnInput.setAttribute("style", "border-color: green");
		        enavn_2.innerHTML = "";
		    }
		}


		function click() {
		    var fnavn = document.getElementById("fnavn").value;
		    var enavn = document.getElementById("enavn").value;
		    var nr = document.getElementById("nr").value;

		    var pass1 = document.getElementById("pass1").value;
		    var pass1_2 = document.getElementById("pass1_2");
		    var pass2 = document.getElementById("pass2").value;

		    if (pass1.length < 4) {
		        passordInput.setAttribute("style", "border-color: red");
		        pass1_2.innerHTML = "For kort passord!";
		    } else {
		        passordInput.setAttribute("style", "border-color: green");
		        pass1_2.innerHTML = "";
		    }
		    
		    if (!(pass1 === pass2)) {
		        passordInput2.setAttribute("style", "border-color: red");
		        pass2_2.innerHTML = "Passord Ikke lik";
		    } else {
		        passordInput2.setAttribute("style", "border-color: green");
		        pass2_2.innerHTML = "";
		    }

		}


		function Lik() {
		    var pass2 = document.getElementById("pass2").value;
		    pass1 = document.getElementById("pass1").value;
		    var pass2_2 = document.getElementById("pass2_2");
		    if (!(pass1 === pass2)) {
		        passordInput2.setAttribute("style", "border-color: red");
		        pass2_2.innerHTML = "Passord Ikke lik";
		    } else {
		        passordInput2.setAttribute("style", "border-color: green");
		        pass2_2.innerHTML = "";
		    }
		}
		</script>
</body>
</html>