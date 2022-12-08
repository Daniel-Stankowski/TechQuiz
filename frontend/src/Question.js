import Answer from "./Answer";

function Question(props) {
  const answers = props.question.correct_answers;
  const correctAnswer = Object.keys(answers)
    .find((key) => answers[key] === true)
    .slice(0, 8);
  console.log(props.question);

  return (
    <div>
      <h1>{props.question.question}</h1>
      {Object.entries(props.question.answers).map((answer) =>
        answer[1] ? (
          <Answer
            setScore={props.setScore}
            correctAnswer={correctAnswer}
            answerId={answer[0]}
            answer={answer[1]}
            click={props.click}
          />
        ) : (
          <></>
        )
      )}
    </div>
  );
}
//forEach( (k,v) => v).map((anwser) => anwser!='null' ? <Anwser anwser={anwser}/> : '')export default Question

export default Question;
