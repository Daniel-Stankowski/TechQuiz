import { Button } from "react-bootstrap";

function Answer(props) {
  const handleScoreAdd = () => {
    if (props.answerId === props.correctAnswer) {
      props.setScore((prevScore) => prevScore + 10);
    }
  };

  const onClick = () => {
    props.click();
    handleScoreAdd();
  };

  return <Button onClick={onClick}>{props.answer}</Button>;
}

export default Answer;
