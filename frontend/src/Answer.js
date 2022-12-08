import { Button } from "react-bootstrap";

function Answer(props) {
    return <Button onClick={props.click}>{props.answer}</Button>
}

export default Answer