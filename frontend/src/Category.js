import Card from "react-bootstrap/Card";
import { useNavigate } from "react-router-dom";

function Category(props) {
  const navigate = useNavigate();

  return (
    <div
      className="p-4"
      style={{ cursor: "pointer" }}
      onClick={(e) => {
        navigate("/quiz/" + props.name.toLowerCase());
      }}
    >
      <Card style={{ width: "12rem" }} bg="light">
        <Card.Img
          variant="top"
          src={"assets/" + props.name + ".png"}
          className="mx-auto d-block mt-3"
          style={{ width: "96px", height: "96px" }}
        />
        <Card.Body>
          <Card.Title>{props.name}</Card.Title>
          <Card.Text>Total questions: {props.count}</Card.Text>
        </Card.Body>
      </Card>
    </div>
  );
}

export default Category;
