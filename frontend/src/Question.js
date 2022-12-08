import Answer from "./Answer";
import Card from 'react-bootstrap/Card';
import ProgressBar from 'react-bootstrap/ProgressBar';
import { useEffect, useState } from "react";

function Question(props) {
  const answers = props.question.correct_answers;
  const [time, setTime] = useState(100);

  const correctAnswer = Object.keys(answers)
    .find((key) => answers[key] === true)
    .slice(0, 8);

  const click = () => {
    props.click();
    setTime(115);
  }
  if(time<=-10) {
    click();
  }

  useEffect( () => {
    setTime(100)
    const interval = setInterval(() => {
      setTime(prev => prev-1)
    }, 100)
    return () => {
      clearInterval(interval);
    };
  }, [])

  return (
    <div>
      <div className="d-flex justify-content-center m-3" >
        <Card style={{ height: '20vh', width: '170vh'}} className="d-flex align-items-center justify-content-center">
          <Card.Title>{props.question.question}</Card.Title>
        </Card>
      </div>
      <div className="d-flex justify-content-center m-4" >
      <style type="text/css">
              {`
                .progress-bar {
                  background-color: #0d1b2a;
                }
            `}
        </style>
        <ProgressBar style={{ width: '170vh'}} now={time} />
      </div>
      <div className="d-flex flex-row flex-shrink-0 flex-wrap justify-content-center">
      {Object.entries(props.question.answers).map((answer) =>
        answer[1] ? (
          <Answer
            setScore={props.setScore}
            correctAnswer={correctAnswer}
            answerId={answer[0]}
            answer={answer[1]}
            click={click}
            time={time}
          />
        ) : (
          <></>
        )
      )}
      </div>
    </div>
  );
}
export default Question;
