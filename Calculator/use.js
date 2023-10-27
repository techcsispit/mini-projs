"use strict";

var input = document.getElementById('input'), // input/output button
  number = document.querySelectorAll('.n'), // number buttons
  operator = document.querySelectorAll('.o'), // operator buttons
  result = document.getElementById('result'), // equal button
  clear = document.getElementById('clear'), // clear button
  resultDisplayed = false; // flag to keep an eye on what output is displayed

// adding click handlers to number buttons
function number_handler(event) {
  // if result is displayed, clear the input before appending the new number
  if (resultDisplayed) {
    input.innerHTML = "";
    resultDisplayed = false;
  }
  input.innerHTML += event.target.innerHTML;
}

for (var i = 0; i < number.length; i++) {
  number[i].addEventListener("click", number_handler);
}

// adding click handlers to operator buttons
function operator_handler(event) {
  var currentString = input.innerHTML;
  var lastChar = currentString[currentString.length - 1];

  // if the last character is an operator, replace it with the current one
  if (lastChar === "+" || lastChar === "-" || lastChar === "*" || lastChar === "/") {
    input.innerHTML = currentString.slice(0, -1) + event.target.innerHTML;
  } else if (currentString.length === 0) {
    // if the first key pressed is an operator, don't do anything
    console.log("Enter a number first");
  } else {
    input.innerHTML += event.target.innerHTML;
  }
}

for (var i = 0; i < operator.length; i++) {
  operator[i].addEventListener("click", operator_handler);
}

// adding a window eventListener to handle keypress events
function windows_handler(event) {
  var key = event.key;
  var allowedKeys = ['+', '-', '*', '/', 'x', 'X', '÷'];

  if (parseInt(key) >= 0 && parseInt(key) <= 9) {
    // if result is displayed, clear the input before appending the new number
    if (resultDisplayed) {
      input.innerHTML = "";
      resultDisplayed = false;
    }
    input.innerHTML += key;
  } else if (allowedKeys.includes(key)) {
    var currentString = input.innerHTML;
    var lastChar = currentString[currentString.length - 1];
    var s = key;
    if (s.toLowerCase() === 'x' || s.toUpperCase() === 'X') {
      s = '*';
    } else if (s.toLowerCase() === '÷') {
      s = '/';
    }

    // if the last character is an operator, replace it with the current one
    if (['+', '-', '*', '/'].includes(lastChar)) {
      input.innerHTML = currentString.slice(0, -1) + s;
    } else if (currentString.length === 0) {
      // if the first key pressed is an operator, don't do anything
      console.log("Enter a number first");
    } else {
      input.innerHTML += s;
    }
  }
}

window.addEventListener("keypress", windows_handler);

function output() {
  var inputString = input.innerHTML;
  var output;
  try {
    // Replace 'x' and '÷' with '*' and '/'
    inputString = inputString.replace(/x/g, '*').replace(/÷/g, '/');

    output = eval(inputString);
    if (output === undefined) {
      throw new Error("Invalid input");
    }
    input.innerHTML = parseFloat(output.toFixed(10));
  } catch (e) {
    if (e instanceof SyntaxError || e.message === "Invalid input") {
      input.innerHTML = "Invalid input";
    }
  }
  resultDisplayed = true;
}

result.addEventListener("click", output);

// clearing the input on press of clear
clear.addEventListener("click", function() {
  input.innerHTML = "";
});

// adding an event for clearing with the help of backspace
window.onkeydown = function (event) {
  var key = event.key;
  if (key === "Backspace") {
    input.innerHTML = "";
  } else if (key === "Enter") {
    output();
  }
};
