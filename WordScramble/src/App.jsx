import { useEffect, useMemo, useState } from "react";
import "./App.css";
import words from "./assets/json/words.json";
import { POINT, TIMER } from "./config";
import { scramble } from "./utils";
import { CountdownTimer } from "./components";

function App() {
  const [counter, setCounter] = useState(0);
  const [score, setScore] = useState(0);
  const [answer, setAnswer] = useState("");
  const [isWrong, setIsWrong] = useState(false);
  const [remainingTime, setRemainingTime] = useState(TIMER);
  const [showAnswer, setShowAnswer] = useState(false);
  const [isAnsweredCorrectly, setIsAnsweredCorrectly] = useState(false); // new state

  const question = useMemo(() => {
    const fq = words?.[counter] || null;
    if (fq) {
      return { ...fq, word: scramble(fq.word) };
    }
  }, [counter]);
  const totalQuestion = words.length;
  const buttonDisabled = answer?.trim()?.length === 0;

  const handleOnGuess = (e) => {
    e.preventDefault();
    const isCorrect = answer === words?.[counter]?.word;
    if (isCorrect) {
      setIsWrong(false);
      setAnswer("");
      setScore(score + POINT);
      setIsAnsweredCorrectly(true);
    } else {
      setIsWrong(true);
    }
  };

  const handleKeyDown = (e) => {
    if (e.key === "Enter") {
      e.preventDefault();
    }
  };

  useEffect(() => {
    if (isAnsweredCorrectly) {
      setShowAnswer(false);
      setRemainingTime(TIMER);
      setIsAnsweredCorrectly(false);
      setCounter(counter + 1);
      
      
    } else if (counter <= totalQuestion - 1 && remainingTime === 0) {
      setShowAnswer(true);
      setTimeout(() => {
        setShowAnswer(false);
        setRemainingTime(TIMER);
        setCounter(counter + 1);
      }, 5000);
    }
  }, [counter, totalQuestion, remainingTime, isAnsweredCorrectly]);

  return (
    <div className="word-scramble">
      <div className="score-container">
        <h2>Score: {score}</h2>
      </div>
      {question ? (
        <>
          <small>Guess the word in</small>
          <CountdownTimer {...{ remainingTime, setRemainingTime }} />
          <h1>{question.word}</h1>
          <i>
            <strong>Hint:</strong>&nbsp;{question.definition}
          </i>
          <div>
            <form onSubmit={handleOnGuess} className="answer-form">
              <label htmlFor="answer">Your answer</label>
              <input
                type="text"
                id="answer"
                onChange={(e) => setAnswer(e.target.value)}
                onKeyDown={handleKeyDown}
                value={answer}
                className="answer-input"
              />
              {isWrong && <small>Try again!</small>}
              {showAnswer && !isAnsweredCorrectly && (
                <div>
                  <small>The correct answer is:</small>
                  <p>{words?.[counter]?.word}</p>
                </div>
              )}
              {!showAnswer && !isAnsweredCorrectly && (
                <button type="submit" disabled={buttonDisabled}>
                  Submit
                </button>
              )}
            </form>
          </div>
        </>
      ) : (
        <>
          <p>Your score</p>
          <h1>{score}</h1>
          <button
            type="button"
            onClick={() => {
              setCounter(0);
              setRemainingTime(TIMER);
              setShowAnswer(false);
            }}
          >
            Try Again!
          </button>
        </>
      )}
    </div>
  );
}

export default App;
