import { useEffect, useState } from "react";
import { Button } from "react-bootstrap";
import { useParams } from "react-router-dom";
import Question from "./Question";
import Finish from "./Finish";
import Spinner from "react-bootstrap/Spinner";

function StartQuiz({ name }) {
  const [questions, setQuestions] = useState();
  const [clicked, setClicked] = useState(false);
  const [questionNumber, setQuestionNumber] = useState(0);
  const [score, setScore] = useState(0);
  const [isEndOfGame, setIsEndOfGame] = useState(false);
  const [dataLoaded, setDataLoaded] = useState(false);

  const { category } = useParams();
  const limit = 10;
  const difficulty = "";

  useEffect(() => {
    const fetchQuestions = async () => {
      const response = await fetch("http://localhost:8080/questions", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ limit, difficulty, category }),
      });

      const data = await response.json();

      setQuestions(data);
      setDataLoaded(true);
    };
    fetchQuestions();
  }, []);
  return (
    <div>
      <style type="text/css">
        {`
            .btn-flat {
              font-size: 2rem;
              background-color: #0d1b2a;
              color: white;
            }
            .btn-flat:hover {
              background-color: #00bfa6;
              color: white;
            }
        `}
      </style>
      {dataLoaded ? (
        !clicked && (
          <Button
            variant="flat"
            style={{ marginTop: "50vh" }}
            onClick={() => setClicked(true)}
          >
            Start Quiz
          </Button>
        )
      ) : (
        <Spinner style={{ marginTop: "50vh" }} animation="border" />
      )}
      {!isEndOfGame && clicked && (
        <>
          <h2>Score: {score}</h2>
          <Question
            setScore={setScore}
            question={questions[questionNumber]}
            click={() =>
              setQuestionNumber((prev) => {
                if (prev + 1 >= questions.length) {
                  setIsEndOfGame(true);
                } else {
                  return prev + 1;
                }
              })
            }
          />
        </>
      )}

      {isEndOfGame && <Finish score={score} name={name} category={category} />}
    </div>
  );
}

export default StartQuiz;
