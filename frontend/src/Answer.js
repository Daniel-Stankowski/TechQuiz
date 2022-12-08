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

  return <>
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
  <Button variant='flat' style={{width: '75vh', height: '15vh'}} className="m-3 btn" onClick={onClick}>{props.answer}</Button></>;
}

export default Answer;
