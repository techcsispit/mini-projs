let speech = new SpeechSynthesisUtterance();

let voices = [];

let voiceSelect = document.querySelector("select");
let pitchInput = document.getElementById("pitch");
let pitchValue = document.getElementById("pitch-value")
let rateInput = document.getElementById("rate");
let rateValue = document.getElementById("rate-value")
let volumeInput = document.getElementById("volume");
let volumeValue = document.getElementById("volume-value");

let audioPlaying = false;

pitchInput.value = "1";
rateInput.value = "1";
volumeInput.value = "0.5";

pitchValue.innerText = "1";
rateValue.innerText = "1";
volumeValue.innerText = "0.5";

window.speechSynthesis.onvoiceschanged = () => {
    voices = window.speechSynthesis.getVoices();
    speech.voice = voices[0];

    voices.forEach((voice , i) => (voiceSelect.options[i] = new Option(voice.name, i)));
}

voiceSelect.addEventListener("change", () => {
    speech.voice = voices[voiceSelect.value];
})

pitchInput.addEventListener("input", () => {
    speech.pitch = pitchInput.value;
    pitchValue.innerText = pitchInput.value;
});

rateInput.addEventListener("input", () => {
    speech.rate = rateInput.value;
    rateValue.innerText = rateInput.value;
});

volumeInput.addEventListener("input", () => {
    speech.volume = volumeInput.value;
    volumeValue.innerText = volumeInput.value;
});

const resetTextArea = () => {
    document.getElementById("textToSpeak").value = "";
}

document.getElementById("playButton").addEventListener("click" , () => {
    speech.text = document.querySelector("textarea").value
    window.speechSynthesis.speak(speech);
});

document.getElementById("pauseButton").addEventListener("click", () => {
    window.speechSynthesis.pause();
});

document.getElementById("resumeButton").addEventListener("click", () => {
    window.speechSynthesis.resume();
});

document.getElementById("stopButton").addEventListener("click", () => {
    window.speechSynthesis.cancel();
    resetTextArea();
});