let blob = document.getElementById("blob");
let outputCode = document.getElementById("css-code");
let sliders = document.querySelectorAll("input[type='range']");
let inputs = document.querySelectorAll("input[type='number']");

sliders.forEach(slider => slider.addEventListener("input", createBlob));
inputs.forEach(inp => inp.addEventListener("change", createBlob));

function createBlob() {
  let radiusOne = sliders[0].value;
  let radiusTwo = sliders[1].value;
  let radiusThree = sliders[2].value;
  let radiusFour = sliders[3].value;

  let blobHeight = inputs[0].value;
  let blobWidth = inputs[1].value;

  let borderRadius = `${radiusOne}% ${100 - radiusOne}% ${100 - radiusThree}% ${radiusThree}% / ${radiusFour}% ${radiusTwo}% ${100 - radiusTwo}% ${100 - radiusFour}%`;

  blob.style.cssText = `border-radius: ${borderRadius}; height: ${blobHeight}px; width: ${blobWidth}px`;

  outputCode.value = `border-radius: ${borderRadius};`;
}

document.getElementById("copy").addEventListener("click", () => {
  navigator.clipboard.writeText(outputCode.value)
    .then(() => alert('Code copied!'))
    .catch((err) => alert(`Failed to Copy code!\nError: ${err}`));
});