import { useEffect, useState } from "react";
import { Button } from "react-bootstrap";
import { useParams } from "react-router-dom";
import Question from "./Question";

function StartQuiz() {
  const [questions, setQuestions] = useState();
  const [clicked, setClicked] = useState(false);
  const [questionNumber, setQuestionNumber] = useState(0);
  const { category } = useParams();
  const limit = 10;
  const difficulty = "";
  useEffect(() => {
    const fetchQuestions = async () => {
      const response = await fetch("http://localhost:8081/questions", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ limit, difficulty, category }),
      });
      const data = await response.json();
      setQuestions(data);
    };
    fetchQuestions();
  }, []);
  return (
    <div>
      {!clicked && (
        <Button onClick={() => setClicked(true)}>Rozpocznij Quiz</Button>
      )}
      {clicked && (
        <Question
          question={questions[questionNumber]}
          click={() => setQuestionNumber((prev) => prev + 1)}
        />
      )}
    </div>
  );
}

export default StartQuiz;
