import { useNavigate } from "react-router-dom";
import classes from "./Scoreboard.module.css";
import Dropdown from "react-bootstrap/Dropdown";
import { useEffect, useState } from "react";
import Table from "react-bootstrap/Table";

const Scoreboard = () => {
  const navigate = useNavigate();
  const [scores, setScores] = useState([]);
  const [category, setCategory] = useState("JAVASCRIPT");
  const [scoresLoaded, setScoresLoaded] = useState(false);

  useEffect(() => {
    const getScores = async () => {
      const response = await fetch("http://localhost:8080/score/all");
      const data = await response.json();

      setScores(data);
      setScoresLoaded(true);
    };

    getScores();
  }, []);

  const handleFilterChange = (category) => {
    setCategory(category);
  };

  const DUMMT_DATA = [
    { name: "John", score: 200, category: "html" },
    { name: "Frank", score: 300, category: "html" },
    { name: "Bob", score: 400, category: "html" },
    { name: "Anna", score: 600, category: "html" },
    { name: "Hania", score: 350, category: "html" },
  ];

  DUMMT_DATA.sort((a, b) => b.score - a.score);

  return (
    <section>
      <header className={classes.scoreboardHeader}>
        <div
          className={classes.back}
          onClick={(e) => {
            navigate("/");
          }}
        >
          Back
        </div>
      </header>

      <Dropdown>
        <Dropdown.Toggle
          style={{ background: "#00bfa6", border: "none", fontWeight: "700" }}
          variant="success"
          id="dropdown-basic"
        >
          Pick category
        </Dropdown.Toggle>

        <Dropdown.Menu>
          <Dropdown.Item onClick={handleFilterChange.bind(this, "LINUX")}>
            Linux
          </Dropdown.Item>
          <Dropdown.Item onClick={handleFilterChange.bind(this, "BASH")}>
            BASH
          </Dropdown.Item>
          <Dropdown.Item onClick={handleFilterChange.bind(this, "PHP")}>
            PHP
          </Dropdown.Item>
          <Dropdown.Item onClick={handleFilterChange.bind(this, "DOCKER")}>
            Docker
          </Dropdown.Item>
          <Dropdown.Item onClick={handleFilterChange.bind(this, "MYSQL")}>
            MySQL
          </Dropdown.Item>
          <Dropdown.Item onClick={handleFilterChange.bind(this, "WORDPRESS")}>
            WordPress
          </Dropdown.Item>
          <Dropdown.Item onClick={handleFilterChange.bind(this, "LARAVEL")}>
            Laravel
          </Dropdown.Item>
          <Dropdown.Item onClick={handleFilterChange.bind(this, "KUBERNETES")}>
            Kubernetes
          </Dropdown.Item>
          <Dropdown.Item onClick={handleFilterChange.bind(this, "JAVASCRIPT")}>
            JavaScript
          </Dropdown.Item>
          <Dropdown.Item onClick={handleFilterChange.bind(this, "DEVOPS")}>
            DevOps
          </Dropdown.Item>
        </Dropdown.Menu>
      </Dropdown>
      <h2 className={classes.title}>{category}</h2>

      <article className={classes.scoreboard}>
        {scoresLoaded && (
          <Table hover size="sm" style={{ width: "40%" }}>
            <thead>
              <tr>
                <th>#</th>
                <th>Name</th>
                <th>Score</th>
              </tr>
            </thead>
            <tbody>
              {scores
                .find((obj) => obj.category === category)
                .scores.sort((a, b) => b.score - a.score)
                .map((item, index) => (
                  <tr>
                    <td>{index}</td>
                    <td>{item.username}</td>
                    <td>{item.score}</td>
                  </tr>
                ))}
            </tbody>
          </Table>
        )}
      </article>
    </section>
  );
};

export default Scoreboard;
