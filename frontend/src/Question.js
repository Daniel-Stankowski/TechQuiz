import { Button } from "react-bootstrap";
import { propTypes } from "react-bootstrap/esm/Image";
import Answer from "./Answer";
import Anwser from "./Answer";

function Question(props) {
  return (
    <div>
      <h1>{props.question.question}</h1>
      {Object.entries(props.question.answers)
        .map((k) => k[1])
        .map((answer) =>
          answer ? <Answer answer={answer} click={props.click} /> : <></>
        )}
    </div>
  );
}
//forEach( (k,v) => v).map((anwser) => anwser!='null' ? <Anwser anwser={anwser}/> : '')export default Question

export default Question;
