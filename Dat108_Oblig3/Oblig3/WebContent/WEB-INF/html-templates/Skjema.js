var button = document.getElementById("button");





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

    if (pass1.length < 4) {
        passordInput.setAttribute("style", "border-color: red");
        pass1_2.innerHTML = "For kort passord!";
    } else {
        passordInput.setAttribute("style", "border-color: green");
        pass1_2.innerHTML = "";
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